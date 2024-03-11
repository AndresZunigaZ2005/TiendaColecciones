package co.edu.uniquindio.tienda.model;

import co.edu.uniquindio.tienda.exceptions.*;
import co.edu.uniquindio.tienda.utils.ArchivoUtils;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.io.IOException;
import java.time.LocalDateTime;
import java.util.*;
import java.util.logging.FileHandler;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.logging.SimpleFormatter;

import co.edu.uniquindio.tienda.utils.ArchivoUtils.*;
@Data
@Builder
@AllArgsConstructor


public class Tienda {
    private String nombre;
    private String direccion;
    private String nit;

    private HashMap<String, Cliente> lstCliente;
    private HashMap<String, Producto> lstProducto;
    private ArrayList<Venta> lstVenta;
    private HashSet<String> lstCarritoCompra;
    private LinkedList<Venta> historicoventas;
    private TreeSet<Producto> inventario;

    private static final Logger LOGGER =Logger.getLogger(Tienda.class.getName());
    //Variable para el SINGLETON
    private static Tienda tienda;


    public String prntHash(){
        String msj = "";
        for (Map.Entry<String, Producto> entry : lstProducto.entrySet()){
            msj += "Clave: " + entry.getKey() + " Valor: " + entry.getValue();
        }
        return msj;
    }

    private Tienda(){
        try {
            FileHandler fh = new FileHandler("logs.log", true);
            fh.setFormatter(new SimpleFormatter());
            LOGGER.addHandler(fh);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
        LOGGER.log(Level.INFO, "Se crea una nueva instanica de Tienda");
        this.lstCliente = new HashMap<>();
        this.lstProducto= new HashMap<>();
        this.lstVenta= new ArrayList<>();
        this.lstCarritoCompra= new HashSet<>();
        this.historicoventas= new LinkedList<>();
        this.inventario= new TreeSet<>();

        leerClienteSerializable();
        leerProductoSerializable();
        leerVentaSerializable();
        leerHistoricoeSerializable();
        leerInventarioSerializable();
    }

    public static Tienda getInstance() {
        if (tienda == null){
            tienda = new Tienda();
        }
        return tienda;
    }

    //Metodos CRUD de cliente

    /**
     * Registro de clientes
     * @param nombre
     * @param numeroIdentificacion
     * @param direccion
     * @throws RegistroClienteException
     * @throws ExistenciaClienteException
     */
    public void registrarCliente(String nombre , String numeroIdentificacion , String direccion) throws RegistroClienteException, ExistenciaClienteException {
        if(nombre.isBlank() || nombre == ""  || numeroIdentificacion.isBlank() || numeroIdentificacion == "" || direccion.isBlank() || direccion == ""){
            throw new RegistroClienteException("Error, Campos vacios");
        }
        else if(lstCliente.containsKey(numeroIdentificacion))
        {
            throw new ExistenciaClienteException("El cliente ya existe");
        }
        else {
            lstCliente.put(numeroIdentificacion, Cliente.builder()
                    .numeroIdentificacion(numeroIdentificacion)
                    .nombre(nombre)
                    .direccion(direccion)
                    .build());
            escribirCliente();
            LOGGER.log(Level.INFO, "El cliente de identificación "+numeroIdentificacion+" se ha registrado");
        }
    }


    /**
     * Metodo para obtener cliente
     * @param numeroIdentificacion
     * @return Cliente
     * @throws ObtenerClienteException
     */
    public Cliente obtenerCliente(String numeroIdentificacion) throws ObtenerClienteException {
        if(lstCliente.containsKey(numeroIdentificacion)){
            return lstCliente.get(numeroIdentificacion);
        }
        throw new ObtenerClienteException("El cliente no existe");
    }


    /**
     * Metodo para actualizar cliente
     * @param numeroIdentificacion
     * @param nombreNuevo
     * @param direccionNueva
     * @throws ExistenciaClienteException
     * @throws ActualizarClienteException
     * @throws ObtenerClienteException
     */
    public void actualizarCliente(String numeroIdentificacion , String nombreNuevo , String direccionNueva) throws ExistenciaClienteException, ActualizarClienteException, ObtenerClienteException {
        if(!lstCliente.containsKey(numeroIdentificacion)){
            throw new ExistenciaClienteException("El cliente no existe");
        }
        else if (nombreNuevo.isBlank() || nombreNuevo == "" || direccionNueva.isBlank() || direccionNueva == "" ) {
            throw new ActualizarClienteException("Error al actualizar, campos vacios");
        } else {
            Cliente client = obtenerCliente(numeroIdentificacion);
            client.setNombre(nombreNuevo);
            client.setDireccion(direccionNueva);
            lstCliente.put(numeroIdentificacion, client);
            LOGGER.log(Level.INFO, "Se ha actualizado el cliente de identificación "+numeroIdentificacion);
        }
    }

    /**
     * Metodos para eliminar cliente
     * @param numeroIdentificacion
     * @throws ExistenciaClienteException
     */
    public void eliminarCliente (String numeroIdentificacion) throws ExistenciaClienteException {
        if(!lstCliente.containsKey(numeroIdentificacion)){
            throw new ExistenciaClienteException("El cliente no existe");
        }
        else
        {
            lstCliente.remove(numeroIdentificacion);
            escribirCliente();
            LOGGER.log(Level.WARNING, "Se ha eliminado el cliente de identificación "+numeroIdentificacion);
        }
    }


    //Metodos CRUD de producto

    /**
     * Metodo para agregar un producto nuevo a la tienda
     * @param codigo
     * @param nombre
     * @param precio
     * @param cantidad
     * @throws AgregarProductoNuevoException
     * @throws obtenerProductoNotFoundException
     */
    public void agregarProductoNuevo(String codigo , String nombre , Double precio , int cantidad) throws AgregarProductoNuevoException, obtenerProductoNotFoundException {
        if(codigo.isBlank() || codigo == "" || nombre.isBlank() || nombre == "" || precio < 0 || cantidad <0)
        {
            System.out.println("ENtro al if");
            throw new AgregarProductoNuevoException("Error al agregar, revise nuevamente");
        }
        else if(isContenido(codigo)) {
            Producto producto = obtenerProducto(codigo);
            producto.setCantidad(producto.getCantidad()+cantidad);
            lstProducto.put(codigo, producto);
            LOGGER.log(Level.INFO, "El producto "+codigo+" se ha creado");
            LOGGER.log(Level.INFO,"La lista es" + tienda.prntHash());

        }
        else{
            Producto nuevoProducto = Producto.builder()
                    .codigo(codigo)
                    .nombre(nombre)
                    .precio(precio)
                    .cantidad(cantidad)
                    .build();
            lstProducto.put(codigo, nuevoProducto);
            escribirProducto();
            LOGGER.log(Level.INFO, "El producto de codigo "+codigo+" se ha sumado a la ");
            LOGGER.log(Level.INFO,"La lista es" + tienda.prntHash());
            }
        }

    /**
     * Metodo para obtener el objeto producto de la lista de productos
     * @param codigo
     * @return
     * @throws obtenerProductoNotFoundException
     */
    public Producto obtenerProducto(String codigo) throws obtenerProductoNotFoundException{
        if(lstProducto.containsKey(codigo)){
            return lstProducto.get(codigo);
        }
        throw new obtenerProductoNotFoundException("El producto no existe");
    }

    public boolean isContenido (String codigo) {
        if(lstProducto.containsKey(codigo)){
            return true;
        }
        return false;

    }


    /**
     * Metodo para actualizar los datos de un producto
     * @param codigo
     * @param nombreNuevo
     * @param precioNuevo
     * @param cantidadNueva
     * @throws ActualizarProductoException
     * @throws ExistenciaProductoException
     * @throws obtenerProductoNotFoundException
     */
    public void actualizarProducto(String codigo , String nombreNuevo , Double precioNuevo , int cantidadNueva) throws ActualizarProductoException, ExistenciaProductoException, obtenerProductoNotFoundException {
        if( codigo.isBlank() || codigo == "" || nombreNuevo.isBlank() || nombreNuevo == "" || precioNuevo < 0 || cantidadNueva <0)
        {
            throw new ActualizarProductoException("Error al actualizar, revise nuevamente");
        }
        else if (!lstProducto.containsKey(codigo))
        {
            throw new ExistenciaProductoException("El producto no existe, por favor verifique la informacion");
        }
        else
        {
            Producto product = obtenerProducto(codigo);
            product.setNombre(nombreNuevo);
            product.setPrecio(precioNuevo);
            product.setCantidad(cantidadNueva);
            lstProducto.put(codigo, product);
            LOGGER.log(Level.INFO, "El producto "+codigo+" se ha creado");
        }
    }

    /**
     * Metodo para eliminar productos de la tienda
     *
     * @param codigo
     * @throws ExistenciaProductoException
     */
    public void eliminarProducto(String codigo) throws ExistenciaProductoException {
        if(lstProducto.containsKey(codigo)){
            lstProducto.remove(codigo);
            escribirProducto();
            LOGGER.log(Level.WARNING, "El producto "+codigo+" se ha eliminado");
        }
        throw new ExistenciaProductoException("Error, el producto no existe");
    }


    //Metodos CRUD Venta

    /**
     * Metodo para agregar una venta con la identificacion del cliente
     * @param codigo
     * @param fecha
     * @param identificacionCliente
     * @param total
     * @param listaDetalles
     * @throws AgregarVentaException
     * @throws obtenerVentaException
     * @throws ObtenerClienteException
     * @throws ExistenciaClienteException
     */
    public void agregarVenta (String codigo , LocalDateTime fecha , String identificacionCliente , Double total , ArrayList<DetalleVenta> listaDetalles) throws AgregarVentaException, obtenerVentaException, ObtenerClienteException, ExistenciaClienteException {
        if(codigo == "" || codigo.isBlank() || fecha == null || identificacionCliente =="" || identificacionCliente.isBlank() || total<0 || listaDetalles == null) {
            throw new AgregarVentaException("Error al agregar venta, por favor verificar los datos");
        }
        else if (obtenerVenta(codigo) != null)
        {
            throw new AgregarVentaException("La venta ya existe, no se puede actualizar");
        }else if (obtenerCliente(identificacionCliente) ==null){
            throw new ExistenciaClienteException("El cliente no existe");
        }
        else{
            Venta venta = Venta.builder()
                    .codigo(codigo)
                    .fecha(fecha)
                    .lstDetalleVenta(listaDetalles)
                    .cliente(obtenerCliente(identificacionCliente))
                    .total(total)
                    .build();
            lstVenta.add(venta);
            escribirVenta();
            LOGGER.log(Level.INFO, "La venta "+codigo+" se ha creado");
        }
    }


    /**
     * Metodo para obtener objeto venta de la lista de ventas
     * @param codigo
     * @return
     * @throws obtenerVentaException
     */
    public Venta obtenerVenta(String codigo) throws obtenerVentaException {
        for (Venta venta: lstVenta) {
            if(venta.getCodigo().equals(codigo)){
                return venta;
            }
        }

        throw new obtenerVentaException("La venta no existe");
    }


    /**
     * Metodo para eliminar una venta de la lista de ventas
     * @param codigo
     * @throws EliminarVentaException
     * @throws obtenerVentaException
     */
    public void eliminarVenta(String codigo) throws EliminarVentaException, obtenerVentaException {
        if(obtenerVenta(codigo) == null)
        {
            throw new  EliminarVentaException("Error al eliminar la venta, el codigo esta mal o la venta no existe");
        }
        else
        {
            lstVenta.remove(obtenerIndiceArrayListVenta(codigo));
            escribirVenta();
            LOGGER.log(Level.WARNING, "La venta "+codigo+" se ha eliminado");
        }
    }


    /**
     * Metodo para obtener el indice de una venta dentro del arraylist de ventas
     * @param codigo
     * @return
     */
    public int obtenerIndiceArrayListVenta (String codigo)
        {
        for(int i =0 ; i<lstVenta.size() ; i++)
        {
            if (lstVenta.get(i).getCodigo().equals(codigo)) {
                return i;
            }
        }
            return -1;
    }



    /**
     * Metodo para agregar una venta al historico de ventas
     * @param venta
     * @throws AgregarVentaEnHistoricoVentasException
     */
    public void agregarVentaEnHistoricoVentas(Venta venta) throws AgregarVentaEnHistoricoVentasException
    {
        if(venta==null)
        {
            throw new AgregarVentaEnHistoricoVentasException("Error, la venta no existe");
        }
        else
        {
            historicoventas.add(venta);
            escribirHistoricoVentas();
            LOGGER.log(Level.INFO, "La venta "+venta.getCodigo()+" se ha anañadido al historico");
        }

    }

    /**
     * Metodo para obtener un objeto venta del historico de ventas
     * @param codigo
     * @return
     * @throws obtenerVentaException
     */
    public Venta obtenerVentaHistoricoVentas(String codigo) throws obtenerVentaException
    {
        for(Venta venta : historicoventas)
        {
            if(venta.getCodigo().equals(codigo))
            {
                return venta;
            }
        }
        throw new obtenerVentaException("La venta no existe");
    }


    //public void actualizarVenta (String codigo , )


    /**
     * Metodo para eliminar venta del historial de ventas
     * @param codigo
     * @throws EliminarVentaException
     */
    public void eliminarVentaEnHistoricoVentas(String codigo) throws EliminarVentaException
    {
        Iterator<Venta> iterador = historicoventas.iterator();

        while (iterador.hasNext()) {
            Venta venta = iterador.next();

            if (venta.getCodigo().equals(codigo)) {

                iterador.remove();
                escribirHistoricoVentas();
                return;
            }
        }
        throw new EliminarVentaException("La venta no existe, por lo tanto no se puede eliminar");
    }


    //metodos para serializar

    //metodos para escribir serializacion
    public void escribirCliente(){
        try {
            ArchivoUtils.serializarObjeto("src/main/resources/persistencia/clientes.ser", lstCliente);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
    }

    public void escribirProducto()
    {
        try {
            ArchivoUtils.serializarObjeto("src/main/resources/persistencia/productos.ser", lstProducto);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
    }

    public void escribirVenta()
    {
        try {
            ArchivoUtils.serializarObjeto("src/main/resources/persistencia/ventas.ser", lstVenta);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
    }

    public void escribirHistoricoVentas()
    {
        try {
            ArchivoUtils.serializarObjeto("src/main/resources/persistencia/historicoVentas.ser", historicoventas);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
    }

    public void escribirInventario()
    {
        try {
            ArchivoUtils.serializarObjeto("src/main/resources/persistencia/inventario.ser", inventario);
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE,e.getMessage());
        }
    }



    //metodos para leer serializacion
    public void leerClienteSerializable(){
        try{
            this.lstCliente = (HashMap<String, Cliente>) ArchivoUtils.deserializarObjeto("src/main/resources/persistencia/clientes.ser");
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    public void leerProductoSerializable(){
        try{
            this.lstProducto = (HashMap<String, Producto>) ArchivoUtils.deserializarObjeto("src/main/resources/persistencia/productos.ser");
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    public void leerVentaSerializable(){
        try{
            this.lstVenta = (ArrayList<Venta>) ArchivoUtils.deserializarObjeto("src/main/resources/persistencia/ventas.ser");
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    public void leerHistoricoeSerializable(){
        try{
            this.historicoventas = (LinkedList<Venta>) ArchivoUtils.deserializarObjeto("src/main/resources/persistencia/historicoVentas.ser");
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }

    public void leerInventarioSerializable(){
        try{
            this.inventario = (TreeSet<Producto>) ArchivoUtils.deserializarObjeto("src/main/resources/persistencia/inventario.ser");
        } catch (IOException | ClassNotFoundException e) {
            LOGGER.log(Level.SEVERE, e.getMessage());
        }
    }


}



