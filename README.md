<p align="center">
<img src="https://github.com/alexsandrospecht/Tsv/blob/master/images/logo.png"> </br>
TXT TO CSV TRANSFORMER
</p>

[![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT)

<p align="center">
<b> Easy way to convert Flat Files to CSV with Java</b>
</p>

### COMO USAR

 * Baixe o projeto `$ git clone https://github.com/alexsandrospecht/Tsv `
 * Acesse a pasta criada `$ cd Tsv`
 * Faça o build `# mvn clean install`
 * Coloque o jar `tsv-1.0.jar` criado dentro da pasta `/target` onde desejar
 * Crie um template para transformar seu arquivo, como o exemplo abaixo:
    ```
    OPERATION=SUM
    CAMPO 1;0;5;
    CAMPO 2;5;6;
    CAMPO 3;6;10;
    ```
### Command line    
 * Rode o jar com o comando: `$ java -jar tsv-1.0.jar arquivo.txt template.txt saida.csv`   
    * Onde `arquivo.txt` é o arquivo de input
    * E `template.txt` é o arquivo contendo o template a ser usado para recortar o input.   
    * E `saiva.csv` é o arquivo onde será gravado o resultado da operação

### Modo gráfico
 * Execute o jar.
 * Será apresentada a tela abaixo, basta preencher os campos e clicar em `Transform`.
 
 <p align="center">
 <img src="https://github.com/alexsandrospecht/Tsv/blob/master/images/tsv.png"> </br>
 </p>

### OPERATIONS
  * O TSV suporta 2 operações diferentes:
    * 1 - `SUM`: Dado a posição inicial, soma-se o valor informado para definir a posição final.
    * 2 - `USER_DEFINED`: O usuário informa tanto a posição inicial quanto final. 
    
     