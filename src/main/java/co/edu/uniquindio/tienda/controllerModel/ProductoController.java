package co.edu.uniquindio.tienda.controllerModel;

import co.edu.uniquindio.tienda.controllerModel.service.IProductoControllerService;

public class ProductoController implements IProductoControllerService {
    ModelFactoryController modelFactoryController;
    public ProductoController(){modelFactoryController = ModelFactoryController.getInstance();}
}
