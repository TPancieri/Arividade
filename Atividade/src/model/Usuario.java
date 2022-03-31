package model;

public class Usuario {

	private int id;           //não foi requisitado mas está presente
	private String login;
	private String senha;

	public void setLogin(String login) {
		this.login = login;
	}

	public String getLogin() {
		return login;

	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getSenha() {
		return senha;
	}

}
