/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.carbonout.util;

import java.io.IOException;
import org.codehaus.jackson.JsonProcessingException;
import org.codehaus.jackson.map.ObjectMapper;

/**
 *
 * @author Usuario
 */
public class Json {
    private static ObjectMapper objMP;
    static{
        objMP = new ObjectMapper();
    }
    
    public static String convertJavaToJson(Object obj) throws IOException{
        String jsonString = "";
        
        try  {
            jsonString = objMP.writeValueAsString(obj);
        }catch(JsonProcessingException e){
                System.out.println("Exception convert Java to Json");
        }
        return jsonString;
    }
    
}
