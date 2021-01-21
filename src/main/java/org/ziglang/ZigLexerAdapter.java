package org.ziglang;

import com.intellij.lexer.*;

public class ZigLexerAdapter extends FlexAdapter {
    public ZigLexerAdapter() {
        super(new ZigLexer(null));
    }
}
