package org.ziglang.psi;

import com.intellij.psi.tree.*;
import org.jetbrains.annotations.*;
import org.ziglang.*;

public class ZigElementType extends IElementType {
    public ZigElementType(@NonNls @NotNull String debugName) {
        super(debugName, ZigLanguage.INSTANCE);
    }
}
