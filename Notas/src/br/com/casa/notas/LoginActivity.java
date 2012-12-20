package br.com.casa.notas;

import br.com.Auxiliares.User;
import br.com.Conexao.PegaDados;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;
import android.app.AlertDialog.Builder;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.Spinner;

public class LoginActivity extends Activity {

	private User user;

	private EditText edTia;
	private EditText senha;
	private Spinner spinner;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		user = User.getInstance();

		preencherSpinner();

		edTia = (EditText) findViewById(R.id.Tia);
		senha = (EditText) findViewById(R.id.senha);

		
	}

	public void logar(View view) {

		StringBuffer valorTia = new StringBuffer(edTia.getText().toString());
		int tia = Integer.parseInt(valorTia.toString());
		user.setTia(tia);

		user.setSenha(senha.getText().toString());

		if ((PegaDados.getInstance().existe(User.getInstance()))
				|| (edTia.getText().toString() == "")
				|| (senha.getText().toString() == "")) {
			Intent i = new Intent(LoginActivity.this, MenuActivity.class);
			startActivity(i);
			finish();
		} else {
			exibeMensagem("Erro", "Usuario ou senha Incorretos");
		}

		// exibeMensagemLogado(new PegaDados().existe(User.getInstance()));

	}

	public void preencherSpinner() {
		spinner = (Spinner) findViewById(R.id.spinnerUnidade);

		spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> parent, View Parent,
					int posicao, long id) {

				StringBuffer unidade = new StringBuffer();
				unidade.append((String) spinner.getItemAtPosition(posicao));

				String valor = "001";
				// valor 1 para São Paulo, Tamboré, Campinas e recife

				if (unidade.toString().equals("Brasilia"))
					valor = "003";
				else if (unidade.toString().equals("Rio de Janeiro"))
					valor = "006";
				else if (unidade.toString().equals("AEJA"))
					valor = "010";

				user.setUnidade(valor.toString());

			}

			public void onNothingSelected(AdapterView<?> arg0) {

			}
		});
	}

	public void exibeMensagem(String titulo, String msn) {
		AlertDialog.Builder dialogo = new Builder(LoginActivity.this);
		dialogo.setTitle(titulo);
		dialogo.setMessage(msn);
		dialogo.setNeutralButton("Sair", null);
		dialogo.show();
	}

	public void exibeMensagemLogado(boolean value) {
		AlertDialog.Builder dialogo = new Builder(LoginActivity.this);
		dialogo.setTitle("Resultado");
		dialogo.setMessage("Valor: " + String.valueOf("" + value));
		dialogo.setNeutralButton("Ok", null);
		dialogo.show();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.activity_login, menu);
		return true;
	}
}
