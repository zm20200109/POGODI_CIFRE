/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Acer
 */
public class PokreniServer extends Thread{

    @Override
    public void run() {
        try {
            ServerSocket serverskiSoket = new ServerSocket(9000);
            //metoda otvara serverski soket na portu 9000
            
            while(true){
                //ceka da se poveze klijent na server 
                Socket s = serverskiSoket.accept();
                System.out.println("Klijent je povezan!");
                
                ObradaKlijentskihZahteva nit = new ObradaKlijentskihZahteva(s);
                nit.start();
            }
            
        } catch (IOException ex) {
            Logger.getLogger(PokreniServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    
    }
    
    
    
}
