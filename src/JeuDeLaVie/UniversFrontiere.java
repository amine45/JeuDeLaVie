package JeuDeLaVie;
/**
 * 
 * Décrire la classe !
 *
 */
public class UniversFrontiere extends Univers {

	public UniversFrontiere() {
		super();
	}

	
	public UniversFrontiere(String file, int id_monde) {
		super(file,id_monde);
	}


	/**
	 * Retourne la coordonnée construite à partir des paramètres. Si la coordonnée dépasse du bord, 
	 * on met le booléen valide à false.
	 * 
	 * @param l
	 *            la ligne
	 * @param c
	 *            la colonne
	 *            
	 * @return La ligne et la colonne sous forme de coordonnées
	 */
	public Coordonnees checkCoord(int l, int c) {
		Coordonnees s = new Coordonnees(l, c);
		if (l < 0 || c < 0 || l >= this.getNbligne()
				|| c >= this.getNbcolonne()) {
			s.x = l;
			s.y = c;
			s.valide = false;
		}
		return s;
	}
}