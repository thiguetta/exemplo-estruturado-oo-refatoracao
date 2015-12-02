#Instruções para execução deste projeto

Antes de importar o projeto em sua IDE preferida, verifique se possua o maven instalado, caso não, acesse [esse site](https://maven.apache.org) e siga as instruções de instalação.

ATENÇÃO: Este projeto tem como dependência o projeto [ProjetoContatosUsandoMaven](https://github.com/thiguetta/exemplo-estruturado-oo-refatoracao/tree/master/ProjetoContatosUsandoMaven), portanto siga as instruções desse projeto antes de importar o ContatoWeb.

Na primeira execução do projeto ele irá baixar as dependências descritas no `pom.xml`. 

Se estiver utilizando alguma IDE com um servidor de aplicação embutido, basta executar o projeto na IDE.

Mas se desejar utilizar o terminal, entre na pasta do projeto e digite o seguinte comando:

```bash
$ mvn clean install
```

Em seguida copie o arquivo `ContatoWeb-1.0-SNAPSHOT.war` gerado dentro da pasta `target` para a pasta de deploys do servidor de aplicação que estiver utillizando.
