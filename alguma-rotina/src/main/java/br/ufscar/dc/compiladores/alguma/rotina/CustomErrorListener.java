package br.ufscar.dc.compiladores.alguma.rotina;

import org.antlr.v4.runtime.BaseErrorListener;
import org.antlr.v4.runtime.RecognitionException;
import org.antlr.v4.runtime.Recognizer;
import org.antlr.v4.runtime.Token;

public class CustomErrorListener extends BaseErrorListener {
    public StringBuilder buffer;

    public CustomErrorListener(StringBuilder buffer){
        this.buffer=buffer;
    }
    @Override
    public void syntaxError(Recognizer<?, ?> recognizer,
                            Object offendingSymbol,
                            int line, int charPositionInLine,
                            String msg, RecognitionException e){
        
        //System.out.println(msg.split("'")[1]);    
        Token t = (Token) offendingSymbol;  

        /* Há algumas saídas mais específicas que não passam na saída padrão, logo haverá impressões específicas para estes casos
         * Fora estes casos, por padrão, as demais saídas serão 'default'
         * Os números abaixo, colocados para cada caso, estão no arquivo AlgumaGrammar.tokens
         * Para encontrar este arquivo, siga o caminho da pasta: 
         * target > generated-sources > antlr4 > AlgumaGrammar.tokens
        */
        switch (t.getType()) { 
            case -1: // -1 refere-se ao token EOF, que indica o fim do programa analisado
                buffer.append("Linha " + line + ": erro sintatico proximo a EOF"+"\nFim da compilacao\n");
                break;
            case 37: // 65 refere-se ao erro em uma cadeia literal NÃO fechada
                buffer.append("Linha " + line + ": cadeia literal nao fechada"+"\nFim da compilacao\n");
                break;
            default: // Por padrão, o programa exibe a mensagem de erro sintático genérica
                buffer.append("Linha " + line + ": erro sintatico proximo a " + t.getText()+"\nFim da compilacao\n");
                break;
        }  
        // Lança a exceção para finalizar o programa
        throw new RuntimeException();
    }
}