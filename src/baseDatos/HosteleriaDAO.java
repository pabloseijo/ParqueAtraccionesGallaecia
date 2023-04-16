package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.ArrayList;
import aplicacion.Hosteleria;


/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class HosteleriaDAO extends AbstractDAO{

    public HosteleriaDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }

    /**
    * Obtiene una lista de todos los establecimientos.
    * 
    * @throws SQLException si hay un error al acceder a la base de datos
    * @return un ArrayList<Hosteleria> con todos los establecimientos.
    */
    public ArrayList<Hosteleria> getEstablecimientos() throws SQLException {
        ArrayList<Hosteleria> resultado = new ArrayList<>();
        ResultSet rsHosteleria;
        PreparedStatement stmHosteleria = null;
        Connection con;
        con = super.getConexion();

        try {
            stmHosteleria = con.prepareStatement("SELECT * FROM Hosteleria ORDER BY Nombre");
            rsHosteleria = stmHosteleria.executeQuery();
            Hosteleria establecimiento;
            while (rsHosteleria.next()) {
                establecimiento = new Hosteleria(rsHosteleria.getInt("codigoRegistro"), rsHosteleria.getString("Nombre"), rsHosteleria.getInt("Aforo"), rsHosteleria.getString("Ubicaciones"), rsHosteleria.getTime("HoraApertura"), rsHosteleria.getTime("HoraCierre"), rsHosteleria.getFloat("Recaudacion"));
                resultado.add(establecimiento);
            }

        } catch (SQLException ex) {
            Logger.getLogger(HosteleriaDAO.class.getName()).log(Level.SEVERE, null, ex);
        } finally {
            try {
                stmHosteleria.close();
            } catch (SQLException e) {
                System.out.println("Imposible cerrar cursores");
            }
        }

        return resultado;
    }
}
