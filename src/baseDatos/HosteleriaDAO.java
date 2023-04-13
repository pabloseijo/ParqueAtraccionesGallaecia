package baseDatos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
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
}
