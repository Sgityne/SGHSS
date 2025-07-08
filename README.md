![Java](https://img.shields.io/badge/java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=white)
![Spring](https://img.shields.io/badge/spring-%236DB33F.svg?style=for-the-badge&logo=spring&logoColor=white)
![MySQL](https://img.shields.io/badge/mysql-4479A1.svg?style=for-the-badge&logo=mysql&logoColor=white)
# Sistema de Gestão Hospitalar e de Serviços de Saúde

O projeto SGHSS visa oferecer uma solução integral para a administração de hospitais, clínicas, laboratórios e serviços de saúde em geral, satisfazendo as necessidades da organização VidaPlus.

Desenvolvido com Java e a estrutura Spring, o sistema disponibiliza recursos como registro, planejamento, prontuários, gestão administrativa e proteção de informações, em conformidade com a LGPD.

---

## Tecnologias Utilizadas
- **Java**
- **Spring Boot**
- **Spring Data JPA**
- **Spring Security**
- **JWT**
- **Hibernate**
- **MySQL**
- **Lombok**
- **Docker**
- **JPA/Hibernate**

---

## 🛠️ Configuração do ambiente de desenvolvimento

### 1. Pré-requisitos
- **JDK 17**
- **Docker**
- **Maven**

### 2. Clonar o repositorio
```
git clone https://github.com/Sgityne/SGHSS.git
cd SGHSS
```

### 3. Iniciar o docker
```
docker-compose up
```

### 4. Configurar o Banco de Dados
Crie um banco de dados no MySQL:
```sql
CREATE DATABASE sghss;
```

### 5. Executar o Projeto
```
mvn spring-boot:run
```
O sistema estará disponível em: `http://localhost:8080`

---

## Principais Funcionalidades

###  Pacientes
- Cadastro de dados pessoais.
- Visualização do seu prontuário.
- Agendamento e cancelamento de consultas.

### Profissionais de Saúde
- Gestão completa da agenda de atendimentos.
- Atualização e acompanhamento de prontuários.

### Administração Hospitalar
- Cadastro, gestão de pacientes e profissionais de saúde.
- Controle de internações.
- Gestão de estoque de suprimentos.

### Segurança e Compliance
- Criptografia e proteção de dados sensíveis.
- Controle de acesso por perfis (paciente, equipe médica, administrador).
- Adequação ao princípios da Lei Geral de Proteção de Dados (LGPD).

---

## 📂 Estrutura do Projeto

```
SGHSS
│── src/main/java/com/vidaplus/sghss
│   ├── config/ 
│   ├── controller/         
│   ├── dto/ 
│   ├── enums/ 
│   ├── model/             
│   ├── repository/         
│   ├── service/            
│   └── security/           
│── compose.yaml                 
│── pom.xml                 
└──  README.md              
```