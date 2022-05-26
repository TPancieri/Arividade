package view;

import java.util.ArrayList;

import model.Veiculo;

public class VeiculoView extends ApplicationView implements IApplicationView {

	public void menuVeiculo() {
		System.out.println("***MENU VEICULO***");
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
		Veiculo veiculo = new Veiculo();

		System.out.println("**Cadastro de Veiculo***");
		System.out.println("-");

		System.out.println("Informe a Placa");
		veiculo.setMarca(s.next());
		System.out.println("Informe a Marca");
		veiculo.setMarca(s.next());
		System.out.println("Informe o Ano");
		veiculo.setId(s.nextInt());
		System.out.println("-");
		System.out.println("Cadastro Realizado!!!");
		System.out.println(veControl.cadastrar(veiculo));

		menuVeiculo();

	}

	public void menuListar() {

		ArrayList<Veiculo> veicList = veControl.listar();

		if (veicList.isEmpty()) {
			System.out.println("Nao possui veiculos cadastrados");
		} else {
			System.out.println("** LISTA DE VEICULOS ***");
			System.out.println("-");
			for (int cont = 0; cont < veicList.size(); cont++) {
				System.out.println(veicList.get(cont).toString());
			}
			System.out.println("-");
			System.out.println("************************");
		}
		menuVeiculo();

	}

	public void menuAtualizar() {
		Veiculo veiculo = new Veiculo();

		System.out.println("**Atualizacao de Veiculo***");
		System.out.println("informe a placa");
		veiculo.setPlaca(s.next());
		System.out.println("informe a marca");
		veiculo.setMarca(s.next());
		System.out.println("informe o ano");
		veiculo.setAno(s.nextInt());
		if (veControl.atualizar(veiculo)) {
			System.out.println("veiculo nao encontrado");
		} else {
			System.out.println("veiculo atualizado com sucesso");

		}
		menuVeiculo();

	}

	public void menuDeletar() {
		Veiculo veiculo = new Veiculo();

		System.out.println("**deletar de veiculo***");

		System.out.println("informe a placa");
		veiculo.setPlaca(s.next());
		;

		if (veControl.deletar(veiculo)) {
			System.out.println("veiculo nao encontrado");
		} else {
			System.out.println("veiculo excluido");
		}
		menuVeiculo();

	}
}
