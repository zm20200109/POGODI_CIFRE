/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import model.SkriveniBroj;
import model.User;

/**
 *
 * @author Acer
 */
public class Controller {
    
    private static Controller instance;
    private List<User> admini; //= new ArrayList<>();
    private User ulogovani=null;
    private List<SkriveniBroj> brojevi = new ArrayList<>();
    
    
    private Controller(){
        User u1 = new User("pera@gmail.com","123456","Pera","Peric");
        User u2 = new User("mara@gmail.com","654321","Mara","Maric");
        admini = new ArrayList<>();
        admini.add(u1);
        admini.add(u2);
    }

    public static Controller getInstance(){
        if(instance == null){
            instance = new Controller();
        }
        return instance;
    }

    public User login(String email, String pass) {
        for(User a:admini){
            if(a.getUsername().equals(email) && a.getLozinka().equals(pass)){
                ulogovani = a;
                return a;
            }
            
        }
        return null;
    }

    public User getUlogovani() {
        return ulogovani;
    }

    public void setUlogovani(User ulogovani) {
        this.ulogovani = ulogovani;
    }

    public void dodajBroj(SkriveniBroj sb) {
        brojevi.add(sb);
    }

    public boolean postoji(SkriveniBroj sb) {
        for(SkriveniBroj skriveniBroj:brojevi){
            if(sb.getVrednost() == skriveniBroj.getVrednost()){
                return true;
            }
        }
        return false;
    }

    public List<SkriveniBroj> getBrojevi() {
        return brojevi;
    }

    public void setBrojevi(List<SkriveniBroj> brojevi) {
        this.brojevi = brojevi;
    }
    
    
    
    
    
}
