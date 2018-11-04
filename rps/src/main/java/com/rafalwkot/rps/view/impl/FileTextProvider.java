package com.rafalwkot.rps.view.impl;

import com.rafalwkot.rps.view.TextProvider;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

public class FileTextProvider implements TextProvider {

    private Map<String, String> texts = new HashMap<>();

    public FileTextProvider(String fileName) {
        ResourceBundle rb = ResourceBundle.getBundle(fileName);
        Set<String> tags = rb.keySet();
        for (String key : tags) {
            try {
                texts.put(key, new String(rb.getString(key).getBytes("ISO-8859-1"), "UTF-8"));
            } catch (UnsupportedEncodingException e) {
                throw new RuntimeException(e);
            }
        }
    }

    public String getText(String tag) {
        return texts.get(tag);
    }

}
