package com.musinsa.urlshort.util;

import org.springframework.stereotype.Component;


@Component
public class Base62 {

    static final int RADIX = 62;
    static final int DEFAULT_VAL = 100000000;
    static final char[] BASE62 = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789".toCharArray();

    /**
     * BASE62 인코딩
     * @param value
     * @return Base62 Encoding
     */
    public static String encoding(int value) {
        final StringBuilder sb = new StringBuilder();
        value = value + DEFAULT_VAL;
        do {
            int i = value % RADIX;
            sb.append(BASE62[i]);
            value /= RADIX;
        } while (value > 0);
        return sb.toString();
    }

    /**
     * BASE62 디코딩
     * @param value
     * @return Base62 Decoding
     */
    public static int decoding(String value) {
        int result=0;
        int power=1;
        for (int i = 0; i < value.length(); i++) {
            int digit = new String(BASE62).indexOf(value.charAt(i));
            result += digit * power;
            power *= RADIX;
        }
        return result-DEFAULT_VAL;
    }
}
