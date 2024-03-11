package co.edu.uniquindio.tienda.controllers;

import co.edu.uniquindio.tienda.exceptions.AgregarProductoNuevoException;
import co.edu.uniquindio.tienda.exceptions.obtenerProductoNotFoundException;
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
import javafx.stage.Stage;

import java.io.IOException;

public class ventanaAgregarProductoNuevoController {

    @FXML
    private Button btnAnadir;

    @FXML
    private Button btnRegresar;

    @FXML
    private Label lblAnadirProducto;

    @FXML
    private Label lblCantidad;

    @FXML
    private Label lblNombre;

    @FXML
    private Label lblPrecio;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtFieldCodigo;

    @FXML
    private TextField txtNombre;

    @FXML
    private TextField txtPrecio;

    private Tienda tienda = Tienda.getInstance();

    @FXML
    void anadirProducto(ActionEvent event) {
        String codigo = txtFieldCodigo.getText();
        String nombre = txtNombre.getText();
        Double precio = Double.parseDouble(txtPrecio.getText());
        int cantidad = Integer.parseInt(txtCantidad.getText());

        try {
            System.out.println("holaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            tienda.agregarProductoNuevo(codigo,nombre,precio,cantidad);
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText(null);
            alert.setContentText("El Producto ha sido creado correctamente");
            alert.showAndWait();
        } catch (obtenerProductoNotFoundException | AgregarProductoNuevoException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText(e.getMessage());
            alert.showAndWait();
        }
    }

    @FXML
    void irAtras(ActionEvent event) throws IOException {
        //TODO cual ventana se va hacia atras
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/Ventanas/ventanaInventario.fxml"));
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

}
