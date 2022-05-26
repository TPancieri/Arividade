package model;

public class Usuario {

	private int id; // não foi requisitado mas está presente

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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

	@Override
	public String toString() {
		return "ID: " + Integer.toString(getId()) + " | Username : " + getLogin() + " | Password : " + getSenha();

	}

}
