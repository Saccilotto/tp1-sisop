%{
#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int yylex();
void yyerror(const char* s);

%}

%token ADD SUB MULT DIV LOAD STORE BRANY BRPOS BRZERO BRNEG SYSCALL LABEL NUMBER ACCUMULATOR PC IDENTIFIER HASH

%start program

%%

program:
    /* empty */
    | program instruction
    ;

instruction:
    operation operand_list
    ;

operation:
    ADD
    | SUB
    | MULT
    | DIV
    | LOAD
    | STORE
    | BRANY
    | BRPOS
    | BRZERO
    | BRNEG
    | SYSCALL
    ;

operand_list:
    operand
    | operand HASH
    ;

operand:
    IDENTIFIER
    | ACCUMULATOR
    | PC
    | NUMBER
    ;

%%
