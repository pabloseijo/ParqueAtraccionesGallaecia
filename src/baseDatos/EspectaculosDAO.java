
package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import aplicacion.Espectaculo;
import aplicacion.Asistir;
import aplicacion.TrabajadorEspectaculo;
/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */

public class EspectaculosDAO extends AbstractDAO{

    public EspectaculosDAO (Connection conexion, aplicacion.FachadaAplicacion fa) {
        super.setConexion(conexion);
        super.setFachadaAplicacion(fa);
    }
    
}