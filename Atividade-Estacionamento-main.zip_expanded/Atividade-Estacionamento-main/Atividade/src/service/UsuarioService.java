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

public class UsuarioService {

	private final String userDB = "C:\\Users\\thiag\\eclipse-workspace\\Atividade-Estacionamento-main.zip_expanded\\Atividade-Estacionamento-main\\Atividade\\src\\data_base\\usuario.txt" ; //"src/data_base/usuario.txt";
	private FileReader arquivoLeitura;
	private BufferedReader memoriaLeitura;
	private File arquivo;
	private FileWriter escreverArquivo;
	private BufferedWriter memoriaEscrita;

	public UsuarioService() {
		try {
			arquivoLeitura = new FileReader(userDB);
			memoriaLeitura = new BufferedReader(arquivoLeitura);
			arquivo = new File(userDB);
		} catch (FileNotFoundException e) {
			System.out.println("nao foi possivel abrir o arquivo");
			System.out.println("erro : " + e.getMessage());
		}

	}

	public Boolean escrever(Usuario usuario) {
		try {
			if (existeArquivo()) {

				int contadorLinha = 0;
				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {

					contadorLinha = contadorLinha + 1;

				}

				contadorLinha = contadorLinha + 1;

				String dadoParaEscrever = contadorLinha + ";" + usuario.getLogin() + ";" + usuario.getSenha() ;

				escreverArquivo = new FileWriter(arquivo, true);
				memoriaEscrita = new BufferedWriter(escreverArquivo);

				memoriaEscrita.write(dadoParaEscrever);
				memoriaEscrita.newLine();

				memoriaEscrita.close();

				return true;

			} else {
				criarArquivo();
				escrever(usuario); // recursao
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

	public Boolean ler(Usuario usuario) {
		try {
			if (existeArquivo()) {

				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");
					if (usuario.getLogin().equals(linha_split[1])) {
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

	public ArrayList<Usuario> ler() {
		ArrayList<Usuario> listUser = new ArrayList<>();
		try {
			if (existeArquivo()) {

				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");
					Usuario usuario = new Usuario();
					usuario.setId(Integer.parseInt(linha_split[0])); // id
					usuario.setLogin(linha_split[1]); // username
					usuario.setSenha(linha_split[2]);// password

					listUser.add(usuario);
				}
			}
		} catch (FileNotFoundException e) {
			System.out.println("arquivo nao encontrado");
			System.out.println(e.getMessage());
		} catch (IOException e) {
			System.out.println("nao foi possivel ler o arquivo");
			System.out.println(e.getMessage());
		}

		return listUser;

	}

	public Boolean excluir(Usuario usuario) { // parametro (
		Boolean excluirUser = false;
		try {
			if (existeArquivo()) {

				ArrayList<String> userListGravar = new ArrayList<>();
				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");

					if (usuario.getLogin().equals(linha_split[1])) {
						userListGravar.add(linha);
					} else {
						excluirUser = true;
					}
				}
				arquivoLeitura.close();
				memoriaLeitura.close();

				escreverArquivo = new FileWriter(arquivo, false);
				memoriaEscrita = new BufferedWriter(escreverArquivo);
				for (String novaLinha : userListGravar) {
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

		return excluirUser;

	}

	public Boolean atualizar(Usuario usuario) {
		Boolean atualizouUser = false;
		try {
			if (existeArquivo()) {

				ArrayList<String> userListGravar = new ArrayList<>();
				String linha = null;
				while ((linha = memoriaLeitura.readLine()) != null) {
					String[] linha_split = linha.split(";");
					if (usuario.getLogin().equals(linha_split[1])) {
						String novaLinha = linha_split[0] + ";" + linha_split[1] + ";" + usuario.getSenha();
						userListGravar.add(novaLinha);
						atualizouUser = true;
					} else {
						userListGravar.add(linha);
					}
				}
				arquivoLeitura.close();
				memoriaLeitura.close();

				escreverArquivo = new FileWriter(arquivo, false);
				memoriaEscrita = new BufferedWriter(escreverArquivo);

				for (String novaLinha : userListGravar) {
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
		return atualizouUser;
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
