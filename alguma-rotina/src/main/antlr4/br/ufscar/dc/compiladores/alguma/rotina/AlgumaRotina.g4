grammar AlgumaRotina;
CATEG_EVENTO: 'pessoal' | 'aula' | 'trabalho';

DIAS_SEM: 'DOMINGO' | 'SEGUNDA' | 'TERCA' | 'QUARTA' | 'QUINTA' | 'SEXTA' | 'SABADO';

IDENT: ('a'..'z'|'A'..'Z') ('_'|'a'..'z'|'A'..'Z'|'0'..'9')*;

CADEIA: ('"' ( ESC_SEQ | ~('"'|'\\'|'\n') )* '"' ) | ('\'' ( ESC_SEQ_SQ | ~('\''|'\\'|'\n') )* '\'');

fragment ESC_SEQ : '\\"';
fragment ESC_SEQ_SQ : '\\\'';

PROGRAMA: ROTINA CORPO EOF;

ROTINA: 'ROTINA' (IDENT':' REGISTRO)+;


AGENDA: (DIAS_SEM PROG_DIA)+;

PROG_DIA: ('quero_estudar' (CADEIA)*)? ','
	'inicio' HORA ','
	'fim' HORA ','
	'eventos' evento_agenda*;

evento_agenda: 
	'(' 'categoria' CATEG_EVENTO ','
	'inicio' HORA ','
	'fim' HORA ')';

PRIOR_TIPO: 'alta' | 'media' | 'baixa';

MODALS: 'estudo_para_prova' | 'projeto' | 'estudo_teorico' | 'lista_de_exercicios' | 'revisao';

// /[0-59]/
HORA: ('0'..'9')+(':' ('0'..'9')+)?'h';

DATE: DAY '/' MONTH '/' YEAR;

DAY: '0'[1-9]  // 01-09
    | [12][0-9] // 10-29
    | '3'[01]   // 30-31
    ;

MONTH: '0'[1-9]  // 01-09
    | '1'[0-2]  // 10-12
    ;

YEAR: [0-9]{4}  // Qualquer sequência de 4 dígitos
    ;

WS: [ \t\r\n]+ -> skip
    ;

EVENTO: 'nome' CADEIA ',' 'inicio' HORA ',' 'fim' HORA ',' 'data' DATE;

SEQ_EVENTO: 'EVENTOS' EVENTO+ 'FIMEVENTOS';

CORPO: 'AGENDA' AGENDA 'FIMAGENDA' EVENTO* SEQ_COMP*;

SEQ_COMP: 'COMPROMISSOS' COMP+ 'FIMCOMPROMISSOS';

COMP:
	IDENT ':' 'nome' CADEIA ',' 'descricao' CADEIA ',' 'data_compromisso' DATE;  

REGISTRO: 'nome' CADEIA ',' 'descricao' CADEIA ',' 'prioridade'  PRIOR_TIPO ',' 'modalidade' MODALS ',' 'tempo_desejado' HORA ',' 'compromisso' IDENT;