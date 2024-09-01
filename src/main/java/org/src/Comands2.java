package org.src;

public enum Comands2 {
    CAT,
    DOG,
    DUCK;

    public static Comands2 fromString(String command2) {
        try {
            return Comands2.valueOf(command2.trim().toUpperCase());
        }
        catch (IllegalArgumentException e) {
            return null;
        }
    }
}