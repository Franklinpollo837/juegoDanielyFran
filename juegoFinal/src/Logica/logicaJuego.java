/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package Logica;
import Armas.Escopeta ;
import Armas.Rifle;
import Personajes.Humanos;
/**
 *
 * @author frank
 */
// Vamos a dar inicio del proyecto 
public class logicaJuego {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Escopeta escopeton = new Escopeta();
        escopeton.calcularDanio();
        System.out.println(escopeton.calcularDanio());
        System.out.println(escopeton.getNombreArma());
        Rifle riflin = new Rifle();
        System.out.println(riflin.calcularDanio());
        System.out.println(riflin.getNombreArma());
        
        Humanos novia = new Humanos("abril", riflin);
        Humanos novia1 = new Humanos("Daniel", riflin);
   
        novia.atacar(novia1);
        
        
        
        // TODO code application logic here
       
    }
   
}
