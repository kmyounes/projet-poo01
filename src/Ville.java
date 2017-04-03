
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;



public class Ville {
    //liste des villes
	public static ArrayList<Ville> villes = new ArrayList<Ville>();
  //=====================Types=============================
  public enum types{
	  agricole, touristique, industrielle, ordinaire
	  }
  
	
	//=====================Variables========================
	
	private String nom,wilaya;
	private double superficie;
	private int nombreFleurs, habitants;
	private ArrayList<Ville> voisSort;
	private types typeV;
	private String couleur;
	private static int numero = 0;

	
  //=====================Constructeurs========================
	
	
	
	public Ville(String nom, String wilaya, double superficie, int habitants) {
		this.nom = nom;
		this.wilaya = wilaya;
		this.superficie = superficie;
		this.habitants = habitants;
		this.voisSort = new ArrayList<Ville>();
		numero ++;

		//Initialisation couleur
		initCouleur();
	}
	
	public Ville(String nom, String wilaya, double superficie, int habitants, int nombreFleurs, types type) {
		this.nom = nom;
		this.wilaya = wilaya;
		this.superficie = superficie;
		this.habitants = habitants;
		this.nombreFleurs = nombreFleurs;
		this.typeV = type;
		this.voisSort = new ArrayList<Ville>();
		numero ++;
		
		//Initialisation couleur
		initCouleur();
	}
	
	public Ville(String nom, String wilaya, double superficie, int habitants, int nombreFleurs, types typeV,
			String couleur) {
		this.nom = nom;
		this.wilaya = wilaya;
		this.superficie = superficie;
		this.nombreFleurs = nombreFleurs;
		this.habitants = habitants;
		this.typeV = typeV;
		this.couleur = couleur;

		
		numero++;
	}
	//Fonction qui initialise la couleur de la ville suivant le nombre de fleurs
	private void initCouleur(){
		if(this.typeV==types.valueOf("ordinaire") &&( this.nombreFleurs<=1)){
			this.couleur="Rouge";
		}
		else if ((this.typeV==types.valueOf("ordinaire") && this.nombreFleurs>1) || (this.typeV!=types.valueOf("ordinaire") && this.nombreFleurs<=1 ) ){
			this.couleur="Orange";
		}
		else {
			this.couleur="Vert";
		}
	}
	
	//=====================Geters/Seters========================
	
	public String getNom() {
		return nom;
	}
	
	public void setNom(String nom) {
		this.nom = nom;
	}
	
	public String getWilaya() {
		return wilaya;
	}
	
	public void setWilaya(String wilaya) {
		this.wilaya = wilaya;
	}
	
	public double getSuperficie() {
		return superficie;
	}
	
	public void setSuperficie(double superficie) {
		this.superficie = superficie;
	}
	
	public int getHabitants() {
		return habitants;
	}
	
	public void setHabitants(int habitants) {
		this.habitants = habitants;
	}
	
	public String getType() {
		return typeV.name();
	}
	
	public void setType(String type) {
		this.typeV = types.valueOf(type);
		
	}
	
	public int getNombreFleurs() {
		return nombreFleurs;
	}
	
	public void setNombreFleurs(int nombreFleurs) {
		this.nombreFleurs = nombreFleurs;
	}
	
	public static int getNumero(){
		return numero;
	}
	
	public static void setNumero(int numero) {
		Ville.numero = numero;
	}
	
	public String getCouleur() {
		return couleur;
	}
	
	public void setCouleur(String couleur) {
		this.couleur = couleur;
	}

	public ArrayList<Ville> getVoisSort() {
		return voisSort;
	}

	public void setVoisSort(ArrayList<Ville> voisSort) {
		this.voisSort = voisSort;
	}

	public types getTypeV() {
		return typeV;
	}

	public void setTypeV(types typeV) {
		this.typeV = typeV;
	}

	//===== méthode Tostring
	public String toString() {
		return "Ville [nom=" + nom + ", wilaya=" + wilaya + ", superficie=" + superficie + ", nombreFleurs="
				+ nombreFleurs + ", habitants=" + habitants + ", typeV=" + typeV + ", couleur=" + couleur + "]";
	}
		
	//=====================Méthodes========================

	public void addVilleSort(Ville v) { //Fonction qui permet d'ajouter une ville comme voisine
		this.voisSort.add(v);
	}

	public boolean voisinSort(Ville v) {// fonction qui vérifie si v est une ville voisine

		return this.voisSort.contains(v);
	}

	// =====================

	public void couleurAffiche() {   //permet d'afficher la couleur de la ville courante

		System.out.println("Ville de couleur: " + this.couleur);

	}
	
	
	public boolean pasChemin(){ //Foction qui Permet de verifier si la ville actuelle ne mène a aucune autre ville
		
		for(Ville v : this.voisSort){
			if(v != null)
				return false;
		}
		return true;
	}
	
	public boolean existe3Chemin(){// Fonction qui permet de verifier l'existence de 3 Villes voisines exactement
		int cpt = 0;
		
		for(Ville v : this.voisSort){
			if(v != null){
				if( cpt == 3)
					return false;
				else
					cpt++;
			}
		}
		
		return cpt == 3;
	}
	
	public boolean voisinDifferents(){ //Fonction qui permet de verifier si toutes le villes voisines sont differentes entre elles
        
		for(int i = 0; i < this.voisSort.size(); i++){
			for(int j = 0; j < this.voisSort.size(); i++){
				if(this.voisSort.get(i).equals(this.voisSort.get(j)))
					return false;
			}
		}
		

		
		
		return true;
	}
	
	
	public boolean plusFleurie(){//Fonction qui permet de verifier que la ville actuelle est plus fleurie que ses voisines
		
		for(Ville v: this.voisSort){
			if(this.getNombreFleurs() < v.getNombreFleurs())
				return false;
		}
		
		return true;		
	}
	
	public boolean methodeBizzare(){ //Fonction qui vérifie que la ville est de type "ordinaire" et "verte" et toutes ses voisines sont rouges
		//if (this.typeV !=types.valueOf("ordinaire") && this.couleur.equalsIgnoreCase("Vert")){
		if (!this.typeV.equals(types.valueOf("ordinaire")) && this.couleur.equalsIgnoreCase("Vert")){
			
			
			
			for(Ville v : this.voisSort){
				if( ! v.getCouleur().equalsIgnoreCase("Rouge"))
					return false;
				}
			
			
			return true;
			}
		else 
			return false;
			
		}
	
	


	
	
	public boolean cheminExiste(Ville fin, Ville... chemin){ //Fonction qui permet de verifier l'existence d'un chemin donné vers une ville donnée
		Ville tampon = this;
		
		for(int i = 0; i < chemin.length; i++){
			if(tampon.voisinSort(chemin[i])){
				tampon = chemin[i];
			} else {
				return false;
			}	
		}
		
		return (tampon.voisinSort(fin));


	}
	
	public boolean existeChemin(Ville fin){//Fonciton qui permet de verifier l'existence  d'un chemin vers une ville donnée
		
		if(this.equals(fin))
			return true;
		
		for(Ville v: this.voisSort){
			if(v.existeChemin(fin))
				return true;
		}
		
		return false;
	}
	
	
	public Ville recherche(String nom){ // Fonction qui permet de rechercher une ville avec son nom 
		
		if(this.getNom().equals(nom))
			return this;
		
		Ville temp;
		
		for(Ville v: this.voisSort){
			temp = v.recherche(nom);
			if(temp != null)
				return temp;
		}
		
		return null;
	}
	
public static Ville rechListe( String nom){
		
		Ville temp;
	
		for(Ville v: Ville.villes){
			temp = v.recherche(nom);
			if(temp != null)
				return temp;
		
		}
	
		return null;
	
	}

	
	public boolean supprime(){ //Fonction qui permet de supprimer La ville actuelle
		if(Ville.villes.indexOf(this) == -1){
			System.out.println("Ville n'existe pas dans la liste!");
			return false;
		}
				
		Ville.villes.remove(this);
		System.out.println("Operation terminee");
		return true;
	}
	
	public void modifieVille(){ //Fonction qui permet de modifier les informations d'une ville
		int choice = 1;
		Scanner in = new Scanner(System.in);
	
		do{
			System.out.printf("Que voulez-vous changer?: %n 1) Nom 2) Wilaya 3) Superficie 4) Type de ville 0) Annuler.%n Votre choix: ");
			choice = in.nextInt();
		
			if(choice < 0 || choice > 4)
				System.out.println("Erreur!! Veuillez entrer un choix valide!");
		
		}while(choice < 0 || choice > 4);
		
		switch(choice){
		case 1: 
			System.out.println("Entrez le nouveau nom:  ");
			this.setNom(in.next());
			break;
		case 2: 
			System.out.println("Entez la nouvelle wilaya:  ");
			this.setWilaya(in.next());
			break;
		case 3: 
			System.out.println("Entrez la nouvelle superficie:  ");
			this.setSuperficie(in.nextDouble());
			break;
		case 4: 
			int type = 1;
			do{
				System.out.printf("Entrez le nouveau type:  1) Agricole, 2) Touristique, 3) Industrielle, 4) Ordinaire.%n Votre choix: ");
				type = in.nextInt();
				if(type < 1 || type >4)
					System.out.println("Error!! Veuillez entrer un type valide!");
			}while(type < 1 || type >4);
		
			switch(type){
			case 1:
				this.setType("agricole");
				break;
			case 2:
				this.setType("touristique");
			break;
			case 3:
				this.setType("industrielle");
				break;	
			case 4:
				this.setType("ordinaire");
				break;
			}
			break;
		}
	
		System.out.println("Fait!");
		in.close();
	}
	
public static void afficheReseauArray(){ //fonction qui permet d'afficher le
		
		for(Ville v: Ville.villes){
			v.afficheReseauVille( 0, 0);
		}
	}
	
	public void afficheReseauVille(){
		this.afficheReseauVille( 0, 0);
		}
	
	public void afficheReseauVille( int numSpace, int i){
	
		System.out.print(this.getNom());
	
		numSpace += this.getNom().length();
		//numSpace += 5;
			
		if( ! this.pasChemin()){
		
			boolean space = false;
		
			//for(Ville temp : v.getVoisinsSortants()){
			for(Ville temp : this.getVoisSort()){
			
				if(temp != null){
					if(space){
					
						//make a string of ' ' numSpaces time.
						char[] chars = new char[ numSpace + i*4 ];
						Arrays.fill(chars, ' ');
						String result = new String(chars);
						System.out.print(result);
					
					
					} else {
						space = !space;
					
					}
				
					System.out.print(" => ");
				
					temp.afficheReseauVille( numSpace ,i+1);
				
				}
			}
		}
	
		System.out.println();
	}

	public static void afficherListeVilles(){
		String vert = "", rouge = "", orange= "";
	
		for(Ville v: Ville.villes){
			if(v.getCouleur().equalsIgnoreCase("vert"))
				vert = vert + " " + v.getNom();			
			if(v.getCouleur().equalsIgnoreCase("rouge"))
				rouge = rouge + " " + v.getNom();
			if(v.getCouleur().equalsIgnoreCase("orange"))
				orange = orange + " " + v.getNom();
		}
	
		System.out.println("La liste des villes: ");
		System.out.println("Vert:  " + vert);
		System.out.println("Rouge:  " + rouge);
		System.out.println("Orange:  " + orange);
	
	}
	
}