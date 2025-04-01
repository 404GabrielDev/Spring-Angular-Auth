# 🛡️ Register/Login - Angular & Spring Boot

Este é um projeto simples de **registro e login**, desenvolvido com **Angular no frontend** e **Java + Spring Boot no backend**, utilizando **Spring Security** para autenticação.  
As senhas dos usuários são **criptografadas** antes de serem armazenadas no banco de dados.

---

## 🚀 **Tecnologias Utilizadas**
### 🔹 **Frontend**:
- [Angular](https://angular.io/)
- [Angular Forms](https://angular.io/guide/forms)
- [Angular Router](https://angular.io/guide/router)

### 🔹 **Backend**:
- [Java 17+](https://www.oracle.com/java/)
- [Spring Boot](https://spring.io/projects/spring-boot)
- [Spring Security](https://spring.io/projects/spring-security)
- [Spring Data JPA](https://spring.io/projects/spring-data-jpa)
- [PostgreSQL](https://www.postgresql.org/)
- [BCrypt](https://docs.spring.io/spring-security/reference/features/authentication/password-storage.html) (para criptografia de senha)

---

## ⚙️ **Como Rodar o Projeto**
### 🖥️ **Backend (Spring Boot)**
1. **Clone o repositório**:
   ```bash
   git [clone https://github.com/seu-usuario/nome-do-repositorio.git](https://github.com/404GabrielDev/Java-Angular-Auth/tree/backend)
   cd /backend
   ```

## 2. *Configure o banco de dados no application.properties*


```spring.datasource.url=jdbc:postgresql://localhost:5432/seu_banco
spring.datasource.username=seu_usuario
spring.datasource.password=sua_senha
```

## 2. ##Instale as dependências:
```
npm install
```

## 3. Inicie o servidor de desenvolvimento:
```bash
ng serve
```

## 4. Acesse no navegador:
http://localhost:4200

🔒 Segurança
* A senha do usuário é criptografada com BCrypt antes de ser salva no banco de dados.

* Spring Security protege as rotas do backend.

* Ainda não utiliza JWT para autenticação, mas pode ser adicionado futuramente.

´´´bash
📦 backendangular
├── 📂 backend
│   ├── 📂 src/main/java/com/example/auth
│   │   ├── 📂 controller  # Controllers das rotas
│   │   ├── 📂 service      # Regras de negócio
│   │   ├── 📂 repository   # Interfaces do banco de dados
│   │   ├── 📂 model        # Modelos de entidade
│   │   ├── 📂 config       # Configuração do Spring Security
│   │   ├── Application.java  # Ponto de entrada da aplicação
│   ├── pom.xml  # Dependências do Maven
│
├── 📂 frontend
│   ├── 📂 src/app
│   │   ├── 📂 components  # Componentes da aplicação
│   │   ├── 📂 services    # Serviços para comunicação com o backend
│   │   ├── app.module.ts  # Módulo principal
│   ├── angular.json  # Configuração do Angular
│
└── README.md  # Este arquivo 📄
´´´

👤 Autor
Feito por João Gabriel.





