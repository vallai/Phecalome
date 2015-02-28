package com.picon.bdd;

public class Caca {

	private long id;
	private long date;
	private int puissance;

	public Caca(long date, int caca) {
		super();
		this.date = date;
		this.puissance = caca;
	}

	public Caca(long id, long date, int caca) {
		super();
		this.id = id;
		this.date = date;
		this.puissance = caca;
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

	public void setDate(long date) {
		this.date = date;
	}

	public int getPuissance() {
		return this.puissance;
	}

	public void setPuissance(int puissance) {
		this.puissance = puissance;
	}



}