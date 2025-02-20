package Actualizado;

	import java.text.SimpleDateFormat;
	import java.util.Date;

	public class Venta extends ItemVenta {
	    private String fecha;

	    public Venta(String idTicket, String codigo, String nombre, double precio, int cantidad) {
	        super(codigo, nombre, precio, cantidad);
	        this.fecha = new SimpleDateFormat("dd-MM-yyyy").format(new Date());
	    }

	    @Override
	    public double calcularTotal() {
	        return (precio * cantidad) + (precio * cantidad * ImpuestoAplicable.IVA) + (precio * cantidad * ImpuestoAplicable.IEPS);
	    }

	    public void mostrarTicket() {
	        System.out.println("\n===== TICKET DE VENTA =====");
	        System.out.println("Fecha: " + fecha + " | Ticket No: " + codigo);
	        System.out.println(this);
	        System.out.println("Total con impuestos: " + calcularTotal());
	    }
	}

