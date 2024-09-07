grammar AlgumaRotina;

CATEG_ATIVIDADES: 'pessoal' | 'aula' | 'trabalho';

DIAS_SEM: 'DOMINGO' | 'SEGUNDA' | 'TERCA' | 'QUARTA' | 'QUINTA' | 'SEXTA' | 'SABADO';

PRIORIDADE_TIPO: 'alta' | 'media' | 'baixa';

MODALIDADE: 'estudo_para_prova' | 'projeto' | 'estudo_teorico' | 'lista_de_exercicios' | 'revisao';

IDENT: ('a'..'z'|'A'..'Z') ('_'|'a'..'z'|'A'..'Z'|'0'..'9')*;

HORA: ('0'..'9')+(':' ('0'..'9')+)?'h';

CADEIA: ('"' ( ESC_SEQ | ~('"'|'\\'|'\n') )* '"' ) | ('\'' ( ESC_SEQ_SQ | ~('\''|'\\'|'\n') )* '\'');

fragment ESC_SEQ : '\\"';
fragment ESC_SEQ_SQ : '\\\'';

CADEIA_NAO_FECHADA : '"' ( ESC_SEQ | ~('"'|'\\'|'\n'))* '\n' -> skip;

rotinas: (rotina)+;

rotina:  (IDENT ':' '(' 'titulo' '=' CADEIA ',' 
    'descricao' '=' CADEIA ',' 
    'prioridade' '='  PRIORIDADE_TIPO ',' 
    'modalidade' '=' MODALIDADE ',' 
    'tempo_desejado' '=' HORA ',' 
    'compromisso' '=' IDENT ')');

programa: seq_comp corpo EOF;

corpo: seq_evento 'ROTINA' rotinas 'FIMROTINA' 'AGENDA' agenda 'FIMAGENDA';

date: DIGIT DIGIT '/' DIGIT DIGIT '/' DIGIT DIGIT DIGIT DIGIT;

agenda: (DIAS_SEM '(' prog_dia ')')+;

seq_evento: 'EVENTOS' (evento_parc)+ 'FIMEVENTOS';

evento_parc: '(' 'nome' '=' CADEIA ',' 'inicio' '=' HORA ',' 'fim' '=' HORA ',' 'data' '=' date ')';

seq_comp: 'COMPROMISSOS' (comp_parc)+ 'FIMCOMPROMISSOS';

comp_parc:
	 IDENT ':' '(' 'titulo' '=' CADEIA ',' 'descricao' '=' CADEIA ',' 'data_compromisso' '=' date ')';  


DIGIT: [0-9];

WS: [ \t\r\n]+ -> skip;

prog_dia: 
	'inicio' '=' HORA ','
	'fim' '=' HORA 
	(',' 'atividades' '=' '{' lista_atividades '}')?;

lista_atividades: atividades_agenda (',' atividades_agenda)*;

atividades_agenda: 
	'(' 'categoria' '=' CATEG_ATIVIDADES ','
	'inicio' '=' HORA ','
	'fim' '=' HORA ')';

// A regra `ERRO` foi removida para evitar problemas na geração de código.

