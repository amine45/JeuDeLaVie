package JeuDeLaVie;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Décrire la classe !
 * 
 * 
 */
public class Univers {

	/**
	 * La liste des cellules vivantes
	 */
	private ArrayList<Cellule> lemonde;

	/**
	 * La liste des cellules mortes
	 */
	private ArrayList<Cellule> celmortes;

	/**
	 * La ligne de la 1ère cellule du fichier lif. Sert pour l'affichage.
	 */
	private int minligne;

	/**
	 * La colonne de la 1ère cellule du fichier lif. Sert pour l'affichage.
	 */
	private int mincolonne;

	/**
	 * Le nombre de lignes maximales du fichier lif. Sert pour l'affichage.
	 */
	private int nbligne;

	/**
	 * Le nombre de colonnes maximales du fichier lif. Sert pour l'affichage.
	 */
	private int nbcolonne;

	/**
	 * Constructeur Univers.
	 * <p>
	 * A la construction d'un Univers, on initialise les deux listes.
	 * </p>
	 * 
	 */
	public Univers() {
		lemonde = new ArrayList<Cellule>();
		celmortes = new ArrayList<Cellule>();
	}

	/**
	 * Constructeur Univers à partir d'un fichier lif.
	 * <p>
	 * A la construction d'un Univers, on initialise la 1ere cellule selon le
	 * monde: l'id_monde 1 représente le monde infini on initialise la 1ère
	 * cellule au coordonnée notée après #P, l'id_monde 2 représente le monde
	 * circulaire on initialise la 1ère cellule au coordonnée (0,0) et
	 * l'id_monde 3 représente le monde frontiere on initialise la 1ère cellule
	 * au coordonnée (0,0).
	 * </p>
	 * 
	 */
	public Univers(String file, int id_monde) {

		lemonde = new ArrayList<Cellule>();
		celmortes = new ArrayList<Cellule>();
		this.nbligne = 0;
		this.nbcolonne = 0;

		File f = new File(file);
		Scanner sc = null;
		int numligne = 0, numcolonne = 0, maxligne = 0;

		try {
			sc = new Scanner(f);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		String ligne = sc.nextLine();

		boolean inutile = true;

		while (sc.hasNextLine() && inutile) {
			if (ligne.charAt(0) == '#' && ligne.charAt(1) != 'P') {
				ligne = sc.nextLine();
			} else {
				inutile = false;
			}
		}

		Scanner st = new Scanner(ligne);
		String c1;
		c1 = st.next();
// throw Exception in case it's not an Integer 
		if (c1.equals("#P")) {
			if (id_monde == 1) {
				try{
				numligne = Integer.parseInt(st.next());
				this.minligne = numligne;
				numcolonne = Integer.parseInt(st.next());
				this.mincolonne = numcolonne;}catch(Exception e){System.out.println("Error input ");}
			} else {
				minligne = 0;
				mincolonne = 0;
			}
		}
		numligne = minligne;
		while ((sc.hasNextLine() && (ligne = sc.nextLine()) != null && ligne
				.length() > 0)) {
			numcolonne = this.mincolonne;
			for (int i = 0; i <= ligne.length() - 1; i++) {
				if (ligne.charAt(i) == '*') {
					Cellule a = new Cellule(new Coordonnees(numligne,
							numcolonne), "vivante");
					lemonde.add(a);
				}

				numcolonne++;

				if (ligne.length() > this.nbcolonne) {
					this.nbcolonne = ligne.length();

				}

			}
			numligne++;
			maxligne++;
			if (maxligne > this.nbligne) {
				this.nbligne = maxligne;
			}

		}
	}

	/**
	 * Retourne la cellule dont les coordonnées sont égales au coordonnées
	 * passées en paramètre. Si la cellule n'existe pas, on la crée.
	 * 
	 * @param s
	 *            Les coordonnées à chercher.
	 * 
	 * @return la cellule correspondante au coordonnées passées en paramètre.
	 * 
	 * 
	 */
	public Cellule cellExists(Coordonnees s) {
		if (s.valide) {
			Iterator<Cellule> it = lemonde.iterator();
			while (it.hasNext()) {
				Cellule cel1 = (Cellule) it.next();
				if (cel1.getCoord().x == s.x && cel1.getCoord().y == s.y
						&& cel1.getEtat().equals("vivante"))
					return cel1;
			}
			Iterator<Cellule> it2 = celmortes.iterator();
			while (it2.hasNext()) {
				Cellule cel2 = (Cellule) it2.next();
				if (cel2.getCoord().x == s.x && cel2.getCoord().y == s.y)
					return cel2;
			}
		}
		return new Cellule(new Coordonnees(s.x, s.y), "morte");
	}

	/**
	 * Ajoute les 8 cellules voisines de chaques cellules vivantes. Puis on
	 * compte les cellules vivantes parmi les 8 pour leur attribuer un état
	 * suivant.
	 * 
	 */

	public void addDeadCells() {
		int i, j, dx, dy;
		int nb = 0;
		Iterator<Cellule> it = this.lemonde.iterator();
		Cellule[] tab = new Cellule[8];
		while (it.hasNext()) {
			Cellule a = it.next();
			if (a.getEtat().equals("vivante")) {
				nb = 0;
				int f = 0;
				i = a.getCoord().x - 1;
				j = a.getCoord().y - 1;
				for (int e = 0; e < 9; e++) {
					dx = i + (e % 3);
					dy = j + (e / 3);

					if (dx != i + 1 || dy != j + 1) {
						if (checkCoord(dx, dy).valide) {
							tab[f] = cellExists(checkCoord(dx, dy));
						} else {
							tab[f] = null;
						}
						f++;
					}
				}

				for (int p = 0; p <= tab.length - 1; p++) {
					if (tab[p] != null && tab[p].getEtat().equals("morte")
							&& !(this.celmortes.contains(tab[p])))
						this.celmortes.add(tab[p]);
				}

				for (int n = 0; n <= tab.length - 1; n++) {
					if (tab[n] != null && tab[n].getEtat().equals("vivante")) {
						nb++;
					}

				}

				if (nb == 2 || nb == 3) {
					a.setEtat_suivant(a.getEtat());
				} else {
					a.setEtat_suivant("morte");
				}
			}
		}
	}

	/**
	 * Ajoute les 8 cellules voisines de chaques cellules mortes. Puis on compte
	 * les cellules vivantes parmi les 8 pour leur attribuer un état suivant.
	 * 
	 */
	public void verifyListDeadCells() {
		int i, j, dx, dy;
		int cp = 0;
		Iterator<Cellule> it = this.celmortes.iterator();
		Cellule[] tab = new Cellule[8];
		while (it.hasNext()) {
			Cellule a = (Cellule) it.next();
			cp = 0;
			int f = 0;
			i = a.getCoord().x - 1;
			j = a.getCoord().y - 1;

			for (int e = 0; e < 9; e++) {
				dx = i + (e % 3);
				dy = j + (e / 3);
				if (dx != i + 1 || dy != j + 1) {
					tab[f] = cellExists(checkCoord(dx, dy));
					f++;
				}
			}
			for (int p = 0; p <= tab.length - 1; p++) {
				if (tab[p] != null && tab[p].getEtat().equals("vivante"))
					cp++;
			}
			if (cp == 3)
				a.setEtat_suivant("vivante");
			else
				a.setEtat_suivant(a.getEtat());
		}
	}

	/**
	 * Change les états des cellules. Supprime dans la liste des cellules
	 * vivantes, les cellules devenues mortes. Ajoute dans la liste des cellules
	 * vivantes, les cellules devenues vivantes et les supprime de la liste des
	 * cellules mortes.
	 * 
	 */

	public void changeState() {
		Iterator<Cellule> it = this.lemonde.iterator();
		while (it.hasNext()) {
			Cellule a = it.next();
			a.setEtat(a.getEtat_suivant());
			a.setEtat_suivant(" ");

		}
		Iterator<Cellule> it3 = this.lemonde.iterator();
		while (it3.hasNext()) {
			Cellule a = (Cellule) it3.next();
			if (a.getEtat().equals("morte")) {
				it3.remove();
			}
		}
		Iterator<Cellule> it2 = this.celmortes.iterator();
		while (it2.hasNext()) {
			Cellule a = (Cellule) it2.next();
			a.setEtat(a.getEtat_suivant());
			a.setEtat_suivant(" ");
			if (a.getEtat().equals("vivante")) {
				this.lemonde.add(new Cellule(new Coordonnees(a.getCoord().x, a
						.getCoord().y), a.getEtat()));
				it2.remove();
			}
		}
		Collections.sort(this.lemonde);
	}

	/**
	 * Permet d'afficher l'univers sous forme de tableau. Les cellules vivantes
	 * sont représentées par des "*". Pour le monde infini on affiche que la
	 * taille maximale du fichier lif.
	 * 
	 */
	public void display() {
		for (int i = minligne; i <= (minligne + nbligne) - 1; i++) {
			for (int j = mincolonne; j <= (mincolonne + nbcolonne) - 1; j++) {
				if (isPresent(i, j)) {
					System.out.print("| * |");
				} else {
					System.out.print("|   |");
				}
			}
			System.out.println();
		}
	}

	/**
	 * Permet de tester si la cellule au coordonnées i et j est présente dans la
	 * liste des cellules vivantes. Comme la liste est toujours triée, on arrête
	 * la boucle dès que l'on a dépassé la ligne correspondante.
	 * 
	 * @param i
	 *            la ligne
	 * 
	 * @param j
	 *            la colonne
	 * 
	 * @return true si la cellule est présente dans la liste, false sinon.
	 */
	public boolean isPresent(int i, int j) {
		Iterator<Cellule> it = lemonde.iterator();
		boolean beforepoint = true;
		while (it.hasNext() && beforepoint) {
			Cellule a = it.next();
			if (a.getCoord().x > i)
				// Arreter le programme dès qu'on dépasse la ligne (ArrayList
				// trié )
				beforepoint = false;
			if (a.getCoord().x == i && a.getCoord().y == j) {
				return true;
			}
		}
		return false;
	}

	/**
	 * Retourne la coordonnées construite à partir des paramètres.
	 * 
	 * @param a
	 *            la ligne
	 * 
	 * @param b
	 *            la colonne
	 * 
	 * @return la coordonnée avec la ligne a et la colonne b.
	 */
	public Coordonnees checkCoord(int a, int b) {
		return new Coordonnees(a, b);
	}

	/**
	 * Calcule une nouvelle génération en utilisant les différentes méthodes.
	 * 
	 */
	public void nextGeneration() {
		this.addDeadCells();
		this.verifyListDeadCells();
		this.changeState();
	}

	/**
	 * 
	 * @return la liste des cellules vivantes.
	 * 
	 */
	public ArrayList<Cellule> getLemonde() {
		return lemonde;
	}

	/**
	 * 
	 * @return la liste des cellules mortes.
	 * 
	 */
	public ArrayList<Cellule> getCelmortes() {
		return celmortes;
	}

	/**
	 * 
	 * @return la ligne de la 1ère cellule du fichier lif.
	 * 
	 */

	public int getMinligne() {
		return minligne;
	}

	/**
	 * 
	 * @return la colonne de la 1ère cellule du fichier lif.
	 * 
	 */
	public int getMincolonne() {
		return mincolonne;
	}

	/**
	 * 
	 * @return le nombre de lignes maximales du fichier lif.
	 * 
	 */
	public int getNbligne() {
		return nbligne;
	}

	/**
	 * 
	 * @return le nombre de colonnes maximales du fichier lif.
	 * 
	 */
	public int getNbcolonne() {
		return nbcolonne;
	}

	/**
	 * Met à jour la liste des cellules vivantes.
	 * 
	 * @param lemonde
	 *            La nouvelle liste.
	 */
	public void setLemonde(ArrayList<Cellule> lemonde) {
		this.lemonde = lemonde;
	}

	/**
	 * Met à jour la liste des cellules mortes.
	 * 
	 * @param celmortes
	 *            La nouvelle liste.
	 */
	public void setCelmortes(ArrayList<Cellule> celmortes) {
		this.celmortes = celmortes;
	}

	/**
	 * Met à jour la ligne de la 1ère cellule.
	 * 
	 * @param minligne
	 *            La nouvelle ligne
	 */
	public void setMinligne(int minligne) {
		this.minligne = minligne;
	}

	/**
	 * Met à jour la colonne de la 1ère cellule.
	 * 
	 * @param mincolonne
	 *            La nouvelle colonne
	 */
	public void setMincolonne(int mincolonne) {
		this.mincolonne = mincolonne;
	}

	/**
	 * Met à jour le nombre maximales de lignes du fichier lif.
	 * 
	 * @param nbligne
	 *            Le nouveau nombre
	 */
	public void setNbligne(int nbligne) {
		this.nbligne = nbligne;
	}

	/**
	 * Met à jour le nombre maximales de colonnes du fichier lif.
	 * 
	 * @param nbcolonne
	 *            Le nouveau nombre
	 */
	public void setNbcolonne(int nbcolonne) {
		this.nbcolonne = nbcolonne;
	}

}