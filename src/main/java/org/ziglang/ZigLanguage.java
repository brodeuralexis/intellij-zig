package org.ziglang;

import com.intellij.lang.Language;
import org.jetbrains.annotations.NonNls;
import org.jetbrains.annotations.NotNull;

/**
 * The class identifying the Zig programming language with the IDE Platform API.
 */
public final class ZigLanguage extends Language {
    /**
     * The singleton for the Zig programming language.
     */
    public static final ZigLanguage INSTANCE = new ZigLanguage();

    /**
     * The identifier with which the Zig programming language is registered to
     * the Platform API.
     */
    @NonNls
    @NotNull
    public static final String IDENTIFIER = "Zig";

    private ZigLanguage() {
        super(IDENTIFIER);
    }
}
