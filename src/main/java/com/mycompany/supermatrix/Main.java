/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermatrix;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author bende
 */
public class Main {
    
    public Main() {
    
        Matriu m1 = new Matriu();
        Matriu m2 = new Matriu();
        try {
            m1.multiplicarMatriuX(m2);
        } catch (InterruptedException ex) {
            Logger.getLogger(Main.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
    public static void main(String[] args) {
        
        new Main();
    }
}
