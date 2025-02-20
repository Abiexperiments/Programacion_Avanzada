package Actualizado;
public class Principal {
    public static void main(String[] args) {
        Inventario inventario = new Inventario();
        InterfazUsuario ui = new InterfazUsuario();
        String opcion;

        while (true) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("1. Ver productos");
            System.out.println("2. Comprar productos");
            System.out.println("3. Salir");
            opcion = ui.leerEntrada("Seleccione una opción: ");

            switch (opcion) {
                case "1":
                    inventario.mostrarProductos();
                    break;
                case "2":
                    inventario.guardarProductos();
                    System.out.println("Productos Comprados correctamente.");
                    break;
                case "3":
                    System.out.println("Saliendo... Gracias por usar el sistema.");
                    return;
                default:
                    System.out.println("Opción inválida. Intente nuevamente.");
            }
        }
    }
}
