package view;

import java.util.Scanner;

import model.Usuario;

public class UsuarioView {

	public void menuUsuario(Usuario usuarios) {

		System.out.println("***MENU USUARIO***");
		System.out.println("-1.Cadastrar");
		System.out.println("-2.Listar");
		System.out.println("-3.Atualizar");
		System.out.println("-4.Deletar");
		System.out.println("-9.Voltar para o menu");

		Scanner input = new Scanner(System.in);

		int number = input.nextInt();
		switch (number) {
		case 1:

			menuCadastro();

			break;

		case 2:

			menuListar(usuarios);

			break;

		case 9:
			MenuView menuGeral = new MenuView();
			menuGeral.menu();
			break;
		}

	}

	public void menuCadastro() {
		Usuario usuarios = new Usuario();

		Scanner scan = new Scanner(System.in);

		System.out.println("**Cadastro de Usuario***");
		System.out.println("-");
		System.out.println("Informe o Username");
		usuarios.setLogin(scan.next());
		System.out.println("Informe a Password");
		usuarios.setSenha(scan.next());
		System.out.println("-");
		System.out.println("Cadastro Realizado!!!");
		System.out.println("" + usuarios.getLogin());

		menuUsuario(usuarios);

	}

	public void menuListar(Usuario usuarios) {

		System.out.println("***Lista de Usuarios");
		System.out.println("-");
		System.out.println("-Username: " + usuarios.getLogin());
		System.out.println("-Password: " + usuarios.getSenha());
		System.out.println("******");

	}
}
