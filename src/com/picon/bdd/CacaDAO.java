package com.picon.bdd;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import android.content.Context;
import android.os.Environment;

public class CacaDAO {

	private String PATH;
	private String FICHIER = "mes_cacas_de_ouf.txt";
	private File mFile = null;
//	private Context c;

	public CacaDAO(Context c) {
//		this.c = c;
//		
		// On cr�e un fichier qui correspond � l'emplacement ext�rieur
		PATH = Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + c.getPackageName() + "/files/";
		
		// Create the parent path
		File dir = new File(PATH);
		if (!dir.exists()) {
		    dir.mkdirs();
		}

		mFile = new File(PATH + FICHIER);

	}
	
 

	public void ecrire() {
		try {

			// Si le fichier est lisible et qu'on peut �crire dedans
			if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
					&& !Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())) {;
				// On cr�e un nouveau fichier. Si le fichier existe d�j�, il ne sera pas cr��
				mFile.createNewFile();
				FileOutputStream output = new FileOutputStream(mFile, true);
				output.write("date,puissance\n".getBytes());
				if(output != null) {
					output.close();
				}
				System.out.println("Caca ins�r�");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void lire() {
		try {
			if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
				int value;
				StringBuffer lu = new StringBuffer();
				FileInputStream input = new FileInputStream(mFile);
				while((value = input.read()) != -1)
					lu.append((char)value);

				System.out.println("Fichier lu : " + lu);
				if(input != null)
					input.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static final String TABLE_NAME = "caca";
	public static final String KEY = "id";
	public static final String DATE = "date";
	public static final String PUISSANCE = "puissance";

	public static final String TABLE_CREATE = "CREATE TABLE " + TABLE_NAME + " (" + KEY + " INTEGER PRIMARY KEY AUTOINCREMENT, " + DATE + " INTEGER, " + PUISSANCE + " INTEGER);";

	public static final String TABLE_DROP =  "DROP TABLE IF EXISTS " + TABLE_NAME + ";";

	/**
	 * @param c le caca � ajouter � la base
	 */
	public void ajouter(Caca c) {

	}

	/**
	 * @param id l'identifiant du caca � supprimer
	 */
	public void supprimer(long id) {

	}

	/**
	 * @param c le caca modifi�
	 */
	public void modifier(Caca c) {

	}


	public ArrayList<Caca> getAll() {
		return null;
	}

	/**
	 * @param id l'identifiant du caca � r�cup�rer
	 */
	public Caca getById(long id) {

		return null;
	}
}