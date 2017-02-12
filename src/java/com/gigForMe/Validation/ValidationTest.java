/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.gigForMe.Validation;

import java.util.ArrayList;

/**
 *
 * @author 110310587
 */
public class ValidationTest {
      public static boolean testAlphaNum(String str) {
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c < 0x30 || (c >= 0x3a && c <= 0x40) || (c > 0x5a && c <= 0x60) || c > 0x7a) {
                return false;
            }
        }
        return true;
    }
      
      public static void main(String[] args) {
           ArrayList<String> alphaNumList = new ArrayList();
        alphaNumList.add("Tone");
        alphaNumList.add("Tone");
        alphaNumList.add("sfafdsaf");
        alphaNumList.add("neh");
        boolean flag = false;
        for (String temp : alphaNumList) {
                flag = testAlphaNum(temp);
            }
       System.out.println(flag);
    }
}
