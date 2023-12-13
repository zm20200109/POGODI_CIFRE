/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package server;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import transfer.KlijentskiZahtev;
import transfer.ServerskiOdgovor;

/**
 *
 * @author Acer
 */
public class ObradaKlijentskihZahteva extends Thread{

    private Socket s;
   
    public ObradaKlijentskihZahteva(Socket s) {
        this.s = s;
    }

    @Override
    public void run() {
        try {
            KlijentskiZahtev kz = primiZahtev(); // sa strima prima zahtev
            ServerskiOdgovor so = new ServerskiOdgovor();
        
            switch(kz.getOperacija()){
            
            
            }
            
            posaljiOdgovor(so);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
      
    }
    
    
    
    private KlijentskiZahtev primiZahtev() throws ClassNotFoundException{
        try {
            ObjectInputStream ois = new ObjectInputStream(s.getInputStream());
            return (KlijentskiZahtev)ois.readObject();
            
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
    private void posaljiOdgovor(ServerskiOdgovor so){
    
        try {         
            ObjectOutputStream ous = new ObjectOutputStream(s.getOutputStream());
            ous.writeObject(so);
        } catch (IOException ex) {
            Logger.getLogger(ObradaKlijentskihZahteva.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    
    
}
