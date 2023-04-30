
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.Date;
import aplicacion.Visitante;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class VisitantesDAO extends AbstractDAO{
    
    public VisitantesDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /**
    * Obtiene una lista de todos los visitantes.
    * 
    * @throws SQLException si hay un error al acceder a la base de datos
    * @return un ArrayList<Visitante> con todos los visitantes.
    */
    public ArrayList<Visitante> getVsitantes() throws SQLException {
        ArrayList<Visitante> resultado = new ArrayList<>();
        ResultSet rsVisitantes;
        PreparedStatement stmVisitantes = null;
        Connection con;
        con = super.getConexion();

        try {
            stmVisitantes = con.prepareStatement("SELECT * FROM Visitantes ORDER BY Nombre");
            rsVisitantes = stmVisitantes.executeQuery();
            Visitante visitante;
            while (rsVisitantes.next()) {
                visitante = new Visitante(rsVisitantes.getString("DNI"), rsVisitantes.getString("Nombre"), rsVisitantes.getDate("fechaNacimiento"), rsVisitantes.getInt("Edad"));
                resultado.add(visitante);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VisitantesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmVisitantes.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }

    /**
     * Obtiene una lista de todos los visitantes.
     *
     * @param usuario nombre del usuario
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return un ArrayList<Visitante> con todos los visitantes.
     */
    public ArrayList<Visitante> getEntradas(String usuario) throws SQLException{
        ArrayList<Visitante> resultado = new ArrayList<>();
        ResultSet rsVisitantes;
        PreparedStatement stmVisitantes = null;
        Connection con;
        con = super.getConexion();

        try {
            stmVisitantes = con.prepareStatement("SELECT * FROM Visitantes WHERE nombreUsuario=? ORDER BY Nombre");
            stmVisitantes.setString(1, usuario);
            rsVisitantes = stmVisitantes.executeQuery();
            Visitante visitante;
            while (rsVisitantes.next()) {
                visitante = new Visitante(rsVisitantes.getString("DNI"), rsVisitantes.getString("Nombre"), rsVisitantes.getDate("fechaNacimiento"), rsVisitantes.getInt("Edad"));
                resultado.add(visitante);
            }

        } catch (SQLException ex) {
            Logger.getLogger(VisitantesDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmVisitantes.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
        
    }

    /**
     * Obtiene una lista de todos los visitantes.
     *
     * @param dni asociado a la entrada.
     * @param nombre asociado a la entrada.
     * @param fechaNacimiento del visitante asociado a la entrada
     * @param nombreUsuario asociado a la entrada
     * @throws SQLException si hay un error al acceder a la base de datos
     * @return un ArrayList<Visitante> con todos los visitantes.
     */
    public void anhadirEntrada(String dni, String nombre, Date fechaNacimiento, String nombreUsuario) throws SQLException{
        Connection con;
        con = super.getConexion();

        PreparedStatement stmEntrada = null;
        try {
            stmEntrada = con.prepareStatement("INSERT INTO Visitantes (DNI,Nombre,fechaNacimiento, nombreUsuario) values(?,?,?,?)");
            stmEntrada.setString(1, dni);
            stmEntrada.setString(2, nombre);
            stmEntrada.setDate(3, fechaNacimiento);
            stmEntrada.setString(4, nombreUsuario);
            stmEntrada.executeUpdate();
            stmEntrada.close();
        } catch (SQLException ex) {
            Logger.getLogger(TrabajadorDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmEntrada.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }
    }

}
