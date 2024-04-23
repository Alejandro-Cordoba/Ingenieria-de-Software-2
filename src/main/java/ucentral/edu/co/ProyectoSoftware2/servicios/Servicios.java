package ucentral.edu.co.ProyectoSoftware2.servicios;

import ucentral.edu.co.ProyectoSoftware2.entidades.Producto;
import ucentral.edu.co.ProyectoSoftware2.proc.Proc;
import ucentral.edu.co.ProyectoSoftware2.exepciones.ResourceNotFoundException;
import ucentral.edu.co.ProyectoSoftware2.repositorios.Repo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import java.io.Serializable;
import java.util.List;

@AllArgsConstructor
@Service
public class Servicios implements Serializable {


    private ModelMapper modelMapper;

    private final Repo repoproduc ;

    public Proc registrar(Proc Proc) {

        Producto elProducto = repoproduc.save(modelMapper.map(Proc, Producto.class));
            return modelMapper.map(elProducto, Proc.class);
    }
    public List<Proc> obtenerProducto() {
        TypeToken<List<Proc>> typeToken = new TypeToken<>() {};
        return modelMapper.map(repoproduc.findAll(), typeToken.getType());

    }
    public Proc obtenerProducto(long serial) {
        Producto producto = repoproduc.findById(serial).orElseThrow(
                ResourceNotFoundException::new);

        return modelMapper.map(producto, Proc.class);

    }
    public Proc actualizar(Proc Proc) {
        repoproduc.save(modelMapper.map(Proc, Producto.class));
        return Proc;

    }
    public void eliminar(long serial) {

        repoproduc.deleteById(serial);


    }
}
