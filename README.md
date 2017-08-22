# Projeto Quartel

Este é o projeto trabalho da disciplina MATC84 - Laboratório de Programação Web - UFBA.

## Dependências:

Este projeto foi desenvolvido com o framework MVC [Spring Boot](http://projects.spring.io/spring-boot/) na IDE Eclipse. Para dar manutenção a aplicação segue abaixo os requisitos:

 - [Eclipse IDE](http://www.eclipse.org/downloads/) com Spring Tools (ver no Marketplace) e [Gradle](https://gradle.org/) (gerenciar dependências do Java, já vem no Eclipse)
 - MySql. Para facilitar recomendo baixarem o XAMPP ou WAMP para usar o PHPMyAdmin

## Estrutura Básica:

```
|-- Quartel
    |-- src
        |-- main
        |   |-- java
        |   |   |-- br
        |   |       |-- ufba
        |   |           |-- dcc
        |   |               |-- quartel
        |   |                   |-- app
        |   |                   |   |-- WebApp.java /* Classe MAIN */
        |   |                   |-- controllers /* Controllers com as rotas da aplicação */
        |   |                   |-- forms /* Classes para lidar com validação de formulários */
        |   |                   |-- models /* Mapeamento das entidades do banco */
                                |-- repositories /* Interfaces das entidades que já implementam todos os métodos CRUD */
        |   |                   |-- utils /* Alguns utilitários */
        |   |-- resources
        |   |   |-- application.properties /* Arquivo de configuração do spring */
        |   |-- webapp
        |       |-- public
        |       |   |-- css
        |       |   |-- img
        |       |   |-- js
        |       |   |-- media
        |       |   |-- uploads
        |       |   |-- vendor /*MÓDULOS DE TERCEIROS*/
        |       |-- views
        |           |-- templates /*JSP TEMPLATES*/
        |               |-- footer.jsp
        |               |-- header.jsp

```

## Instruções:

#### Para executar o programa: 
 - Com acesso ao seu MySql crie um usuário novo chamado quartel_user com senha hq@quartel. Defina a máquina de acesso como localhost
 - Em seguida seguida importe o banco de dados com o arquivo quartel.db.sql na pasta docs.
 - Importe o projeto para o workspace do eclipse como um projeto Gradle (Existing Gradle Project).
 - Tenha certeza que já baixou as dependências pelo Gradle no Eclipse. (Refresh Gradle Project)
 - Verifique se a perspectiva do Spring está aberta (No canto da janela com Open Perspetive).
 - No menu "Boot Dashboard" escolha o projeto e clique em no play para rodar o serviço em localhost:8080
 - Para manusear o diagrama de classes em models.ucls instale o plugin [Object AID](http://www.objectaid.com/installation) no Eclipse. Para usar Basta arrastar a classe para o arquivo
 - Para acessar a aplicação é possível utilizar o usuário padrão root, senha root@quartel

Se você não estiver vendo o menu Boot Dashboard vá em Window > Show View > Other > Spring > Boot Dashboard

## Links Úteis:

 - https://github.com/spring-projects/spring-boot/tree/master/spring-boot-samples
 - http://projects.spring.io/spring-framework/
 - http://www.mkyong.com/tutorials/spring-boot-tutorials/
 - http://www.devmedia.com.br/desenvolvendo-uma-aplicacao-web-com-spring-boot-e-spring-mvc/34122
 - https://www.tutorialspoint.com/spring/
 - https://www.tutorialspoint.com/hibernate/
 - https://hellokoding.com/registration-and-login-example-with-spring-security-spring-boot-spring-data-jpa-hsql-jsp/
 - https://medium.com/@gustavo.ponce.ch/spring-boot-spring-mvc-spring-security-mysql-a5d8545d837d
 - http://source.lishman.com/project/689#card/3327/file/19199
