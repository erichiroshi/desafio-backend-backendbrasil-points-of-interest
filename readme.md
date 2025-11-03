<p align="center">
  <img width="30%" src="images/backendbr-logo.png" alt="Backend Brasil Logo">
</p>

<h3 align="center">Desafio Backend - Points of Interest</h3>

<p align="center">
  <img alt="License: MIT" src="https://img.shields.io/badge/license-MIT-%2304D361">
  <img alt="Language: Java" src="https://img.shields.io/badge/language-Java%2025-blue">
  <img alt="Version: 1.0" src="https://img.shields.io/badge/version-1.0-yellowgreen">
</p>

---

## 🧭 Visão Geral

Este projeto foi desenvolvido como parte do **desafio técnico Backend Brasil** e implementa uma **API de Pontos de Interesse (Points of Interest)**.  
O sistema permite **cadastrar, listar e buscar pontos de interesse** próximos a uma coordenada específica, utilizando cálculos de distância Euclidiana.

---

## 📚 Sumário

- [🧭 Visão Geral](#-visão-geral)
- [📚 Sumário](#-sumário)
- [⚙️ Tecnologias Utilizadas](#️-tecnologias-utilizadas)
- [🏗️ Arquitetura da Solução](#️-arquitetura-da-solução)
- [🚀 Execução do Projeto](#-execução-do-projeto)
  - [✅ Pré-requisitos](#-pré-requisitos)
  - [📥 Clonar o repositório](#-clonar-o-repositório)
  - [▶️ Rodar a aplicação](#️-rodar-a-aplicação)
  - [🧩 Acessar a documentação Swagger](#-acessar-a-documentação-swagger)
- [💬 Interagindo com a API](#-interagindo-com-a-api)
- [📬 Endpoints e Exemplos](#-endpoints-e-exemplos)
  - [1️⃣ Listar todos os pontos — `GET /points`](#1️⃣-listar-todos-os-pontos--get-points)
  - [2️⃣ Criar novo ponto — `POST /points`](#2️⃣-criar-novo-ponto--post-points)
  - [3️⃣ Buscar pontos próximos — `GET /points/near?x=20&y=10&dMax=10`](#3️⃣-buscar-pontos-próximos--get-pointsnearx20y10dmax10)
- [🤝 Contribuições](#-contribuições)
- [🔗 Referências e Créditos](#-referências-e-créditos)

---

## ⚙️ Tecnologias Utilizadas

| Tecnologia | Finalidade |
|-------------|-------------|
| ☕ **Java 25** | Linguagem principal |
| 🍃 **Spring Boot 3.5.7** | Framework de aplicação |
| 🧩 **Spring Data JPA** | Persistência e mapeamento com H2 Database |
| 💾 **H2 Database** | Banco de dados em memória para testes |
| 🩺 **Spring Boot Actuator** | Monitoramento e métricas da aplicação |
| ⚡ **Spring Boot DevTools** | Hot reload e ferramentas de desenvolvimento |
| 🌐 **Spring Web (Spring MVC)** | Criação de endpoints RESTful |
| 📘 **Springdoc OpenAPI (Swagger UI)** | Documentação interativa da API |
| 🧰 **Lombok** | Redução de boilerplate |

---

## 🏗️ Arquitetura da Solução

```
[Cliente / Postman / Swagger UI]
        ↓
  REST API (Spring Boot)
        ↓
 [PointsController]
   ├── GET /points → lista todos os pontos
   ├── POST /points → cria novo ponto
   └── GET /points/near → busca pontos próximos
        ↓
 [Service Layer]
   └── PointsService (regras de distância e filtragem)
        ↓
 [Repository]
   └── JpaRepository (persistência em H2)
```

---

## 🚀 Execução do Projeto

### ✅ Pré-requisitos
- **Java 25+**
- **Maven 3.9+**

### 📥 Clonar o repositório

```bash
git clone https://github.com/erichiroshi/desafio-backend-backendbrasil-points-of-interest.git
cd desafio-backend-backendbrasil-points-of-interest
```

### ▶️ Rodar a aplicação

```bash
./mvnw spring-boot:run
```

A aplicação estará disponível em:  
👉 [http://localhost:8080](http://localhost:8080)

### 🧩 Acessar a documentação Swagger
👉 [http://localhost:8080/swagger-ui.html](http://localhost:8080/swagger-ui.html)

---

## 💬 Interagindo com a API

As requisições podem ser testadas via **Postman**, **Insomnia** ou **Swagger UI**.

---

## 📬 Endpoints e Exemplos

### 1️⃣ Listar todos os pontos — `GET /points`

**Response**
```json
[
  {
    "id": 1,
    "name": "Lanchonete",
    "x": 27,
    "y": 12
  },
  {
    "id": 2,
    "name": "Posto",
    "x": 31,
    "y": 18
  }
]
```

---

### 2️⃣ Criar novo ponto — `POST /points`

**Request Body**
```json
{
  "name": "Supermercado",
  "x": 20,
  "y": 10
}
```

**Response**
```http
HTTP/1.1 201 Created
Location: /points/3
```

---

### 3️⃣ Buscar pontos próximos — `GET /points/near?x=20&y=10&dMax=10`

**Response**
```json
[
  {
    "name": "Supermercado",
  },
  {
    "name": "Farmácia",
  }
]
```

---

## 🤝 Contribuições

Contribuições são sempre bem-vindas!  
Para contribuir:

1. Crie um fork do repositório.  
2. Crie uma branch de feature:  
   ```bash
   git checkout -b feature/nova-funcionalidade
   ```
3. Commit suas mudanças:  
   ```bash
   git commit -m "feat: nova funcionalidade"
   ```
4. Envie um Pull Request.  

📜 **Boas práticas**
- Adicione testes unitários.  
- Documente suas alterações no código.  
- Use mensagens de commit seguindo o padrão **Conventional Commits**.

---

## 🔗 Referências e Créditos

- Desafio original: [Backend Brasil - Points of Interest](https://github.com/backend-br/desafios/blob/master/points-of-interest/PROBLEM.md)
- Baseado no conteúdo do canal [Build & Run](https://www.youtube.com/watch?v=Vc-V310gY5I&list=PLxCh3SsamNs7y1Y-QaVdWx0MUh0wvo7TV&index=8)
- Repositório: [desafio-backend-backendbrasil-points-of-interest](https://github.com/erichiroshi/desafio-backend-backendbrasil-points-of-interest)
- Desenvolvido por [**Eric Hiroshi**](https://github.com/erichiroshi)
- Licença: [MIT](LICENSE)

---

<p align="center">
  <em>“Código limpo é aquele que expressa a intenção com simplicidade e precisão.”</em>
</p>
