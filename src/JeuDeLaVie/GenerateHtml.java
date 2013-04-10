package JeuDeLaVie;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Properties;

public class GenerateHtml {

	public GenerateHtml() throws IOException {
	}

	public void openFile(String s) {
		Properties sys = System.getProperties();
		String os = sys.getProperty("os.name");
		System.out.println(os);
		Runtime r = Runtime.getRuntime();
		try {
			if (os.endsWith("NT") || os.endsWith("2000") || os.endsWith("XP")
					|| os.endsWith("Vista")) {
				r.exec("cmd /c start http://fr.wikipedia.org/wiki/Jeu_de_la_vie");
			} else {
				r.exec("firefox .//" + s);
			}
		} catch (IOException ex) {
			ex.printStackTrace();

		}
}

/***
 * Cette méthode permet d'éditer un fichier html en mettant les résultats des jeux 
 * dans un tableau 
 * @param res une ArrayList de Jeu qui contient les résultats de chaque Jeu 
 */
	public void writeFileHtml(ArrayList<Jeu> res) {
		StringBuffer html = new StringBuffer();
		try {
			FileWriter write = new FileWriter(new File("resultat.html"));
			write.write(""+resultsGame(res));
			write.close();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
 public StringBuffer resultsGame(ArrayList<Jeu> res){
	 StringBuffer html = new StringBuffer();
	html.append("<html><head><title>Resultats Jeu</title></head><body>");
	// à completer 
	html.append("</body></html>");
	return html;
 }
	public void listerFiles(String s) throws IOException {
		File fichier = new File(s);
		if (fichier.isDirectory()) {
			File[] tab = fichier.listFiles();
			// String [] tab2 = new String [3];
			for (int i = 0; i <= tab.length - 1; i++) {
				System.out.println(tab.length);
				String[] tab2 = new String[3];
				String r = "" + tab[i];
				tab2[0] = "-s";
				tab2[1] = "11";
				tab2[2] = "" + r;
				new Jeu(tab2);
			}
		} else {
			System.out.println("Directory Does Not Exist !");
		}
	}

	public void writeFileHtml() throws IOException {
		FileReader s = new FileReader("html");
		BufferedReader d = new BufferedReader(s);
		FileWriter h = new FileWriter("index.html");
		String line = d.readLine();
		while (line != null) {
			h.write(line);
			line = d.readLine();
		}
		h.write("</body></html>");
		h.close();
		d.close();
		s.close();
	}
}
