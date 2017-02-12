/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.gigForMe.utils;

import static com.gigForMe.utils.IConstants.ANSI_BLUE;
import static com.gigForMe.utils.IConstants.ANSI_RESET;
import java.io.InputStream;

/**
 *
 * @author bemerson
 */
public class StringUtils {
    
    public static boolean isStringEmpty(String input){
        if (input == null){
            return true;
        }
        else if (input.length()==0){
            return true;
        }
        else return false;
    }
    
    //Method to cut string down to the last whitespace before a certain value, eg 160 characters
     public static String cutToLastSpace(String oldString, int cutOff){
        
        String tempStr;
        //If the cutOff value is greater than length of string, there's no need to cut
        if (cutOff>oldString.length()){
            tempStr = oldString;
        }
        //If it's longer than the cutoff, cut it to the desired length
        else{
            tempStr = oldString.substring(0, cutOff);
            
             //find the last whitespace before the cutoff and memorise that space
            int spacePlace = 0;
            for (int position = tempStr.length()-1; position>0; position --){
                if (tempStr.charAt(position) == ' '){;     
                    spacePlace = position;
                    break;
                }
            }

            //cut the string to the last whitespace
            tempStr = tempStr.substring(0, spacePlace);
        }
        
       
        return tempStr;
    }
     
     public static String blueText(String msg){
        int numSpaces = 110- msg.length();
        String spaces = "";
        if (msg.length()< 120){
            for (int i = 0; i<(numSpaces/2); i++){
                spaces += "-";
            }
        }
        String message = ANSI_BLUE + spaces +msg + spaces +ANSI_RESET;
        return message;
    }
     
    
}
