# Projeto Quartel

Este é o projeto trabalho da disciplina MATC84 - Laboratório de Programação Web - UFBA.

## Dependências:

Este projeto foi desenvolvido com o framework [Spring Boot](http://projects.spring.io/spring-boot/) na IDE Eclipse. Para dar manutenção a aplicação segue abaixo os requisitos:

 - [Eclipse IDE](http://www.eclipse.org/downloads/) com Spring Tools (ver no Marketplace) e [Gradle](https://gradle.org/) (gerenciar dependências do Java, já vem no Eclipse)
 - [Node.js](https://nodejs.org/en/) para o Yarn
 - [Yarn](https://www.npmjs.com/package/yarn) para gerenciar dependências js/css

## Estrutura Básica:

```
|-- Quartel
    |-- README.md
    |-- src
        |-- main
        |   |-- java
        |   |   |-- br
        |   |       |-- ufba
        |   |           |-- dcc
        |   |               |-- quartel
        |   |                   |-- app
        |   |                   |   |-- WebApp.java
        |   |                   |-- controllers
        |   |                   |-- forms
        |   |                   |-- models
        |   |                   |-- utils
        |   |-- resources
        |   |   |-- application.properties
        |   |   |-- static
        |   |   |-- templates
        |   |-- webapp
        |       |-- package.json
        |       |-- yarn.lock
        |       |-- public
        |       |   |-- css
        |       |   |   |-- main.css
        |       |   |-- img
        |       |   |-- js
        |       |   |   |-- main.js
        |       |   |-- media
        |       |   |-- uploads
        |       |   |-- vendor /*YARN MODULES FOLDER*/
        |       |-- views
        |           |-- login.jsp
        |           |-- templates /*JSP TEMPLATES*/
        |               |-- footer.jsp
        |               |-- header.jsp
        |-- test
            |-- java
                |-- br
                    |-- dcc
                        |-- ufba
                            |-- quartel
                                |-- WebAppTests.java

```

## Instruções:

#### Para executar o programa: 
 - Importe para o workspace do eclipse como um projeto Gradle.
 - Tenha certeza que já baixou as dependências pelo Gradle no Eclipse. (Refresh Gradle Project)
 - Verifique se a perspectiva do Spring está aberta.
 - No menu "Boot Dashboard" escolha o projeto e clique em no play para rodar o serviço em localhost:8080

#### Para instalar dependências com Yarn:
 - Para configurar a pasta public/vendor execute: `yarn install --modules-folder public/vendor` na pasta "webapp"
 - A pasta node_modules foi customizada para public/vendor então para adicionar dependências use `yarn add [package]@[version] --modules-folder public/vendor`

Se você não estiver vendo o menu Boot Dashboard vá em Window > Show View > Other > Spring > Boot Dashboard

## Links Úteis:

 - https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples
 - http://projects.spring.io/spring-framework/
 - http://www.mkyong.com/tutorials/spring-boot-tutorials/
 - http://www.devmedia.com.br/desenvolvendo-uma-aplicacao-web-com-spring-boot-e-spring-mvc/34122
 - https://www.tutorialspoint.com/spring/
