package co.edu.uniquindio.tienda.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaActualizarProductoController {

    @FXML
    private Button btnGuardar;

    @FXML
    private Button btnRegresar;

    @FXML
    private Label lblActualizarProducto;

    @FXML
    private Label lblCantidad;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblPrecio;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    public void irAtras(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventanas/ventanaInventario.fxml"));
        Parent root = loader.load();

        // Crear una nueva escena
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Historico de ventas");

        // Mostrar la nueva ventana
        stage.show();

        // Cerrar la ventana actual
        Stage ventanaActual = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ventanaActual.close();
    }
}

