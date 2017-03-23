# TSV

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

## TXT TO CSV TRANSFORMER

### COMO USAR

 * Baixe o projeto `$ git clone https://github.com/alexsandrospecht/com.github.alexsandrospecht.Tsv `
 * Acesse a pasta criada `$ cd com.github.alexsandrospecht.Tsv`
 * Faça o build `# mvn clean install`
 * Coloque o jar `tsv-1.0.jar` criado dentro da pasta `/target` onde desejar
 * Crie um template para transformar seu arquivo, como o exemplo abaixo:
    ```
    OPERATION=SUM
    CAMPO 1;0;5;
    CAMPO 2;5;6;
    CAMPO 3;6;10;
    ```
 * Rode o jar com o comando: `$ java -jar tsv-1.0.jar arquivo.txt template.txt`   
    * Onde `arquivo.txt` é o arquivo de input
    * E `template.txt` é o arquivo contendo o template a ser usado para recortar o input.   

### OPERATIONS
  * O TSV suporta 2 operações diferentes:
    * 1 - `SUM`: Dado a posição inicial, soma-se o valor informado para definir a posição final.
    * 2 - `USER_DEFINED`: O usuário informa tanto a posição inicial quanto final. 
     