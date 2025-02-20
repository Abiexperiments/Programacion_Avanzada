package Ejercicio;

public interface IcontroladorVcrud {
	
		public static final Vcrud Ventana = new Vcrud();
		public void CargarVcrud(); //con este cargare y establecere el titulo del Frame
		public void BotonAgregar();
		public void BotonEliminar();
		public void BotonModificar();
		public void BotonSalir();
		public void BotonBuscar();
		

	}

