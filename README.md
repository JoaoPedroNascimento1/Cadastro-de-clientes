Segue o **README.md completo, atualizado e consolidado**, agora com:

* ✅ Docker + PostgreSQL
* ✅ Segurança com roles (`ROLE_BASIC` e `ROLE_ADMIN`)
* ✅ Controle de acesso correto (SEM PUT)
* ✅ Tudo integrado em um único documento profissional

---

# 📌 Sistema de Cadastro de Clientes API

## 📖 Descrição

Este projeto consiste em uma API RESTful para gerenciamento de clientes, desenvolvida utilizando **Java com Spring Boot**.

O sistema foi projetado para organizar e controlar dados de clientes, permitindo operações de cadastro, consulta e remoção de forma segura.

A aplicação aplica boas práticas de desenvolvimento backend, incluindo arquitetura em camadas, validação de dados e autenticação com **JWT (JSON Web Token)**.

---

## 🚀 Tecnologias Utilizadas

* **Java 17+**
* **Spring Boot**
* **Spring Web**
* **Spring Data JPA**
* **Spring Security**
* **JWT**
* **Hibernate**
* **Validation**
* **PostgreSQL**
* **Maven**
* **Docker & Docker Compose**

Ferramentas:

* Postman / Insomnia
* Git e GitHub

---

## 🏗️ Arquitetura e Decisões Técnicas

Arquitetura em camadas:

```id="x5b17y"
Controller → Service → Repository → Entity
```

### 🔹 Decisões adotadas:

* Separação de responsabilidades
* Uso de DTOs
* Segurança stateless com JWT
* Integração com banco via JPA
* Estrutura preparada para escalabilidade

---

## ⚙️ Funcionalidades

* ✅ Cadastro de usuários
* ✅ Autenticação com JWT
* ✅ CRUD parcial de clientes:

  * Criar cliente
  * Listar clientes
  * Buscar por ID
  * Deletar cliente
* ✅ Controle de acesso por roles

---

## 🔐 Segurança

A aplicação utiliza **Spring Security + JWT**, com controle de acesso baseado em roles.

---

### 🔹 Roles do sistema

* `ROLE_BASIC` → Pode **apenas visualizar** clientes
* `ROLE_ADMIN` → Pode **gerenciar clientes**

---

### 🔹 Autenticação

1. Login com email e senha
2. Geração de token JWT
3. Envio no header:

```http id="pn3rfe"
Authorization: Bearer <token>
```

4. Filtro valida e autentica o usuário

---

### 🔒 Autorização (Controle de acesso)

| Endpoint                | BASIC | ADMIN |
| ----------------------- | ----- | ----- |
| `/auth/**`              | ✅     | ✅     |
| `GET /clientes`         | ✅     | ✅     |
| `GET /clientes/{id}`    | ✅     | ✅     |
| `POST /clientes`        | ❌     | ✅     |
| `DELETE /clientes/{id}` | ❌     | ✅     |

---

### 🔒 Regras do ClienteController

#### ✔ `ROLE_BASIC`

* Listar clientes
* Buscar cliente por ID

---

#### ✔ `ROLE_ADMIN`

* Criar clientes
* Deletar clientes
* Visualizar clientes

---

### 🔹 Garantias de segurança

* 🔐 Autenticação stateless
* 🔐 Autorização por roles
* 🔐 Separação entre leitura e escrita

---

## ▶️ Como Executar o Projeto

### 🔹 Execução local

```bash id="gjs12n"
git clone https://github.com/JoaoPedroNascimento1/Cadastro-de-clientes.git
cd Cadastro-de-clientes
mvn spring-boot:run
```

---

## 🐳 Executando com Docker (PostgreSQL)

### 📋 Pré-requisitos

```bash id="llst6u"
docker --version
docker-compose --version
```

---

### ⚙️ Passo a passo

#### 1. Clonar o projeto

```bash id="duhivp"
git clone https://github.com/JoaoPedroNascimento1/Cadastro-de-clientes.git
cd Cadastro-de-clientes
```

---

#### 2. Subir containers

```bash id="jgoa4u"
docker-compose up --build
```

Isso irá:

* Baixar PostgreSQL
* Criar banco automaticamente
* Subir a aplicação

---

#### 3. Acessar

```id="em18c2"
http://localhost:8080
```

---

### 🗄️ Configuração do banco

* Host: `db`
* Porta: `5432`
* Database: `clientes_db`
* Usuário: `postgres`
* Senha: `postgres`

---

### 🔄 Comandos úteis

```bash id="e9j9b1"
docker-compose down
docker-compose up
docker-compose down -v
```

---

### 📦 docker-compose.yml

```yaml id="9g8u0m"
version: '3.8'

services:
  db:
    image: postgres:15
    container_name: postgres-db
    environment:
      POSTGRES_DB: clientes_db
      POSTGRES_USER: postgres
      POSTGRES_PASSWORD: postgres
    ports:
      - "5432:5432"
    volumes:
      - postgres_data:/var/lib/postgresql/data

  app:
    build: .
    container_name: clientes-api
    ports:
      - "8080:8080"
    depends_on:
      - db
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://db:5432/clientes_db
      SPRING_DATASOURCE_USERNAME: postgres
      SPRING_DATASOURCE_PASSWORD: postgres

volumes:
  postgres_data:
```

---

## 📡 Endpoints da API

### 🔐 Login

```http id="trq79v"
POST /auth/login
```

---

### 👤 Clientes

#### Listar

```http id="0pt6qg"
GET /clientes
```

---

#### Buscar por ID

```http id="k3fnhl"
GET /clientes/{id}
```

---

#### Criar

```http id="e3nfwc"
POST /clientes
```

---

#### Deletar

```http id="h7htg9"
DELETE /clientes/{id}
```

---

## 📂 Estrutura de Pastas

```id="q1bbfl"
src/main/java/

├── controller
├── service
├── repository
├── entity
├── dto
├── security
├── config
```

---

## 🔮 Melhorias Futuras

* Paginação
* Swagger
* Testes automatizados
* Deploy em cloud
* Controle mais avançado de permissões

---

## ⭐ Diferenciais do Projeto

* ✔ Segurança com JWT
* ✔ Controle de acesso por roles
* ✔ Integração com PostgreSQL via Docker

---

## 👨‍💻 Autor

**João Pedro Nascimento**

* GitHub: [https://github.com/JoaoPedroNascimento1](https://github.com/JoaoPedroNascimento1)
* LinkedIn: *(https://www.linkedin.com/in/joaopedronascimento1/)*

---

