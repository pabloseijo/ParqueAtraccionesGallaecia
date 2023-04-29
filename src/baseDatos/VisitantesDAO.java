
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
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
                visitante = new Visitante(rsVisitantes.getString("DNI"), rsVisitantes.getString("Nombre"), rsVisitantes.getString("Email"), rsVisitantes.getDate("fechaNacimiento"), rsVisitantes.getInt("Altura"), rsVisitantes.getInt("Edad"));
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
                visitante = new Visitante(rsVisitantes.getString("DNI"), rsVisitantes.getString("Nombre"), rsVisitantes.getString("Email"), rsVisitantes.getDate("fechaNacimiento"), rsVisitantes.getInt("Altura"), rsVisitantes.getInt("Edad"));
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

}