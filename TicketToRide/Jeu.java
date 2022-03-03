// D but du code d'origine
// D?but du code d'origine
class Jeu 
{
	Plateau plateau;
	
	IHM ihm;

	// ACCESSEURS
	
	Plateau getPlateau()
	{
		return this.plateau;
	}

	Jeu(){
		plateau = new Plateau();
		ihm = new IHM();
	}

	void affichePlateau(){
		// FOURNI
		this.ihm.afficheFenetre("Les Aventuriers du Rail",1366,768,"lightGray");
		for(Etat e : plateau.getEtats())
		{
			this.ihm.dessineEtat(e);
		}
		for(Route r : plateau.getRoutes())
		{
			this.ihm.dessineRoute(r);
		}
		for(Ville v : plateau.getVilles())
		{
			this.ihm.dessineVille(v);
		}
		affichePioche();
		afficheJoueurCourant();
	}

	public static void main(String[] args)
	{
		Jeu jeu = new Jeu();
		jeu.creeJoueurs(5);
		jeu.indiceJoueurCourant = 0;
		joueursRestantsAJouer = jeu.joueurs.length;
		jeu.initialisePioches();
		jeu.distribueCartesWagon();
		jeu.affichePlateau();
		do
		{
			jeu.tourDeJeu();
		}
		while (dernierTour == false);
		do
		{
			jeu.tourDeJeu();
			joueursRestantsAJouer -= 1;
		}
		while( joueursRestantsAJouer != 0);
	}

	Joueur[] joueurs;

	int indiceJoueurCourant;

	static boolean dernierTour = false;

	// ACCESSEURS
	Joueur[] getJoueurs()
	{
		return joueurs;
	}

	Joueur getJoueurCourant()
	{
		return joueurs[this.indiceJoueurCourant];
	}
	
	void tourDeJeu()
	{
		this.ihm.effaceInformation();
		afficheJoueurCourant();
		affichePioche();
		demandeAction();
	}

	void creeJoueurs(int nbJoueurs)
	{
		String[] couleur;
		couleur = Donnees.COULEURS_JOUEUR;
		this.joueurs = new Joueur[nbJoueurs];
		for( int k = 0 ; k < nbJoueurs ; k++)
		{
			joueurs[k] = new Joueur( k , couleur[k]);
		}
		indiceJoueurCourant = 0;
	}

	void changeJoueur()
	{
		nbActionJoueurCourant = 0;
		if (this.indiceJoueurCourant == joueurs.length - 1)
		{
			indiceJoueurCourant = 0;
		}
		else
		 {
		 	indiceJoueurCourant += 1;
		 }
	}

	void demandeAction() {
		// FOURNI
		this.ihm.effaceBoutons();
		this.ihm.dessineBoutonSuivant(false);
		ActionUtilisateur reponse = this.ihm.attenteActionJoueur();
		switch(reponse.getType()){
			case FINTOUR : changeJoueur();
				break;
			case ROUTE :
				selectionRoute(reponse.getParametre());
				break;
			case PIOCHECW:
				piocheCarteWagon(Integer.parseInt(reponse.getParametre()));
				break;
			default : break;
		}
	}

	void afficheJoueurCourant()
	{
		//Joueur joueur = rechercheJoueurCourant(indiceJoueurCourant);
		String couleurJoueur = this.getJoueurCourant().getCouleur();
		this.ihm.afficheInformation("Joueur " + this.getJoueurCourant().getNumero() , 15 , 400 , false , couleurJoueur);
		this.ihm.afficheInformation("Score " + this.getJoueurCourant().getScore() , 15 , 425 , false , couleurJoueur);
		this.ihm.afficheInformation("Wagon " + this.getJoueurCourant().getNombreWagons() , 15 , 450 , false , couleurJoueur);
		this.ihm.afficheCouleurJoueurCourant(this.getJoueurCourant().getCouleur());
		this.ihm.afficheCartesJoueur(this.getJoueurCourant());
	}
/**
 * La classe Jeu int?gre les classes du jeu des Aventuriers du Rail et impl?mente la
 * m?canique de jeu d?taill?e dans les r?gles du jeu original.
 * Les diff?rentes versions de cette classe permet de r?aliser les objectifs fix?s
 * par les huit incr?ments du Projet.
 * @ACOMPLETER
 */
	/**
	 * Nombre d'actions du joueur courant pendant le tour
	 * @since Incr?ment 3
	 * @EXTENSION
	 */
	 static int nbActionJoueurCourant;
	// TODO d?clarer un attribut pour le nombre d'actions du joueur courant

	/**
	 * S?lection d'une route de la part du joueur qui en devient propri?taire
	 * A partir de l'incr?ment 4, le score et le nombre de wagon restants au joueur
	 * sont mis ? jour.
	 * @param nom le nom de la route s?lectionn?e
	 * @since Incr?ment 3
	 */
	void selectionRoute(String route)
	{
		Route routePlateau = this.plateau.rechercheRoute(route);
		int[] ListeScore = {1,2,4,7,10,15};
		if(nbActionJoueurCourant == 0) 
		{
			if(routePlateau != null && routePlateau.getProprietaire() == null) 
			{
				routePlateau.setProprietaire(getJoueurCourant());
				this.ihm.effaceRoute(routePlateau);
				this.ihm.dessineRoute(routePlateau);
				this.ihm.dessineVille(routePlateau.getVilleDepart());
				this.ihm.dessineVille(routePlateau.getVilleArrivee());
				nbActionJoueurCourant = 2;
				getJoueurCourant().enleveWagons(routePlateau.getLongueur());
				getJoueurCourant().ajouteAuScore(ListeScore[routePlateau.getLongueur()-1]);
				detecteDernierTour();
			}
			else if (routePlateau != null && routePlateau.getProprietaire() != null) 
			{
				this.ihm.afficheMessageErreur("Route deja occupee");
			}
		}
		else 
		{
			if (routePlateau != null && routePlateau.getProprietaire() != null) 
			{
				this.ihm.afficheMessageErreur("Route deja occupee");
			}
			else 
			{
				if (this.nbActionJoueurCourant==1) 
				{
					this.ihm.afficheMessageErreur("Vous ne pouvez pas prendre de route");
				}
				else 
				{
					this.ihm.afficheMessageErreur("Vous avez deja joue");
				}
			}
		}
	}

/**
 * La classe Jeu int?gre les classes du jeu des Aventuriers du Rail et impl?mente la
 * m?canique de jeu d?taill?e dans les r?gles du jeu original.
 * Les diff?rentes versions de cette classe permet de r?aliser les objectifs fix?s
 * par les huit incr?ments du Projet.
 * @ACOMPLETER
 */


	/**
	 * Le nombre de joueurs restants ? jouer lorsque le dernier tour
	 *        est d?tect?
	 * @since Incr?ment 4
	 */
	 static int joueursRestantsAJouer;
	// TODO d?clarer le nombre de joueurs restant ? jouer

	// ACCESSEURS
	
	 int getJoueursRestantsAJouer()
	 {
	 	return joueursRestantsAJouer;
	 }
	//?TODO d?clarer les accesseurs pour les nouveaux attributs

	/**
	 * @since Incr?ment 4
	 */
	 boolean getDernierTour()
	 {
	 	return dernierTour;
	 }

	/**
	 * @since Incr?ment 4
	 */
	 void setDernierTour()
	 {
	 	this.dernierTour = true;
	 }
	/**
	 * V?rifie si le joueur courant a moins de 3 wagons restants et met ? jour
	 * l'attribut dernierTour.
	 * @since Incr?ment 4
	 */
	void detecteDernierTour()
	{
		if(getJoueurCourant().getNombreWagons() <= 2)
		{
			setDernierTour();
		}
	}
	void setJoueursRestantsAJouer(int temp)
	{
		this.joueursRestantsAJouer = temp;
	}

// import java.util.Random;

	/**
	 * La pioche (l'objet {@link PiocheCartesWagon}) de cartes "wagon"
	 * @since Incr?ment 5
	 */
	// TODO d?clarer la pioche cach?e de cartes wagon
	PiocheCartesWagon piocheCachee = new PiocheCartesWagon();

	/**
	 * La d?fausse (l'objet {@link PiocheCartesWagon}) de cartes "wagon"
	 * @since Incr?ment 5
	 */
	// TODO d?clarer la d?fausse de cartes wagon
	PiocheCartesWagon defausseCartesWagon = new PiocheCartesWagon();
	PiocheCartesWagon getDefausseCartesWagon()
	{
		return this.defausseCartesWagon;
	}

	/**
	 * La pioche visible (le tableau d'objets {@link CarteWagon}) de cartes "wagon"
	 * @since Incr?ment 5
	 */
	// TODO d?clarer la pioche visible de cartes wagon
	CarteWagon[] piocheVisible = new CarteWagon[5];

	/**
	 * Initialise les pioches de cartes "wagon" ainsi que la d?fausse
	 * @since Incr?ment 5
	 */
	// TODO d?clarer la m?thode initialisePioches (manque surement 10000 trucs dans celle l?)
	void initialisePioches()
	{
		this.piocheCachee.ajouteCartes();
		piocheCachee.melange();
		for (int k = 0 ; k < 5 ; k++)
		{
			this.piocheVisible[k] = this.piocheCachee.depile();
		}
	}

	// Accesseurs de la pioche (rajout?e)
	PiocheCartesWagon getPiocheCartesWagon()
	{
		return this.piocheCachee;
	}

	CarteWagon[] getPiocheVisible()
	{
		return this.piocheVisible;
	}

	/**
	 * Affiche les pioches de cartes et la d?fausse
	 * @since Incr?ment 6
	 */
	// TODO d?clarer la m?thode affichePioches
	void affichePioche()
	{
		ihm.affichePioches(this.piocheCachee , this.piocheVisible);
	}

	/**
	 * Pioche d'une carte "wagon" de la part du joueur, soit dans la pioche
	 * cach?e, soit dans la pioche visible A partir de l'incr?ment 7, la carte
	 * pioch?e est ajout?e ? la main du joueur
	 * @param indice l'indice de la carte pioch?e visible s?lectionn?e, ou -1 si
	 *            la carte est pioch?e dans la pioche cach?e.
	 * @since Incr?ment 6
	 */
	// TODO d?clarer la m?thode piocheCarteWagon

	void piocheCarteWagon(int indice)
	{
		if(indice < -1 || indice > 4)
		{
			throw new Error("Format invalide");
		}
		if(indice == -1 && this.nbActionJoueurCourant < 2) // Si le joueur veut piocher une carte cach e
		{
			this.nbActionJoueurCourant++;
			this.getJoueurCourant().prendsCarteWagon(this.piocheCachee.depile());
		}
		else
		{
			if(this.piocheVisible[indice].estLocomotive()) // Si le joueur veut piocher une Loco
			{
				if(this.nbActionJoueurCourant == 0) // Peut piocher deux cartes
				{
					// Donner la carte au joueur
					this.nbActionJoueurCourant += 2;
					this.getJoueurCourant().prendsCarteWagon(this.piocheVisible[indice]);
					this.piocheVisible[indice] = this.piocheCachee.depile();
				}
				else
				{
					ihm.afficheMessageErreur("Vous n'avez pas assez d'action pour piocher");
				}
			}
			else
			{
				if(this.nbActionJoueurCourant < 2)
				{
					// Donner la carte au joueur
					this.nbActionJoueurCourant++;
					this.getJoueurCourant().prendsCarteWagon(this.piocheVisible[indice]);
					this.piocheVisible[indice] = this.piocheCachee.depile();
				}
				else
				{
					ihm.afficheMessageErreur("Pas assez d'actions restantes !");
				}
			}
		
		}
	}
/**
 * La classe Jeu int?gre les classes du jeu des Aventuriers du Rail et impl?mente la
 * m?canique de jeu d?taill?e dans les r?gles du jeu original.
 * Les diff?rentes versions de cette classe permet de r?aliser les objectifs fix?s
 * par les huit incr?ments du Projet.
 * @ACOMPLETER
 */
	/**
	 * Distribue quatre cartes "wagon" ? chaque joueur
	 * Les cartes "wagon" sont retir?es de la pioche de cartes "wagon"
	 * @since Incr?ment 7
	 */
	// TODO d?clarer la m?thode distribueCartesWagon
	void distribueCartesWagon()
	{
		for(int i = 0 ; i < 4 ; i++)
		{
			for(int k = 0 ; k < joueurs.length ; k++)
			{
				this.joueurs[k].prendsCarteWagon(this.getPiocheCartesWagon().depile());
			}
		}
	}
}
// Fin du code d'origine

// Code import  :
/**
 * La classe Jeu int gre les classes du jeu des Aventuriers du Rail et impl mente la
 * m canique de jeu d taill e dans les r gles du jeu original.
 * Les diff rentes versions de cette classe permet de r aliser les objectifs fix s
 * par les huit incr ments du Projet.
 * @ACOMPLETER
 */
class Jeu {
	/**
	 * Recherche l'indice du joueur dont le diam tre est maximum.
	 * @param diametres les diam tres de chaque joueur
	 * @return l'indice du joueur dont le diam tre est maximum
	 * @since Incr ment 8
	 */
	// TODO d clarer la m thode maxDiametre

	/**
	 * Recherche l'indice des joueurs dont le nombre de groupes connexes
	 *  est minimum. Plus le nombre de groupes connexes est faible, plus le r seau  
	 *  du joueur est dense.
	 * @param connexites le nombre de groupes connexes de chaque joueur
	 * @return l'indice du joueur dont le nombre de groupes
	 * connexes est minimum.
	 * @since Incr ment 8
	 */
	// TODO d clarer la m thode minGroupesConnexes

	/**
	 * Calcule et affiche le joueur qui remporte la partie
	 * @since Incr ment 8
	 */
	// TODO d clarer la m thode afficheVainqueur

	/**
	 * Calcule et affiche les scores de la partie pour l'ensemble des joueurs.
	 * @since Incr ment 8
	 * @EXTENSION
	 */
	// TODO d clarer la m thode afficheScores

	/**
	 * Recherche le ou les indices des joueurs dont le diam tre est maximum.
	 * @param diametres les diam tres de chaque joueur
	 * @return une liste contenant l'indice du joueur dont le diam tre est maximum 
	 * ou plusieurs indices en cas d' galit .
	 * @since Incr ment 8
	 * @EXTENSION
	 */
	// TODO rechercher les diam tres maximums ex-aequo

	/**
	 * Recherche le ou les indices des joueurs dont le nombre de groupes connexes
	 *  est minimum. Plus le nombre de groupes connexes est faible, plus le r seau  
	 *  du ou des joueur(s) est dense.
	 * @param connexites le nombre de groupes connexes de chaque joueur
	 * @return une liste contenant l'indice du joueur dont le nombre de groupes
	 * connexes est minimum ou plusieurs indices en cas d' galit .
	 * @since Incr ment 8
	 * @EXTENSION
	 */
	// TODO rechercher les nombres de groupes connexes minimums ex-aequo
}
