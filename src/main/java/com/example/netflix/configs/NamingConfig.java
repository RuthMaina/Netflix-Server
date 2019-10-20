package com.example.netflix.configs;

import org.apache.commons.text.WordUtils;

public class NamingConfig {
    final char[] delimiters = { ' ', '_', '-' };

    public String NamingConfig(String text){
        return WordUtils.capitalizeFully(text, delimiters);
    }
}
