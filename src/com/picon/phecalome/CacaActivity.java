package com.picon.phecalome;

import java.sql.Timestamp;
import java.util.Calendar;

import android.os.Bundle;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.actionbarsherlock.app.SherlockActivity;
import com.picon.bdd.Caca;
import com.picon.bdd.CacaDAO;

public class CacaActivity extends SherlockActivity implements View.OnLongClickListener {
	
	private CacaDAO dao;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_caca);
		
		// Evenements sur les boutons caca
		RelativeLayout layout_caca_1 = (RelativeLayout) findViewById(R.id.layout_caca_1);
		layout_caca_1.setOnLongClickListener(this);
		
		RelativeLayout layout_caca_2 = (RelativeLayout) findViewById(R.id.layout_caca_2);
		layout_caca_2.setOnLongClickListener(this);
		
		RelativeLayout layout_caca_3 = (RelativeLayout) findViewById(R.id.layout_caca_3);
		layout_caca_3.setOnLongClickListener(this);
		
		RelativeLayout layout_caca_4 = (RelativeLayout) findViewById(R.id.layout_caca_4);
		layout_caca_4.setOnLongClickListener(this);
		
		RelativeLayout layout_caca_5 = (RelativeLayout) findViewById(R.id.layout_caca_5);
		layout_caca_5.setOnLongClickListener(this);
		
		RelativeLayout layout_caca_6 = (RelativeLayout) findViewById(R.id.layout_caca_6);
		layout_caca_6.setOnLongClickListener(this);
		
		RelativeLayout layout_caca_7 = (RelativeLayout) findViewById(R.id.layout_caca_7);
		layout_caca_7.setOnLongClickListener(this);
		
		// BDD
		dao = new CacaDAO(this);
	}

	@Override
	public boolean onLongClick(View v) {
		Timestamp now = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		switch (v.getId()) {
		case R.id.layout_caca_1 :
			dao.ecrireCaca(new Caca(now.getTime(), 1));
			Toast.makeText(CacaActivity.this, "Caca 1 inseré", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.layout_caca_2 : 
			dao.ecrireCaca(new Caca(now.getTime(), 2));
			Toast.makeText(CacaActivity.this, "Caca 2 inseré", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.layout_caca_3 : 
			dao.ecrireCaca(new Caca(now.getTime(), 3));
			Toast.makeText(CacaActivity.this, "Caca 3 inseré", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.layout_caca_4 : 
			dao.ecrireCaca(new Caca(now.getTime(), 4));
			Toast.makeText(CacaActivity.this, "Caca 4 inseré", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.layout_caca_5 : 
			dao.ecrireCaca(new Caca(now.getTime(), 5));
			Toast.makeText(CacaActivity.this, "Caca 5 inseré", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.layout_caca_6 : 
			dao.ecrireCaca(new Caca(now.getTime(), 6));
			Toast.makeText(CacaActivity.this, "Caca 6 inseré", Toast.LENGTH_SHORT).show();
			return true;
		case R.id.layout_caca_7 : 
			dao.ecrireCaca(new Caca(now.getTime(), 7));
			Toast.makeText(CacaActivity.this, "Caca 7 inseré", Toast.LENGTH_SHORT).show();
			return true;
		}
		return false;
	}
}
