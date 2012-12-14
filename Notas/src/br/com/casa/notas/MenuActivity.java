package br.com.casa.notas;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;

public class MenuActivity extends Activity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.menu_act2);

	}

	public void goHorario(View view) {
		Intent i = new Intent(MenuActivity.this, MainActivity.class);
		startActivity(i);
	}

	public void goNotas(View view) {
		// Intent i = new Intent(MenuActivity.this, NotasActivity.class);
		// startActivity(i);
	}

	public void sair(View view) {
		Intent i = new Intent(MenuActivity.this, LoginActivity.class);
		startActivity(i);
		finish();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

	@Override
	public void onDestroy() {

		super.onDestroy();

		Log.d("Cadastro", "Fechando");

	}

}
