# Projeto Quartel

Este é o projeto trabalho da disciplina MATC84 - Laboratório de Programação Web - UFBA.

## Dependências:

Este projeto foi desenvolvido com o framework MVC [Spring Boot](http://projects.spring.io/spring-boot/) na IDE Eclipse. Para dar manutenção a aplicação segue abaixo os requisitos:

 - [Eclipse IDE](http://www.eclipse.org/downloads/) com Spring Tools (ver no Marketplace) e [Gradle](https://gradle.org/) (gerenciar dependências do Java, já vem no Eclipse)
 - MySql. Para facilitar recomendo baixarem o XAMPP ou WAMP para usar o PHPMyAdmin

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
        |   |                   |-- controllers /* Controllers com as rotas da aplicação */
        |   |                   |-- forms
        |   |                   |-- models /* Mapeamento das entidades do banco */
                                |-- repositories /* Interfaces das entidades que já implementam todos os métodos CRUD */
        |   |                   |-- utils
        |   |-- resources
        |   |   |-- application.properties
        |   |   |-- static
        |   |   |-- templates
        |   |-- webapp
        |       |-- public
        |       |   |-- css
        |       |   |   |-- main.css
        |       |   |-- img
        |       |   |-- js
        |       |   |   |-- main.js
        |       |   |-- media
        |       |   |-- uploads
        |       |   |-- vendor /*MÓDULOS DE TERCEIROS*/
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
 - Com acesso ao seu MySql crie um usuário novo chamado quartel_user com senha hq@quartel. Defina a máquina de acesso como localhost
 - Em seguida seguida importe o banco de dados com o arquivo quartel.db.sql na pasta docs.
 - Importe para o workspace do eclipse como um projeto Gradle.
 - Tenha certeza que já baixou as dependências pelo Gradle no Eclipse. (Refresh Gradle Project)
 - Verifique se a perspectiva do Spring está aberta.
 - No menu "Boot Dashboard" escolha o projeto e clique em no play para rodar o serviço em localhost:8080

Se você não estiver vendo o menu Boot Dashboard vá em Window > Show View > Other > Spring > Boot Dashboard

## Links Úteis:

 - https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples
 - http://projects.spring.io/spring-framework/
 - http://www.mkyong.com/tutorials/spring-boot-tutorials/
 - http://www.devmedia.com.br/desenvolvendo-uma-aplicacao-web-com-spring-boot-e-spring-mvc/34122
 - https://www.tutorialspoint.com/spring/
 - https://www.tutorialspoint.com/hibernate/
