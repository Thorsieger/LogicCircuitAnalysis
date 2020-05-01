lexer grammar CircuitLexer;

// Lexing rules: recognize tokens
BTRUE: 'true';
BFALSE: 'false';
SEMIC: ';';
LPAR: '(';
RPAR: ')';
INT: '!';
ESP: '&';
BAR: '|';
EQU: '=';
VIRG: ',';
FCTN: 'eq_circuit';
RETURN: 'returns';
ND: 'end';
DESC: 'descr';
EVL: 'eval';
PORT: [a-zA-Z0-9][a-zA-Z0-9]*;
WS : [ \t\r\n]+ ->skip;
