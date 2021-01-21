package org.ziglang.psi;

import com.intellij.psi.tree.*;
import org.jetbrains.annotations.*;
import org.ziglang.*;

public class ZigTokenType extends IElementType {
    public ZigTokenType(@NonNls @NotNull String debugName) {
        super(debugName, ZigLanguage.INSTANCE);
    }
}
