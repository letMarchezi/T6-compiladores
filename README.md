# T2-Construcao-Compiladores

## T2 - Analisador Sintático ##
Neste repositório, encontra-se o segundo trabalho realizado na disciplina de Construção de Compiladores ofertada no 1º semestre de 2024 ministrada pelo Prof. Dr. Daniel Lucrédio.
O objetivo do mesmo é desenvolver um analisador sintático. Abaixo, encontra-se as instruções do que é necessário ter instalado na máquina pessoal para executar o analisador, assim como, compilar e executá-lo. Ademais, conterá a explicação da gramática criada mediante regras para atender aos casos de teste fornecidos pelo professor (foi reaproveitada a gramática do analisador léxico do trabalho anterior + criação de nova gramática para atender a análise sintática).
Espera-se que este analisador léxico funcione nos sistemas operacionais: Linux, Windows e macOS.

## Integrantes ##
Este trabalho foi desenvolvido pelas alunas:
- Lara Santiago Rodrigues, RA 769701 - Turma A
- Letícia Bossatto Marchezi, RA 791003 - Turma A

## Requisitos ##
Para a execução do analisador, é necessário ter instalado Java (aceitável qualquer versão a partir da *8*), Maven (*versão 3.6.3*) e ANTLR (*versão 4.13.1*).

- A dupla usou, especificadamente, a versão mais atual do Java, que no atual momento do trabalho é a *19.0.2*.

Verifique se o Java e Maven estão definidos nas variáveis de ambiente de seu sistema, dessa forma, será possível invocar os comandos em qualquer diretório.

## Instruções de uso ##
O trabalho foi desenvolvido usando a IDE Visual Studio Code e a execução ocorreu em dois sistemas operacionais diferentes: Linux (Ubuntu) e Windows 10.

Para facilitar o *download* do trabalho, acesse a pasta: ![T2](https://github.com/letMarchezi/T2-Construcao-Compiladores/tree/main/alguma-grammar).

Após realizar o *download*, o projeto pode ser aberto no VS (visual studio). Veja abaixo como fazer:
![](https://github.com/letMarchezi/T1/assets/110498717/c3dd0f2a-c792-4519-96a6-775352a1e38e)


* Avisos: coloque a pasta baixada em um diretório curto e sem espaços em branco para evitar erros.

## Compilação ##

Para compilar o projeto é necessário executar o segundo comando no diretório **alguma-grammar**:

	mvn clean package

Assim, será gerado o arquivo do analisador sintático empacotado com as dependências dentro da pasta _alguma\_grammar/target_. Este arquivo será utilizado nos passos futuros para a execução.

## Como executar? ##

### Execução manual ###
Para executar é necessário localizar o analisador sintático, que foi empacotado no arquivo **compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar** na pasta _alguma\_grammar/target_. 

O analisador sintático recebe dois parâmetros, sendo o primeiro o caminho do arquivo de entrada que será analisado, e o segundo o caminho do arquivo de saída. Ambos os caminhos dos arquivos devem ser completos (*absolute path*). 

Após localizar o analisador sintático, a execução poderá ser realizada da seguinte forma (independente do sistema operacional).

* Abra um _prompt_ de comando e digite o seguinte comando:

		java -jar (caminho do analisador .jar) (caminho do arquivo de teste) (caminho do arquivo de saída)

Onde:
- O caminho do analisador .jar é a localização do arquivo compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar;
- O caminho do arquivo de teste é o caminho absoluto do arquivo .txt que contém um algoritmo que será analisado pelo programa;
- O caminho do arquivo de saída é o caminho absoluto do arquivo .txt onde será armazenado o resultado da análise. Caso o diretório final ou o arquivo não existam, eles serão criados.

Um exemplo de execução é a seguinte:
- Linux

  		java -jar home/lara/Documentos/T2-Construcao-Compiladores/alguma-grammar/target/alguma-grammar-1.0-SNAPSHOT-jar-with-dependencies.jar home/lara/Documentos/T2-Construcao-Compiladores/alguma-grammar/casos-de-teste/2.casos_teste_t2/entrada/42-algoritmo_7-1_apostila_LA_1_erro_linha_10.txt home/lara/Documentos/T2-Construcao-Compiladores/alguma-grammar/resultado

- Windows

		java -jar D:\Documentos\UFSCar\Compiladores-2024.1\T2-Construcao-Compiladores\alguma-grammar\target\alguma-grammar-1.0-SNAPSHOT-jar-with-dependencies.jar D:\Documentos\UFSCar\Compiladores-2024.1\casos-de-teste\2.casos_teste_t2\entrada\4-algoritmo_2-2_apostila_LA_1_erro_linha_10.txt D:\Documentos\UFSCar\Compiladores-2024.1\T2-Construcao-Compiladores\saida.txt


### Correção automática ###

A análise sintática também pode ser realizada por meio do ![corretor automatico](https://github.com/dlucredio/compiladores-corretor-automatico/tree/master), executando o analisador em lotes em conjunto com a correção dos resultados, comparando a saída gerada com o resultado esperado. 

Há 62 casos a serem testados para este trabalho. Acesse a pasta completa em: ![casos-de-teste](https://github.com/letMarchezi/T2-Construcao-Compiladores/tree/main/alguma-grammar/casos-de-teste/2.casos_teste_t2). 

A execução do corretor automático é feita com o seguinte comando:


		java -jar (caminho do corretor) "java -jar (caminho analisador .jar)" (caminho gcc) (diretorio de saída) (diretorio dos casos de teste) (RA dos alunos) (nome do trabalho)


Onde:
- O caminho corretor é a localização do arquivo compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar;
- O caminho do analisador .jar é a localização do arquivo compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar;
- O caminho gcc é a localização do executável do compilador gcc em seu sistema. Caso o comando *gcc* seja reconhecido, este poderá ser utilizado;
- O diretorio de saída é o caminho absoluto para armazenamento dos resultados do analisador;
- O diretorio dos casos de teste é o caminho absoluto da pasta **casos-de-teste**;
- RA dos alunos é uma string com o RA dos membros separados por vírgula
- Nome do trabalho é uma das opções entre t1, t2, t3, t4 ou t5. 

Exemplos:

- Linux

		java -jar home/lara/Documentos/T2-Construcao-Compiladores/alguma-grammar/compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar home/lara/Documentos/T2-Construcao-Compiladores/alguma-grammar/target/alguma-grammar-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc home/lara/Documentos/T2-Construcao-Compiladores/alguma-grammar/temp home/lara/Documentos/T2-Construcao-Compiladores/alguma-grammar/casos-de-teste "769701, 791003" t2

- Windows

		java -jar D:\Documentos\UFSCar\Compiladores-2024.1\T2-Construcao-Compiladores\alguma-grammar\compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar "java -jar D:\Documentos\UFSCar\Compiladores-2024.1\T2-Construcao-Compiladores\alguma-grammar\target\alguma-grammar-1.0-SNAPSHOT-jar-with-dependencies.jar" gcc temp D:\Documentos\UFSCar\Compiladores-2024.1\casos-de-teste "769701, 791003" t2


## Gramática ##
A gramática utilizada no desenvolvimento do trabalho foi a especificada nos casos de teste apresentados acima e vista em sala de aula. Para conferir a gramática em mais detalhes, recomenda-se a visualização do arquivo **AlgumaGrammar.g4**. Abaixo, há uma breve explicação da gramática criada, relembrando que ela engloba, em certos pontos, o que já foi desenvolvido no analisador léxico (trabalho realizado anteriormente):

Definições já realizadas anteriormente:
- CARACTERE_ESP: são caracteres especiais utilizados ao longo dos algoritmos e sem uma semântica específica por trás deles (como vírgulas, pontos, ponto e vírgula);
- NUM_INT e NUM_REAL: nestes padrões são especificados os formatos de valores inteiros e reais, respectivamente. Ambos devem ser imprimidos na forma <'numero',NUM_INT> ou <'numero',NUM_REAL>;
- IDENT: este padrão é responsável por definir o que pode ser considerado um identificador (ou variável) dentro dos algoritmos. Identificadores são cadeias iniciadas por letras e seguidar por letras ou números, além do símbolo de _. Devem ser imprimidos da forma <'exemplo111',IDENT>;
- CADEIA: este padrão identifica uma cadeia de caracteres (ou string) dentro dos algoritmos. As cadeias são definidas por sequências de quaisquer símbolos que estão entre aspas simples ou duplas. Devem ser imprimidos da forma <'"string"',CADEIA>;
- COMENTARIO: os comentários são ignorados pelo analisador léxico, de modo que não geram tokens. São identificados por caracteres que estão entre chaves. São reconhecidos pelo padrão { comentario };
- CADEIA_NAO_FECHADA: Cadeias de aspas duplas ou aspas simples que não foram fechadas na mesma linha que foram iniciadas. Exemplo: 'imprimindo a sequencia\n
- COMENTARIO_NAO_FECHADO: Identifica comentários que não foram fechados na mesma linha. Exemplo: { comentario. 
- WS: define espaços em branco, quebras de linha e tabulações, que também são ignorados pelo analisar léxico;
- ERRO: Identificador coringa que detecta qualquer padrão que não foi identificado nas regras anteriores;

Novas definições para o analisador sintático:
- programa: representa um conjunto de declarações seguido pelo corpo do programa, que é delimitado pelas palavras-chave 'algoritmo' e 'fim_algoritmo';
- op_logico_1: representa um operador 'ou';
- op_logico_2: representa um operador 'e';
- declaracoes: representa um conjunto de zero ou mais declarações locais OU globais;
- tipo_basico: representa um os tipos básicos para o funcionamentos dos algoritmos;
- identificador: conjunto de zero ou mais identificadores (IDENT já foi definido no trabalho anterior) com uma determinada dimensão (usada na declaração de arranjos);
- variavel: representa um conjunto de um ou mais identificadores (separador por vírgula) de um determinado tipo;
- decl_local_global: representa um conjunto de declarações locais OU globais;
- tipo_basico_ident: representa um dos tipos básicos ou um novo identificador;
- declaracao_local: representa uma palavra-chave 'declare' seguida por uma variável OU a palavra-chave 'constante' seguida por um identificador, um tipo básico e um valor OU uma definição de um identificador de algum tipo;
- dimensao: representa um conjunto de zerou ou mais expressões aritméticas entre colchetes;
- tipo: representa um registro ou um tipo estendido;
- tipo_estendido: representa um tipo_basico_ident com variação;
- valor_constante: representa uma constante pode ser uma cadeira, um número inteiro ou real, ou um valor lógico;
- registro: representa um conjunto de zero ou mais variáveis delimitadas pelas palavras-chave 'registro' e 'fim_registro';
- declaracao_global: representa a definição de um procedimento OU uma função, que são conjuntos de parâmetros (opcionais), um conjunto de zero ou mais declarações locais delimitados por suas respectivas palavras-chave;
- parametro: representa uma palavra-chave 'var' (opcional), seguida por um conjunto de um ou mais identificadores com um determinado tipo;
- parametros: representa um conjunto de um ou mais parâmetros separados por vírgula;
- corpo: representa um corpo do programa, definido como um conjunto de zero ou mais declarações locais e um conjunto de zero ou mais comandos;
- cmd: identifica os comandos da linguagem, que serão especificados a seguir;
- cmdLeia: representa a palavra-chave 'leia' seguida por um conjunto de um ou mais identificadores separados por vírgula;
- cmdEscreva: representa a palavra-chave 'escreva' seguida por um conjunto de um ou mais expressões separadas por vírgula;
- cmdSe: representa a palavra-chave 'se' seguida por uma expressão, que é seguida pela palavra-chave 'entao', delimitando um conjunto de zero ou mais comandos, além da palavra-chave 'senao' e seus comandos, finalizado pela palavra-chave 'fim_se';
- cmdCaso: representa a palavra-chave 'caso' seguida por uma expressão aritmética, de modo que a palavra-chave 'seja' delimite uma seleção de argumentos, além de um valor padrão opcional;
- cmdPara: representa a palavra-chave 'para' seguida por um identificador que recebe uma expressão aritmética, delimitando um intervalo com a palavra-chave 'ate', responsável por repetir um conjunto de zero ou mais comandos tantas vezes quanto forem necessárias para a finalização do loop;
- cmdEnquanto: representa a palavra-chave 'enquanto' seguida por uma expressão e um conjunto de zero ou mais comandos delimitados pelas palavras-chave 'faca' e 'fim_enquanto';
- cmdFaca: representa a palavra-chave 'faca' seguida por um conunto de zero ou mais comandos, repetindo uma determinada expressão com o auxílio da palavra-chave 'ate';
- cmdAtribuicao: representa um identificador recebendo uma determinada expressão com o auxílio do símbolo de atribuição '<-';
- cmdChamada: representa um identificador que recebe um conjunto de uma ou mais expressões separados por vírgulas entre parênteses;
- cmdRetorne: representa a palavra-chave 'retorne' seguida por uma expressão;
- selecao: representa um conjunto de zero ou mais itens;
- item_selecao: representa constantes seguidas por um conjunto de zero ou mais comandos;
- constantes: representa um  conjunto de um ou mais números separados por vírgula;
- numero_intervalo: representa um número inteiro formando, opcionalmente, um intervalo através do símbolo '..' (os números podem ser valores negativos);
- op_unario: representa um operador de subtração, para a representação de um valor negativo;
- exp_aritmetica: representa um termo seguido por zero ou mais operadores e termos;
- termo: representa um fator seguido por zero ou mais operadores e fatores;
- fator: representa uma parcela seguida por zero ou mais operadores e novas parcelas. É importante notar que "exp_aritmetica", "termo", "fator" e - os operadores definidos a seguir são os responsáveis pela precedência de operações matemáticas no programa;
- op1: representa as operações de adição e subtração;
- op2: representa as operações de multiplicação e divisão;
- op3: representa a operação de módulo;
- parcela: representa uma parcela unária (que pode ser negativa ou não) ou uma parcela não unária;
- parcela_unario: representa um identificador; um identificador com um conjunto de uma ou mais expressões entre parênteses; um número inteiro; um número real; ou uma expressão;
- parcela_nao_unario: representa o símbolo '&' seguido por um identificador ou uma cadeia (definida no tópico anterior) de caracteres;
- exp_relacional: representa a expressão aritmética seguida, opcionalmente, por um operador relacional e uma outra expressão aritmética;
- op_relacional: representa os operadores relacionados de igualdade, diferença e maior ou menor (ou igual) que;
- expressao: representa um conjunto de um ou mais termos lógicos seguidos por operadores lógicos;
- termo_logico: representa um conjunto de um ou mais fatores lógicos seguidos por operadores lógicos;
- fator_logico: representa uma parcela lógica que pode ser negada com o uso da palavra-chave 'nao' (opcional);
- parcela_logica: representa os valores verdadeiro ou falso ou uma expressão relacional;