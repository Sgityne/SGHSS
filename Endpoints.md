# 📍 Endpoints
### 🔐 Authenticação

- `POST /auth/register` → Criar conta (Médico/Admin/RH)
  <br><br>
  - **Request**
    ```
      {
	      "nome": "Admin2",
	      "email": "Admin2@Admin.com",
	      "password": "Admin",
	      "role": "ADMIN"
      }


- `POST /auth/login` → Login (JWT)
  <br><br>
  - **Request**
    ```
      {
	      "email": "Email@email.com",
	      "password": "password"
      }
  - **Response**
    ```
      {
	      "token": "eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpc3MiOiJzZ2hzcy1hcGkiLCJzdWIiOiJBZG1pbkBBZG1pbi5jb20iLCJleHAiOjE3NTE5NDk1MTR9.d8IfvSfJ2stLqpRYSokqwghXV54FxdchtK9jnYfKoa4"
      }

- Com o Token, poderá fazer o resto das requisições, junto ao Prefix: Bearer
---
### 👤 Paciente
- `POST /api/pacientes` → Criar paciente
- `PUT /api/pacientes/{id}` → Atualiza um paciente
  <br><br>
  - **Request**
    ```
    {
        "nome": "Art Cooper",
        "cpf": "1234567891",
        "dataNascimento": "1985-04-20",
        "endereco": "Brasil",
        "telefone": "1234-1234",
        "email": "ArtC@paciente.com"
    }

  - **Response**
    ```
    {
        "id": 6,
        "nome": "Art Cooper",
        "cpf": "1234567891",
        "dataNascimento": "1985-04-20",
        "endereco": "Brasil",
        "telefone": "1234-1234",
        "email": "ArtC@paciente.com"
    }

- `GET /api/pacientes` → Listar todos pacientes
  <br><br>
  - **Response**
    ```
    [
        {
            "id": 5,
            "nome": "jubliscleusu",
            "cpf": "1231231231",
            "dataNascimento": "1942-04-20",
            "endereco": "lisboa",
            "telefone": "1234-1234",
            "email": "eojubis@paciente.com"
        },
        {
            "id": 6,
            "nome": "Art Cooper",
            "cpf": "1234567891",
            "dataNascimento": "1985-04-20",
            "endereco": "Brasil",
            "telefone": "1234-1234",
            "email": "ArtC@paciente.com"
        }
    ]

- `GET /api/pacientes/{id}` → Listar por id do paciente
<br><br>
  - **Response**
    ```
    {
        "id": 6,
        "nome": "Art Cooper",
        "cpf": "1234567891",
        "dataNascimento": "1985-04-20",
        "endereco": "Brasil",
        "telefone": "1234-1234",
        "email": "ArtC@paciente.com"
    }

- `DELETE /api/pacientes/{id}` → Deleta um paciente
---
### 🏥 Consulta
- `POST /api/consulta` → Agenda consulta
  <br><br>
    - **Request**
      ```
      {
          "pacienteId": "5",
          "medicoId": "2",
          "dataHora": "2025-07-13T13:00:00"
      }

    - **Response**
      ```
      {
          "id": 4,
          "pacienteId": "5",
          "medicoId": "2",
          "dataHora": "2025-07-13T13:00:00",
          "status": "AGENDADA"
      }

- `GET /api/consulta/{id}` → Lista consulta pelo id
- `GET /api/consulta/paciente/{id}` → Lista consultas pelo id do paciente
<br><br>
  - **Response**
    ```
    [
        {
            "id": 4,
            "pacienteId": "5",
            "medicoId": "2",
            "dataHora": "2025-07-13T13:00:00",
            "status": "AGENDADA"
        }
    ]
- `PUT /api/consulta/{id}` → Cancela uma consulta
---
### 📄 Exame
- `POST /api/exames` → Registra um exame
  <br><br>
    - **Request**
      ```
      {
          "pacienteId": "4",
          "descricao": "Exame"
      }

    - **Response**
      ```
      {
          "id": "2",
          "pacienteId": "4",
          "descricao": "Exame"
          "dataHora": "2025-07-07T:13:22:48"
      }

- `GET /api/exames/{id}` → Lista Exames por id do paciente
  <br><br>
    - **Response**
      ```
      [
          {
              "id": 1,
              "pacienteId": "4",
              "descricao": "Exame1",
              "dataHora": "2025-07-07T13:21:05"
          },
          {
              "id": 2,
              "pacienteId": "4",
              "descricao": "Exame2",
              "dataHora": "2025-07-07T13:22:48"
          }
      ]

---
### 🛏️ Leito
- `POST /api/leitos` → Cria um leito
  <br><br>
    - **Request**
      ```
      {
          "numero": "101"
      }

- `GET /api/exames/{id}` → Lista Exames por id do paciente
  <br><br>
    - **Response**
      ```
      [
          {
              "id": 9,
              "numero": "101",
              "status": "DISPONIVEL"
          }
      ]

---
### 🏥 Internação
- `POST /api/internacoes?pacienteId={id}&leitoId={id}` → Interna um paciente
  <br><br>
    - **Request**
      ```
      {
          "id": 2,
          "paciente": {
              "id": 5,
              "nome": "jubliscleusu",
              "cpf": "1231231231",
              "dataNascimento": "1942-04-20",
              "endereco": "lisboa",
              "telefone": "1234-1234",
              "email": "eojubis@paciente.com"
          },
          "leito": {
              "id": 9,
              "numero": 101,
              "status": "OCUPADO"
          },
          "dataEntrada": "2025-07-07T21:14:01.6212164",
          "dataSaida": null
      }

- `PUT /api/internacoes/{id}` → Dá alta para um paciente
- `GET /api/internacoes` → Lista todas as internações
    - **Request**
      ```
      [
          {
              "id": 2,
              "paciente": {
                  "id": 5,
                  "nome": "jubliscleusu",
                  "cpf": "1231231231",
                  "dataNascimento": "1942-04-20",
                  "endereco": "lisboa",
                  "telefone": "1234-1234",
                  "email": "eojubis@paciente.com"
              },
              "leito": {
                  "id": 9,
                  "numero": 101,
                  "status": "OCUPADO"
              },
              "dataEntrada": "2025-07-07T21:14:01.6212164",
              "dataSaida": null
          }
      ]

---
### 💊 Suprimentos
- `POST /api/pacientes` → Criar paciente
- `PUT /api/pacientes/{id}` → Atualiza um paciente
  <br><br>
    - **Request**
      ```
      {
          "nome": "Comprimido",
          "quantidade": "3"
      }

    - **Response**
      ```
      {
          "id": 1,
          "nome": "Comprimido",
          "quantidade": 3
      }

- `GET /api/pacientes` → Listar todos pacientes
  <br><br>
    - **Response**
      ```
      [
          {
              "id": 1,
              "nome": "Comprimido",
              "quantidade": 3
          }
      ]

- `GET /api/pacientes/{id}` → Listar por id do paciente
  <br><br>
    - **Response**
      ```
      {
          "id": 1,
          "nome": "Comprimido",
          "quantidade": 3
      }

- `DELETE /api/pacientes/{id}` → Deleta um paciente