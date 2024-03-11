package co.edu.uniquindio.tienda.controllers;

import co.edu.uniquindio.tienda.controllerModel.ModelFactoryController;
import co.edu.uniquindio.tienda.exceptions.ObtenerClienteException;
import co.edu.uniquindio.tienda.model.Tienda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class ValidarClienteController {

    ModelFactoryController modelFactoryController;


    @FXML
    private  Button btnAdministrador;

    @FXML
    private Button btnRegistrarCliente;

    @FXML
    private Button btnValidar;

    @FXML
    private Label lblNoEstaRegistrado;

    @FXML
    private Label lblNumeroIdentificacion;

    @FXML
    private Label lblValidarCliente;

    @FXML
    private TextField txtFieldNumeroIdentificacion;

    private Tienda tienda = Tienda.getInstance();

    @FXML
    void AbrirPanelRegistroCliente(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventanas/registroUsuario.fxml"));
        Parent root = loader.load();

        // Crear una nueva escena
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Nueva Ventana");

        // Mostrar la nueva ventana
        stage.show();

        // Cerrar la ventana actual
        Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ventanaActual.close();
    }

    @FXML
    void ValidarCliente(ActionEvent event) throws IOException {
        //TODO terminar conexión ventana, tiene que llevar a comprar productos
        try {
            if(tienda.obtenerCliente(txtFieldNumeroIdentificacion.getText())!=null){
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventanas/listaProductos.fxml"));
                Parent root = loader.load();

                // Crear una nueva escena
                Scene scene = new Scene(root);
                Stage stage = new Stage();
                stage.setScene(scene);
                stage.setTitle("Lista De Productos");

                // Mostrar la nueva ventana
                stage.show();

                // Cerrar la ventana actual
                Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
                ventanaActual.close();
            }
        } catch (ObtenerClienteException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void validarAdministrador(ActionEvent event) throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventanas/ventanaInventario.fxml"));
        Parent root = loader.load();

        // Crear una nueva escena
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Ventana inventario");

        // Mostrar la nueva ventana
        stage.show();

        // Cerrar la ventana actual
        Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ventanaActual.close();
    }
}

