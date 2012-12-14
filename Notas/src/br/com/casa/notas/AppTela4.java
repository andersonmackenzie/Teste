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

public class AppTela4 extends Activity {
	public ListView lista4;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela4);

		List<String> teste = new Tratamento().tabelaDados();
		String[] contatos = { teste.get(11).toString(),
				teste.get(18).toString(), teste.get(25).toString(),
				teste.get(32).toString(), teste.get(39).toString(),
				teste.get(46).toString() };

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, contatos);
		lista4 = (ListView) findViewById(R.id.lista4);
		lista4.setAdapter(adapter);

		lista4.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView arg0, View arg1, View arg2,
					long arg3) {
				if (lista4.getSelectedItem() != null) {
					AlertDialog.Builder dialogo = new AlertDialog.Builder(
							AppTela4.this);
					dialogo.setTitle("");
					dialogo.setMessage(lista4.getSelectedItem().toString());
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
