package com.picon.bdd;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Caca {

	private long id;
	private long date;
	private int puissance;

	public Caca (int puissance) {
		super();
		Timestamp now = new java.sql.Timestamp(Calendar.getInstance().getTime().getTime());
		this.date = now.getTime();
		this.puissance = puissance;		
	}
	
	public Caca(long date, int puissance) {
		super();
		this.date = date;
		this.puissance = puissance;
	}

	public Caca(long id, long date, int puissance) {
		super();
		this.id = id;
		this.date = date;
		this.puissance = puissance;
	}

	public long getId() {
		return this.id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public long getDate() {
		return this.date;
	}
	
	public String getDateString() {
		Timestamp t = new Timestamp(this.date);
		DateFormat formatter = new SimpleDateFormat("dd/MM HH:mm"); 
		
		String jourDeLaSemaine = "";
		switch (t.getDay()) {
		case 1 : 
			jourDeLaSemaine = "Lundi ";
			break;
		case 2 : 
			jourDeLaSemaine = "Mardi ";
			break;
		case 3 : 
			jourDeLaSemaine = "Mercredi ";
			break;
		case 4 : 
			jourDeLaSemaine = "Jeudi ";
			break;
		case 5 : 
			jourDeLaSemaine = "Vendredi ";
			break;
		case 6 : 
			jourDeLaSemaine = "Samedi ";
			break;
		case 0 : 
			jourDeLaSemaine = "Dimanche ";
			break;
		}
		return jourDeLaSemaine + formatter.format(t);
	}

	public void setDate(long date) {
		this.date = date;
	}

	public int getPuissance() {
		return this.puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}

	public String toString() {
		return  this.getDateString() + " - " + this.puissance;
	}


}