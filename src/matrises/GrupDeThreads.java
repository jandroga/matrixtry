/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package matrises;

/**
 *
 * @author bende
 */
public class GrupDeThreads implements Runnable {
        
    private int files2;
    private int files1;
    private int columnes1;
    private int columnes2;
    private int [][] B;
    private int [][] C;
    private int [][] A;
    private int row;
    private int col;
    
    public GrupDeThreads(int[][] A, int[][] B, int [][] C){
        
        Matrises m = new Matrises();
        
        A = Matrises.matriu1;
        B = Matrises.matriu2;
        C = Matrises.resultat;
        this.A = A;
        this.B = B;
        this.C = C;
        
        columnes1 = Matrises.columnes1;
        columnes2 = Matrises.columnes2;
        files1 = Matrises.files1;
        files2 = Matrises.files2;
        
    }
    

    
    public void run(){

    
        C[columnes2][files1] = (A[row][0] * B[0][col])+ (A[row][1]*B[1][col]) ;
        
    }
}
