
# Gastos API - Estudo Java com PostgreSQL

Este projeto é uma aplicação Java que utiliza PostgreSQL como banco de dados. Feito para estudo.

## Pré-requisitos

- Java JDK 11 ou superior
- PostgreSQL 12 ou superior
- Maven 3.6 ou superior (se for um projeto Maven)
- IDE de sua preferência (IntelliJ, Eclipse, VS Code, etc.)

## Configuração do Banco de Dados

1. Instale e configure o PostgreSQL em seu sistema
2. Crie um banco de dados para o projeto:
   ```sql
   CREATE DATABASE nome_do_banco;
   ```
3. Crie um usuário e conceda permissões (opcional):
   ```sql
   CREATE USER usuario WITH PASSWORD 'senha';
   GRANT ALL PRIVILEGES ON DATABASE nome_do_banco TO usuario;
   ```

## Configuração do Projeto

1. Clone o repositório:
   ```bash
   git clone [URL do repositório**]
   ```
2. Configure as credenciais do banco de dados no arquivo `src/main/resources/application.properties` (para Spring Boot) ou no local apropriado de configuração:
   ```properties
   spring.datasource.url=jdbc:postgresql://localhost:5432/nome_do_banco
   spring.datasource.username=usuario
   spring.datasource.password=senha
   spring.jpa.hibernate.ddl-auto=update
   ```

## Estrutura do Projeto

```
projeto-java-postgresql/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/
│   │   │       └── exemplo/
│   │   │           ├── controller/       # Controladores REST
│   │   │           ├── model/            # Entidades JPA
│   │   │           ├── repository/       # Repositórios Spring Data
│   │   │           ├── service/          # Lógica de negócio
│   │   │           └── Application.java  # Classe principal
│   │   └── resources/
│   │       ├── application.properties    # Configurações
│   │       └── static/                  # Arquivos estáticos
│   └── test/                            # Testes
├── pom.xml                              # Configuração Maven
└── README.md
```

## Executando o Projeto

1. Compile o projeto:
   ```bash
   mvn clean install
   ```
2. Execute a aplicação:
   ```bash
   mvn spring-boot:run
   ```
   Ou execute a classe `Application.java` diretamente em sua IDE

## Endpoints da API

- `GET /gastos` - Lista todos os Gastos
- `POST /gastos` - Cria um Gasto
- `GET /gastos/total` - Calcula o gasto total
- `PUT /gastos/{id}` - Atualiza um Gasto
- `DELETE /gastos/{id}` - Remove um Gasto

## Testes

Para executar os testes:
```bash
  mvn test
```

## Licença

[MIT License](LICENSE)
