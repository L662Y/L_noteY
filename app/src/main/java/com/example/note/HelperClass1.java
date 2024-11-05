package com.example.note;

import java.util.ArrayList;
import java.util.Collections;

public class HelperClass1 {
    String s1, s2;

    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }

    public HelperClass1(String s1, String s2) {
        this.s1 = s1;
        this.s2 = s2;
    }

    public static ArrayList sort(String string) {
        //String[] s = new String[100];
        ArrayList arrayList = new ArrayList();
        int b = -1, e = 0;
        for (int i = 0; i < string.length(); i++) {
            if (string.charAt(i) == '+') {
                {
                    arrayList.add(string.substring((b + 1), i));
                    //  s[ind] = string.substring((b + 1), (i));
                    b = i;
                    e++;
                }
            }
        }
        return arrayList;
    }

    public static String unsort(ArrayList arrayList) {
        String s = "";
        for (int i = 0; i < arrayList.size(); i++) {
            s = s + arrayList.get(i) + "+";

        }


        return s;
    }

    public static String convertRegister(int a) {
        String string = Integer.toString(a);
        return string;
    }

}
