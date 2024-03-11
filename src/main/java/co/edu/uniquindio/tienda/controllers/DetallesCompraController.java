package co.edu.uniquindio.tienda.controllers;

import co.edu.uniquindio.tienda.controllerModel.ModelFactoryController;
import co.edu.uniquindio.tienda.model.DetalleVenta;
import co.edu.uniquindio.tienda.model.Producto;
import co.edu.uniquindio.tienda.model.Tienda;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import de.jensd.fx.glyphs.fontawesome.FontAwesomeIconView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;

import java.net.URL;
import java.util.ResourceBundle;

public class DetallesCompraController implements Initializable {

    //TODO terminar la ventana, problema al iniciar el comboBox
    ModelFactoryController modelFactoryController;

    @FXML
    private Button btnActualizar;

    @FXML
    private Button btnAniadirProducto;

    @FXML
    private Button btnContinuar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnIrAtras;

    @FXML
    private ComboBox<Producto> cBoxProductos;

    @FXML
    private TableColumn<DetalleVenta, Integer> columnCantidad;

    @FXML
    private TableColumn<DetalleVenta,Double> columnPrecioUnidad;

    @FXML
    private TableColumn<DetalleVenta, String> columnProducto;

    @FXML
    private TableColumn<DetalleVenta, Double> columnSubtotal;

    @FXML
    private Label lblCantidad;

    @FXML
    private Label lblProducto;

    @FXML
    private Label lblProductosAComprar;

    @FXML
    private Spinner<Integer> spinnerCantidad;

    @FXML
    private TableView<DetalleVenta> tableViewDetalleVenta;

    private Tienda tienda = Tienda.getInstance();

    @FXML
    void ActualizarProducto(MouseEvent event) {

    }

    @FXML
    void AniadirProducto(MouseEvent event) {

    }

    @FXML
    void EliminarProducto(MouseEvent event) {

    }

    @FXML
    void irAtras(ActionEvent event){

    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        FontAwesomeIconView icon = new FontAwesomeIconView(FontAwesomeIcon.ARROW_LEFT);
        icon.setSize("2em");
        btnIrAtras.setGraphic(icon);



        cBoxProductos.getItems().addAll(tienda.getLstProducto().values());


        // Crear un SpinnerValueFactory con los límites del 1 al 100
        SpinnerValueFactory<Integer> valueFactory = new SpinnerValueFactory.IntegerSpinnerValueFactory(1, 100);

        // Establecer el valor inicial del Spinner
        valueFactory.setValue(1); // Puedes establecer cualquier valor inicial que desees

        // Asignar el SpinnerValueFactory al Spinner
        spinnerCantidad.setValueFactory(valueFactory);
    }
}

