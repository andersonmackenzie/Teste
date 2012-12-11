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

public class PegaDados {

	public StringBuffer recebe() {

		DefaultHttpClient httpclient = new DefaultHttpClient();

		List<String> authpref = new ArrayList<String>();
		authpref.add(AuthPolicy.BASIC);

		HttpPost httpget = new HttpPost(
				"http://www3.mackenzie.com.br/tia/verifica.php?alumat=31087922&pass=kjcr*74&unidade=001");

		StringBuffer conteudo = new StringBuffer();
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
}
