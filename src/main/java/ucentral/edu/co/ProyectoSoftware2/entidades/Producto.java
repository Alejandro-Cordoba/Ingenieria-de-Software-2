package ucentral.edu.co.ProyectoSoftware2.entidades;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "Producto")
@Table(name = "PRODUCTOS")
@Builder
public class Producto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_PRODUCTOS")
    @SequenceGenerator(name = "SEQ_PRODUCTOS", sequenceName = "SEQ_PRODUCTOS", allocationSize = 1)
    @Column(name = "PRO_CODIGO", nullable = false)
    private long serial;

    @Column(name = "PRO_NOMBRE", nullable = false)
    private String nombre;

    @Column(name = "PRO_DESCRIPCION", nullable = false)
    private String descripcion;

    @Column(name = "PRO_CATEGORIA", nullable = false)
    private String categoria;

    @Column(name = "PRO_PRECIO_UND", nullable = false)
    private float precio_und;

    @Column(name = "PRO_CANTIDAD", nullable = false)
    private float cantidad;

    @ManyToMany(mappedBy = "productos")
    private Set<Venta> ventas = new HashSet<>();
}
