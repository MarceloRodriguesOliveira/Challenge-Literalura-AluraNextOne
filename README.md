Literalura

Projeto desenvolvido em Java com Spring Boot, que permite gerenciar livros e autores de forma interativa via console. O sistema oferece funcionalidades de consulta e listagem de livros e autores.

Funcionalidades

O menu principal oferece as seguintes opções:

Buscar livro pelo título
Permite pesquisar um livro pelo seu título e registrar a busca.

Listar livros registrados
Exibe todos os livros cadastrados no sistema.

Listar autores registrados
Exibe todos os autores presentes na base de dados.

Listar autores vivos em um determinado ano
Permite filtrar autores que estavam vivos em um ano específico.

Listar livros em um determinado idioma
Filtra os livros cadastrados pelo idioma.

Sair
Encerra o programa.

Tecnologias utilizadas

Java 17+

Spring Boot 3

JPA / Hibernate

Banco de dados: PostgreSQL

Maven

Estrutura do projeto

LiteraluraApplication – Classe principal que inicia a aplicação.

MainMenuComponent – Gerencia o menu interativo do console.

BookService – Lógica de negócios relacionada aos livros.

AuthorService – Lógica de negócios relacionada aos autores.

InputReader – Classe utilitária para ler entradas do usuário via console.

entity – Contém entidades Book e Author.

repository – Contém os repositórios JPA para persistência de dados.

Como rodar o projeto

Clone o repositório:

git clone git@github.com:SeuUsuario/Literalura.git
cd Literalura

Compile e rode a aplicação usando Maven:

./mvnw spring-boot:run

O menu será exibido no console:

- Buscar livro pelo título
- Listar livros registrados
- Listar autores registrados
- Listar autores vivos em um determinado ano
- Listar livros em um determinado idioma
0 - sair

Insira o número da opção desejada e siga as instruções.

Observações

O InputReader é gerenciado pelo Spring, garantindo que entradas do usuário sejam lidas corretamente sem causar NullPointerException.

O projeto pode ser facilmente expandido para utilizar outros bancos de dados, basta configurar no seu application.properties
