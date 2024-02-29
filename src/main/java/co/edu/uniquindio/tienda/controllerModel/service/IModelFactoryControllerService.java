package co.edu.uniquindio.tienda.controllerModel.service;

import co.edu.uniquindio.tienda.model.Cliente;
import co.edu.uniquindio.tienda.model.Producto;
import co.edu.uniquindio.tienda.model.Venta;

import java.util.*;

public interface IModelFactoryControllerService {
    HashMap<String, Cliente> obtenerClientes();
    HashMap<String, Producto> obtenerProductos();
    List<Venta> obtenerVentas();
    HashSet<String> obtenerCarritoCompras();
    LinkedList<Venta> obtenerHistoricoVentas();
    TreeSet<Producto> obtenerInvetario();
    Boolean crearCliente(String numeroIdentificacion, String nombre, String direccion);
    Boolean editarCliente(String numeroIdentificacion, String nombre, String direccion);
    Boolean eliminarCliente(String numeroIdentificacion, String nombre, String direccion);
}
