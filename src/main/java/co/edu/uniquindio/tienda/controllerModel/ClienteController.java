package co.edu.uniquindio.tienda.controllerModel;

import co.edu.uniquindio.tienda.controllerModel.service.IClienteControllerService;
import co.edu.uniquindio.tienda.model.Cliente;

public class ClienteController implements IClienteControllerService {
    ModelFactoryController modelFactoryController;
    public ClienteController(){modelFactoryController = ModelFactoryController.getInstance();}

    @Override
    public Boolean crearCliente(String numeroIdentificacion, String nombre, String direccion) {
        return modelFactoryController.crearCliente(numeroIdentificacion, nombre, direccion);
    }

    @Override
    public Boolean editarCliente(String numeroIdentificacion, String nombre, String direccion) {
        return modelFactoryController.crearCliente(numeroIdentificacion, nombre, direccion);
    }

    @Override
    public Boolean eliminarCliente(String numeroIdentificacion, String nombre, String direccion) {
        return modelFactoryController.crearCliente(numeroIdentificacion, nombre, direccion);
    }
}
