package ucentral.edu.co.ProyectoSoftware2.controladores;

import ucentral.edu.co.ProyectoSoftware2.proc.Proc;
import ucentral.edu.co.ProyectoSoftware2.entidades.Producto;
import ucentral.edu.co.ProyectoSoftware2.servicios.Servicios;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Log4j2
@AllArgsConstructor
@RestController
@RequestMapping("/api/productos")
@CrossOrigin(origins = "${spring.webmvc.cors.allowed-origins}",
        methods = {RequestMethod.GET, RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})

public class Controladorproductoang {
    private static final Logger logger = LogManager.getLogger(Controladorproducto.class);


    private Servicios servicios;

    @GetMapping("/")
    public ResponseEntity<List<Proc>> listarEquipos(){

        return ResponseEntity.ok(servicios.obtenerProducto());
    }

    @GetMapping("/{serial}")
    public ResponseEntity<Proc> obtenerPorId(@PathVariable("serial") Long serial) {
        log.info( " Ïngresa serial "+ serial);
        return ResponseEntity.ok(servicios.obtenerProducto(serial));
    }


    @PostMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Proc> crear(@Validated @RequestBody Proc entityproc) {
        entityproc = servicios.registrar(entityproc);

        return new ResponseEntity<>(entityproc, HttpStatus.CREATED);
    }
    @PutMapping("/")
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Proc> modificar(@Validated @RequestBody Proc entityproc) {
        entityproc = servicios.actualizar(entityproc);

        return new ResponseEntity<>(entityproc, HttpStatus.CREATED);
    }

    @DeleteMapping("/{serial}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void borrado(@PathVariable("serial") Long serial) {

        servicios.eliminar(serial);
    }

}
