package org.ziglang;

import com.intellij.openapi.fileTypes.*;
import com.intellij.openapi.util.*;
import com.intellij.openapi.vfs.*;
import org.jetbrains.annotations.*;

import javax.swing.*;

/**
 * The file type for any virtual files associated with the Zig programming
 * language.
 */
public final class ZigFileType extends LanguageFileType {
    /**
     * An instance of a language file type identifying associated files as
     * containing Zig source code.
     */
    @NotNull
    public static final ZigFileType INSTANCE = new ZigFileType();

    /**
     * The default extension for a Zig source code file.
     */
    @NonNls
    @NotNull
    public static final String DEFAULT_EXTENSION = "zig";

    /**
     * The default extension for a Zig source code file, including the dot.
     */
    @NonNls
    @NotNull
    public static final String DOT_DEFAULT_EXTENSION = "." + DEFAULT_EXTENSION;

    private ZigFileType() {
        super(ZigLanguage.INSTANCE, false);
    }

    @Override
    public @NonNls @NotNull String getName() {
        return ZigLanguage.IDENTIFIER;
    }

    @Override
    public @NlsContexts.Label @NotNull String getDescription() {
        return ZigLanguage.IDENTIFIER + " language";
    }

    @Override
    public @NlsSafe @NotNull String getDefaultExtension() {
        return DEFAULT_EXTENSION;
    }

    @Override
    public @NotNull Icon getIcon() {
        return ZigIcons.FAVICON;
    }

    @Override
    public String getCharset(@NotNull VirtualFile file, byte @NotNull [] content) {
        /// Zig files are always UTF-8 encoded files.
        return CharsetToolkit.UTF8;
    }
}
