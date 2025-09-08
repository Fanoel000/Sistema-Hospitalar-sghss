🏥 Sistema Hospitalar — Documentação
Sistema de gerenciamento hospitalar com autenticação
por token JWT, controle de acesso por roles
(Médico/Enfermeiro), documentação automática
via Swagger UI e persistência em MySQL. 

✅ Tecnologias Utilizadas
Spring Boot 3.3.13 (Java 17+)
Spring Security — Autenticação e Autorização
JWT (JSON Web Token) — Autenticação stateless
MySQL — Banco de dados relacional
Spring Data JPA — Persistência
Swagger UI (OpenAPI 3) — Documentação da API
Lombok — Redução de boilerplate
Maven — Gerenciamento de dependências

🚀 Como Executar o Projeto
Pré-requisitos
JDK 17+
MySQL 8+
Maven 3.6+
Passo 1: Configurar o Banco de Dados
Crie o banco de dados HospitalCWB (ou altere no application.properties):

CREATE DATABASE IF NOT EXISTS HospitalCWB;
Passo 2: Configurar application.properties
Arquivo: src/main/resources/application.properties

# MySQL
spring.datasource.url=jdbc:mysql://localhost:3306/HospitalCWB?createDatabaseIfNotExist=true&useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=sua_senha_aqui

# JPA
spring.jpa.hibernate.ddl-auto=update
spring.jpa.show-sql=true

# JWT
app.jwtSecret=MinhaChaveSecretaSuperSegura1234567890
app.jwtExpirationMs=86400000 # 24 horas

# Swagger
springdoc.swagger-ui.path=/swagger-ui.html
springdoc.api-docs.path=/v3/api-docs
springdoc.swagger-ui.disable-swagger-default-url=true

Passo 3: Compilar e Executar
mvn clean compile spring-boot:run

✅ Botão 🔐 Authorize disponível para autenticação.

Endpoints Principais
🔐 Autenticação

POST
/auth/register Registrar novo usuário (Médico/Enfermeiro)

POST
/auth/login Gerar token JWT

Exemplo de Registro
{
  "email": "medico@hospital.com",
  "senha": "123456",
  "profissao": "Medico"
}

Exemplo de Login
{
  "email": "medico@hospital.com",
  "senha": "123456"
}

Estrutura do Projeto

src/main/java/com/hospitalcmb/Hospital/
├── config/          # Configurações de Security, JWT, Swagger
├── controller/      # Controllers REST
├── model/           # Entidades JPA
├── repository/      # Repositórios JPA
├── service/         # Serviços de negócio
├── security/        # JWT Utils e UserDetails
└── exception/       # Exceções customizadas

Testando com Postman
Importe a coleção do Swagger:
➤ No Postman: Import → Link → Cole: http://localhost:8080/v3/api-docs
Use o token JWT no header:
➤ Authorization: Bearer SEU_TOKEN_AQUI

Licença
MIT License — Livre para uso, modificação e distribuição.
