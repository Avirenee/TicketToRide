/**
 * La classe Ville représente une ville du jeu des Aventuriers du Rail.
 * Une ville dispose d'un nom, d'une abscisse et d'une ordonnée pour l'affichage
 * sur la carte.
 * @since Incrément 1
 * @ACOMPLETER
 */
class Ville {
	/**
	 * le nom de la ville
	 */
	 String nom;
	
	/**
	 * l'abcisse des coordonnées des la ville
	 */
	 double x ;
	
	/**
	 * l'ordonnée des coordonnées des la ville
	 */
	double y ;

	int numero;
	
	/**
	 * Crée une ville
	 * @param nom le nom de la ville
	 * @param x l'abcisse de la ville
	 * @param y l'ordonnée de la ville
	 */
	Ville(String nom,double x,double y)
	{
		 this.nom = nom ;
		 this.x = x ;
		 this.y = y ;
	}
	// ACCESSEURS
	String getNom() 
	{
		return nom;
	}

	double getX() 
	{
		return x;
	}

	double getY() 
	{
		return y;
	}

	int getNumero()
	{
		return this.numero;
	}
	
	/**
	 * @return une représentation textuelle de la ville. On indique le nom de la
	 *         ville puis ses coordonnées, séparées par une virgule et entre
	 *         parenthèses.
	 */
	String versChaine()
	{
		return nom + " (" + x + "," + y + ")";
	}

	void setNumero(int numero)
	{
		this.numero = numero;
	}
}
