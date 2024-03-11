package co.edu.uniquindio.tienda.controllers;

import co.edu.uniquindio.tienda.controllerModel.ModelFactoryController;
import co.edu.uniquindio.tienda.model.Producto;
import co.edu.uniquindio.tienda.model.Tienda;
import javafx.beans.property.SimpleDoubleProperty;
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
import java.util.ResourceBundle;

public class VentanaListaProductosController implements Initializable {
    private ModelFactoryController modelFactoryController;
    @FXML
    private TableView<Producto> TbProductos;

    @FXML
    private TableView<Producto> TbProductosAgregados;

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
    private TableColumn<Producto, String> tcIdProductoAnadido;

    @FXML
    private TableColumn<Producto, String> tcIdProductoVenta;

    @FXML
    private TableColumn<Producto, String> tcNombreProductoAnadido;

    @FXML
    private TableColumn<Producto, String> tcNombreProductoVenta;

    @FXML
    private TableColumn<Producto, Double> tcPrecioUnidadAnadido;

    @FXML
    private TableColumn<Producto, Double> tcPrecioUnidadVenta;

    @FXML
    private TableColumn<Producto, Double> tcSubtotal;

    @FXML
    private TextField txtBuscarPorID;

    @FXML
    private TextField txtBuscarPorNombre;

    @FXML
    private TextField txtCantidad;

    @FXML
    private TextField txtTotalVenta;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        modelFactoryController = ModelFactoryController.getInstance();
        // Llamado al método para cargar los datos en la tabla al inicializar la ventana
        cargarDatosEnTabla();
    }

    private void cargarDatosEnTabla() {
        ObservableList<Producto> datosTabla = FXCollections.observableArrayList(modelFactoryController.obtenerInvetario());

        // Asignas los datos a la tabla y a cada columna
        TbProductos.setItems(datosTabla);

        tcIdProductoVenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getCodigo()));

        tcNombreProductoVenta.setCellValueFactory(cellData -> new SimpleStringProperty(cellData.getValue().getNombre()));

        tcPrecioUnidadVenta.setCellValueFactory(cellData -> new SimpleDoubleProperty(cellData.getValue().getPrecio()).asObject());

        // Añades las columnas a la tabla
        TbProductos.getColumns().setAll(tcIdProductoVenta, tcNombreProductoVenta, tcPrecioUnidadVenta);

        TbProductos.setEditable(true);
    }



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

