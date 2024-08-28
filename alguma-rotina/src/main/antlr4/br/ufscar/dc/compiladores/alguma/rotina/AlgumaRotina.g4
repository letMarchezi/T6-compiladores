grammar AlgumaRotina;

IDENT: ('a'..'z'|'A'..'Z') ('_'|'a'..'z'|'A'..'Z'|'0'..'9')*;

HORA: ('0'..'9')+(':' ('0'..'9')+)?'h';

COMENTARIO : '{' ~('\n'|'}')* '}' -> skip;

CADEIA: ('"' ( ESC_SEQ | ~('"'|'\\'|'\n') )* '"' ) | ('\'' ( ESC_SEQ_SQ | ~('\''|'\\'|'\n') )* '\'');

fragment ESC_SEQ : '\\"';
fragment ESC_SEQ_SQ : '\\\'';

CADEIA_NAO_FECHADA : '"' ( ESC_SEQ | ~('"'|'\\'|'\n'))* '\n' -> skip;

COMENTARIO_NAO_FECHADO : '{' (~('\n'|'}'))* '\n' -> skip;

categ_evento: 'pessoal' | 'aula' | 'trabalho';

dias_sem: 'DOMINGO' | 'SEGUNDA' | 'TERCA' | 'QUARTA' | 'QUINTA' | 'SEXTA' | 'SABADO';

prior_tipo: 'alta' | 'media' | 'baixa';

modals: 'estudo_para_prova' | 'projeto' | 'estudo_teorico' | 'lista_de_exercicios' | 'revisao';

rotina:  (IDENT':' '(' registro ')')+;

programa: 'ROTINA' rotina corpo 'FIMROTINA' EOF;

corpo: 'AGENDA' agenda 'FIMAGENDA' seq_evento seq_comp;

agenda: (dias_sem '(' prog_dia ')')+;

seq_evento: 'EVENTOS' (evento_parc)+ 'FIMEVENTOS';

evento_parc: '(' 'nome' CADEIA ',' 'inicio' HORA ',' 'fim' HORA ',' 'data' date ')';

seq_comp: 'COMPROMISSOS' (comp_parc)+ 'FIMCOMPROMISSOS';

comp_parc:
	 IDENT ':' '(' 'nome' CADEIA ',' 'descricao' CADEIA ',' 'data_compromisso' date ')';  

registro: 'nome' CADEIA ',' 
    'descricao' CADEIA ',' 
    'prioridade'  prior_tipo ',' 
    'modalidade' modals ',' 
    'tempo_desejado' HORA ',' 
    'compromisso' IDENT;

date: DIGIT DIGIT '/' DIGIT DIGIT '/' DIGIT DIGIT DIGIT DIGIT;

DIGIT: [0-9];

WS: [ \t\r\n]+ -> skip;

prog_dia: ('quero_estudar' (CADEIA)* ',')? 
	'inicio' HORA ','
	'fim' HORA ','
	'eventos' evento_agenda (',' evento_agenda)*;

evento_agenda: 
	'(' 'categoria' categ_evento ','
	'inicio' HORA ','
	'fim' HORA ')';

// A regra `ERRO` foi removida para evitar problemas na geração de código.
