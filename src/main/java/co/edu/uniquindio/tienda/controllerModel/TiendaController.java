package co.edu.uniquindio.tienda.controllerModel;

import co.edu.uniquindio.tienda.controllerModel.service.ITiendaControllerService;

public class TiendaController implements ITiendaControllerService {
    ModelFactoryController modelFactoryController;
    public TiendaController(){modelFactoryController = ModelFactoryController.getInstance();}
}
