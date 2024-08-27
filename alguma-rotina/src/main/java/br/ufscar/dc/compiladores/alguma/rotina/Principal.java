/*
2º trabalho prático da disciplina Construção de Compiladores - 2024/1
Desenvolvido por:
- Lara Santiago Rodrigues, 769701
- Letícia Bossatto Marchezi, 791003
*/
package br.ufscar.dc.compiladores.alguma.grammar;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import java.io.File;
import java.io.FileWriter;

public class Principal {
    
    // Criação de buffer para armazenar a saída
    private static StringBuilder buffer = new StringBuilder();
    
    public static void main(String[] args) {
        // Validação da quantidade de argumentos
        if (args.length < 2) {
            System.out.println("Uso: java -jar analisador-sintatico-compilado.jar "
                    + "<caminho para o arquivo de entrada> " + "<caminho para o arquivo de saída>");
            System.exit(0);
        }


        // Criação do diretório de saída
        createOutputDirectory(args[1]);

        try {
            // Leitura dos caracteres
            CharStream cs = CharStreams.fromFileName(args[0]);
            AlgumaRotinaLexer lexer = new AlgumaRotinaLexer(cs);

            // Remove a classe padrão de listeners para erros  

            CommonTokenStream tokens = new CommonTokenStream(lexer);
            AlgumaRotinaParser parser = new AlgumaRotinaParser(tokens);
            //parser.removeErrorListeners();
            
            // Adicionando a classe CustomErrorListener com método customizado para erros de sintaxe (syntaxError)
            //parser.addErrorListener(new CustomErrorListener(buffer));
            // Invocando o parser
            parser.programa();
            
        } catch (Exception ex) {
            // Detecção de exceções
            System.err.println("Erro: " + ex.getMessage());
        }

        // Escreve o resultado do buffer no arquivo de saída
        writeOutputToFile(args[1]);
    }

    /**
     * Cria o(s) diretório(s) pai do arquivo dado caso não exista(m).
     * @param filePath caminho do arquivo a ter os diretórios pai criados.
     */
    private static void createOutputDirectory(String filePath) {
        File file = new File(filePath);
        // Definição do diretório
        String directoryPath = file.getParent();
        File directory = new File(directoryPath);
        // Criação do diretório de saída
        directory.mkdirs();
    }

    /**
     * Escreve o conteúdo do buffer no arquivo destino.
     * Garante que os recursos serão liberados após o procedimento ao usar try-with-resources, além
     * da detecção de exceções ao escrever no arquivo, além de imprimir o erro no terminal.
     * @param filePath caminho do arquivo de saída a ser escrito.
     */
    private static void writeOutputToFile(String filePath) {
        try (FileWriter writer = new FileWriter(filePath)) {
            writer.write(buffer.toString());
        } catch (Exception e) {
            System.err.println("Erro " + e.getMessage()+" ao escrever no arquivo "+filePath);
        }
    }
}