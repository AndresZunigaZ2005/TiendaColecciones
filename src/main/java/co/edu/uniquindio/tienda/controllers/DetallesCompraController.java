package co.edu.uniquindio.tienda.controllers;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

public class DetallesCompraController {

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAniadirProducto;

    @FXML
    private Button btnContinuar;

    @FXML
    private Button btnEliminar;

    @FXML
    private ComboBox<?> cBoxProductos;

    @FXML
    private TableColumn<?, ?> columnCantidad;

    @FXML
    private TableColumn<?, ?> columnPrecioUnidad;

    @FXML
    private TableColumn<?, ?> columnProducto;

    @FXML
    private TableColumn<?, ?> columnSubtotal;

    @FXML
    private Label lblCantidad;

    @FXML
    private Label lblProducto;

    @FXML
    private Label lblProductosAComprar;

    @FXML
    private Spinner<?> spinnerCantidad;

    @FXML
    private TableView<?> tableViewDetalleVenta;

    @FXML
    void ActualizarProducto(MouseEvent event) {

    }

    @FXML
    void AniadirProducto(MouseEvent event) {

    }

    @FXML
    void EliminarProducto(MouseEvent event) {

    }

}

