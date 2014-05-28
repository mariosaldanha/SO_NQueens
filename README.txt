Trabalho de Sistemas Operacionais
Integrantes: Mário Saldanha, Álvaro Gonçalves
Implementação para resolver o problema das N Queens em paralelo


Fucionamento do programa: 
-- Resolve o problema das N Queens utilizando threads;
-- Escreve a saída em um arquivo .txt, o nome do arquivo informa o número de rainhas utilizadas;


Executar o programa: $ ./executeme <numero de rainhas>
-- Script executeme chama o makefile para compilar os arquivos java;
-- Após dispara a execução do programa, esperando o número de rainhas como parametro;


Excluir .class e .txt(arquivos de saida do programa): $ make clean


OBS: 
--Arquivo NQueensSeq possui a implementação sequencial do mesmo problema apenas para testes.
Compilar NQueensSeq: javac NQueensSeq.java
Executar NQueensSeq: java NQueensSeq <numero de rainhas>
