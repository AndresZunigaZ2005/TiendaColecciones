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

public class ventanaInventarioController {

        @FXML
        private Button btnActualizarProducto;

        @FXML
        private Button btnAnadirProducto;

        @FXML
        private Button btnBuscarPorCodigo;

        @FXML
        private Button btnBuscarPorNombre;

        @FXML
        private Button btnEliminarProducto;

        @FXML
        private Button btnRegresar;

        @FXML
        private Label lblInventario;

        @FXML
        private TableColumn<?, ?> tcCantidad;

        @FXML
        private TableColumn<?, ?> tcCodigoProducto;

        @FXML
        private TableColumn<?, ?> tcNombreProducto;

        @FXML
        private TableColumn<?, ?> tcPrecio;

        @FXML
        private TextField txtBuscarPorCodigo;

        @FXML
        private TextField txtBuscarPorNombre;

        @FXML
        void irHistoricoVentas (ActionEvent event) throws IOException {

            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventanas/ventanaHistoricoVentas.fxml"));
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

    public void anadirProducto(ActionEvent actionEvent) throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventanas/ventanaAgregarProductoNuevo.fxml"));
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

    public void regresarVentana(ActionEvent actionEvent) throws IOException {

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
        Stage ventanaActual = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ventanaActual.close();
    }


    public void irActualizarProducto(ActionEvent actionEvent) throws IOException{
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventanas/ventanaActualizarProducto.fxml"));
        Parent root = loader.load();

        // Crear una nueva escena
        Scene scene = new Scene(root);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.setTitle("Actualizar producto");

        // Mostrar la nueva ventana
        stage.show();

        // Cerrar la ventana actual
        Stage ventanaActual = (Stage) ((Node) actionEvent.getSource()).getScene().getWindow();
        ventanaActual.close();
    }
}


