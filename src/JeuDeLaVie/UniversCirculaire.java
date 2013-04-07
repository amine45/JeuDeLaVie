package JeuDeLaVie;
/**
 * 
 * Classe UniversCirculaire représente le monde circulaire , cette classe hérite de
 * Univers et donc a les memes attributs que Univers , la méthode checkCoord est redéfinie. 
 *
 */
public class UniversCirculaire extends Univers {

	public UniversCirculaire() {
		super();
	}

	public UniversCirculaire(String file, int id_monde){
		super(file,id_monde);
	}
	
	/**
	 * Retourne la coordonnée construite à partir des paramètres. Si la coordonnée dépasse du bord, 
	 * on retourne la coordonnée de la cellule du bord opposée.
	 * 
	 * @param l
	 *            la ligne
	 * @param c
	 *            la colonne
	 *            
	 * @return La ligne et la colonne sous forme de coordonnées
	 * @author Boufatah-Manivannin
	 */
	public Coordonnees checkCoord(int l, int c) { 
		Coordonnees s = new Coordonnees(l, c);
		if (c < 0 && l >= 0 && l <= this.getNbligne()-1) {
			s.x = l;
			s.y = this.getNbcolonne()-1;
		}
		if (c > this.getNbcolonne()-1 && l >= 0 && l <= this.getNbligne()-1) {
			s.x = l;
			s.y = 0;
		}
		if (c < 0 && l < 0) {
			s.x = this.getNbligne()-1;
			s.y = this.getNbcolonne()-1;
		}
		if (c > this.getNbcolonne()-1 && l > this.getNbligne()-1) {
			s.x = l;
			s.y = 0;
		}
		if (l < 0 && c >= 0 && c <= this.getNbcolonne()-1) {
			s.x = this.getNbligne()-1;
			s.y = c;
		}
		if (l < 0 && c > this.getNbcolonne()-1) {
			s.x = this.getNbligne()-1;
			s.y = 0;
		}
		if (l > this.getNbligne()-1 && c >= 0 && c <= this.getNbcolonne()-1) {
			s.x = 0;
			s.y = c;
		}
		if (c > this.getNbcolonne()-1 && l >= 0 && l <= this.getNbligne()-1) {
			s.x = l;
			s.y = 0;
		}

		if (c > this.getNbcolonne()-1 && l > this.getNbligne()-1) {
			s.x = 0;
			s.y = 0;
		}
		if (c < 0 && l > this.getNbligne()-1) {
			s.x = 0;
			s.y = this.getNbcolonne()-1;
		}
		return s;
	}
}