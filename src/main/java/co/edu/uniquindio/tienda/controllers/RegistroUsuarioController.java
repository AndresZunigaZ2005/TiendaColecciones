package co.edu.uniquindio.tienda.controllers;

import co.edu.uniquindio.tienda.controllerModel.ModelFactoryController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

public class RegistroUsuarioController {
    ModelFactoryController modelFactoryController;


    @FXML
    private Button btnCancelar;

    @FXML
    private Button btnRegistrar;

    @FXML
    private AnchorPane contenedorPrincipal;

    @FXML
    private Label lblDireccion;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblNumeroIdentificacion;

    @FXML
    private Label lblRegistroUsuario;

    @FXML
    private TextField txtFieldDireccion;

    @FXML
    private TextField txtFieldNombre;

    @FXML
    private TextField txtFieldNumeroIdentificacion;

    @FXML
    void RegistrarUsuario(MouseEvent event) {

    }

}
