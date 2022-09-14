package leetcode.editor.test;

import java.security.PrivateKey;

/**
 * @Author: aajijifujiji
 * @DATE: 2021/12/6 23:31
 */
public enum Size {
    SMALL("S")
    , MEDIUM("M")
    , LARGE("L")
    , EXTRA_LARGE("XL");

    Size(String abbr) {
        this.abbr = abbr;
    }

    public String getAbbr() {
        return abbr;
    }

    private String abbr;

}
