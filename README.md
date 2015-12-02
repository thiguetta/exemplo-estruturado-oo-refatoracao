#Sobre o projeto

Este projeto contém uma série de subprojetos apresentando a evolução do código de um projeto de Agenda de Contatos, nele poderá acompanhar como o projeto passou por melhorias tanto de código quanto de tecnologia, utilizando as mais primitivas até as mais avançadas. 

##Linha do tempo

- [ProjetoContato] (https://github.com/thiguetta/exemplo-estruturado-oo-refatoracao/tree/master/ProjetoContato) - Este projeto foi feito em Java puro, utilizando exibição de dados em tela (terminal), leitura do teclado (prompt) e armazenamento em arquivos texto plano.
- [ProjetoContatoRefatorado](https://github.com/thiguetta/exemplo-estruturado-oo-refatoracao/tree/master/ProjetoContatoRefatorado) - Este projeto melhora o projeto anterior utilizando técnicas de refatoração para melhoria do código.
- [ProjetoRefatoradoComBancoDeDados](https://github.com/thiguetta/exemplo-estruturado-oo-refatoracao/tree/master/ProjetoRefatoradoComBancoDeDados) - Este projeto complementa o projeto anterior utilizando uma biblioteca externa (inserindo o `.jar` manualmente no projeto), introduzindo uma nova forma de armazenamento de dados utilizando JDBC e MySQL.
- [ProjetoContatosUsandoMaven](https://github.com/thiguetta/exemplo-estruturado-oo-refatoracao/tree/master/ProjetoContatosUsandoMaven) - Este projeto apresenta o conceito de controle de dependência utilizando o maven, não sendo mais necessário ter que inserir manualmente as bibliotecas externas.
- [ContatoWeb](https://github.com/thiguetta/exemplo-estruturado-oo-refatoracao/tree/master/ContatoWeb) - Este projeto introduz uma nova forma de apresentação e interação com os dados através da web com JSP (Java Server Pages), embora seja um novo projeto, utiliza como dependência o projeto anterior.

#Refatoração

`Refatoração (refactoring)` é um processo de manutenção de código que todo programador deve fazer de tempos em tempos. Esse processo consiste basicamente de 3 Rs:

- Renomear variáveis, métodos ou classes para que o código fique mais legível
- Reorganizar seu código movendo código de uma classe que não faz sentido para outra mais coerente, ou até mesmo indentando ele.
- Remover código (importações, repetições) que não seja mais útil para seu projeto.

##5 dicas para melhorar seu código orientado a objetos:

1. analise o código e defina responsabilidades (o que o código faz)
2. agrupe responsabilidades comuns a um determinado tema em uma classe
3. se necessário crie classes diferentes para grupo de responsabilidades diferentes
4. uma classe não deve conter mais responsabilidades do que necessário
5. se uma classe contém grupos distintos de responsabilidades, então divida-as em outras classes mais significativas


PS: se preciso ler do arquivo e salvar no arquivo, atribua os métodos a uma classe chamada Arquivo ou algo que remeta a sua responsabilidade. Não faz sentido eu ter um método “ler do teclado” em uma classe que trabalha com arquivos.

PS2: sempre que uma classe, método ou variável não fizer sentido, refatore! =D

#Atenção

Para executar esses projetos será necessário JDK 1.8+, certifique-se de instala-los em sua máquina, é possível obter o JDK [neste site](http://www.oracle.com/technetwork/java/javase/downloads).

