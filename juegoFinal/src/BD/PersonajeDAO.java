/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package BD;

/**
 *
 * @author frank
 */
import modelo.Personaje;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import modelo.Personaje;

public class PersonajeDAO {

    public void guardarPersonaje(Personaje p) {
        String sql = "INSERT INTO personajes(nombre, raza, vida, energia, fuerza) VALUES (?, ?, ?, ?, ?)";

        try (Connection conn = ConexionBD.conectar();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, p.getNombre());
            stmt.setString(2, p.getTipoRaza());
            stmt.setDouble(3, p.getVida());
           stmt.setDouble(4, p.getArma().getDano());
            stmt.setDouble(5, p.getFuerza());

            stmt.executeUpdate();
            System.out.println("✅ Personaje guardado en la base de datos");

        } catch (SQLException e) {
            System.out.println("❌ Error al guardar el personaje");
            e.printStackTrace();
        }
    }
}