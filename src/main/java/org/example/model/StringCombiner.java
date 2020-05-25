package org.example.model;

import org.example.interfaces.StringOperation;

public class StringCombiner implements StringOperation {
    @Override
    public String operate(String str1, String str2) {
        return str1.concat(" ").concat(str2);
    }
}
