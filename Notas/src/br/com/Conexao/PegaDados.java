package br.com.Conexao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.AuthPolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import br.com.Auxiliares.User;

public class PegaDados {
	private StringBuilder conteudo = new StringBuilder();
	private static PegaDados instance;
	private StringBuilder conteudoNotas = new StringBuilder();

	private PegaDados() {
		recebeNotas();
	}

	public void recebe() {

		DefaultHttpClient httpclient = new DefaultHttpClient();

		User user = User.getInstance();

		List<String> authpref = new ArrayList<String>();
		authpref.add(AuthPolicy.BASIC);

		HttpPost httpget = new HttpPost(

		"http://www3.mackenzie.com.br/tia/verifica.php?alumat=" + user.getTia()
				+ "&pass=" + user.getSenha() + "&unidade=" + user.getUnidade());

		HttpResponse response;
		try {
			response = httpclient.execute(httpget);

			HttpEntity entity = response.getEntity();

			if (entity != null) {
				EntityUtils.toString(entity);
			}

			HttpPost httpget2 = new HttpPost(
					"http://www3.mackenzie.com.br/tia/horarChamada.php");

			response = httpclient.execute(httpget2);

			if (entity != null) {

				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));
				String line = "";

				while ((line = rd.readLine()) != null) {
					conteudo.append(line);
				}
				httpclient.getConnectionManager().shutdown();
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// return conteudo;
	}

	public void recebeNotas() {
		DefaultHttpClient httpclient = new DefaultHttpClient();

		User user = User.getInstance();

		List<String> authpref = new ArrayList<String>();
		authpref.add(AuthPolicy.BASIC);

		HttpPost httpget = new HttpPost(

		"http://www3.mackenzie.com.br/tia/verifica.php?alumat=" + user.getTia()
				+ "&pass=" + user.getSenha() + "&unidade=" + user.getUnidade());

		conteudo = new StringBuilder();
		HttpResponse response;
		try {
			response = httpclient.execute(httpget);

			HttpEntity entity = response.getEntity();

			if (entity != null) {
				EntityUtils.toString(entity);
			}
			HttpPost httpget2 = new HttpPost(
					"http://www3.mackenzie.com.br/tia/notasChamada.php");

			response = httpclient.execute(httpget2);

			if (entity != null) {

				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));
				String line = "";

				while ((line = rd.readLine()) != null) {
					conteudoNotas.append(line);
				}

				httpclient.getConnectionManager().shutdown();
			}

		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

		// return conteudo;
	}

	public List<StringBuffer> getDadosNotas() {

		StringBuilder html = getConteudoNotas();

		Document doc = Jsoup.parse(html.toString());

		Element table = doc.select("table[id=mytable]").first();

		Iterator<Element> ite = table.select("td").iterator();

		List<StringBuffer> listaNotas = new ArrayList<StringBuffer>();
		int i = 0;
		StringBuffer saida;
		while (ite.hasNext()) {
			saida = new StringBuffer();
			saida.append(ite.next().text());
			if (i >= 13) {
				listaNotas.add(saida);

			}
			i++;
		}
		return listaNotas;
	}

	public boolean existe(User user) {

		DefaultHttpClient httpclient = new DefaultHttpClient();

		List<String> authpref = new ArrayList<String>();
		authpref.add(AuthPolicy.BASIC);

		HttpPost httpget = new HttpPost(
				"http://www3.mackenzie.com.br/tia/verifica.php?alumat="
						+ user.getTia() + "&pass=" + user.getSenha()
						+ "&unidade=" + user.getUnidade());

		HttpResponse response;
		try {
			response = httpclient.execute(httpget);
			HttpEntity entity = response.getEntity();

			int contador = 0;
			if (entity != null) {

				BufferedReader rd = new BufferedReader(new InputStreamReader(
						response.getEntity().getContent()));

				while (rd.readLine() != null) {
					contador++;

				}

				httpclient.getConnectionManager().shutdown();
			}

			if (contador > 150) {
				recebe(); // temporario
				recebeNotas();
				return true;

			}
			return false;

		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

	public StringBuilder getConteudo() {
		return conteudo;
	}

	public void setConteudo() {
		conteudo = new StringBuilder();
	}

	public static PegaDados getInstance() {

		if (instance == null) {
			instance = new PegaDados();

		}
		return instance;
	}

	public StringBuilder getConteudoNotas() {
		// if (conteudoNotas == null) {
		// recebeNotas();
		// }
		return conteudoNotas;
	}

}
