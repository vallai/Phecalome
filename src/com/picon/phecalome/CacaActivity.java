package com.picon.phecalome;

import java.sql.Timestamp;
import java.util.Calendar;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.picon.bdd.Caca;
import com.picon.bdd.CacaDAO;

public class CacaActivity extends Activity implements View.OnClickListener {
	
	private CacaDAO dao;

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
		
		// BDD
		dao = new CacaDAO(this);
	}

	@Override
	public void onClick(View v) {
		Timestamp now = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		switch (v.getId()) {
		case R.id.layout_caca_1 :
			dao.ecrireCaca(new Caca(now.getTime(), 1));
			Toast.makeText(CacaActivity.this, "Caca 1 inser�", Toast.LENGTH_SHORT).show();
			break;
		case R.id.layout_caca_2 : 
			dao.ecrireCaca(new Caca(now.getTime(), 2));
			Toast.makeText(CacaActivity.this, "Caca 2 inser�", Toast.LENGTH_SHORT).show();
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
