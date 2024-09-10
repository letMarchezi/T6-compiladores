/*
6º trabalho prático da disciplina Construção de Compiladores - 2024/1
Desenvolvido por:
- Lara Santiago Rodrigues, 769701
- Letícia Bossatto Marchezi, 791003
*/
package br.ufscar.dc.compiladores.alguma.rotina;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import br.ufscar.dc.compiladores.alguma.rotina.AlgumaRotinaParser.ProgramaContext;

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
            CharStream cs = CharStreams.fromFileName(args[0]);
            AlgumaRotinaLexer lexer = new AlgumaRotinaLexer(cs);
            CommonTokenStream tokens = new CommonTokenStream(lexer);
            AlgumaRotinaParser parser = new AlgumaRotinaParser(tokens);
            ProgramaContext arvore = parser.programa();
            AlgumaRotina ar = new AlgumaRotina();
            
            // Erros léxicos e sintáticos são mostrados no stdout

            // Inicialização do programa
            ar.visitPrograma(arvore);
            
            AlgumaRotinaUtils.errosSemanticos.forEach((s) -> System.out.println(s));
            AlgumaRotinaUtils.errosSemanticos.forEach((s) -> buffer.append(s + "\n"));

            // Chama o gerador de HTML caso não hajam erros semânticos
            if(AlgumaRotinaUtils.errosSemanticos.size() == 0 ){
                
                GeradorAlgumaRotinaHTML gerador = new GeradorAlgumaRotinaHTML();
                gerador.visit(arvore);
    
                // Obtem o HTML gerado
                String codigoHtml = gerador.getHtml();
    
                // Salva o HTML em um arquivo
                try (FileWriter writer = new FileWriter("resultado.html")) {
                    writer.write(codigoHtml);
                }
            }
           
        } catch (Exception ex) {
            // Detecção de exceções
            // System.err.println("Erro: " + ex.getMessage());
        }
        buffer.append("Fim da compilacao\n");
        // Escreve os resultados dos erros semânticos no arquivo de saída
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