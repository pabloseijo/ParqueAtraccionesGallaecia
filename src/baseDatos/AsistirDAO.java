
package baseDatos;

import java.sql.*;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import aplicacion.*;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class AsistirDAO extends AbstractDAO {

    public AsistirDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /**
     * Añade una entrada a un visitante
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public void comprarEntrada(Date fecha, Time hora, String dni, int espectaculo) {
        Connection con;

        con = super.getConexion();

        PreparedStatement stmAsistir = null;

        try {
            stmAsistir = con.prepareStatement("INSERT INTO Asistir (FechaVisita, horaVisita, Visitante, Espectaculo) VALUES (? ? ? ?)");
            stmAsistir.setDate(1, fecha);
            stmAsistir.setTime(2, hora);
            stmAsistir.setString(3, dni);
            stmAsistir.setInt(4, espectaculo);
            stmAsistir.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(AsistirDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmAsistir.close();
                } catch (SQLException e) {
                    System.out.println("Imposible cerrar cursores");
                }
        }
    }

    /**
     * Devuelve todas las entradas de los visitantes para los espectaculos
     *
     * @throws SQLException si hay un error al acceder a la base de datos
     */
    public ArrayList<Asistir> consultarAsistir() throws SQLException {
        ArrayList<Asistir> resultado = new ArrayList<>();
        Asistir asistirActual;
        Connection con;
        PreparedStatement stmAsistir = null;
        ResultSet rsAsistir;

        con = this.getConexion();

        try  {
            stmAsistir = con.prepareStatement("SELECT FechaVisita, fechaVisita, Visitante, Espectaculo FROM Asistir");
            rsAsistir = stmAsistir.executeQuery();
            while (rsAsistir.next())
            {
                asistirActual = new Asistir(rsAsistir.getDate("FechaVisita"), rsAsistir.getTime("horaVisita"), rsAsistir.getString("Visitante"), rsAsistir.getInt("Espectaculo"));
                resultado.add(asistirActual);
            }

        } catch (SQLException e){
            System.out.println(e.getMessage());
        } finally{
            try {stmAsistir.close();} catch (SQLException e){System.out.println("Imposible cerrar cursores");}
        }
        return resultado;
    }


}
