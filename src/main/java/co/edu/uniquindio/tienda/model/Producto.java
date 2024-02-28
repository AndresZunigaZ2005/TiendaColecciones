package co.edu.uniquindio.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class Producto {
    private String codigo;
    private String nombre;
    private Double precio;
    private Integer cantidad;



}
