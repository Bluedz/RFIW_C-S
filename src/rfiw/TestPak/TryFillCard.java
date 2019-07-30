/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw.TestPak;

/**
 *
 * @author Zyh
 */
public class TryFillCard {
    
     public static void main(String[] args){
        try{
            rfiw.service.IOProcess.fillRFTagList("1234");
        }catch(Exception e){
        System.out.println(e);
        System.out.println("1");
        }
        System.out.println("2");
        
    }
}
