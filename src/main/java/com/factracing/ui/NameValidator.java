package com.factracing.ui;

import com.sun.jna.platform.win32.WinDef;

/**
 * Created by Janik on 17.05.2017.
 */
public class NameValidator implements Validator<String> {
    CharSequence[] invalidCharacters;

    public NameValidator(){
        this(new CharSequence[]{"@", ".", ",", "!", "%", "$"});
    }

    public NameValidator(CharSequence[] invalidCharacters){
        this.invalidCharacters = invalidCharacters;
    }

    @Override
    public String validate(String ob) {
        String name = ob;
        if(name.length() > 0)
            for(CharSequence invalid:invalidCharacters)
                if(name.contains(invalid)) {
                    return null;
                }
            return name;
    }
}
