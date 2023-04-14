package net.acasualpancake.util;

import org.jetbrains.annotations.Nullable;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

@SuppressWarnings("unused")
public class FileAtlas {

    private static Map<String, File> atlas;
    private static boolean isInit = false;

    /**
     * <p>Utility class. Do not instantiate.</p>
     */
    private FileAtlas() {}

    /**
     * <p>Do use update instead.</p>
     * @param identifier The string identifier.
     * @param f The file.
     */
    @Deprecated
    public static void add(String identifier, File f) {
        atlas.put(identifier, f);
    }

    /**
     * <p>Removes variables from the file atlas.</p>
     * @param identifier The string identifier.
     */
    public static void remove(String identifier) {
        if (!atlas.containsKey(identifier)) return;
        atlas.remove(identifier);
    }

    /**
     * <p>Updates existing variables and adds new variables if they don't exist.</p>
     * @param identifier The string identifier to call the file.
     * @param f The file to be stored.
     */
    public static void update(String identifier, File f) {
        if (atlas.containsKey(identifier)) {
            atlas.replace(identifier, f);
        } else {
            add(identifier, f);
        }
    }

    /**
     * <p>Returns a stored file.</p>
     * @param identifier The string identifier.
     * @return The file.
     */
    public static @Nullable File get(String identifier) {
        if (!atlas.containsKey(identifier)) return null;
        return atlas.get(identifier);
    }

    /**
     * <p>Instantiates required variables.</p>
     * @return true if succeeded.
     */
    public static boolean init() {
        if (isInit) return false;

        // Run init code
        atlas = new HashMap<>();

        // Close init code
        isInit = true;
        return true;
    }
}
