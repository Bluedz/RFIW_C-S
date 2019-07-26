/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw.TestPak;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream; 
import java.util.Iterator;
import java.util.Properties; 
/**
 *
 * @author Zyh
 */
public class ReadProps {
    
    public void read(String uri, String fileName) {
            
            Properties prop = new Properties(); 
            try{
                InputStream in = new BufferedInputStream (new FileInputStream(uri+fileName));
                prop.load(in);     ///加载属性列表
                Iterator<String> it=prop.stringPropertyNames().iterator();
                while(it.hasNext()){
                    String key=it.next();
                    System.out.println(key+":"+prop.getProperty(key));
                    
                }
                in.close();

            }
            catch(Exception e){
                     System.out.println(e);
            }
    }
    
    public void write(String uri, String fileName){
        Properties prop = new Properties(); 
        try{
                     ///保存属性到b.properties文件
             FileOutputStream oFile = new FileOutputStream(uri+fileName, true);//true表示追加打开
             prop.setProperty("phone", "10086");
             prop.store(oFile, "The New properties file");
             oFile.close();
        }
        catch(Exception e){
              System.out.println(e);
        }        
    
    }
    
    public static void main(String[] args) { 
    //
        // String uri = "D:\\_sync\\jobs\\RFIW\\RFIW\\src\\rfiw\\";
        // String uri = "TestPak\\";
        String uri = "";
        new ReadProps().write(uri, "config.properties");
        new ReadProps().read(uri, "config.properties");
    //
    
    }
}
