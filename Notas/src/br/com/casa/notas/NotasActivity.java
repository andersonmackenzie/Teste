package br.com.casa.notas;

import android.os.Bundle;
import android.app.ActivityGroup;
import android.content.Intent;
import android.content.res.Resources;
import android.view.Menu;
import android.widget.TabHost;

public class NotasActivity extends ActivityGroup {
	static TabHost tabHost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_notas);

		Resources res = getResources();
		tabHost = (TabHost) findViewById(R.layout.activity_tab_nota);
		tabHost.setup(this.getLocalActivityManager());
		TabHost.TabSpec spec;
		Intent i;
		// Tab #1
		i = new Intent().setClass(this, AppTelaNota.class);
		i.putExtra("tab", "0");
		
		spec = tabHost.newTabSpec("0").setIndicator("Tab 1").setContent(i);
		tabHost.addTab(spec);

	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
			getMenuInflater().inflate(R.menu.activity_notas, menu);
		return true;
	}

}
