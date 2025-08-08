/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Logica;
import Armas.* ;
import Personajes.*;
import java.util.Scanner;
/**
 *
 * @author danir
 */
//clase para crear a los personajes
public class SelecionPersonaje {
    Scanner sc = new Scanner(System.in);
    public Personaje seleccionar(String nombreJugador) {
        int opcionPersonaje;
        while (true) {
            System.out.println("Que " + nombreJugador + " escoja a su personaje\n");
            System.out.println("1 = Humano");
            System.out.println("2 = Orco");
            System.out.println("3 = Elfo");
            System.out.println("4 = Bestia");

            
               while (true) {
          
            if (sc.hasNextInt()) { // Verifica si lo ingresado es un entero
                opcionPersonaje = sc.nextInt();
                sc.nextLine();
                break; 
            } else {
                System.out.println("ingrese un numero valido");
                sc.nextLine();
            }
        }

            switch (opcionPersonaje) {
                case 1 -> { return crearHumano(); }
                case 2 -> { return crearOrco(); }
                case 3 -> { return crearElfo(); }
                case 4 -> { return crearBestia(); }
                default -> System.out.println("Opción inválida. Intenta de nuevo\n");
            }
        }
    }
    
     private Humanos crearHumano() {
           System.out.println("Ingrese el nombre del Humano:");
    String nombre = sc.nextLine();
    int opcionArma;
    while (true) {
        System.out.println("Escoge un arma para que " + nombre + " se defienda:\n");
        System.out.println("1 = Escopeta");
        System.out.println("2 = Rifle");

        
              while (true) {
          
            if (sc.hasNextInt()) { // Verifica si lo ingresado es un entero
                opcionArma = sc.nextInt();
                sc.nextLine();
                break; 
            } else {
                System.out.println("ingrese un numero valido");
                sc.nextLine();
            }
        }

        switch (opcionArma) {
            case 1 -> {
                Escopeta escopeta = new Escopeta();
                System.out.println("Humano con Escopeta creado correctamente");
                return new Humanos(nombre, escopeta);
                   }

            case 2 -> {
                Rifle rifle = new Rifle();
                System.out.println("Humano con Rifle creado correctamente");
                return new Humanos(nombre, rifle);
                   }

            default -> System.out.println("Opción inválida. Intenta de nuevo.\n");
        }
    }
    }
    public Orco crearOrco() {
        
    System.out.println("Ingrese el nombre del Orco:");
    String nombre = sc.nextLine();
    int opcionArma;
    while (true) {
        System.out.println("Escoge un arma para que " + nombre + " se defienda:\n");
        System.out.println("1 = Hacha");
        System.out.println("2 = Martillo");

                   while (true) {
          
            if (sc.hasNextInt()) { // Verifica si lo ingresado es un entero
                opcionArma = sc.nextInt();
                sc.nextLine();
                break; 
            } else {
                System.out.println("ingrese un numero valido");
                sc.nextLine();
            }
        }

        switch (opcionArma) {
            case 1 -> {
                Hacha Hacha = new Hacha();
                System.out.println("Orco con Hacha creado correctamente");
                return new Orco(nombre, Hacha);
            }

            case 2 -> {
                Martillo Martillo = new Martillo();
                System.out.println("Orco con Martillo creado correctamente");
                return new Orco(nombre, Martillo);
            }

            default -> System.out.println("Opción inválida. Intenta de nuevo.\n");
        }
    }
        
    }
    
    public Elfo crearElfo(){
        
           System.out.println("Ingrese el nombre del Elfo:");
    String nombre = sc.nextLine();
    int opcionArma;
    while (true) {
        System.out.println("Escoge un arma para que " + nombre + " se defienda:\n");
        System.out.println("1 = Baculo de Agua");
        System.out.println("2 = Baculo de Fuego");
        System.out.println("3 = Baculo de Aire");
        System.out.println("4 = Baculo de Tierra");

                   while (true) {
          
            if (sc.hasNextInt()) { // Verifica si lo ingresado es un entero
                opcionArma = sc.nextInt();
                sc.nextLine();
                break; 
            } else {
                System.out.println("ingrese un numero valido");
                sc.nextLine();
            }
        }

        switch (opcionArma) {
            case 1 -> {
                BaculoAgua BaculoAgua = new BaculoAgua();
                System.out.println("Elfo con Baculo de Agua creado correctamente");
                return new Elfo(nombre, BaculoAgua,"Agua");
                   }

            case 2 -> {
                BaculoFuego BaculoFuego = new BaculoFuego();
                System.out.println("Elfo con Baculo de Fuego creado correctamente");
                return new Elfo(nombre, BaculoFuego,"Fuego");
                   }
            case 3 -> {
                BaculoAire BaculoAire = new BaculoAire();
                System.out.println("Elfo con Baculo de Aire creado correctamente");
                return new Elfo(nombre, BaculoAire, "Aire");
            }
            case 4 ->{
                BaculoTierra BaculoTierra = new BaculoTierra();
                System.out.println("Elfo con Baculo de Tierra creado correctamente");
                return new Elfo(nombre, BaculoTierra, "Tierra");
            }
            

            default -> System.out.println("Opción inválida. Intenta de nuevo.\n");
        }
    }
        
    }
    
    public Bestia crearBestia(){
        int opcionArma;
                   System.out.println("Ingrese el nombre de la Bestia:");
    String nombre = sc.nextLine();

    while (true) {
        System.out.println("Escoge un arma para que " + nombre + " se defienda:\n");
        System.out.println("1 = Puños");
        System.out.println("2 = Espada");

                   while (true) {
          
            if (sc.hasNextInt()) { // Verifica si lo ingresado es un entero
                opcionArma = sc.nextInt();
                sc.nextLine();
                break; 
            } else {
                System.out.println("ingrese un numero valido");
                sc.nextLine();
            }
        }

        switch (opcionArma) {
            case 1 ->      {
                Puños Puños = new Puños();
                System.out.println("Bestia con Puños creado correctamente");
                return new Bestia(nombre, Puños);
                           }

            case 2 ->      {
                Espada Espada = new Espada();
                System.out.println("Bestia con Espada creado correctamente");
                return new Bestia(nombre, Espada);
                           }

            default -> System.out.println("Opción inválida. Intenta de nuevo.\n");
        }
    }
        
    }
}
