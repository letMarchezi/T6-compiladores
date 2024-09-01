package br.ufscar.dc.compiladores.alguma.rotina;

import java.util.List;
import java.util.ArrayList;

import org.antlr.v4.runtime.Token; 

public class AlgumaRotinaUtils {
    // Lista que armazenará os erros semânticos
    public static List<String> errosSemanticos = new ArrayList<>();
    
    // Método auxiliar para adicionar os erros identificados
    public static void adicionarErroSemantico(Token t, String mensagem) {
        int linha = t.getLine();
        errosSemanticos.add(String.format("Linha %d: %s", linha, mensagem));
    }
}
