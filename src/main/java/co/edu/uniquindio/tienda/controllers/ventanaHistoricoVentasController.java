package co.edu.uniquindio.tienda.controllers;

import co.edu.uniquindio.tienda.model.*;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDateTime;
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
    private Label lblTotalventa;

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
    private TableColumn<DetalleVenta, ?> tcIDProducto;

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

    @FXML
    private TextField txtTotalVenta;

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
    void eliminarVenta(ActionEvent event) {

    }

    @FXML
    void irVentanaAnterior(ActionEvent event) {

    }

    @FXML
    void verDetalleVentaSeleccionado(ActionEvent event) {
        // Obtener la fila seleccionada
        Venta ventaSeleccionada = tvHistoricoVentas.getSelectionModel().getSelectedItem();

        // Verificar si hay una fila seleccionada
        if (ventaSeleccionada != null) {
            // Acciones que deseas realizar si hay una venta seleccionada
            // Por ejemplo, imprimir el código de la venta seleccionada
            System.out.println("Código de la venta seleccionada: " + ventaSeleccionada.getCodigo());

            // Llamar a otros métodos que desees ejecutar
            // Por ejemplo:
            // otroMetodo(ventaSeleccionada);
        } else {
            // Si no hay una fila seleccionada, mostrar un mensaje de advertencia
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

