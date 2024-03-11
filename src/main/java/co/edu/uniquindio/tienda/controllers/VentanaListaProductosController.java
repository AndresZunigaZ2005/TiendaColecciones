package co.edu.uniquindio.tienda.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;

public class VentanaListaProductosController {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAniadir;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGenerarVenta;

    @FXML
    private Button btnRegresar;

    @FXML
    private Label lblBUscarPorID;

    @FXML
    private Label lblBuscarPorNombre;

    @FXML
    private Label lblCantidad;

    @FXML
    private Label lblListaDeProductos;

    @FXML
    private Label lblTotalVenta;

    @FXML
    private TableColumn<?, ?> tcCantidadAnadido;

    @FXML
    private TableColumn<?, ?> tcIdProductoAnadido;

    @FXML
    private TableColumn<?, ?> tcIdProductoVenta;

    @FXML
    private TableColumn<?, ?> tcNombreProductoAnadido;

    @FXML
    private TableColumn<?, ?> tcNombreProductoVenta;

    @FXML
    private TableColumn<?, ?> tcPrecioUnidadAnadido;

    @FXML
    private TableColumn<?, ?> tcPrecioUnidadVenta;

    @FXML
    private TableColumn<?, ?> tcSubtotal;

    @FXML
    private TextField txtBuscarPorID;

    @FXML
    private TextField txtBuscarPorNombre;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtTotalVenta;

    @FXML
    void regresarVentana(ActionEvent event) throws IOException {

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventanas/validarCliente.fxml"));
        Parent root = loader.load();

        // Crear una nueva escena
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Historico de ventas");

        // Mostrar la nueva ventana
        stage.show();

        // Cerrar la ventana actual
        Stage ventanaActual = (Stage) ((Node) event.getSource()).getScene().getWindow();
        ventanaActual.close();

    }

}

