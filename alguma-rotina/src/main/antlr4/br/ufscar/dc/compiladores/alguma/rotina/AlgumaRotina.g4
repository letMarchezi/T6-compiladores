grammar AlgumaRotina;

IDENT: ('a'..'z'|'A'..'Z') ('_'|'a'..'z'|'A'..'Z'|'0'..'9')*;

HORA: ('0'..'9')+(':' ('0'..'9')+)?'h';


CADEIA: ('"' ( ESC_SEQ | ~('"'|'\\'|'\n') )* '"' ) | ('\'' ( ESC_SEQ_SQ | ~('\''|'\\'|'\n') )* '\'');

fragment ESC_SEQ : '\\"';
fragment ESC_SEQ_SQ : '\\\'';

CADEIA_NAO_FECHADA : '"' ( ESC_SEQ | ~('"'|'\\'|'\n'))* '\n' -> skip;

categ_atividades: 'pessoal' | 'aula' | 'trabalho';

dias_sem: 'DOMINGO' | 'SEGUNDA' | 'TERCA' | 'QUARTA' | 'QUINTA' | 'SEXTA' | 'SABADO';

prioridade_tipo: 'alta' | 'media' | 'baixa';

modalidade: 'estudo_para_prova' | 'projeto' | 'estudo_teorico' | 'lista_de_exercicios' | 'revisao';

rotinas: (rotina)+;

rotina:  (IDENT':' '(' 'titulo=' CADEIA ',' 
    'descricao=' CADEIA ',' 
    'prioridade='  prioridade_tipo ',' 
    'modalidade=' modalidade ',' 
    'tempo_desejado=' HORA ',' 
    'compromisso=' IDENT ')');

programa: seq_comp corpo EOF;

corpo: 'ROTINA' rotinas 'FIMROTINA' 'AGENDA' agenda 'FIMAGENDA' seq_evento;

agenda: (dias_sem '(' prog_dia ')')+;

seq_evento: 'EVENTOS' (evento_parc)+ 'FIMEVENTOS';

evento_parc: '(' 'nome' CADEIA ',' 'inicio' HORA ',' 'fim' HORA ',' 'data' date ')';

seq_comp: 'COMPROMISSOS' (comp_parc)+ 'FIMCOMPROMISSOS';

comp_parc:
	 IDENT ':' '(' 'nome' CADEIA ',' 'descricao' CADEIA ',' 'data_compromisso' date ')';  

date: DIGIT DIGIT '/' DIGIT DIGIT '/' DIGIT DIGIT DIGIT DIGIT;

DIGIT: [0-9];

WS: [ \t\r\n]+ -> skip;

prog_dia: 
	'inicio' HORA ','
	'fim' HORA 
	(',' 'atividades' '=' '{' lista_atividades '}')?;

lista_atividades: atividades_agenda (',' atividades_agenda)*;

atividades_agenda: 
	'(' 'categoria' categ_atividades ','
	'inicio' HORA ','
	'fim' HORA ')';

// A regra `ERRO` foi removida para evitar problemas na geração de código.

