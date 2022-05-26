package view;

import java.util.Scanner;

import controller.UsuarioController;
import controller.VeiculoController;

public abstract class ApplicationView {
public UsuarioController userControl ;
public VeiculoController veControl;
public Scanner s;

public ApplicationView() {
	userControl = new UsuarioController();
	s = new Scanner(System.in);
	veControl= new VeiculoController();
}
	
}
