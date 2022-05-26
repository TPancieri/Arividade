package view;

import java.util.ArrayList;

import model.Usuario;

public class UsuarioView extends ApplicationView implements IApplicationView {

	public void menuUsuario() {

		System.out.println("***MENU USUARIO***");
		System.out.println("-1.Cadastrar");
		System.out.println("-2.Listar");
		System.out.println("-3.Atualizar");
		System.out.println("-4.Deletar");
		System.out.println("-9.Voltar para o menu");

		int number = s.nextInt();
		switch (number) {
		case 1:
			menuCadastro();
			break;

		case 2:
			menuListar();
			break;

		case 3:
			menuAtualizar();
			break;

		case 4:
			menuDeletar();
			break;

		case 9:
			MenuView menuGeral = new MenuView();
			menuGeral.menu();
			break;
		}

	}

	public void menuCadastro() {
		Usuario usuario = new Usuario();

		System.out.println("**Cadastro de Usuario***");
		System.out.println("-");
		System.out.println("Informe o Username");
		usuario.setLogin(s.next());
		System.out.println("Informe a Password");
		usuario.setSenha(s.next());
		System.out.println("-");
		System.out.println("Cadastro Realizado!!!");
		System.out.println("" + usuario.getLogin());

		System.out.println(userControl.cadastrar(usuario));

		// menuUsuario(usuario);
		menuUsuario();

	}

	public void menuListar() {

		ArrayList<Usuario> userList = userControl.listar();

		if (userList.isEmpty()) {
			System.out.println("Nao possui usuarios cadastrados");
		} else {
			System.out.println("** LISTA DE USUARIOS ***");
			System.out.println("-");
			for (int cont = 0; cont < userList.size(); cont++) {
				System.out.println(userList.get(cont).toString());
			}
			System.out.println("-");
			System.out.println("************************");
		}
		menuUsuario();

	}

	public void menuAtualizar() {
		Usuario usuario = new Usuario();

		// instancia e setar informacao
		System.out.println("**Atualizacao de usuario***");

		System.out.println("informe o login");
		usuario.setLogin(s.next());
		System.out.println("informe a senha");
		usuario.setSenha(s.next());

		if (userControl.atualizar(usuario)) {
			System.out.println("usuario nao encontrado");
		} else {
			System.out.println("usuario atualizado com sucesso");

		}
		menuUsuario();

	}

	public void menuDeletar() {
		Usuario usuario = new Usuario();

		System.out.println("**deletar de usuario***");

		System.out.println("informe o login");
		usuario.setLogin(s.next());
//		usuario.setSenha(s.next());
//		System.out.println("senha");

		if (userControl.deletar(usuario)) {
			System.out.println("usuario nao encontrado"); // se for true retorna false
		} else {
			System.out.println("usuario excluido"); // se for false retorna true
		}
		menuUsuario();

	}

}
