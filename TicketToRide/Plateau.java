/**
 * La classe Plateau représente le plateau de jeu des Aventuriers du Rail.
 * Il se compose d'un ensemble d'objets {@link Etat}, d'un ensemble d'objets {@link Ville} et d'un
 * ensemble d'objets {@link Route}.
 * @since Incrément 1
 * @ACOMPLETER
 */
class Plateau {

	/**
	 * La liste des états du plateau de jeu
	 * @FOURNI
	 */
	Etat[] etats;

	/**
	 * La liste des villes du plateau de jeu
	 */
	Ville[] villes;

	/**
	 * La liste des routes du plateau de jeu
	 */
	Route[] routes;
	
	/**
	 * Crée le plateau de jeu
	 */
	Plateau() {
		initialiseEtats();
		initialiseVilles();
		initialiseRoutes();// @FOURNI
		// TODO Compléter avec l'initialisation des villes et des routes
	}

	// ACCESSEURS
	/**
	 * @return les états du plateau de jeu
	 * @FOURNI
	 */
	Etat[] getEtats() 
	{
		return this.etats;
	}

	Ville[] getVilles()
	{
		return this.villes;
	}

	Route[] getRoutes()
	{
		return this.routes;
	}

	Plateau(Etat[] etats , Ville[] villes , Route[] routes)
	{
		this.etats = etats;
		this.villes = villes;
		this.routes = routes;
	}
	
	/**
	 * Initialise l'ensemble des états du jeu à partir des données fournies (
	 * {@link Donnees#ETATS}) Les données utilisées sont transformées pour
	 * isoler le nom de l'état et son "contour".
	 * @FOURNI
	 */
	void initialiseEtats() 
	{
		this.etats = new Etat[Donnees.ETATS.length];
		for(int i=0;i<Donnees.ETATS.length;i++){
			etats[i] = new Etat(Donnees.ETATS[i][0],Donnees.ETATS[i][1]);
		}
	}

	
	/**
	 * Initialise l'ensemble des villes du jeu à partir des données fournies (
	 * {@link Donnees#VILLES}) Les données utilisées sont transformées pour
	 * isoler le nom de la ville, son abscisse et son ordonnée.
	 */
	void initialiseVilles()
	{
		this.villes = new Ville[Donnees.VILLES.length];
		String[] ville = Donnees.VILLES;
		double x;
		String temp;
		double y;
		String nom;
		for(int k = 0 ; k < ville.length ;  k++)
		{
			y = Double.parseDouble(ville[k].substring(ville[k].lastIndexOf(" ")));
			temp = ville[k].substring(0,ville[k].lastIndexOf(" "));
			x = Double.parseDouble(temp.substring(temp.lastIndexOf(" ")));
			temp = temp.substring(0,temp.lastIndexOf(" "));
			villes[k] = new Ville( temp , x , y );
			villes[k].setNumero(k);
		}
	}
	
	/**
	 * Initialise l'ensemble des routes du jeu à partir des données fournies (
	 * {@link Donnees#ROUTES}) Les données utilisées sont transformées pour
	 * isoler le nom de la ville de départ, le nom de la ville d'arrivée et la
	 * couleur de la route. La taille de la route est calculée à partir des
	 * coordonnées des villes ({@link Route#getLongueur()})
	 */
	void initialiseRoutes()
	{
		this.routes = new Route[Donnees.ROUTES.length];
		String[][] route = Donnees.ROUTES;
		for(int k = 0 ; k < routes.length ; k++)
		{
			routes[k] = new Route(rechercheVille(route[k][0]) , rechercheVille(route[k][1]) , route[k][2]);
		}
	}
	
	/**
	 * Recherche d'une ville à partir de son nom
	 * @param nom le nom de la ville
	 * @return un objet {@link Ville} correspond au nom recherché, {@code null} sinon
	 */
	Ville rechercheVille(String nom)
	{
		for( int k = 0 ; k < villes.length ; k++)
		{
			if(villes[k].getNom().equals(nom))
			{
				return villes[k];
			}
		}
		return null;
	}
	
	/**
	 * Recherche d'une route à partir de son nom
	 * @param nom le nom de la route
	 * @return un objet {@link Route} correspond au nom recherché, {@code null} sinon
	 * @EXTENSION
	 */
	Route rechercheRoute(String nom)
	{
		for ( int k = 0 ; k < routes.length ; k++)
		{
			if (routes[k].getNom().equals(nom))
			{
				return routes[k];
			}
		}
		return null;
	}
}
