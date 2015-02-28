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

	private String CHEMIN;
	private String FICHIER = "mes_cacas_de_ouf.txt";
	private File fichierSauvegarde = null;
	//	private Context c;

	public CacaDAO(Context c) {
		//		this.c = c;

		// On cr�e un fichier qui correspond � l'emplacement ext�rieur
		CHEMIN = Environment.getExternalStorageDirectory().getPath() + "/Android/data/" + c.getPackageName() + "/files/";
		fichierSauvegarde = new File(CHEMIN + FICHIER);

		// Si le dossier n'existe pas, creation du dossier et du fichier
		File dir = new File(CHEMIN);
		if (!dir.exists()) {
			dir.mkdirs();
			System.out.println("Le dossier a �t� cr��");
			this.creerFichier();
		}

		
	}
	
	public void creerFichier() {
		try {

			// Si le fichier est lisible et qu'on peut �crire dedans
			if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
					&& !Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())) {
				// On cr�e un nouveau fichier. Si le fichier existe d�j�, il ne sera pas cr��
				fichierSauvegarde.createNewFile();
				FileOutputStream output = new FileOutputStream(fichierSauvegarde);
				
				// Ecriture dans le fichier
				output.write("".getBytes());

				// Fermeture du fichier
				if(output != null) {
					output.close();
				}
				System.out.println("Le fichier a �t� cr��.");
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void ecrireCaca(Caca c) {
		try {

			// Si le fichier est lisible et qu'on peut �crire dedans
			if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())
					&& !Environment.MEDIA_MOUNTED_READ_ONLY.equals(Environment.getExternalStorageState())) {
				// On cr�e un nouveau fichier. Si le fichier existe d�j�, il ne sera pas cr��
				fichierSauvegarde.createNewFile();
				FileOutputStream output = new FileOutputStream(fichierSauvegarde, true);

				// Creation de la variable � entrer dans le fichier
				String caca_texte = c.getDate() + "," + c.getPuissance() + "\n";

				// Ecriture dans le fichier
				output.write(caca_texte.getBytes());

				// Fermeture du fichier
				if(output != null) {
					output.close();
				}
				System.out.println("Caca ins�r� : " + c);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public ArrayList<Caca> lireCacas() {
		ArrayList<Caca> cacas = new ArrayList<Caca>();
		try {
			if(Environment.MEDIA_MOUNTED.equals(Environment.getExternalStorageState())) {
				int value;

				// Ouverture du fichier
				StringBuffer lu = new StringBuffer();
				FileInputStream input = new FileInputStream(fichierSauvegarde);

				// Lecture du fichier caract�re par caract�re
				while((value = input.read()) != -1)
					lu.append((char)value);

				// Parse du fichier
				// Decoupe selon les lignes
				String[] lignes = lu.toString().split("\n");

				for (String ligne: lignes) {
					// Decoupe selon la virgule
					String[] elements = ligne.split(",");
					long date = Long.valueOf(elements[0]).longValue();
					int puissance = Integer.parseInt(elements[1]);
					
					// Creation du caca et ajout
					Caca c = new Caca(date, puissance);
					cacas.add(c);
				}

				if(input != null)
					input.close();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return cacas;
	}
}