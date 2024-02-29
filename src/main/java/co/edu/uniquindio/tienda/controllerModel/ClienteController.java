package co.edu.uniquindio.tienda.controllerModel;

import co.edu.uniquindio.tienda.controllerModel.service.IClienteControllerService;

public class ClienteController implements IClienteControllerService {
    ModelFactoryController modelFactoryController;
    public ClienteController(){modelFactoryController = ModelFactoryController.getInstance();}
}
