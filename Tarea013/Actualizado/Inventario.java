package Actualizado;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Inventario {
    private List<Producto> productos;
    private PersistenciaArchivo<Producto> persistencia;
    private final String archivoCSV = "productos.csv";
    private final String archivoJSON = "productos.json";

    public Inventario() {
        this.productos = new ArrayList<>();
        this.persistencia = new PersistenciaArchivo<>();
        cargarProductos();
    }
    
    
    	private void cargarProductos() {
    	    try {
    	        productos = persistencia.cargarCSV(archivoCSV);
    	        if (productos.isEmpty()) {
    	            productos = persistencia.cargarJSON(archivoJSON);
    	        }
    	        if (productos.isEmpty()) { // si aún está vacío, cargar productos iniciales
    	            inicializarProductos();
    	            guardarProductos();
    	        }
    	    } catch (IOException e) {
    	        System.out.println("Error al cargar productos.");
    	    }
    	}

    	private void inicializarProductos() {
    	    productos.add(new Producto("001", "Arroz 1kg", 35, 10));
    	    productos.add(new Producto("002", "Azúcar 1kg", 25, 10));
    	    productos.add(new Producto("003", "Harina 1kg", 28, 10));
    	    productos.add(new Producto("004", "Aceite 1L", 50, 10));
    	    productos.add(new Producto("005", "Leche 1L", 35, 10));
    	    productos.add(new Producto("006", "Huevos 12 unidades", 45, 10));
    	    productos.add(new Producto("007", "Fideos 500g", 20, 10));
    	    productos.add(new Producto("008", "Sal 1kg", 15, 10));
    	    productos.add(new Producto("009", "Pasta de tomate 400g", 25, 10));
    	    productos.add(new Producto("010", "Atún lata 170g", 35, 10));
    	}

    

    public void guardarProductos() {
        try {
            persistencia.guardarCSV(productos, archivoCSV);
            persistencia.guardarJSON(productos, archivoJSON);
        } catch (IOException e) {
            System.out.println("Error al guardar productos.");
        }
    }
    
    public void mostrarProductos() {
        System.out.println("\n===== LISTA DE PRODUCTOS =====");
        productos.forEach(System.out::println);
    }
    //hacerlo con una coleccion con for each
}
