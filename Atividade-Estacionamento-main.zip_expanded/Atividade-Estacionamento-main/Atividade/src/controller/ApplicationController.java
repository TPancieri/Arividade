package controller;

import service.UsuarioService;
import service.VeiculoService;

public abstract class ApplicationController {

	public UsuarioService userService;
	public VeiculoService veService;

	public ApplicationController() {
		userService = new UsuarioService();
		veService = new VeiculoService();
	}

}
