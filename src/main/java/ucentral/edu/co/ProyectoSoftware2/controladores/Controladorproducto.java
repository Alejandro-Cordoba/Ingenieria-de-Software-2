package ucentral.edu.co.ProyectoSoftware2.controladores;

import ucentral.edu.co.ProyectoSoftware2.proc.Proc;
import ucentral.edu.co.ProyectoSoftware2.servicios.Servicios;
import lombok.extern.log4j.Log4j2;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Log4j2
@Controller
public class Controladorproducto {
    private static final Logger logger = LogManager.getLogger(Controladorproducto.class);

    @Autowired
    Servicios servicioProducto;

    @GetMapping({  "/producto"})
    public String listarProducto(Model model){
        logger.info("Verificando ");
        model.addAttribute("producto",servicioProducto.obtenerProducto());
        return "producto";
    }
    @GetMapping("/producto/nuevo")
    public String mostrarFormulario(Model model){
        Proc Proc = new Proc();
        model.addAttribute("producto", Proc);
        return "crear_producto";
    }
    @PostMapping("/producto")
    public String registrarProducto(@ModelAttribute("producto") Proc producto) {
        servicioProducto.registrar(producto);
        return "redirect:/producto";
    }


    @GetMapping("/producto/modificar/{serial}")
    public String mostrarFormularioEditar(@PathVariable long serial, Model model){
        Proc Proc = new Proc();
        model.addAttribute("producto", servicioProducto.obtenerProducto(serial));
        return "editar_producto";
    }

    @PostMapping("/producto/{serial}")
    public String modificarProducto(@PathVariable long serial,@ModelAttribute( "producto") Proc Proc, Model model){


        model.addAttribute("producto", servicioProducto.actualizar(Proc));
        return "redirect:/producto";
    }
    @GetMapping("/producto/{serial}")
    public String eliminarProducto(@PathVariable long serial){

        servicioProducto.eliminar(serial);

        return "redirect:/producto";
    }
}
