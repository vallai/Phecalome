package com.picon.phecalome;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		// Evenements sur les boutons
		Button bouton_caca = (Button) findViewById(R.id.caca_button);
		bouton_caca.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.caca_button : 
			Intent intentCaca = new Intent(MainActivity.this, CacaActivity.class);
			startActivity(intentCaca);
			break;
		}
	}
}
