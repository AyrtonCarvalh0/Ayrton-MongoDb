# 🗂️ Ayrton-MongoDb (Workshop MongoDB)

Projeto desenvolvido como exercício prático do curso de Java do Nélio Alves, com foco na construção de uma API REST utilizando Spring Boot e MongoDB.

A aplicação simula uma pequena rede social onde usuários podem criar posts e adicionar comentários. O projeto explora modelagem de documentos, relacionamentos entre dados e consultas avançadas utilizando Spring Data MongoDB.

---

## 🎯 Objetivo

Aplicar na prática:

- Modelagem de dados em banco NoSQL (MongoDB)
- Criação de API REST com Spring Boot
- Relacionamento entre documentos (User → Post → Comment)
- Uso de DTOs para evitar acoplamento e problemas de serialização
- Consultas por texto e intervalo de datas
- Estruturação em camadas (Controller, Service, Repository)

---

## 🧠 Estrutura da Aplicação

### 📌 User
- Nome  
- Email  
- Lista de posts associados  

### 📌 Post
- Título  
- Corpo  
- Data  
- Autor (AuthorDTO)  
- Lista de comentários  

### 📌 Comment
- Texto  
- Data  
- Autor (AuthorDTO)  

O MongoDB armazena os dados como documentos.  
Os comentários são armazenados dentro do documento de Post, enquanto o autor é representado por um DTO para manter a resposta leve e organizada.

---

## 🔎 Principais Funcionalidades

- Criar, listar, atualizar e deletar usuários  
- Criar posts associados a usuários  
- Adicionar comentários a posts  
- Buscar posts por:
  - Texto  
  - Intervalo de datas  
- Consultar posts de um usuário específico  

---

## 🛠️ Tecnologias

- Java 21  
- Spring Boot  
- Spring Web  
- Spring Data MongoDB  
- MongoDB  
- Maven  

---

## 🚀 Como executar

### 1️⃣ Requisitos
- Java 21  
- MongoDB rodando localmente **ou** MongoDB Atlas  

### 2️⃣ Clonar o repositório
git clone https://github.com/AyrtonCarvalh0/Ayrton-MongoDb.git
cd Ayrton-MongoDb
./mvnw spring-boot:run

###3️⃣ Configurar conexão
No arquivo application.properties:

spring.data.mongodb.uri=mongodb://localhost:27017/workshopMongo
server.port=8080

###4️⃣ Executar a aplicação
Windows:
mvnw.cmd spring-boot:run

Linux/Mac:
./mvnw spring-boot:run

A API ficará disponível em:
http://localhost:8080
