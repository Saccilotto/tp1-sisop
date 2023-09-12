%{
#include "parser.tab.h"
%}

%option noyywrap

%{
int yylval_num;
char* yylval_label;
%}

%%


ADD             { return ADD; }
SUB             { return SUB; }
MULT            { return MULT; }
DIV             { return DIV; }
LOAD            { return LOAD; }
STORE           { return STORE; }
BRANY           { return BRANY; }
BRPOS           { return BRPOS; }
BRZERO          { return BRZERO; }
BRNEG           { return BRNEG; }
SYSCALL         { return SYSCALL; }
"ACCUMULATOR"   { return ACCUMULATOR; }
"PC"            { return PC; }
"LABEL"         { return LABEL; }
[0-9]+          { yylval_num = atoi(yytext); return NUMBER; }
#               { return HASH; }
[a-zA-Z_][a-zA-Z0-9_]*  { yylval_label = strdup(yytext); return IDENTIFIER; }
[ \t\n]         ; // Ignore whitespace and newline
.               { printf("Invalid character: %s\n", yytext); }

%%

