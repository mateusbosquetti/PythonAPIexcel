from flask import Flask, request, jsonify
import pandas as pd
import requests
import io
import time

app = Flask(__name__)

# URLs das APIs do Spring Boot
URL_TURMAS = "http://localhost:8081/turma"
URL_ALUNOS = "http://localhost:8081/aluno"

@app.route('/upload', methods=['POST'])
def upload_file():
    if 'file' not in request.files:
        return jsonify({"error": "Nenhum arquivo enviado"}), 400
    
    file = request.files['file']
    
    if file.filename == '':
        return jsonify({"error": "Nome do arquivo inválido"}), 400
    
    try:
        # Ler o arquivo Excel diretamente do request
        df = pd.read_excel(io.BytesIO(file.read()), usecols=[0, 1], names=["turma", "nome"])

        # 1️⃣ Cadastrar as turmas primeiro
        turmas = [{"nome": turma} for turma in df["turma"].unique()]
        response_turmas = requests.post(URL_TURMAS, json=turmas, headers={"Content-Type": "application/json"})
        print("Cadastro de turmas:", response_turmas.status_code, response_turmas.text)

        # Pequeno delay para garantir que as turmas sejam criadas antes dos alunos
        time.sleep(2)

        # 2️⃣ Cadastrar os alunos
        alunos = df.to_dict(orient="records")  # Converte cada linha em um dicionário
        response_alunos = requests.post(URL_ALUNOS, json=alunos, headers={"Content-Type": "application/json"})
        print("Cadastro de alunos:", response_alunos.status_code, response_alunos.text)

        return jsonify({
            "status": "success",
            "turmas_response": response_turmas.json(),
            "alunos_response": response_alunos.json()
        })

    except Exception as e:
        return jsonify({"error": str(e)}), 500

if __name__ == '__main__':
    app.run(debug=True, port=5000)
