package aplicacion;


import baseDatos.FachadaBaseDatos;

/**
 *
 * @author Manuel Estevez, Miguel Leal, Pablo Lobato y Pablo Seijo
 */
public class FachadaAplicacion {

    GUI.FachadaGUI fachadaGui;
    baseDatos.FachadaBaseDatos fachadaBd;


    public FachadaAplicacion()  {
        // Inicializamos las fachadas de la bd y gui
        fachadaBd = new baseDatos.FachadaBaseDatos(this);
        fachadaGui = new GUI.FachadaGUI(this, this.fachadaBd);
    }
    


    public static void main(String[] args) {
        FachadaAplicacion fachadaAplicacion;
     
        // Inicializamos las fachas
        fachadaAplicacion = new FachadaAplicacion();
        // Lanzamos la primera ventana
        fachadaAplicacion.iniciaInterfazUsuario();
    }

    public FachadaBaseDatos getFachadaBD() {
        return this.fachadaBd;
    }

    public void iniciaInterfazUsuario() {
        fachadaGui.iniciaVista();
    }

    public Usuario comprobarAutentificacion(String nombreUsuario, String clave) {
        return fachadaBd.validarUsuario(nombreUsuario, clave);
      }

    

}
