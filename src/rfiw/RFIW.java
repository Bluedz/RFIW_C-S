/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rfiw;
import javax.swing.JFrame;
import rfiw.network.MainServer;
// import rfiw.data.BillData;
/**
 *
 * @author Zyh
 */
public class RFIW {

    /**
     */       
    public RFIW (){
        // init();
    }
    public void init(){
        // frameTag = "Welcome";// frameTag = "Bill";// frameTag = "Bye";
        // switchJframe();
    }
    
    /**
    * Router
     * @param jframe
    */
    public static void switchJframe(JFrame jframe){        
        jframe.dispose();
        switch (rfiw.data.ControlData.frameTag) {
            case "Welcome":
                new Pg_Welcome().setVisible(true);
                // welcomePage.setVisible(true);
                break;
            case "Bill":
                JFrame billPage = new Pg_Bill();
                       billPage.setVisible(true);
                break;
            case "Bye":
                new Pg_Bye().setVisible(true);
                break;
            default:
                new Pg_Welcome().setVisible(true);
                break;
        }
    }
    
    public static void main(String[] args) throws Exception {
        // TODO code application logic here
        // RFIW runner = new RFIW();                
        
        JFrame welcomePage = new Pg_Welcome();
        welcomePage.setVisible(true);
        // MainServer Server = 
        new rfiw.network.MainServer();
        
        /* test
        rfiw.data.BillData.billList[1][1] = "show";
        System.out.print(rfiw.data.BillData.billList[1][1]);
        // System.out.print(TestData.tData);
         */
        
    }
    
    
    
}
