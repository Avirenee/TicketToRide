/**
 * La classe PiocheCartesWagon est l'implémentation d'une pile abstraite dont le
 * stockage des éléments est réalisé dans un tableau.
 * @since Incrément 5
 * @ACOMPLETER
 */
class PiocheCartesWagon
{
	

	/**
	 * Le tableau interne pour stocker les cartes de la pile
	 */
	CarteWagon[] cartes;

	/**
	 * l'indice du sommet de la pile
	 */
	int indiceSommet;

	/**
	 * Crée une pile de cartes "wagon". On initialise le tableau de façon à
	 * pouvoir stocker 110 cartes "wagon", comme indiqué dans la règle du jeu.
	 */
	PiocheCartesWagon()
	{
		this.indiceSommet = -1;
		this.cartes = new CarteWagon[110];
		// Si 110 cartes (sinon il faut modifier le 110)
	}

	// ACCESSEURS
	// TODO déclarer les accesseurs en lecture pour les attributs
	int getIndiceSommet()
	{
		return this.indiceSommet;
	}

	CarteWagon[] getCartes()
	{
		return this.cartes;
	}

	/**
	 * @return {@code vrai} si l'indice du sommet est égal à -1, {@code faux}
	 *         sinon
	 */
	// TODO déclarer la méthode estVide
	boolean estVide()
	{
		if(this.indiceSommet == -1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * @return {@code vrai} si l'indice du sommet est égale à la taille du
	 *         tableau de cartes, {@code faux} sinon
	 */
	// TODO déclarer la méthode estPleine
	boolean estPleine()
	{
		if(this.indiceSommet == this.cartes.length - 1)
		{
			return true;
		}
		else
		{
			return false;
		}
	}

	/**
	 * Empile une carte "wagon"
	 * @param carte l'objet {@link CarteWagon} à empiler. Erreur si la pile est
	 *            pleine
	 */
	// TODO déclarer la méthode empile
	void empile(CarteWagon element) 
	{
		if(!estPleine())
		{
			this.cartes[indiceSommet + 1] = element;
			this.indiceSommet++;
		}
		else
		{
			throw new Error("Pile pleine");
		}
	}


	/**
	 * Renvoie la carte "wagon" située au sommet de la pile, mais ne la retire pas de
	 * la pile.
	 * @return l'objet {@link CarteWagon} présent au sommet de la pile. Erreur
	 *         si la pile est vide
	 */
	// TODO déclarer la méthode getSommet
	CarteWagon getSommet()
	{
		if(this.indiceSommet == -1)
		{
			throw new Error("La pile est vide");
		}
		else
		{
		return cartes[this.indiceSommet];
		}
	}

	/**
	 * Dépile une carte "wagon"
	 * @return l'objet {@link CarteWagon} présent au sommet de la pile. Erreur
	 *         si la pile est vide
	 */
	// TODO déclarer la méthode depile
	CarteWagon depile()
	{
		if(!estVide())
		{
			this.indiceSommet--;
			return this.cartes[indiceSommet+1];
		}
		else
		{
			throw new Error("Pile vide");
		}
	}


	/**
	 * @return une représentation textuelle de la pile. On indique pour chaque
	 *         élément sa position dans la pile
	 */
	// TODO déclarer la méthode versChaine
	String versChaine()
	{
		String chaine = "";
		for( int k = 0 ; k < indiceSommet + 1 ; k++)
		{
			if(cartes[k].getCouleur() != null)
			{
			chaine += k+1 + ": Wagon " + cartes[k].getCouleur() + "\n";
			}
			else
			{
				chaine += k+1 + ": Locomotive" + "\n";
			}
		}
		return chaine;
	}

	/**
	 * Crée les 110 cartes "wagon" (12 par couleur et 14 locomotives) du jeu et
	 * remplit la pioche.
	 */
	// TODO déclarer la méthode ajouteCartes
	void ajouteCartes()
	{
		String[] couleurs = Donnees.COULEURS_WAGON;
		for(int k = 0 ; k < couleurs.length ; k++)
		{
			for( int j = 0 ; j < 12 ; j++)
			{
				CarteWagon newCarte = new CarteWagon(couleurs[k]);
				empile(newCarte);
			}
		}
		for( int i = 0 ; i < 14 ; i++)
		{
			CarteWagon newCarte = new CarteWagon(null);
				empile(newCarte);
		}
	}

	/**
	 * Mélange la pile de cartes "wagon" pour créer un tirage aléatoire
	 * @EXTENSION
	 */
	// TODO déclarer la méthode melange

	/**
	 * Extrait un sous-ensemble de la pile de cartes "wagon"
	 * @param nombreCartes le nombre de cartes "wagon" à extraire
	 * @return un tableau d'objets {@link CarteWagon} contenant
	 *         {@code nombreCartes} cartes "wagon"
	 */
	// TODO déclarer la méthode extraitCartes
	CarteWagon[] extraitCartes(int nbCartes)
	{
		CarteWagon[] tabCarte;
		if(nbCartes > this.indiceSommet+1)
		{
			tabCarte = new CarteWagon[indiceSommet+1];
			for(int k = 0 ; k < tabCarte.length ; k++)
			{
				tabCarte[k] = depile();
			}
		}
		else
		{
			tabCarte = new CarteWagon[nbCartes];
			for(int k = 0 ; k < tabCarte.length ; k++)
			{
				tabCarte[k] = depile();
			}
		}
		return tabCarte;
	}
	
	void melange()
	{
		PiocheCartesWagon newPioche = new PiocheCartesWagon();
		while(!newPioche.estPleine())
		{
			int rand = (int) (Math.random() * 110);
			if(this.cartes[rand] != null)
			{
				newPioche.empile(this.cartes[rand]);
				this.cartes[rand] = null;
			}
			
		}
		this.cartes = newPioche.cartes;
	}
}
