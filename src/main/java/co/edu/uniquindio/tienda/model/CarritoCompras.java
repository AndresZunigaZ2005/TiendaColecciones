package co.edu.uniquindio.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class CarritoCompras {
    private String codigo;
    private Cliente cliente;

}
