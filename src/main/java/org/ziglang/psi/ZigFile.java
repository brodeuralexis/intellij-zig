package org.ziglang.psi;

import com.intellij.extapi.psi.*;
import com.intellij.openapi.fileTypes.*;
import com.intellij.psi.*;
import org.jetbrains.annotations.*;
import org.ziglang.*;

public class ZigFile extends PsiFileBase {
    public ZigFile(@NotNull FileViewProvider viewProvider) {
        super(viewProvider, ZigLanguage.INSTANCE);
    }

    @Override
    public @NotNull FileType getFileType() {
        return ZigFileType.INSTANCE;
    }

    @Override
    public String toString() {
        return "Zig File";
    }
}
