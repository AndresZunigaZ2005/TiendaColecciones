package co.edu.uniquindio.tienda.controllerModel;

import co.edu.uniquindio.tienda.controllerModel.service.IVentaControllerService;

public class VentaController implements IVentaControllerService {
    ModelFactoryController modelFactoryController;
    public VentaController(){modelFactoryController = ModelFactoryController.getInstance();}
}
