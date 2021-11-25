/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package matrises;

import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author bende
 */
public class Matrises{
    
    private static int maxNumb;//static perquè pugui arribar des de altres mètodes
    public static int files1;
    public static int columnes1;
    public static int files2;
    public static int columnes2;
    public static int [][] matriu1;
    public static int [][] matriu2;
    public static int [][] resultat;
    private static int nThreads = 5;
    public static GrupDeThreads [][] Threads = new GrupDeThreads[files1][columnes2];

    private static void imprimirMatrius() {
        
        System.out.println("-----------------");
        System.out.println("PRIMERA MATRIU");
        for (int i = 0; i < matriu1.length; i++) {
            for (int j = 0; j < matriu1[i].length; j++) {
                System.out.print(matriu1[i][j] + " ");
            }
            System.out.println();
        }
        //SEPARADOR
        System.out.println("-----------------");
        //SEPARADOR        
        System.out.println("SEGONA MATRIU");
                for (int i = 0; i < matriu2.length; i++) {
            for (int j = 0; j < matriu2[i].length; j++) {
                System.out.print(matriu2[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println("-----------------");
    }

    
    
    //métode per demanar mida màxima i tal
    private static void demanarValorsPrimera(){

        Scanner scan = new Scanner(System.in);
        System.out.println("De quantes files vols fer les matrius? Inserta un nombre");
        files1 = scan.nextInt();
        System.out.println("De quantes columnes vols fer les matrius? Inserta un nombre");
        columnes1 = scan.nextInt();
        System.out.println("Quin és el nombre màxim que es podrà trobar?");
        maxNumb = scan.nextInt();

    }
    private static void demanarValorsSegona(){

        Scanner scan = new Scanner(System.in);
        System.out.println("RECORDA QUE LA SEGONA MATRIU HA DE TENIR LES MATEIXES COLUMNES QUE FILES TÉ LA PRIMERA");
        System.out.println("De quantes files vols fer les matrius? Inserta un nombre");
        files2 = scan.nextInt();
        System.out.println("De quantes columnes vols fer les matrius? Inserta un nombre");
        columnes2 = scan.nextInt();
        System.out.println("Quin és el nombre màxim que es podrà trobar?");
        maxNumb = scan.nextInt();
        if(columnes2 == files1){
            System.out.println("No funcionarà");
        }else{
            System.out.println("Ben fet");}

    }
    
    //método per generar matrius amb files i columnes demanades
    private static int [][] generarPrimeraMatriu(){
        
        demanarValorsPrimera();
    
        //Array per guardar els valors:
        int[][] array = new int[files1][columnes1];
        
        //Feim random nums per guardar dins l'array
        Random ran = new Random();
        
        //I omplim l'array
        for (int i = 0; i < files1; i++) {
            for (int j = 0; j < columnes1; j++) {

                array[i][j] = ran.nextInt(maxNumb);
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        matriu1 = array;
        return array;
 
    }
    private static int [][] generarSegonaMatriu(){
    
        demanarValorsSegona();
        
        //Array per guardar els valors:
        int[][] array = new int[files2][columnes2];
        
        //Feim random nums per guardar dins l'array
        Random ran = new Random();
        
        //I omplim l'array
        for (int i = 0; i < files2; i++) {
            for (int j = 0; j < columnes2; j++) {

                array[i][j] = ran.nextInt(maxNumb);
            }
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.print(array[i][j] + " ");
            }
            System.out.println();
        }
        matriu2 = array;
        return array;
 
    }
    
        public static void activarThreads(){
        
        for(int i = 0; i < columnes2; i++){
            for(int j = 0; j < files1; j++){
                Threads[i][j] = new GrupDeThreads(matriu1, matriu2, resultat);
                Threads[i][j].start();
            }
        }showThread();
    }
        public static void showThread(){
            
            for (int i = 0; i < columnes2; i++) {
                for (int j = 0; j < files1; j++) {
                    System.out.println("[" + i + "," + j + "] = " + resultat[i][j]);
                }
            }
        }
        public void run (){
        activarThreads();
        }

    
    
    

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        generarPrimeraMatriu();
        generarSegonaMatriu();
        imprimirMatrius();
        activarThreads();
        
    }
    
}
