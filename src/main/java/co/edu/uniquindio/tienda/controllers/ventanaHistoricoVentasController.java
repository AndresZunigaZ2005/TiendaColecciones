package co.edu.uniquindio.tienda.controllers;

import co.edu.uniquindio.tienda.exceptions.EliminarVentaException;
import co.edu.uniquindio.tienda.exceptions.obtenerVentaException;
import co.edu.uniquindio.tienda.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ventanaHistoricoVentasController implements Initializable {

    @FXML
    private Button btnBuscarFecha;

    @FXML
    private Button btnBuscarIDCliente;

    @FXML
    private Button btnBuscarIDVenta;

    @FXML
    private Button btnEliminarVenta;

    @FXML
    private Button btnVerDetalleVenta;

    @FXML
    private Button btnregresar;

    @FXML
    private DatePicker datePickerFechaVenta;

    @FXML
    private Label lblDetalleVenta;

    @FXML
    private Label lblHistoricoVentas;

    @FXML
    private TableColumn<Venta, String> tcCodigoVenta;

    @FXML
    private TableColumn<Venta, LocalDateTime> tcFechaVenta;

    @FXML
    private TableColumn<Venta, String> tcIDCliente;

    @FXML
    private TableColumn<Venta, String> tcNombreCliente;

    @FXML
    private TableColumn<Venta, Double> tcValorVenta;

    @FXML
    private TableView<Venta> tvHistoricoVentas;

    ////////////////////////////////////////////////////////////////////////
    @FXML
    private TableColumn<DetalleVenta, String> tcIDProducto;

    @FXML
    private TableColumn<DetalleVenta, String> tcNombreProducto;

    @FXML
    private TableColumn<DetalleVenta, Double> tcPrecioUnidad;

    @FXML
    private TableColumn<DetalleVenta, Integer> tcCantidad;

    @FXML
    private TableColumn<DetalleVenta, Double> tcSubtotal;

    @FXML
    private TableView <DetalleVenta> tableViewDetalleVenta;

    @FXML
    private TextField txtBuscarIDCliente;

    @FXML
    private TextField txtBuscarIDVenta;


    private Tienda tienda = Tienda.getInstance();

    @FXML
    void buscarVentaPorCodigoVenta(ActionEvent event) {

    }

    @FXML
    void buscarVentaPorFecha(ActionEvent event) {

    }

    @FXML
    void buscarVentaPorIDCliente(ActionEvent event) {

    }

    @FXML
    void verDetalleVentaSeleccionado(ActionEvent event) {
        // Obtener la fila seleccionada
        Venta ventaSeleccionada = tvHistoricoVentas.getSelectionModel().getSelectedItem();

        // Verificar si hay una fila seleccionada
        if (ventaSeleccionada != null) {


            // Obtener la lista de detalles de venta de la venta seleccionada
            ArrayList<DetalleVenta> detallesVenta = ventaSeleccionada.getLstDetalleVenta();

            // Limpiar la tabla de detalles de venta
            tableViewDetalleVenta.getItems().clear();

            // Llenar la tabla de detalles de venta con los detalles de la venta seleccionada
            tableViewDetalleVenta.getItems().addAll(detallesVenta);
        } else {
            // Si no hay una fila seleccionada, mostrar un mensaje de advertencia
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona una venta de la tabla superior.");
            alert.showAndWait();
        }
    }

    @FXML
    void irVentanaAnterior(ActionEvent event) throws IOException {
        //TODO terminar la conexión de ventanas
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

    @FXML
    void eliminarVenta(ActionEvent event) {
        // Obtener la venta seleccionada en la tabla de ventas
        Venta ventaSeleccionada = tvHistoricoVentas.getSelectionModel().getSelectedItem();

        // Verificar si hay una venta seleccionada
        if (ventaSeleccionada != null) {
            // Obtener la lista de ventas del objeto tienda y eliminar la venta seleccionada
            try {
                tienda.eliminarVenta(ventaSeleccionada.getCodigo()); // Asegúrate de tener un método para eliminar la venta en tu objeto tienda
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmación");
                alert.setHeaderText(null);
                alert.setContentText("La venta ha sido eliminada correctamente");
                alert.showAndWait();
                // Actualizar la tabla de ventas eliminando la fila correspondiente
                tvHistoricoVentas.getItems().remove(ventaSeleccionada);
            } catch (obtenerVentaException | EliminarVentaException e) {
                // Mostrar un mensaje de advertencia si no hay una venta seleccionada
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error");
                alert.setHeaderText(null);
                alert.setContentText(e.getMessage());
                alert.showAndWait();
            }
        } else {
            // Mostrar un mensaje de advertencia si no hay una venta seleccionada
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setTitle("Advertencia");
            alert.setHeaderText(null);
            alert.setContentText("Por favor, selecciona una venta de la tabla.");
            alert.showAndWait();
        }
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tcCodigoVenta.setCellValueFactory(new PropertyValueFactory<>("codigo"));
        tcFechaVenta.setCellValueFactory(new PropertyValueFactory<>("fecha"));

        tcIDCliente.setCellValueFactory(cellData -> {
            Cliente cliente = cellData.getValue().getCliente();
            String identificacion = cliente != null ? cliente.getNumeroIdentificacion() : "";
            return new SimpleStringProperty(identificacion);
        });


        tcNombreCliente.setCellValueFactory(cellData -> {
            Cliente cliente = cellData.getValue().getCliente();
            String nombreCliente = cliente != null ? cliente.getNombre() : "";
            return new SimpleStringProperty(nombreCliente);
        });

        tcValorVenta.setCellValueFactory(new PropertyValueFactory<>("total"));

        ObservableList<Venta> ventas = FXCollections.observableArrayList(tienda.getLstVenta());
        tvHistoricoVentas.setItems(ventas);
    }
}

