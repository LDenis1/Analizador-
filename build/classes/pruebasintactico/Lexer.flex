package pruebasintactico;
import static pruebasintactico.Tokens.*;
%%
%class Lexer
%type Tokens

L=[a-zA-Z_]+
D=[0-9]+
espacio=[ ,\t,\r,\n]+
Caracter = .*

%{
    public String lexeme;
%}
%%

{espacio} {/*Ignore*/}
"(*" {Caracter} "*)" {/*Ignore*/}


"PROGRAM"           {lexeme= yytext(); return PROGRAM;}
"CONST"             {lexeme= yytext(); return CONST;}
"TYPE"              {lexeme= yytext(); return TYPE;}
"VAR"               {lexeme= yytext(); return VAR;}
"BEGIN"             {lexeme= yytext(); return BEGIN;}
"END"               {lexeme= yytext(); return END;}

 . {return ERROR;}

 