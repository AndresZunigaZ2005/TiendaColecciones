package co.edu.uniquindio.tienda.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.ArrayList;

@Data
@NoArgsConstructor
@Builder
@AllArgsConstructor

public class Venta {

    private String codigo;
    private LocalDateTime fecha;
    private Double total;
    private ArrayList<DetalleVenta> lstDetalleVenta;
    private Cliente cliente;
}
