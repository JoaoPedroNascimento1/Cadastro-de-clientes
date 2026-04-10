# Cadastro de Clientes API

## Sobre o Projeto
API REST desenvolvida para gerenciamento de clientes, com foco em boas práticas de desenvolvimento backend utilizando Java e Spring Boot.

O projeto foi construído com arquitetura em camadas, autenticação JWT, controle de permissões por roles e documentação interativa da API via Swagger/OpenAPI, simulando uma aplicação backend utilizada em ambientes reais de mercado.

---

## Tecnologias Utilizadas

- Java 17
- Spring Boot
- Spring Security
- JWT (JSON Web Token)
- Spring Data JPA
- PostgreSQL
- Docker / Docker Compose
- Swagger / OpenAPI
- Maven

---

## Funcionalidades

### Autenticação e Segurança
- Login com autenticação JWT
- Proteção de rotas privadas
- Controle de acesso baseado em Roles
- Diferenciação entre usuários ADMIN e BASIC

### Gestão de Clientes
- Cadastro de clientes
- Listagem de clientes
- Busca de cliente por ID
- Exclusão de clientes

### Documentação
- Documentação completa dos endpoints com Swagger/OpenAPI

---

## Arquitetura do Projeto

O projeto segue o padrão de arquitetura em camadas:

```text
Controller → Service → Repository → Database
```

### Organização das Responsabilidades

- **Controller:** Responsável por receber requisições HTTP e retornar respostas.
- **Service:** Contém regras de negócio da aplicação.
- **Repository:** Responsável pela comunicação com banco de dados.
- **DTOs:** Utilizados para transferência segura de dados.
- **Security:** Configuração de autenticação/autorização JWT.

---

## Diferenciais Técnicos

Este projeto implementa conceitos importantes utilizados no mercado backend:

- Arquitetura RESTful
- Separação de responsabilidades (SRP)
- Autenticação Stateless com JWT
- Controle de permissões com Spring Security
- Documentação desacoplada utilizando interfaces Swagger
- Containerização com Docker
- Boas práticas de organização e Clean Code

---

## Como Executar o Projeto

### Pré-requisitos

- Java 17+
- Maven
- Docker / Docker Compose
- PostgreSQL (caso não utilize Docker)

---

### Clonar Repositório

```bash
git clone https://github.com/JoaoPedroNascimento1/Cadastro-de-clientes.git
```

---

### Executar com Docker

```bash
docker-compose up -d
```

---

### Executar Aplicação

```bash
./mvnw spring-boot:run
```

---

## Documentação da API

Após iniciar a aplicação:

```bash
http://localhost:8080/swagger-ui/index.html
```

---

## Principais Endpoints

### Autenticação

| Método | Endpoint | Descrição |
|--------|---------|----------|
| POST | /auth/login | Realiza login do usuário |

---

### Clientes

| Método | Endpoint | Descrição |
|--------|---------|----------|
| POST | /clientes | Cadastra novo cliente |
| GET | /clientes | Lista todos os clientes |
| GET | /clientes/{id} | Busca cliente por ID |
| DELETE | /clientes/{id} | Remove cliente |

---

## Autor

Desenvolvido por **João Pedro Nascimento**

[LinkedIn](https://www.linkedin.com/in/joaopedronascimento1) • [GitHub](https://github.com/JoaoPedroNascimento1)
