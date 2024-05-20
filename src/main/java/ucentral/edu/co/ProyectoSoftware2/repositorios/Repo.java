package ucentral.edu.co.ProyectoSoftware2.repositorios;


import ucentral.edu.co.ProyectoSoftware2.entidades.Producto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface Repo extends JpaRepository<Producto, Long>, JpaSpecificationExecutor<Producto> {

}
