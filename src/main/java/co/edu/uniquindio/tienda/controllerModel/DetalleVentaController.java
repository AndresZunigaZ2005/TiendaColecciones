package co.edu.uniquindio.tienda.controllerModel;

import co.edu.uniquindio.tienda.controllerModel.service.IDetalleVentaControllerService;

public class DetalleVentaController implements IDetalleVentaControllerService {
    ModelFactoryController modelFactoryController;
    public DetalleVentaController(){modelFactoryController = ModelFactoryController.getInstance();}
}
