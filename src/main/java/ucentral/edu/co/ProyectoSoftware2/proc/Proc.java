package ucentral.edu.co.ProyectoSoftware2.proc;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;
@AllArgsConstructor
@NoArgsConstructor
@Data
@ToString
public class Proc implements Serializable{
    private long serial;
    @NotBlank(message = "El nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "La descripción es obligatoria")
    private String descripcion;
    @NotBlank(message = "La categoria es obligatoria")
    private String  categoria;
    @NotBlank(message = "El precio unitario del producto es obligatorio")
    private String  Precio_und;
    @NotBlank(message = "ELa cantidad del producto es obligatorio")
    private String  cantidad;
}
