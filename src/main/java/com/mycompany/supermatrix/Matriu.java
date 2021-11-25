/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.supermatrix;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author bende
 */
public class Matriu {
    
    private int files;
    private int columnes;
    private int[][] matriu;
    private int maxNum;
    Scanner scan = new Scanner(System.in);
    
    public Matriu() {
    
        crearMatriu();
        farcirMatriu();
        printMatriu();
        
        
    }
    
    public Matriu(int files, int columnes){
    
        matriu = new int[files][columnes];
        
    }
    
    public int getColumnes(){
    
        return columnes;
    }
    
    public int[][] getMatriu(){
        
        return matriu;
    }
    
    public int getFiles(){
    
        return files;
    }
    
    private int[] agafarColumna(Matriu m, int fila){
        
    int[] columna = new int[columnes];
    
                for (int j = 0; j < m.getFiles(); j++) {
                columna[j] = m.getMatriu()[j][fila];   //columna j perquè volem recórrer les columnes amb cada fila
                }
        return columna;
    }
    
    
//    private int[] agafarFila(int files){
//    
//        
//        
//        return fila;
//    }
    
    public void multiplicarMatriuX(Matriu m) throws InterruptedException{
        
        ArrayList<Thread> arrayTh = new ArrayList();
        Matriu resultat = new Matriu(files,m.getColumnes());
        
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < m.getColumnes(); j++) {
                
               
                Thread t = new Thread(new Resultat(matriu[i], agafarColumna(m,i), resultat, i, j));
                t.start();
                System.out.println("Thread afegit");
                arrayTh.add(t);
            }
            
        }
        
//        if(columnes == m.getFiles()){
//            for (int i = 0; i < columnes; i++) {//columnes primera
//                for (int j = 0; j < m.getFiles(); j++) {//files de segona matriu passada per paràmetres a main
//                    
//                    
//                    Resultat res = new Resultat(matriu[], agafarColumna(m,i), resultat, i, j);
//                    //
//                    
//                    Thread t = new Thread(res);
//                    t.start();
//                    System.out.println("Thread afegit");
//                    arrayTh.add(t);
//                }
//            }

        
        for (Thread thread : arrayTh) {
            thread.join();
        }
        System.out.println("aaaa");
        resultat.printMatriu();
        
    }
    
    public void printMatriu(){
    
        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {;
                System.out.print(matriu[i][j] + " " );
            }
            System.out.println("");
            
        }
    }
    
    private void farcirMatriu(){
        
        
        System.out.println("Fica el nombre màxim que vulguis");
        maxNum = Integer.parseInt(scan.next());

        for (int i = 0; i < files; i++) {
            for (int j = 0; j < columnes; j++) {
                
                matriu[i][j] = (int) Math.floor(Math.random()*(maxNum+1));
            }
        }
    }
    
    private int[][] crearMatriu(){
        
        System.out.println("Fica files");
        files = Integer.parseInt(scan.next());
        System.out.println("Fica columnes");
        columnes = Integer.parseInt(scan.next());
        this.matriu = new int[files][columnes];
        
        return matriu;
    }

}
