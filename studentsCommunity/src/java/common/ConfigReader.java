/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.evaluates.common;

import java.io.IOException;
import java.io.InputStream;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.context.FacesContext;

/**
 *
 * @author Admin
 */
public class ConfigReader {
    public static String getWebPath(){
                
            URL location= ConfigReader.class.getProtectionDomain().getCodeSource().getLocation();
            String p= location.getPath();
            p=p.substring(0,p.lastIndexOf("/"))+"/../../../../../";
            return p;
    }
    public static String get(String property){
        String property_v=null;
        try {


            InputStream in = new FileInputStream(getWebPath()+"WEB-INF/SysConfig.properties");
            
            Properties properties = new Properties();
               
            properties.load(in);
             property_v = properties.getProperty(property);
          
            
         
        } catch (IOException ex) {
            Logger.getLogger(ConfigReader.class.getName()).log(Level.SEVERE, null, ex);
        }
    
       return property_v;
    }
}
