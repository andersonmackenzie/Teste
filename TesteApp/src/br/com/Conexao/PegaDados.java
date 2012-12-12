package br.com.Conexao;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.client.params.AuthPolicy;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

import br.com.Auxiliares.User;

public class PegaDados {

	public StringBuilder recebe() {

		DefaultHttpClient httpclient = new DefaultHttpClient();

		List<String> authpref = new ArrayList<String>();
		authpref.add(AuthPolicy.BASIC);

		User user = User.getInstance();

		HttpPost httpget = new HttpPost(
				"http://www3.mackenzie.com.br/tia/verifica.php?alumat="
						+ user.getTia() + "&pass=" + user.getSenha()
						+ "&unidade=" + user.getUnidade());

		StringBuilder conteudo = new StringBuilder();
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

		return conteudo;
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

			if (contador > 150)
				return true;
			return false;

		} catch (ClientProtocolException e) {
			e.printStackTrace();
			return false;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}

	}

}
