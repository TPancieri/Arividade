package view;

import java.util.Scanner;

public class MenuView {

	public void menu() {

		System.out.println("***  MENU  ***");
		System.out.println("-");
		System.out.println("-1.Cadastrar Usuario");
		System.out.println("-2.Cadastrar TipoVeiculo");
		System.out.println("-3.Cadastrar Veiculo");
		System.out.println("-4.Cadastrar Pessoa");
		System.out.println("-9.Voltar");

		Scanner input = new Scanner(System.in);

		int number = input.nextInt();
		switch (number) {
		case 1:
			UsuarioView user = new UsuarioView();
			user.menuUsuario();
			break;
		case 3:
			VeiculoView veiculo = new VeiculoView();
			veiculo.menuVeiculo();
			break;
		case 4:
//			PessoaView pessoa = new PessoaView();
//			pessoa.menuPessoa();
			break;
		case 9:

			LoginView login = new LoginView();
			login.login();
			MenuView menuGeral = new MenuView();
			menuGeral.menu();
			break;
		}

	}

}
