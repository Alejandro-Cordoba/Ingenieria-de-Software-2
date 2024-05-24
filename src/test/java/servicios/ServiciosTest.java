package servicios;


import ucentral.edu.co.ProyectoSoftware2.entidades.Producto;
import ucentral.edu.co.ProyectoSoftware2.repositorios.Repo;
import ucentral.edu.co.ProyectoSoftware2.servicios.Servicios;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.BDDMockito.given;
import static org.assertj.core.api.Assertions.assertThat;


@ExtendWith(MockitoExtension.class)
class ServiciosTest {
    private Producto producto;


    @InjectMocks
    ServiciosTest serviciosproducto;
    @Mock
    Repo repositorioproducto;

    @BeforeEach
    void setup(){

        producto = Producto
                .builder()
                .serial(1)
                .nombre("espejo".toUpperCase())
                .descripcion("accesorio para ver ")
                .categoria("accesorio")
                .precio_und(30000)
                .cantidad(2)
                .build();
        repositorioproducto.save(producto);
    }
    @DisplayName("Test de Registrar Producto")
    @Test
    void testRegistrarProducto(){

        given(repositorioproducto.save(producto)).willReturn(producto);

        Producto productoG = serviciosproducto.registrar(producto);

        assertThat(productoG).isNotNull();
    }

    @DisplayName("Test listado de carros ")
    @Test
    void testListar() {
        //given ()


        Carro carro1 = Carro
                .builder()
                .codigo(2)
                .placa("sdsd")
                .modelo(1254)
                .propietario(propietario)
                .build();

        given(repositorioCarro.findAll()).willReturn(List.of(carro, carro1));
        //when ()
        List<Carro> carros = serviciosCarro.consultarT();

        // then
        assertThat(carros).isNotNull();
        assertThat(carros.size()).isEqualTo(2);
    }
    @DisplayName("Test listado de carros vacio")
    @Test
    void testListarVacio() {
        //given ()
        given(repositorioCarro.findAll()).willReturn(Collections.emptyList());
        //when ()
        List<Carro> carros = serviciosCarro.consultarT();

        // then
        assertThat(carros).isEmpty();
        assertThat(carros.size()).isZero();
    }
    @DisplayName("Test listado de carros vacio")
    @Test
    void testObtenerId() {
        //given ()
        given(repositorioCarro.findById(1)).willReturn(Optional.of(carro));

        //when ()
        Carro carroG = serviciosCarro.consultarPK(carro.getCodigo());

        // then
        assertThat(carroG).isNotNull();

    }
    @DisplayName("Test Actualizar carro")
    @Test
    void testActualizar() {
        //given ()
        given(repositorioCarro.findById(1)).willReturn(Optional.of(carro));
        given(repositorioCarro.save(carro)).willReturn(carro);
        carro.setPlaca("abc123".toUpperCase());
        carro.setModelo(2013);

        //when ()
        Carro carroG = serviciosCarro.actualizar(carro);

        // then
        assertThat(carroG.getModelo()).isEqualTo(2013);
        //assertThat(carroG.getPlaca()).isEqualTo("abc123".toUpperCase());


    }

    private Producto createProducto() {


        Producto producto = Producto
                .builder()
                .serial(1)
                .nombre("farol".toUpperCase())
                .descripcion("accesorio para ver ")
                .categoria("accesorio")
                .precio_und(50000)
                .cantidad(2)
                .build();
        return producto;
    }

}