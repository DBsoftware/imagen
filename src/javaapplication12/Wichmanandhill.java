/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication12;

/**
 *
 * @author blueashym
 */
public class Wichmanandhill {
        public double[] generar(int parada,int valx,int valy,int valz) {     
        int n=0;
        double [] x =new double[parada];
        double [] y =new double[parada];
        double [] z =new double[parada];
        double [] u =new double[parada];
        x[0]=valx;
        y[0]=valy;
        z[0]=valz;
        double aux=0;
        while(n<parada-1){
            x[n+1]=(171*x[n])%30269;
            y[n+1]=(172*y[n])%30307;
            z[n+1]=(170*z[n])%30323;
            aux=(x[n+1]/30269)+(y[n+1]/30307)+(z[n+1]/30323);
            u[n]=aux-(int)aux;
            n++;
        }
        return u;
    } 
}
