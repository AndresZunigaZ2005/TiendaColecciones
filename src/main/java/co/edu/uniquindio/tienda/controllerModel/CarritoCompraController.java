package co.edu.uniquindio.tienda.controllerModel;

import co.edu.uniquindio.tienda.controllerModel.service.ICarritoCompraControllerService;

public class CarritoCompraController implements ICarritoCompraControllerService {
    ModelFactoryController modelFactoryController;
    public CarritoCompraController(){modelFactoryController = ModelFactoryController.getInstance();}
}
