/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermatrix;

/**
 *
 * @author bende
 */
public class Resultat implements Runnable{
    
    private int result = 0;
    private int[] valorsFila;
    private int[] valorsColumna;
    private Matriu m;
    private int fila;
    private int columna;
    
    public Resultat(int[] valorsFila, int[] valorsColumna, Matriu m, int fila, int columna){
    
        this.m = m;
        this.valorsColumna = valorsColumna;
        this.valorsFila = valorsFila;
        this.fila = fila;
        this.columna = columna;
        
    }
    private void calcularResultat(){
        
        for (int i = 0; i < valorsColumna.length; i++) {
            result += valorsFila[i]*valorsColumna[i];
            
        }
        m.getMatriu()[fila][columna] = result;
    }

    @Override
    public void run() {
       calcularResultat();
    }
}
