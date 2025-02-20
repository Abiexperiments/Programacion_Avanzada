package Ejercicio;

import java.awt.event.*;

public class ControladorCrudProfesores implements IcontroladorVcrud , ActionListener{
	Vcrud CrudVista;
	public ControladorCrudProfesores() {
	 this.CargarVcrud();
	 this.CrudVista.GetBtnAñadir().addActionListener(this);
	 this.CrudVista.GetBtnmodificar().addActionListener(this);
	 this.CrudVista.GetBtnBuscar().addActionListener(this);
	 this.CrudVista.GetBtnEliminar().addActionListener(this);
	 //  dice algo de crear default table model tengo que checar eso
	 // crear clase profesor
	 
	}
	
	@Override
	public void CargarVcrud() {
		// TODO Auto-generated method stub
		CrudVista=new Vcrud();
		CrudVista.setTitle("CRUD DE PROFESORES");
		CrudVista.setVisible(true);
	}

	@Override
	public void BotonAgregar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BotonEliminar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BotonModificar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BotonSalir() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void BotonBuscar() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}
