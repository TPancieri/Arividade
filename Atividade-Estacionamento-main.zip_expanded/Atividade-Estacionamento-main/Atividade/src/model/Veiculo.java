package model;

public class Veiculo {

	private int ano;
	private int id;
	private String placa;
	private String marca;

	public void setAno(int ano) {
		this.ano = ano;
	}

	public int getAno() {
		return ano;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setPlaca(String placa) {
		this.placa = placa;
	}

	public String getPlaca() {
		return placa;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}
	@Override
	public String toString() {
		return "ID: " + Integer.toString(getId()) + "ANO: " + Integer.toString(getAno()) + " | Marca : " + getMarca() + " | Placa: " + getPlaca();

	}
}
