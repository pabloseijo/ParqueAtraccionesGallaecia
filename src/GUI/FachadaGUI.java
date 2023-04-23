package GUI;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */

public class FachadaGUI {
    aplicacion.FachadaAplicacion fachadaAplicacion;
    baseDatos.FachadaBaseDatos fachadaBaseDatos;

    public FachadaGUI(aplicacion.FachadaAplicacion fachadaAplicacion, baseDatos.FachadaBaseDatos fachadaBaseDatos){
        this.fachadaAplicacion = fachadaAplicacion;
        this.fachadaBaseDatos = fachadaBaseDatos;
    }


    // Esto hace que se inicie la ventana de autentifcacion
    public void iniciaVista(){
        LoginGUI vAutentificacion;

        // Iniciar login y ventana inicial

        vAutentificacion = new LoginGUI(null, fachadaAplicacion, fachadaBaseDatos);
    }

}

