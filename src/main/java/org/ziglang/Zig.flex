// Copyright 2000-2020 JetBrains s.r.o. and other contributors. Use of this source code is governed by the Apache 2.0 license that can be found in the LICENSE file.
package org.ziglang;

import com.intellij.lexer.*;
import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import org.ziglang.psi.*;

%%

%public
%class ZigLexer
%implements FlexLexer
%unicode
%function advance
%type IElementType
%eof{  return;
%eof}

hex = [0-9a-fA-F]
hex_ = [0-9a-fA-F_]
dec = [0-9]
dec_ = [0-9_]

dec_int = {dec} ({dec_}* {dec})?
hex_int = {hex} ({hex_}* {hex})?

char_escape = "\\x" {hex} {hex}
            | "\\u{" {hex}+ "}"
            | "\\" [nr\\t\'\"]
char_char = {char_escape}
          | [^\\\'\n]
string_char = {char_escape}
            | [^\\\"\n]

doc_comment = "\/\/\/" [^\n]*
line_comment = "\/\/" [^\n]*
line_string = ("\\\\" [^\n]* [ \n]*)+

WHITESPACE = [\s\f\t\n\r]

CHARLITERAL = "'" {char_char} "'"
FLOAT = "0x" {hex_}* {hex} "." {hex_int} ([pP] [-+]? {hex_int})?
      |      {dec_int}     "." {dec_int} ([eE] [-+]? {dec_int})?
      | "0x" {hex_}* {hex} "."? [pP] [-+]? {hex_int}
      |      {dec_int}     "."? [eE] [-+]? {dec_int}
INTEGER = "0b" [_01]* [01]
        | "0o" [_0-7]* [0-7]
        | "0x" {hex_}* {hex}
        |      {dec_int}

STRINGLITERALSINGLE = "\"" {string_char}* "\""
STRINGLITERALLINE = {line_string}

IDENTIFIER = [A-Za-z_][A-Za-z0-9_]*

%%

{WHITESPACE}+ { return TokenType.WHITE_SPACE; }
{doc_comment} { return ZigTypes.DOCCOMMENT; }
{line_comment} { return ZigTypes.LINECOMMENT; }

\&\=   { return ZigTypes.AMPERSANDEQUAL; }
\&     { return ZigTypes.AMPERSAND; }

\*\%\= { return ZigTypes.ASTERISKPERCENTEQUAL; }
\*\%   { return ZigTypes.ASTERISKPERCENT; }
\*\=   { return ZigTypes.ASTERISKEQUAL; }
\*\*   { return ZigTypes.ASTERISK2; }
\*     { return ZigTypes.ASTERISK; }

\^\=   { return ZigTypes.CARETEQUAL; }
\^     { return ZigTypes.CARET; }

\:     { return ZigTypes.COLON; }
\,     { return ZigTypes.COMMA; }

\.\.\. { return ZigTypes.DOT3; }
\.\.   { return ZigTypes.DOT2; }
\.\*   { return ZigTypes.DOTASTERISK; }
\.\?   { return ZigTypes.DOTQUESTIONMARK; }
\.     { return ZigTypes.DOT; }

\=\=   { return ZigTypes.EQUALEQUAL; }
\=\>   { return ZigTypes.EQUALRARROW; }
\=     { return ZigTypes.EQUAL; }

\!\=   { return ZigTypes.EXCLAMATIONMARKEQUAL; }
\!     { return ZigTypes.EXCLAMATIONMARK; }

\<\<\= { return ZigTypes.LARROW2EQUAL; }
\<\<   { return ZigTypes.LARROW2; }
\<\=   { return ZigTypes.LARROWEQUAL; }
\<     { return ZigTypes.LARROW; }

\{     { return ZigTypes.LBRACE; }
\[     { return ZigTypes.LBRACKET; }
\(     { return ZigTypes.LPAREN; }

\-\%\= { return ZigTypes.MINUSPERCENTEQUAL; }
\-\%   { return ZigTypes.MINUSPERCENT; }
\-\=   { return ZigTypes.MINUSEQUAL; }
\-\>   { return ZigTypes.MINUSRARROW; }
\-     { return ZigTypes.MINUS; }

\%\=   { return ZigTypes.PERCENTEQUAL; }
\%     { return ZigTypes.PERCENT; }

\|\|   { return ZigTypes.PIPE2; }
\|\=   { return ZigTypes.PIPEEQUAL; }
\|     { return ZigTypes.PIPE; }

\+\%\= { return ZigTypes.PLUSPERCENTEQUAL; }
\+\%   { return ZigTypes.PLUSPERCENT; }
\+\=   { return ZigTypes.PLUSEQUAL; }
\+\+   { return ZigTypes.PLUS2; }
\+     { return ZigTypes.PLUS; }

c      { return ZigTypes.LETTERC; }
\?     { return ZigTypes.QUESTIONMARK; }

\>\>\= { return ZigTypes.RARROW2EQUAL; }
\>\>   { return ZigTypes.RARROW2; }
\>\=   { return ZigTypes.RARROWEQUAL; }
\>     { return ZigTypes.RARROW; }

\}     { return ZigTypes.RBRACE; }
\]     { return ZigTypes.RBRACKET; }
\)     { return ZigTypes.RPAREN; }
\;     { return ZigTypes.SEMICOLON; }

\/\=   { return ZigTypes.SLASHEQUAL; }
\/     { return ZigTypes.SLASH; }

\~     { return ZigTypes.TILDE; }

\@     { return ZigTypes.AT; }

{STRINGLITERALSINGLE} { return ZigTypes.STRINGLITERALSINGLE; }
{STRINGLITERALLINE} { return ZigTypes.STRINGLITERALLINE; }
{CHARLITERAL} { return ZigTypes.CHARLITERAL; }

align { return ZigTypes.KEYWORD_ALIGN; }
allowzero { return ZigTypes.KEYWORD_ALLOWZERO; }
and { return ZigTypes.KEYWORD_AND; }
anyframe { return ZigTypes.KEYWORD_ANYFRAME; }
anytype { return ZigTypes.KEYWORD_ANYTYPE; }
asm { return ZigTypes.KEYWORD_ASM; }
async { return ZigTypes.KEYWORD_ASYNC; }
await { return ZigTypes.KEYWORD_AWAIT; }
break { return ZigTypes.KEYWORD_BREAK; }
callconv { return ZigTypes.KEYWORD_CALLCONV; }
catch { return ZigTypes.KEYWORD_CATCH; }
comptime { return ZigTypes.KEYWORD_COMPTIME; }
const { return ZigTypes.KEYWORD_CONST; }
continue { return ZigTypes.KEYWORD_CONTINUE; }
defer { return ZigTypes.KEYWORD_DEFER; }
else { return ZigTypes.KEYWORD_ELSE; }
enum { return ZigTypes.KEYWORD_ENUM; }
errdefer { return ZigTypes.KEYWORD_ERRDEFER; }
error { return ZigTypes.KEYWORD_ERROR; }
export { return ZigTypes.KEYWORD_EXPORT; }
extern { return ZigTypes.KEYWORD_EXTERN; }
false { return ZigTypes.KEYWORD_FALSE; }
fn { return ZigTypes.KEYWORD_FN; }
for { return ZigTypes.KEYWORD_FOR; }
if { return ZigTypes.KEYWORD_IF; }
inline { return ZigTypes.KEYWORD_INLINE; }
noalias { return ZigTypes.KEYWORD_NOALIAS; }
nosuspend { return ZigTypes.KEYWORD_NOSUSPEND; }
noinline { return ZigTypes.KEYWORD_NOINLINE; }
null { return ZigTypes.KEYWORD_NULL; }
opaque { return ZigTypes.KEYWORD_OPAQUE; }
orelse { return ZigTypes.KEYWORD_ORELSE; }
or { return ZigTypes.KEYWORD_OR; }
packed { return ZigTypes.KEYWORD_PACKED; }
pub { return ZigTypes.KEYWORD_PUB; }
resume { return ZigTypes.KEYWORD_RESUME; }
return { return ZigTypes.KEYWORD_RETURN; }
linksection { return ZigTypes.KEYWORD_LINKSECTION; }
struct { return ZigTypes.KEYWORD_STRUCT; }
suspend { return ZigTypes.KEYWORD_SUSPEND; }
switch { return ZigTypes.KEYWORD_SWITCH; }
test { return ZigTypes.KEYWORD_TEST; }
threadlocal { return ZigTypes.KEYWORD_THREADLOCAL; }
true { return ZigTypes.KEYWORD_TRUE; }
try { return ZigTypes.KEYWORD_TRY; }
undefined { return ZigTypes.KEYWORD_UNDEFINED; }
union { return ZigTypes.KEYWORD_UNION; }
unreachable { return ZigTypes.KEYWORD_UNREACHABLE; }
usingnamespace { return ZigTypes.KEYWORD_USINGNAMESPACE; }
var { return ZigTypes.KEYWORD_VAR; }
volatile { return ZigTypes.KEYWORD_VOLATILE; }
while { return ZigTypes.KEYWORD_WHILE; }

{IDENTIFIER} { return ZigTypes.IDENTIFIERLITERAL; }
{INTEGER} { return ZigTypes.INTEGERLITERAL; }
{FLOAT} { return ZigTypes.FLOATLITERAL; }

[^] { return TokenType.BAD_CHARACTER; }
