package br.com.casa.notas;

import java.util.List;

import br.com.Conexao.Tratamento;
import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.AdapterView.OnItemClickListener;

public class AppTela2 extends Activity {
	public ListView listaI2;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela2);

		List<String> teste = new Tratamento().tabelaDados();
		ArrayAdapter<String> adapter;
		if (teste.size() > 5) {

			String[] contatos = { teste.get(9).toString(),
					teste.get(16).toString(), teste.get(23).toString(),
					teste.get(30).toString(), teste.get(37).toString(),
					teste.get(44).toString() };

			adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, contatos);
		} else {

			String[] contatos = { "Não existem dados" };
			adapter = new ArrayAdapter<String>(this,
					android.R.layout.simple_list_item_1, contatos);
		}

		listaI2 = (ListView) findViewById(R.id.lista2);
		listaI2.setAdapter(adapter);

		listaI2.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView arg0, View arg1, View arg2,
					long arg3) {
				if (listaI2.getSelectedItem() != null) {
					AlertDialog.Builder dialogo = new AlertDialog.Builder(
							AppTela2.this);
					dialogo.setTitle("");
					dialogo.setMessage(listaI2.getSelectedItem().toString());
					dialogo.setNeutralButton("OK", null);
					dialogo.show();
				}

			}

			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {

			}

		});

	}

}
