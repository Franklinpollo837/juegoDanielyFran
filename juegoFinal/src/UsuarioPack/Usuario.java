/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package UsuarioPack;

/**
 *
 * @author danir
 */
public class Usuario {
    // creamos los atributos de los Usuarios
    public String Nombre;
    public int Nganadas;
// constructor
    public Usuario(String Nombre, int Nganadas) {
        this.Nombre = Nombre;
        this.Nganadas = Nganadas;
    }
// geters Y setters
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public int getNganadas() {
        return Nganadas;
    }

    public void setNganadas(int Nganadas) {
        this.Nganadas = Nganadas;
    }
// toString
    @Override
    public String toString() {
        return "Usuario{" + "Nombre=" + Nombre + ", Nganadas=" + Nganadas + '}';
    }
    
}
