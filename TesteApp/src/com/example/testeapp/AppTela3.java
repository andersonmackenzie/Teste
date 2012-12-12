package com.example.testeapp;

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

public class AppTela3 extends Activity {
	public ListView lista3;

	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.tela3);

		List<String> teste = new Tratamento().tabelaDados();
		String[] contatos = { teste.get(10).toString(),
				teste.get(17).toString(), teste.get(24).toString(),
				teste.get(31).toString(), teste.get(38).toString(),
				teste.get(45).toString() };

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, contatos);
		lista3 = (ListView) findViewById(R.id.lista3);
		lista3.setAdapter(adapter);

		lista3.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView arg0, View arg1, View arg2,
					long arg3) {
				if (lista3.getSelectedItem() != null) {
					AlertDialog.Builder dialogo = new AlertDialog.Builder(
							AppTela3.this);
					dialogo.setTitle("");
					dialogo.setMessage(lista3.getSelectedItem().toString());
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
