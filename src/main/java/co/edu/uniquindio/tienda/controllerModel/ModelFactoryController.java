package co.edu.uniquindio.tienda.controllerModel;

import co.edu.uniquindio.tienda.controllerModel.service.IModelFactoryControllerService;
import co.edu.uniquindio.tienda.model.Cliente;
import co.edu.uniquindio.tienda.model.Producto;
import co.edu.uniquindio.tienda.model.Tienda;
import co.edu.uniquindio.tienda.model.Venta;

import java.util.*;

public class ModelFactoryController implements IModelFactoryControllerService {
    Tienda tienda;

    @Override
    public HashMap<String, Cliente> obtenerClientes() {
        return null;
    }

    @Override
    public HashMap<String, Producto> obtenerProductos() {
        return null;
    }

    @Override
    public List<Venta> obtenerVentas() {
        return null;
    }

    @Override
    public HashSet<String> obtenerCarritoCompras() {
        return null;
    }

    @Override
    public LinkedList<Venta> obtenerHistoricoVentas() {
        return null;
    }

    @Override
    public TreeSet<Producto> obtenerInvetario() {
        return null;
    }

    @Override
    public Boolean crearCliente(String numeroIdentificacion, String nombre, String direccion) {
        return null;
    }

    @Override
    public Boolean editarCliente(String numeroIdentificacion, String nombre, String direccion) {
        return null;
    }

    @Override
    public Boolean eliminarCliente(String numeroIdentificacion, String nombre, String direccion) {
        return null;
    }

    private static class SingletonHolder {
        private final static ModelFactoryController eINSTANCE = new ModelFactoryController();
    }
    public static ModelFactoryController getInstance() {
        return SingletonHolder.eINSTANCE;
    }
    private ModelFactoryController() {
        System.out.println("Invocación clase singleton");
    }
}
