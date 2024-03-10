package co.edu.uniquindio.tienda.controllers;

import co.edu.uniquindio.tienda.controllerModel.ModelFactoryController;
import co.edu.uniquindio.tienda.exceptions.ExistenciaClienteException;
import co.edu.uniquindio.tienda.exceptions.RegistroClienteException;
import co.edu.uniquindio.tienda.main.Main;
import co.edu.uniquindio.tienda.model.Tienda;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class RegistroUsuarioController implements Initializable {
    ModelFactoryController modelFactoryController;

    Tienda tienda= Tienda.getInstance();


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
    void RegistrarUsuario(ActionEvent event) {
        String nombre = txtFieldNombre.getText();
        String identificacion = txtFieldNumeroIdentificacion.getText();
        String direccion = txtFieldDireccion.getText();

        try {
            tienda.registrarCliente(nombre, identificacion, direccion);
        } catch (ExistenciaClienteException | RegistroClienteException e) {
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Confirmación");
            alert.setHeaderText(null);
            alert.setContentText("El usuario ha sido creada correctamente");
            alert.showAndWait();
        }
    }

    @FXML
    void cerrarVentana(ActionEvent event) throws IOException {
        //TODO terminar la conexión de ventanas
        FXMLLoader loader = new FXMLLoader(getClass().getResource("OtraVentana.fxml"));
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

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}
