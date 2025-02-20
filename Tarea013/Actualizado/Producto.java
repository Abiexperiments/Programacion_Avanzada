package Actualizado;


	public class Producto extends ItemVenta implements ImpuestoAplicable {
	    public Producto(String codigo, String nombre, double precio, int cantidad) {
	        super(codigo, nombre, precio, cantidad);
	    }

	    @Override
	    public double calcularIVA() {
	        return precio * IVA;
	    }
	    
	    @Override
	    public double calcularIEPS() {
	        return precio * IEPS;
	    }
	    
	    @Override
	    public double calcularTotal() {
	        return precio + calcularIVA() + calcularIEPS();
	    }
	    
	    @Override
	    public String toString() {
	        return String.format("%-5s %-30s %-10.2f %-5d", codigo, nombre, calcularTotal(), cantidad);
	    }
	}


