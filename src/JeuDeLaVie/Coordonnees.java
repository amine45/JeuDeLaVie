package JeuDeLaVie;
/**
 * <b>Coordonnees est la classe qui représente la position d'une cellule.</b>
 * <p>
 * Une coordonnées est représentée par les informations suivantes:
 * </p>
 * <ul>
 * <li>Une ligne x</li>
 * <li>Une colonne y</li>
 * <li>Un booléen valide (à expliquer) </li>
 * </ul>
 * </p>
 */
public class Coordonnees {
	
	/**
	 * La ligne
	 */
	public int x;
	
	/**
	 * La colonne
	 */
	public int y;
	
	/**
	 * (à expliquer)
	 */
	public boolean valide;

	
	/**
	 * Constructeur Coordonnees
	 * <p>
	 * A la construction d'une coordonnée, la ligne et la colonne sont fixées
	 * par la valeur des paramètres. On initialise le booléen valide à true.
	 * </p>
	 * 
	 * @param a
	 *            La ligne à attribuer
	 * @param b
	 *            La colonne à attribuer.
	 * 
	 */
public Coordonnees(int a, int b) {
		this.x = a;
		this.y = b;
		valide = true;
	}
}