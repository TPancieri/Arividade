package model;

public class Pessoa {

	private String nome;
	private String telefone;
	private String email;
	private int id;

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEmail() {
		return email;
	}
	@Override
	public String toString() {
		return "ID: " + Integer.toString(getId()) +  " | Nome: " + getNome() + " | Telefone : " + getTelefone() + " | Email : " + getEmail();
}
}