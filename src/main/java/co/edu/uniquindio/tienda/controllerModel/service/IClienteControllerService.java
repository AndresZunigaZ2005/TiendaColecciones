package co.edu.uniquindio.tienda.controllerModel.service;

import co.edu.uniquindio.tienda.model.Cliente;

public interface IClienteControllerService {
    Boolean crearCliente(String numeroIdentificacion, String nombre, String direccion);
    Boolean editarCliente(String numeroIdentificacion, String nombre, String direccion);
    Boolean eliminarCliente(String numeroIdentificacion, String nombre, String direccion);
}
