package Actualizado;

	import java.util.Scanner;

	public class InterfazUsuario {
	    private Scanner scanner;

	    public InterfazUsuario() {
	        this.scanner = new Scanner(System.in);
	    }

	    public String leerEntrada(String mensaje) {
	        System.out.print(mensaje);
	        return scanner.nextLine().trim();
	    }
	    
	    public int leerEntero(String mensaje) {
	        while (true) {
	            try {
	                System.out.print(mensaje);
	                return Integer.parseInt(scanner.nextLine().trim());
	            } catch (NumberFormatException e) {
	                System.out.println("Entrada inválida. Intente de nuevo.");
	            }
	        }
	    }
	}


