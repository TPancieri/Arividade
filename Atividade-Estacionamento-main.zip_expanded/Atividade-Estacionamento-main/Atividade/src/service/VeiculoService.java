package service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import model.Usuario;
import model.Veiculo;

public class VeiculoService {

	private final String userDB = "C:\\Users\\thiag\\eclipse-workspace\\Atividade-Estacionamento-main.zip_expanded\\Atividade-Estacionamento-main\\Atividade\\src\\data_base\\veiculo.txt"; // "src/data_base/usuario.txt";
	private FileReader arquivoLeitura;
	private BufferedReader memoriaLeitura;
	private File arquivo;
	private FileWriter escreverArquivo;
	private BufferedWriter memoriaEscrita;

	public VeiculoService() {
		try {
			arquivoLeitura = new FileReader(userDB);
			memoriaLeitura = new BufferedReader(arquivoLeitura);
			arquivo = new File(userDB);
		} catch (FileNotFoundException e) {
			System.out.println("nao foi possivel abrir o arquivo");
			System.out.println("erro : " + e.getMessage());
		}

	}

	public Boolean escrever(Veiculo veiculo) {
		try {
			if (existeArquivo()) {

				int contadorLinha = 0;
				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {

					contadorLinha = contadorLinha + 1;

				}

				contadorLinha = contadorLinha + 1;

				// String dadoParaEscrever = contadorLinha + ";" + usuario.getLogin() + ";" +
				// usuario.getSenha() ;
				// ID;ANO;PLACA;MARCA;
				String dadoParaEscrever = contadorLinha + ";" + veiculo.getAno() + ";" + veiculo.getMarca() + ";"
						+ veiculo.getPlaca();

				escreverArquivo = new FileWriter(arquivo, true);
				memoriaEscrita = new BufferedWriter(escreverArquivo);

				memoriaEscrita.write(dadoParaEscrever);
				memoriaEscrita.newLine();

				memoriaEscrita.close();

				return true;

			} else {
				criarArquivo();
				escrever(veiculo); // recursao
			}

		} catch (FileNotFoundException e) {
			System.out.println("arquivo nao encontrado");
			System.out.println(e.getMessage());

		} catch (IOException e) {
			System.out.println("nao foi possivel ler o arquivo");
			System.out.println(e.getMessage());

		}
		return false;

	}

	public Boolean ler(Veiculo veiculo) {
		try {
			if (existeArquivo()) {

				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");
					if (veiculo.getPlaca().equals(linha_split[3])) {

						return true;
					}
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("arquivo nao encontrado");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("nao foi possivel ler o arquivo");
			System.out.println(e.getMessage());
		}

		return false;

	}

	public ArrayList<Veiculo> ler() {
		ArrayList<Veiculo> listVeiculo = new ArrayList<>();
		try {
			if (existeArquivo()) {

				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");
					Veiculo veiculo = new Veiculo();
					veiculo.setId(Integer.parseInt(linha_split[0]));
					veiculo.setAno(Integer.parseInt(linha_split[1]));
					veiculo.setMarca(linha_split[2]);
					veiculo.setPlaca(linha_split[3]);

					listVeiculo.add(veiculo);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("arquivo nao encontrado");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("nao foi possivel ler o arquivo");
			System.out.println(e.getMessage());
		}

		return listVeiculo;

	}

	public Boolean excluir(Veiculo veiculo) { // parametro (
		Boolean excluirVeiculo = false;
		try {
			if (existeArquivo()) {

				ArrayList<String> veicListGravar = new ArrayList<>();
				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");

					if (veiculo.getPlaca().equals(linha_split[3])) {
						veicListGravar.add(linha);
					} else {
						excluirVeiculo = true;
					}
				}
				arquivoLeitura.close();
				memoriaLeitura.close();

				escreverArquivo = new FileWriter(arquivo, false);
				memoriaEscrita = new BufferedWriter(escreverArquivo);
				for (String novaLinha : veicListGravar) {
					memoriaEscrita.write(novaLinha);
					memoriaEscrita.newLine();
				}
				memoriaEscrita.close();

			} else {
				return false;
			}

		} catch (IOException e) {
			System.out.println(e.getMessage());

		}

		return excluirVeiculo;

	}

	public Boolean atualizar(Veiculo veiculo) {
		Boolean atualizouVeiculo = false;
		try {
			if (existeArquivo()) {

				ArrayList<String> veicListGravar = new ArrayList<>();
				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");
					if (veiculo.getPlaca().equals(linha_split[3])) {
						String novaLinha = linha_split[0] + ";" + veiculo.getAno() + ";" + veiculo.getMarca() + ";"
								+ linha_split[3];
						veicListGravar.add(novaLinha);
						atualizouVeiculo = true;
					} else {
						veicListGravar.add(linha);
					}
				}
				arquivoLeitura.close();
				memoriaLeitura.close();

				escreverArquivo = new FileWriter(arquivo, false);
				memoriaEscrita = new BufferedWriter(escreverArquivo);

				for (String novaLinha : veicListGravar) {
					memoriaEscrita.write(novaLinha);
					memoriaEscrita.newLine();
				}
				memoriaEscrita.close();
			} else {
				return false;
			}
		} catch (FileNotFoundException e) {
		} catch (IOException e) {
		}
		return atualizouVeiculo;
	}

	private Boolean existeArquivo() {

		return arquivo.exists();

	}

	private Boolean criarArquivo() {

		try {

			// if (arquivo.exists())
			return arquivo.createNewFile();

		} catch (IOException error) {
			System.out.println("ocorreu um erro a criar o arquivo \n" + error.getMessage());
			return false;
		}

	}
}
