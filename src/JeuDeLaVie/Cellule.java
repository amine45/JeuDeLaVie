
package JeuDeLaVie;

/**
 * <b>Cellule est la classe qui représente une cellule du Jeu de la Vie.</b>
 * <p>
 * Une cellule est caractérisée par les informations suivantes:
 * </p>
 * <ul>
 * <li>Une coordonnée qui représente la ligne et la colonne.</li>
 * <li>Un état. La cellule peut être vivante ou morte.</li>
 * <li>Un état_suivant. La cellule peut devenir vivante ou morte à la génération
 * suivante.</li>
 * </ul>
 * </p>
 */

public class Cellule implements Comparable<Object>{

	
	/**
	 * Les coordoonnées de la cellule.
	 */
	private Coordonnees coord;
	
	/**
	 * L'état présent de la cellule.
	 */
	private String état;
	
	/**
	 * L'état de la cellule après une génération.
	 */
	private String état_suivant;

	
	/**
	 * Constructeur Cellule.
	 * <p>
	 * A la construction d'une cellule, les coordoonées et l'état de la cellule
	 * sont fixées par la valeur des paramètres.
	 * </p>
	 * 
	 * @param coor
	 *            Les coordonnées à attribuer à la cellule.
	 * @param etat
	 *            L'état à attribuer à la cellule.
	 * 
	 */
	public Cellule(Coordonnees coor, String etat) {
		this.coord = coor;
		this.état = etat;
	}

	
	/**
	 * @return les coordoonées de la cellule.
	 */
	public Coordonnees getCoord() {
		return this.coord;
	}
	
	/**
	 * @return l'état de la cellule sous forme de chaine de caractère.
	 */
	public String getEtat() {
		return this.état;
	}
	
	
	/**
	 * @return l'état de la cellule après une génération sous forme de chaine de caractère.
	 */

	public String getEtat_suivant() {
		return this.état_suivant;
	}
	
	
	/**
	 * Met à jour les coordonnées de la cellule.
	 * 
	 * @param coord
	 *            Les nouvelles coordonnées de la cellule.
	 */
	public void setCoord(Coordonnees coord) {
		this.coord = coord;
	}


	/**
	 * Met à jour l'état de la cellule.
	 * 
	 * @param etat
	 *            Le nouvel état de la cellule
	 */
	public void setEtat(String etat) {
		this.état = etat;
	}

	
	/**
	 * Met à jour l'état suivant de la cellule.
	 * 
	 * @param etat
	 *            Le nouvel état suivant de la cellule
	 */
	public void setEtat_suivant(String etat) {
		this.état_suivant = etat;
	}
	
	
	/**
	 * Compare deux cellules.
	 * 
	 * @param o
	 *            Une instance de type Object.
	 * 
	 * @return ...
	 */

	public int compareTo(Object o) {

		if (o instanceof Cellule) {
			Cellule z = (Cellule) o;
			if (this.getCoord().x == z.getCoord().x) {
				return this.getCoord().y - z.getCoord().y;
			} else {
				return this.getCoord().x - z.getCoord().x;
			}
		} else
			return Integer.MAX_VALUE;
	}

	
	/**
	 * Vérifie l'égalité entre deux cellules.
	 * 
	 * @param obj
	 *            Une instance de type Object
	 * 
	 * @return true si les cellules ont les mêmes coordonnées, false sinon.
	 */
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cellule other = (Cellule) obj;
		if (getCoord().x != other.getCoord().x)
			return false;
		if (getCoord().y != other.getCoord().y)
			return false;
		return true;
	}

	
	/**
	 * Affiche les informations d'une cellule.
	 * 
	 * @return les informations de la cellule sous forme de chaine de caractère.
	 */
	public String toString() {
		return "Cellule [x=" + getCoord().x + ", y=" + getCoord().y + ", état="
				+ état + ", état_suivant=" + état_suivant + "]";

	}

}