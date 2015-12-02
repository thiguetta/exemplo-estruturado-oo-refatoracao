#Instruções para execução deste projeto

Antes de importar o projeto em sua IDE preferida, verifique se possua o maven instalado, caso não, acesse [esse site](https://maven.apache.org) e siga as instruções de instalação.

Em seguida, importe o arquivo `agenda.sql` no seu MySQL.

Na primeira execução do projeto ele irá baixar as dependências descritas no `pom.xml`. 

Se estiver utilizando uma IDE basta executar o projeto.

Se desejar utilizar o terminal, entre na pasta do projeto e digite o seguinte comando:

```bash
$ mvn clean install
```
Para executar via terminal, ainda na pasta do projeto execute o comando:

```bash
$ java -jar target/Contatos-1.0-SNAPSHOT.jar
```
