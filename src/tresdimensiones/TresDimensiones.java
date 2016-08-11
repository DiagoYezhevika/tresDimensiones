/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tresdimensiones;
import java.util.*;
/**
 *
 * @author LENOVO
 */
public class TresDimensiones {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        String cultivo[] = {"Arroz","Maiz","Trigo"};
        String anio[] = {"2012","2013","2014","2015"};
        String ciudad[] = {"Cucuta","Medellin","Cali"};
        byte datos[][][] = new byte[3][3][4];
        
        System.out.println("Total Fondo : " + datos.length);
        System.out.println("Total Filas : " + datos[0].length);
        System.out.println("Total Columnas : " + datos[0][0].length);
        datos = llenar_vector_random(datos);
        mostrarDatos(datos,ciudad,cultivo,anio);
        
        System.out.println("\nTotal Produccion Maiz Medellin : " + totalProduccion(datos));
        System.out.println("Total Produccion Colombia 2014 : " + totalProduccionColombia(datos));
        System.out.println("Año De Mayor Produccion : " + anio[mayorProduccion(datos)]);
        System.out.println("Promedio De Produccion Por Año De Trigo : " + promedioProduccion(datos));
        
        
    }
    
    public static byte[][][] llenar_vector_random(byte[][][] datos) {
        byte i = 0, j = 0, k = 0;
        Random rnd = new Random();
        for (i = 0; i < datos.length; i++) {
            for (j = 0; j < datos[i].length; j++){
                for (k = 0; k < datos[i][j].length; k++) {
                    datos[i][j][k] = randomByte();
                }
            }
        }
        return datos;
    }
    
    public static byte randomByte() {
        byte i = 0;
        Random rnd = new Random();
        do{
            i = (byte) rnd.nextInt(100);
        }
        while(i<20);
        
        return i;
    }
    
    public static void mostrarDatos (byte[][][] datos,String[] ciudad,String[] cultivo, String[] anio) {
        byte i=0,j=0,k=0,c=0;
        for (i = 0; i < datos.length; i++) {
            System.out.println(ciudad[i]);
            for(byte a=0; a < datos[0][0].length;a++){
                System.out.print(anio[a] + "\t");
                if ( a == datos[0][0].length - 1){
                    System.out.print("\n");
                }
            }
            for (j = 0; j < datos[i].length; j++){
                for (k = 0; k < datos[i][j].length; k++) {
                    System.out.print(datos[i][j][k] + "\t");
                    //System.out.print(c + "\t");
                    c++;
                    if (c == (datos[i][j].length)){
                        System.out.print(cultivo[j] + "\t");
                        System.out.print("\n");
                        c = 0;
                    }
                }
            }
        }
    }    
    
    public static int totalProduccion (byte [][][] datos) {
        int total = 0;
        for(byte i = 0; i<datos[1][1].length;i++){
            total = total + datos[1][1][i];
        }
        return total;
    }
    
    public static int totalProduccionColombia (byte [][][] datos) {
        int total = 0;
        for(byte i = 0; i<datos.length;i++){
            for (byte j = 0; j<datos[0].length;j++){
                total = total + datos[i][j][2];
            }
        }
        return total;
    }
    
    public static int mayorProduccion (byte [][][] datos) {
       int total = 0, mayor = 0;
       byte anio=0;
        for(byte k = 0; k<datos[0][0].length;k++){
            for(byte i = 0; i<datos.length;i++){
                for (byte j = 0; j<datos[0].length;j++){
                    total = total + datos[i][j][k];
                }
            }
            if(total > mayor){
                anio = k;
                mayor = total;
            }
            total=0;
        }
        
        return anio;
    }
    
    public static float promedioProduccion (byte [][][] datos) {
        float total = 0;
        for(byte i = 0; i<datos[1][2].length;i++){
            total = total + datos[1][2][i];
        }
        return total;
    }
    
}
