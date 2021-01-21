package org.ziglang;

import com.intellij.openapi.util.IconLoader;
import org.jetbrains.annotations.NotNull;

import javax.swing.*;

public final class ZigIcons {
    @NotNull
    public static final Icon FAVICON = IconLoader.getIcon("/icons/zig-favicon.png", ZigIcons.class);

    private ZigIcons() {}
}
