package br.com.Auxiliares;

public class User {
	private int tia;
	private String senha;
	private String unidade;

	private static User singleton;

	private User() {

	}

	public int getTia() {
		return tia;
	}

	public void setTia(int tia) {
		this.tia = tia;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getUnidade() {
		return unidade;
	}

	public void setUnidade(String string) {
		this.unidade = string;
	}

	public static User getInstance() {
		if (singleton == null)
			singleton = new User();
		return singleton;

	}
}
