package br.com.casa.notas;

import android.os.Bundle;
import android.app.TabActivity;
import android.content.Intent;
import android.widget.TabHost;

public class MainActivity extends TabActivity {

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		TabHost tbHost = getTabHost();
		TabHost.TabSpec Spec;
		Intent intent;
		intent = new Intent().setClass(this, AppTela1.class);
		Spec = tbHost.newTabSpec("tab1").setIndicator("Segunda")
				.setContent(intent);
		tbHost.addTab(Spec);

		intent = new Intent().setClass(this, AppTela2.class);
		Spec = tbHost.newTabSpec("tab2").setIndicator("Terça")
				.setContent(intent);
		tbHost.addTab(Spec);

		intent = new Intent().setClass(this, AppTela3.class);

		Spec = tbHost.newTabSpec("tab3").setIndicator("Quarta")
				.setContent(intent);
		tbHost.addTab(Spec);

		intent = new Intent().setClass(this, AppTela4.class);
		Spec = tbHost.newTabSpec("tab4").setIndicator("Quinta")
				.setContent(intent);
		tbHost.addTab(Spec);

		intent = new Intent().setClass(this, AppTela5.class);
		Spec = tbHost.newTabSpec("tab5").setIndicator("Sexta")
				.setContent(intent);
		tbHost.addTab(Spec);

		intent = new Intent().setClass(this, AppTela6.class);
		Spec = tbHost.newTabSpec("tab6").setIndicator("Sabado")
				.setContent(intent);
		tbHost.addTab(Spec);
		tbHost.setCurrentTab(0);
	}

}
