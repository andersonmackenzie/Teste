package br.com.Conexao;

import java.util.List;

public class ListasDados {
	public static List<String> segunda;
	public static List<String> terca;
	public static List<String> quarta;
	public static List<String> quinta;
	public static List<String> sexta;
	public static List<String> sabado;

	public ListasDados() {
		List<String> lista = new Tratamento().tabelaDados();

	}

}
