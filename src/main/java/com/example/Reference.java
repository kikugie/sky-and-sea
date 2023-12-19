package com.example;

import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Reference {
    public static final String MOD_ID = "modid";
    public static final String MOD_NAME = "IDK";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_NAME);

    public static Identifier id(String value) {
        return new Identifier(MOD_ID, value);
    }
}