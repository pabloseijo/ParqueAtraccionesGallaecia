/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import aplicacion.Hostelero;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class HostelerosDAO extends AbstractDAO{

    public HostelerosDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /**
    * Obtiene una lista de todos los hosteleros.
    * 
    * @throws SQLException si hay un error al acceder a la base de datos
    * @return un ArrayList<Hostelero> con todos los hosteleros.
    */
    public ArrayList<Hostelero> getHosteleros() throws SQLException {
        ArrayList<Hostelero> resultado = new ArrayList<>();
        ResultSet rsHosteleros;
        PreparedStatement stmHosteleros = null;
        Connection con;
        con = super.getConexion();

        try {
            stmHosteleros = con.prepareStatement("SELECT * FROM Hosteleros ORDER BY fechaContratacion");
            rsHosteleros = stmHosteleros.executeQuery();
            Hostelero hostelero;
            while (rsHosteleros.next()) {
                hostelero = new Hostelero(rsHosteleros.getString("DNI"), rsHosteleros.getString("Nombre"), rsHosteleros.getString("Direccion"), rsHosteleros.getFloat("Salario"), rsHosteleros.getString("Telefono"), rsHosteleros.getDate("fechaContratacion"), rsHosteleros.getDate("fechaNacimiento"), rsHosteleros.getString("Formacion"), rsHosteleros.getInt("Espectaculo"));
                resultado.add(hostelero);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HostelerosDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmHosteleros.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }
}