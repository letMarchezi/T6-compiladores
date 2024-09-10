# T6 - Construção de Compiladores

## Rotina de Estudos ##
Neste repositório, encontra-se o sexto e último trabalho realizado na disciplina de Construção de Compiladores ofertada no 1º semestre de 2024 ministrada pelo Prof. Dr. Daniel Lucrédio.
O objetivo do mesmo é desenvolver um compilador completo para uma rotina de estudos semanal. De tal modo, o objetivo é que dado um conjunto de informações a certa da rotina de uma pessoa (a ser detalhado e exemplificado abaixo), ao final teremos o planejamento de uma rotina de estudos semanal para que a pessoa cumpra com seus afazeres de estudo, de acordo com a necessidade e tal compromissos/eventos que irão ocorrer referente aos estudos.

Espera-se que este analisador léxico funcione nos sistemas operacionais: Linux, Windows e macOS.

## Integrantes ##
Este trabalho foi desenvolvido pelas alunas:
- Lara Santiago Rodrigues, RA 769701 - Turma A
- Letícia Bossatto Marchezi, RA 791003 - Turma A

### Índice ###

1. [Introdução](#introdução)
2. [Projeto da Linguagem](#projeto-da-linguagem)
3. [Requisitos e Instruções](#requisitos-e-instruções)
4. [Casos de Teste](#casos-de-teste)
5. [Uso do Compilador](#uso-do-compilador)
6. [Saídas e Resultados](#saídas-e-resultados)

## Introdução ##
O objetivo do projeto é desenvolver uma rotina de estudos semanais. De tal modo, dada a rotina de uma pessoa com base em algumas informações que serão detalhadas na seção abaixo, o compilador deve analisar os casos em que há erros semânticos e informá-los (via arquivos de saída na extensão .txt), assim como gerar um arquivo na extensão .html que exibe o planejamento dessa rotina de estudos semanais, baseado nas informações passadas mediante casos de teste.

## Projeto da Linguagem ##
A gramática da linguagem foi desenvolvida para suportar programas divididos em 4 regras:
- Compromissos: são declarados os compromissos existentes, a exemplo de provas, entrega de trabalho/relatório ou apresentação de trabalho/seminário. Indica-se o título, a descrição e a data do compromisso;
- Rotina: são declarados as rotinas existentes, ou seja, cada rotina refere-se a algum estudo que precisa ocorrer. Indica-se o título, descrição, prioridade, modalidade, tempo desejado e a qual compromisso é vinculado (se existir);
- Agenda: é declarado cada dia da semana (opcionalmente) que deseja-se estudar. Indica-se o horário inicial e final que há tempo pretendido para o estudo, assim como um conjunto de atividades que possam existir em tal dia. Para cada atividade, indica-se sua categoria, horário de início e fim.
  - **Obs1:** não é obrigatório ter atividades;
  - **Obs2:** Os dias variam de DOMINGO a SÁBADO.
- Eventos: é uma listagem de eventos - que podem estar associados aos compromissos - indicando o nome, horário de início, horário de fim e a data. Nos casos em que são referenciados ao compromisso, o evento é mais detalhado possuindo o horário.

## Requisitos e Instruções

### Requisitos ###
Para a execução do analisador, é necessário ter instalado Java (aceitável qualquer versão a partir da *8*), Maven (*versão 3.6.3*) e ANTLR (*versão 4.13.1*).

- A dupla usou, especificadamente, a versão mais atual do Java, que no atual momento do trabalho é a *19.0.2*.

Verifique se o Java e Maven estão definidos nas variáveis de ambiente de seu sistema, dessa forma, será possível invocar os comandos em qualquer diretório.

### Instruções de uso ###
O trabalho foi desenvolvido usando a IDE Visual Studio Code e a execução ocorreu em dois sistemas operacionais diferentes: Linux (Ubuntu) e Windows 10.

Para facilitar o *download* do trabalho, acesse a pasta: [T6](https://github.com/letMarchezi/T6-compiladores/tree/main/alguma-rotina).

Após realizar o *download*, o projeto pode ser aberto no VS (visual studio). Veja abaixo como fazer:
![](https://github.com/letMarchezi/T1/assets/110498717/c3dd0f2a-c792-4519-96a6-775352a1e38e)


* Avisos: coloque a pasta baixada em um diretório curto e sem espaços em branco para evitar erros.

## Casos de Teste ##
A dupla criou 5 casos de teste para exemplificar o compilador. Dentre eles, 1 caso de teste não apresenta erros e os demais, apresentam, pelo menos, um erro semântico. Veja abaixo, um exemplo com o formato denotado nos casos de teste, seguimentado de acordo com suas regras:
- Compromissos
  
  ![](https://github.com/letMarchezi/T6-compiladores/blob/main/alguma-rotina/casos-de-testes/apenas-imagens/Captura%20de%20tela%20de%202024-09-07%2018-37-30.png)

  A seção de compromissos é delimitada pelo identificador 'compromissoX:' sendo X o número do compromisso e é seguida pelos elementos que a compõe: título, descrição e data_compromisso (consulte a gramática para informações mais detalhadas).

- Rotina

  ![](https://github.com/letMarchezi/T6-compiladores/blob/main/alguma-rotina/casos-de-testes/apenas-imagens/Captura%20de%20tela%20de%202024-09-07%2018-37-40.png)

  A seção de rotina é delimitada pelo identificador 'rotinaX:' sendo X o número da rotina e é seguida pelos elementos que a compõe: título, descrição, prioridade, modalidade, tempo_desejado e compromisso (consulte a gramática para informações mais detalhadas).

- Agenda

  ![](https://github.com/letMarchezi/T6-compiladores/blob/main/alguma-rotina/casos-de-testes/apenas-imagens/Captura%20de%20tela%20de%202024-09-07%2018-54-06.png)

  A seção de agenda é representada pelos dias da semana (lembrando que não é obrigatório inserir todos). O objetivo é que para cada dia da semana que seja declarado, informe o horário inicial e final que deseja-se estudar, assim como, se houver, uma listagem de atividades no dia com sua categoria, início e fim (consulte a gramática para informações mais detalhadas).

- Eventos

  ![](https://github.com/letMarchezi/T6-compiladores/blob/main/alguma-rotina/casos-de-testes/apenas-imagens/Captura%20de%20tela%20de%202024-09-07%2018-37-57.png)

  A seção de eventos é uma listagem dos eventos que irão ocorrer e é seguida pelos elementos: nome, início, fim e data. Eventos podem estar relacionados com os compromissos.

O exemplo completo encontra-se em: [AlgumaRotina.g4](https://github.com/letMarchezi/T6-compiladores/blob/main/alguma-rotina/src/main/antlr4/br/ufscar/dc/compiladores/alguma/rotina/AlgumaRotina.g4)

A gramática detalhada encontra-se em: [caso3_erro_compromissoJaDeclarado.txt](https://github.com/letMarchezi/T6-compiladores/blob/main/alguma-rotina/casos-de-testes/caso3_erro_compromissoJaDeclarado.txt)

A pasta com todos os casos de teste encontra-se em: [casos-de-testes](https://github.com/letMarchezi/T6-compiladores/tree/main/alguma-rotina/casos-de-testes)

## Uso do Compilador ##
### Compilação ###

Para compilar o projeto é necessário executar o segundo comando no diretório **alguma-rotina**:

	mvn clean package

Assim, será gerado o arquivo do analisador empacotado com as dependências dentro da pasta _alguma\_rotina/target_. Este arquivo será utilizado nos passos futuros para a execução.

### Como executar? ###
Para executar é necessário localizar o analisador, que foi empacotado no arquivo **compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar** na pasta _alguma\_rotina/target_. 

O analisador recebe dois parâmetros, sendo o primeiro o caminho do arquivo de entrada que será analisado, e o segundo o caminho do arquivo de saída. Ambos os caminhos dos arquivos devem ser completos (*absolute path*). 

Após localizar o analisador sintático, a execução poderá ser realizada da seguinte forma (independente do sistema operacional).

* Abra um _prompt_ de comando e digite o seguinte comando:

		java -jar (caminho do analisador .jar) (caminho do arquivo de teste) (caminho do arquivo de saída)

Onde:
- O caminho do analisador .jar é a localização do arquivo compiladores-corretor-automatico-1.0-SNAPSHOT-jar-with-dependencies.jar;
- O caminho do arquivo de teste é o caminho absoluto do arquivo .txt que contém um algoritmo que será analisado pelo programa;
- O caminho do arquivo de saída é o caminho absoluto do arquivo .txt onde será armazenado o resultado da análise. Caso o diretório final ou o arquivo não existam, eles serão criados.

Um exemplo de execução é a seguinte:
- Linux

  		java -jar /home/lara/Documentos/T6-compiladores/alguma-rotina/target/alguma-rotina-1.0-SNAPSHOT-jar-with-dependencies.jar /home/lara/Documentos/T6-compiladores/alguma-rotina/casos-de-testes/caso1_correto.txt /home/lara/Documentos/T6-compiladores/alguma-rotina/saida/caso1

- Windows

		java -jar D:\Documentos\UFSCar\Compiladores-2024.1\T6-Construcao-Compiladores\alguma-rotina\target\alguma-rotina-1.0-SNAPSHOT-jar-with-dependencies.jar D:\Documentos\UFSCar\Compiladores-2024.1\casos-de-testes\caso1_correto.txt D:\Documentos\UFSCar\Compiladores-2024.1\T6-Construcao-Compiladores\saida.txt


## Saídas e Resultados ##
Após a utilização do compilador para análise de um determinado programa de entrada, são gerados alguns arquivos:
- Arquivos de saída referente a cada caso de entrada. Estes arquivos se encontram na pasta [saida](https://github.com/letMarchezi/T6-compiladores/tree/main/alguma-rotina/saida). Veja um exemplo, referente ao caso de teste 7 (caso7_correto.txt) já mencionado na seção **Casos de Teste**.

  Saída gerada no arquivo saida7.txt
  
  ![](https://github.com/letMarchezi/T6-compiladores/blob/main/alguma-rotina/casos-de-testes/apenas-imagens/Captura%20de%20tela%20de%202024-09-09%2022-57-28.png)

- Arquivo .html. Este arquivo se encontra em [teste.html](https://github.com/letMarchezi/T6-compiladores/blob/main/alguma-rotina/teste.html). Idealmente, optamos por focar em apenas um caso de teste para a saída em html.

  Saída gerada no arquivo teste.html
  
  ![](https://github.com/letMarchezi/T6-compiladores/blob/main/alguma-rotina/casos-de-testes/apenas-imagens/Captura%20de%20tela%20de%202024-09-09%2022-56-27.png)


Um exemplo de utilização do compilador está disponível neste [link](https://youtu.be/8U54GH_gsxc).
