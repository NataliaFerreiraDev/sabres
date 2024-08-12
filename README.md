# Controle de Sabres

## Descrição

O **Controle de Sabres** é um software desenvolvido para o cadastro e gerenciamento de sabres de luz. Este projeto tem como objetivo permitir o registro de diferentes tipos de sabres, bem como realizar operações de CRUD (Create, Read, Update, Delete) sobre os mesmos.

## Tecnologias Utilizadas

- **Java 17**: Linguagem de programação utilizada para o desenvolvimento do back-end.
- **JUnit 5**: Framework de testes unitários utilizado para garantir a qualidade do código Java.
- **Angular**: Framework JavaScript utilizado para o desenvolvimento do front-end.
- **Angular Material 15**: Conjunto de componentes de interface de usuário para Angular, utilizado para construir uma interface moderna e responsiva.

## Funcionalidades

- Cadastro de novos sabres de luz.
- Visualização de detalhes dos sabres cadastrados.
- Edição de informações de sabres.
- Remoção: Em vez de excluir registros, um flag deleted é utilizado para marcar sabres como removidos, preservando a integridade e o histórico dos dados.

## Estrutura do Projeto

### Back-end

- O back-end foi desenvolvido em Java 17 utilizando Spring Framework.
- Testes unitários foram implementados com JUnit 5 para garantir a confiabilidade das funcionalidades.

### Front-end

- O front-end foi desenvolvido em Angular, com a interface de usuário estilizada utilizando Angular Material 15.

## Instalação

### Pré-requisitos

- [Java 17](https://www.oracle.com/java/technologies/javase-jdk17-downloads.html)
- [Node.js](https://nodejs.org/en/) (para rodar o Angular)
- [Angular CLI](https://angular.io/cli) (para rodar os comandos Angular)

### Passos

1. **Clone o repositório:**
   ```bash
   git clone https://github.com/seu-usuario/controle-de-sabres.git

2. **Navegue até o diretório do back-end e compile o projeto:**
   ```bash
   cd controle-de-sabres/backend
   ./mvnw clean install

3. **Inicie o servidor back-end:**
   ```bash
   ./mvnw spring-boot:run

4. **Em um novo terminal, navegue até o diretório do front-end e instale as dependências:**
   ```bash
   cd ../frontend
   npm install

5. **Inicie o servidor front-end:**
   ```bash
   ng serve

6. **Acesse a aplicação em seu navegador no endereço:**
   ```bash
   [cd controle-de-sabres/backend
   ./mvnw clean install](http://localhost:4200)


## Contribuição

Contribuições são bem-vindas! Para contribuir com este projeto, siga os passos abaixo:

1. **Faça um fork do projeto:**
   Clique no botão "Fork" no canto superior direito da página do repositório no GitHub.

2. **Clone o repositório forkado:**
   ```bash
   git clone https://github.com/seu-usuario/controle-de-sabres.git

3. **Crie uma nova branch para suas alterações:**
   ```bash
   git checkout -b minha-nova-funcionalidade

4. **Faça as alterações desejadas no código.**

5. **Faça o commit das suas alterações:**
   ```bash
   git commit -m 'Adiciona nova funcionalidade'

6. **Envie suas alterações para o repositório forkado:**
   ```bash
   git push origin minha-nova-funcionalidade

7. **Abra um Pull Request:**
   - Vá até o repositório original no GitHub.
   - Clique em "Compare & pull request".
   - Descreva as alterações que você fez.
   - Envie o Pull Request para revisão.

## Licença

Este projeto está licenciado sob a [Licença MIT](LICENSE). Isso significa que você pode usar, modificar e distribuir o software livremente, desde que mantenha o aviso de copyright original e a licença incluídos em todas as cópias ou partes substanciais do software.
