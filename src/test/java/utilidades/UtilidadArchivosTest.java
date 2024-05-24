package utilidades;
import ucentral.edu.co.ProyectoSoftware2.entidades.Producto;
import ucentral.edu.co.ProyectoSoftware2.ut.Producto;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class UtilidadArchivosTest {


    @Test
    @DisplayName("Test registrar objeto en archivo")
    void registrarObjeto() {
        Produto producto = new Producto(1L,"millos","Equipo de la capital Bogotá");
        boolean rta = UtilidadArchivos.guardar("prueba.txt", producto);
        Assertions.assertTrue(rta);
    }
    @Test
    @DisplayName("Test registrar objeto en archivo")
    void leerObjeto() {
        Equipo equipo = new Equipo(1L,"millos","Equipo de la capital Bogotá");
        UtilidadArchivos.guardar("prueba.txt", equipo);
        Equipo elequipo = (Equipo)UtilidadArchivos.obtener ("prueba.txt");
        System.out.println(elequipo);
        Assertions.assertNotNull(elequipo);
    }

}