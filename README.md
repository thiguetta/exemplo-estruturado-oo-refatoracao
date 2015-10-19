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

