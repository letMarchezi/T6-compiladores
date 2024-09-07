
package br.ufscar.dc.compiladores.alguma.rotina;

import java.util.List;
import br.ufscar.dc.compiladores.alguma.rotina.TabelaDeSimbolos.Horario_inicio_fim;

class EntradaTabelaAgenda {
        // Criação das especificações de DIAS DA SEMANA
        public enum DiaSemana {
            DOMINGO,
            SEGUNDA,
            TERCA,
            QUARTA,
            QUINTA,
            SEXTA,
            SABADO,
            INVALIDO
        }

    DiaSemana dia;
    Horario_inicio_fim inicio_fim;
    List<Horario_inicio_fim> horarios_ocupados;
    

    public EntradaTabelaAgenda(DiaSemana dia, Horario_inicio_fim inicio_fim, List<Horario_inicio_fim> horarios_atividades) {
        this.dia = dia;
        this.inicio_fim = inicio_fim;
        this.horarios_ocupados = horarios_atividades;
    }
    
    @Override
    public String toString() {
        return "Agenda {" +
                "dia=" + dia +
                ", inicio_fim=" + inicio_fim +
                ", horarios_ocupados=" + horarios_ocupados +
                '}';
    }
}