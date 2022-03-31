package model;

public class TipoVeiculo {

	private int id;
	private String descricao;

	public void setNome(int id) {
		this.id = id;
	}

	public int get() {
		return id;

	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getDescricao() {
		return descricao;
	}

}
