package com.picon.phecalome;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

public class CacaActivity extends Activity implements View.OnClickListener {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_caca);
		
		// Evenements sur les boutons caca
		RelativeLayout layout_caca_1 = (RelativeLayout) findViewById(R.id.layout_caca_1);
		layout_caca_1.setOnClickListener(this);
		
		RelativeLayout layout_caca_2 = (RelativeLayout) findViewById(R.id.layout_caca_2);
		layout_caca_2.setOnClickListener(this);
		
		RelativeLayout layout_caca_3 = (RelativeLayout) findViewById(R.id.layout_caca_3);
		layout_caca_3.setOnClickListener(this);
		
		RelativeLayout layout_caca_4 = (RelativeLayout) findViewById(R.id.layout_caca_4);
		layout_caca_4.setOnClickListener(this);
		
		RelativeLayout layout_caca_5 = (RelativeLayout) findViewById(R.id.layout_caca_5);
		layout_caca_5.setOnClickListener(this);
		
		RelativeLayout layout_caca_6 = (RelativeLayout) findViewById(R.id.layout_caca_6);
		layout_caca_6.setOnClickListener(this);
		
		RelativeLayout layout_caca_7 = (RelativeLayout) findViewById(R.id.layout_caca_7);
		layout_caca_7.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.layout_caca_1 : 
			Toast.makeText(CacaActivity.this, "Caca 1", Toast.LENGTH_LONG).show();
			break;
		case R.id.layout_caca_2 : 
			Toast.makeText(CacaActivity.this, "Caca 2", Toast.LENGTH_LONG).show();
			break;
		case R.id.layout_caca_3 : 
			Toast.makeText(CacaActivity.this, "Caca 3", Toast.LENGTH_LONG).show();
			break;
		case R.id.layout_caca_4 : 
			Toast.makeText(CacaActivity.this, "Caca 4", Toast.LENGTH_LONG).show();
			break;
		case R.id.layout_caca_5 : 
			Toast.makeText(CacaActivity.this, "Caca 5", Toast.LENGTH_LONG).show();
			break;
		case R.id.layout_caca_6 : 
			Toast.makeText(CacaActivity.this, "Caca 6", Toast.LENGTH_LONG).show();
			break;
		case R.id.layout_caca_7 : 
			Toast.makeText(CacaActivity.this, "Caca 7", Toast.LENGTH_LONG).show();
			break;
		}
	}
}
