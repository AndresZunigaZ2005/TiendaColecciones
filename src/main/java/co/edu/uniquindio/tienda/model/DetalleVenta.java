package co.edu.uniquindio.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor
public class DetalleVenta {

    private Producto producto;
    private Integer cantidad;
    private Integer subTotal;
}
