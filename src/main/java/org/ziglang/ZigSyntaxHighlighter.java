package org.ziglang;

import com.intellij.lexer.*;
import com.intellij.openapi.editor.*;
import com.intellij.openapi.editor.colors.*;
import com.intellij.openapi.fileTypes.*;
import com.intellij.psi.*;
import com.intellij.psi.tree.*;
import org.jetbrains.annotations.*;
import org.ziglang.psi.*;

public class ZigSyntaxHighlighter extends SyntaxHighlighterBase {
    public static final TextAttributesKey LINE_COMMENT = TextAttributesKey.createTextAttributesKey("LINE_COMMENT", DefaultLanguageHighlighterColors.LINE_COMMENT);
    public static final TextAttributesKey DOC_COMMENT = TextAttributesKey.createTextAttributesKey("DOC_COMMENT", DefaultLanguageHighlighterColors.DOC_COMMENT);
    public static final TextAttributesKey STRING = TextAttributesKey.createTextAttributesKey("STRING", DefaultLanguageHighlighterColors.STRING);
    public static final TextAttributesKey KEYWORD = TextAttributesKey.createTextAttributesKey("KEYWORD", DefaultLanguageHighlighterColors.KEYWORD);
    public static final TextAttributesKey BAD_CHARACTER = TextAttributesKey.createTextAttributesKey("ZIG_BAD_CHARACTER", HighlighterColors.BAD_CHARACTER);

    private static final TextAttributesKey[] BAD_CHAR_KEYS = new TextAttributesKey[]{BAD_CHARACTER};
    private static final TextAttributesKey[] LINE_COMMENT_KEYS = new TextAttributesKey[]{LINE_COMMENT};
    private static final TextAttributesKey[] DOC_COMMENT_KEYS = new TextAttributesKey[]{DOC_COMMENT};
    private static final TextAttributesKey[] STRING_KEYS = new TextAttributesKey[]{STRING};
    private static final TextAttributesKey[] KEYWORD_KEYS = new TextAttributesKey[]{KEYWORD};
    private static final TextAttributesKey[] EMPTY_KEYS = new TextAttributesKey[0];

    @Override
    public @NotNull Lexer getHighlightingLexer() {
        return new ZigLexerAdapter();
    }

    @Override
    public TextAttributesKey @NotNull [] getTokenHighlights(IElementType tokenType) {
        if (tokenType.equals(ZigTypes.DOCCOMMENT)) {
            return DOC_COMMENT_KEYS;
        } else if (tokenType.equals(ZigTypes.LINECOMMENT)) {
            return LINE_COMMENT_KEYS;
        } else if (tokenType.equals(TokenType.BAD_CHARACTER)) {
            return BAD_CHAR_KEYS;
        } else if (isString(tokenType)) {
            return STRING_KEYS;
        } else if (isKeyword(tokenType)) {
            return KEYWORD_KEYS;
        } else {
            return EMPTY_KEYS;
        }
    }

    private static boolean isString(@NotNull IElementType tokenType) {
        return tokenType.equals(ZigTypes.STRINGLITERALLINE)
                || tokenType.equals(ZigTypes.STRINGLITERALSINGLE)
                || tokenType.equals(ZigTypes.CHARLITERAL);
    }

    private static boolean isKeyword(@NotNull IElementType tokenType) {
        return tokenType.equals(ZigTypes.KEYWORD_ALIGN)
                || tokenType.equals(ZigTypes.KEYWORD_ALLOWZERO)
                || tokenType.equals(ZigTypes.KEYWORD_AND)
                || tokenType.equals(ZigTypes.KEYWORD_ANYFRAME)
                || tokenType.equals(ZigTypes.KEYWORD_ANYTYPE)
                || tokenType.equals(ZigTypes.KEYWORD_ASM)
                || tokenType.equals(ZigTypes.KEYWORD_ASYNC)
                || tokenType.equals(ZigTypes.KEYWORD_AWAIT)
                || tokenType.equals(ZigTypes.KEYWORD_BREAK)
                || tokenType.equals(ZigTypes.KEYWORD_CALLCONV)
                || tokenType.equals(ZigTypes.KEYWORD_CATCH)
                || tokenType.equals(ZigTypes.KEYWORD_COMPTIME)
                || tokenType.equals(ZigTypes.KEYWORD_CONST)
                || tokenType.equals(ZigTypes.KEYWORD_CONTINUE)
                || tokenType.equals(ZigTypes.KEYWORD_DEFER)
                || tokenType.equals(ZigTypes.KEYWORD_ELSE)
                || tokenType.equals(ZigTypes.KEYWORD_ENUM)
                || tokenType.equals(ZigTypes.KEYWORD_ERRDEFER)
                || tokenType.equals(ZigTypes.KEYWORD_ERROR)
                || tokenType.equals(ZigTypes.KEYWORD_EXPORT)
                || tokenType.equals(ZigTypes.KEYWORD_EXTERN)
                || tokenType.equals(ZigTypes.KEYWORD_FALSE)
                || tokenType.equals(ZigTypes.KEYWORD_FN)
                || tokenType.equals(ZigTypes.KEYWORD_FOR)
                || tokenType.equals(ZigTypes.KEYWORD_IF)
                || tokenType.equals(ZigTypes.KEYWORD_INLINE)
                || tokenType.equals(ZigTypes.KEYWORD_LINKSECTION)
                || tokenType.equals(ZigTypes.KEYWORD_NOALIAS)
                || tokenType.equals(ZigTypes.KEYWORD_NOINLINE)
                || tokenType.equals(ZigTypes.KEYWORD_NOSUSPEND)
                || tokenType.equals(ZigTypes.KEYWORD_NULL)
                || tokenType.equals(ZigTypes.KEYWORD_OPAQUE)
                || tokenType.equals(ZigTypes.KEYWORD_OR)
                || tokenType.equals(ZigTypes.KEYWORD_ORELSE)
                || tokenType.equals(ZigTypes.KEYWORD_PACKED)
                || tokenType.equals(ZigTypes.KEYWORD_PUB)
                || tokenType.equals(ZigTypes.KEYWORD_RESUME)
                || tokenType.equals(ZigTypes.KEYWORD_RETURN)
                || tokenType.equals(ZigTypes.KEYWORD_STRUCT)
                || tokenType.equals(ZigTypes.KEYWORD_SUSPEND)
                || tokenType.equals(ZigTypes.KEYWORD_SWITCH)
                || tokenType.equals(ZigTypes.KEYWORD_TEST)
                || tokenType.equals(ZigTypes.KEYWORD_THREADLOCAL)
                || tokenType.equals(ZigTypes.KEYWORD_TRUE)
                || tokenType.equals(ZigTypes.KEYWORD_TRY)
                || tokenType.equals(ZigTypes.KEYWORD_UNDEFINED)
                || tokenType.equals(ZigTypes.KEYWORD_UNION)
                || tokenType.equals(ZigTypes.KEYWORD_UNREACHABLE)
                || tokenType.equals(ZigTypes.KEYWORD_USINGNAMESPACE)
                || tokenType.equals(ZigTypes.KEYWORD_VAR)
                || tokenType.equals(ZigTypes.KEYWORD_VOLATILE)
                || tokenType.equals(ZigTypes.KEYWORD_WHILE);
    }
}
