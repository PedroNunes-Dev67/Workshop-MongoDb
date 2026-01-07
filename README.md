# 🌿🖥️ Rede Social com MongoDB
![Java](https://img.shields.io/badge/Java-21-orange?style=for-the-badge&logo=java)
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-3.5-green?style=for-the-badge&logo=springboot)
![MongoDB](https://img.shields.io/badge/MongoDB-Database-green?style=for-the-badge&logo=mongodb)
![Swagger](https://img.shields.io/badge/Swagger-OpenAPI%203.0-85EA2D?style=for-the-badge&logo=swagger)
![License](https://img.shields.io/badge/License-MIT-yellow?style=for-the-badge)

> API REST para posts e comentários utilizando banco NoSQL com queries avançadas e
relacionamentos entre documentos.

---

## 📋 Sobre o Projeto
O Rede-Social-MongoDB é uma aplicação de exemplo tipo rede social construída em Java, que demonstra o uso de MongoDB (banco de dados NoSQL) para persistência de dados. O foco principal do projeto é criar uma API REST para posts e comentários, explorando funcionalidades avançadas do MongoDB, como consultas complexas e relacionamentos entre documentos, sem utilizar um banco relacional tradicional. 
github.com

### ✨ Principais Caracterísicas
- ✅ **Agregação entre documentos** - Como é a agregação entre dois documentos ou mais
- ✅ **Validação de dados** - Bean Validation para garantir integridade dos dados
- ✅ **Tratamento de Exceções** - Respostas HTTP padronizadas e mensagens de erro claras
- ✅ **Documentação Interativa** - Swagger UI para testar endpoints facilmente

  ---
## 🚀 Tecnologias Utilizadas 

### Back-end
- **Java 21** - Linguagem de programação
- **Spring Boot 3.5** - Framework para desenvolvimento de aplicações
- **Spring Data MongoDB** - Persistência de dados

### Banco de Dados
- **MongoDB** - Banco de dados NoSql

### Documentação
- **SpringDoc OpenAPI 3** - Geração automática de documentação
- **Swagger UI** - Interface interativa para testes

### Validação
- **Bean Validation (Jakarta)** - Validação de dados de entrada

### Build & Deploy
- **Maven** - Gerenciamento de dependências
---

## 📸 Screenshots

### Swagger UI - Endpoints Disponíveis
![Swagger UI](public/)

### Exemplo de Resposta
![JSON Response](public/)

---

## 🛠️ Pré-requisitos

Antes de começar, você vai precisar ter instalado em sua máquina:

- [Java JDK 21+](https://www.oracle.com/java/technologies/downloads/)
- [MongoDB 8+](https://www.mongodb.com/try/download/community)
- [Maven 3.8+](https://maven.apache.org/download.cgi)
- [Git](https://git-scm.com/downloads)

---

## 🔧 Como Executar o Projeto

### ⚠️ Certifique-se de que o MongoDB esteja instalado corretamente na sua máquina, na porta 27017

### 1️⃣ Clone o repositório

```bash
git clone https://github.com/PedroNunes-Dev67/Workshop-MongoDb.git
cd Workshop-MongoDb
```
### 2️⃣ Execute a aplicação

```bash
# Usando Maven
mvn spring-boot:run

# Ou compilando o JAR
mvn clean package
java -jar target/workshop-mongodb-0.0.1-SNAPSHOT.jar
```

### 3️⃣ Acesse a documentação Swagger

Abra seu navegador e acesse:

```
http://localhost:8080/swagger-ui.html
```

## 📚 Endpoints da API

### 💁🏽 Users

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/users` | Lista todos os usuários |
| `GET` | `/users/{id}` | Busca usuário por ID |
| `POST` | `/users` | Cria um novo usuário |
| `PUT` | `/users/{id}` | Atualiza dados do usuário |
| `DELETE` | `/users/{id}` | Remove um usuário |

### 🚩 Posts

| Método | Endpoint | Descrição |
|--------|----------|-----------|
| `GET` | `/posts/{id}` | Busca post por id |
| `GET` | `/posts/titlesearch` | Busca post por alguma palavra no titulo |
| `POST` | `/posts/fullsearch` | Busca post por alguma palavra em geral e entre datas como paramentro |

## 📝 Exemplo de Requisição

### POST `/users` - Criar novo usuário

**Request Body:**
```json
{
  "nome": "Pedro Nunes",
  "email": "pedro@example.com"
}
```

**Response (201 Created):**
```json
{
  "id": aideaiefn2342mesm123m32,
  "nome": "Pedro Nunes",
  "email": "pedro@example.com"
}
```

## ✅ Validações Implementadas

A API possui validações robustas para garantir a qualidade dos dados:

| Campo | Validações |
|-------|------------|
| **Nome** | Não pode ser vazio |
| **Email** | Formato de email válido; Único no sistema |

---

## 🔒 Tratamento de Exceções

A API retorna respostas HTTP padronizadas para diferentes cenários:

| Status Code | Descrição |
|-------------|-----------|
| `200 OK` | Requisição bem-sucedida |
| `201 Created` | Recurso criado com sucesso |
| `400 Bad Request` | Dados de entrada inválidos |
| `404 Not Found` | Recurso não encontrado |
| `409 Conflict` | Conflito (ex: email já cadastrado) |
| `500 Internal Server Error` | Erro interno do servidor |

**Exemplo de resposta de erro:**
```json
{
  "moment": "2025-12-27T10:30:00Z",
  "status": 409,
  "message": "Email já cadastrado no sistema",
  "path": "/usuarios"
}
```

---


## 📦 Build do Projeto

Para gerar o arquivo JAR executável:

```bash
mvn clean package
```

O arquivo será gerado em: `target/crud-usuario-swagger-0.0.1-SNAPSHOT.jar`

---
## 🌱 Próximas Melhorias

- [ ] Implementar autenticação JWT
- [ ] Criar testes unitários com JUnit e Mockito
- [ ] Adicionar filtros de busca (por nome, email, etc)
- [ ] Configurar Docker Compose
- [ ] Deploy em produção (Railway/Render)

---

## 🤝 Contribuições

Contribuições são sempre bem-vindas! Para contribuir:

1. Faça um fork do projeto
2. Crie uma branch para sua feature (`git checkout -b feature/MinhaFeature`)
3. Commit suas mudanças (`git commit -m 'Adiciona nova feature'`)
4. Push para a branch (`git push origin feature/MinhaFeature`)
5. Abra um Pull Request

---

## 📄 Licença

Este projeto está sob a licença MIT. Veja o arquivo [LICENSE](LICENSE) para mais detalhes.

---

## 👤 Autor

**Pedro Nunes**

- 🔗 GitHub: [@PedroNunes-Dev67](https://github.com/PedroNunes-Dev67)
- 💼 LinkedIn: [Pedro Nunes](https://www.linkedin.com/in/pedro-nunes-dev67)
- 📧 Email: pedrovitornunes89@gmail.com
- 📱 Telefone: (81) 99102-4299

---

## 🙏 Agradecimentos

- [DIO](https://www.dio.me/) - Pela plataforma de ensino e pelo bootcamp
- [Spring Framework](https://spring.io/) - Pela excelente documentação
- [SpringDoc OpenAPI](https://springdoc.org/) - Pela facilidade de integração do Swagger

---

<div align="center">

### ⭐ Se este projeto foi útil para você, considere dar uma estrela!

**Desenvolvido com ☕ e 💙 por Pedro Nunes**

</div>
