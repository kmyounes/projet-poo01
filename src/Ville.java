
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Ville {
  //=====================Types=============================
  public enum types{
	  agricole, touristique, industrielle, ordinaire
	  };
  
	
	//=====================Variables========================
	
	private String nom,wilaya;
	private double superficie;
	private int nombreFleurs, habitants;  
	private ArrayList<Ville> voisEnt;
	private ArrayList<Ville> voisSort;
	private types typeV;
	private String couleur;
	private static int numero = 0;
	public static ArrayList<Ville> villes = new ArrayList<Ville>();

	
  //=====================Constructeurs========================
	
	
	
	public Ville(String nom, String wilaya, double superficie, int habitants) {
		this.nom = nom;
		this.wilaya = wilaya;
		this.superficie = superficie;
		this.habitants = habitants;
		this.voisEnt = new ArrayList<Ville>();
		this.voisSort = new ArrayList<Ville>();
		numero ++;

		//Initialisation couleur
		initCouleur();
	}
	
	public Ville(String nom, String wilaya, double superficie, int habitants, int nbFleur, types type) {
		this.nom = nom;
		this.wilaya = wilaya;
		this.superficie = superficie;
		this.habitants = habitants;
		this.nombreFleurs = nbFleur;
		this.typeV = type;
		this.voisEnt = new ArrayList<Ville>();
		this.voisSort = new ArrayList<Ville>();
		numero ++;
		
		//Initialisation couleur
		initCouleur();
	}
	
	private void initCouleur(){
		
		if(this.typeV==types.valueOf("ordinaire") &&( this.nombreFleurs<=1)){
			this.couleur="Rouge";
		}
		else if ((this.typeV==types.valueOf("ordinaire") && this.nombreFleurs>1) || (this.typeV!=types.valueOf("ordinaire") && this.nombreFleurs<=1 ) ){
     		//afficher en orange	
			this.couleur="Orange";
		}
		else {
			//afficher en vert
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
	
	public ArrayList<Ville> getVoisEnt() {
		return voisEnt;
	}
	
	public void setVoisEnt(ArrayList<Ville> voisEnt) {
		this.voisEnt = voisEnt;
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
	
	
	public void addVilleSort(Ville v){
		this.voisSort.add(v);
	}
	
	public void addVilleEnt(Ville v){
		this.voisEnt.add(v);
	}
	
	
	public String toString() {
		return "Ville [nom=" + nom + ", wilaya=" + wilaya + ", superficie=" + superficie + ", nombreFleurs="
				+ nombreFleurs + ", habitants=" + habitants + ", typeV=" + typeV + ", couleur=" + couleur + "]";
	}
		
	//=====================Méthodes========================


	

	

	// *Reworked by Legend 
	public void couleurAffiche(){
		
		System.out.println("Ville de couleur: " + this.couleur);
		
	}
	
	/*
	 * I edited this method since we should look for the number of cities that we go to! 
	 * 
	 */
	public boolean pasChemin(){
		
		for(Ville v : this.voisSort){
			if(v != null)
				return false;
		}
		return true;
	}
	
	public boolean existe3Chemin(){
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
	
	// *Reworked by Legend: Added villes between them
	public boolean voisinDifferents(){
        
		for(int i = 0; i < this.voisSort.size(); i++){
			for(int j = 0; j < this.voisSort.size(); i++){
				if(this.voisSort.get(i).equals(this.voisSort.get(j)))
					return false;
			}
		}
		
		for(int i = 0; i < this.voisEnt.size(); i++){
			for(int j = 0; j < this.voisEnt.size(); i++){
				if(this.voisEnt.get(i).equals(this.voisEnt.get(j)))
					return false;
			}
		}
		
		
		return true;
	}
	
	
	// *Reworked by Legend: Added villes sortant
	public boolean plusFleurie(){
		
		for(Ville v: this.voisSort){
			if(this.getNombreFleurs() < v.getNombreFleurs())
				return false;
		}
		
		return true;		
	}
	
	// *Reworked by Legend: Use method equals with strings!
	public boolean methodeBizzare(){
		//if (this.typeV !=types.valueOf("ordinaire") && this.couleur.equalsIgnoreCase("Vert")){
		if (!this.typeV.equals(types.valueOf("ordinaire")) && this.couleur.equalsIgnoreCase("Vert")){
			
			
			
			for(Ville v: this.voisEnt){
				if( ! v.getCouleur().equalsIgnoreCase("Rouge"))
					return false;
			}
			for(Ville v : this.voisSort){				
				if( ! v.getCouleur().equalsIgnoreCase("Rouge"))
					return false;
				}
			
			
			return true;
			}
		else 
			return false;
			
		}
	
	// *Made by Legend: Verifie si v appartient au liste des voisins Entrant
	public boolean voisinEnt(Ville v){
		
		return this.voisEnt.contains(v);
	}

	// *Made by Legend: Verifie si v appartient au liste des voisins Sortant
	public boolean voisinSort(Ville v){
		
		return this.voisSort.contains(v);
	}
	
	public boolean cheminExiste(Ville fin, Ville... chemin){
		Ville tampon = this;
		
		for(int i = 0; i < chemin.length; i++){
			if(tampon.voisinSort(chemin[i])){
				tampon = chemin[i];
			} else {
				return false;
			}	
		}
		
		if(tampon.voisinSort(fin))
			return true;
		
		return false;
			
	}
	
	public boolean existeChemin(Ville fin){
		
		if(this.equals(fin))
			return true;
		
		for(Ville v: this.voisSort){
			if(v.existeChemin(fin))
				return true;
		}
		
		return false;
	}
	
	
	public Ville recherche(String nom){
		
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

	
	public boolean supprime(){
		
		if(Ville.villes.indexOf(this) == -1){
			System.out.println("Ville n'existe pas dans la liste!");
			return false;
		}
				
		Ville.villes.remove(this);
		System.out.println("Operation terminee");
		return true;
		
		
	}
	
	
	public static void afficheReseauArray(){
		
		for(Ville v: Ville.villes){
			afficheReseauVille(v, 0, 0);
		}
	}
	
	public static void afficheReseauVille(Ville v){
		afficheReseauVille(v, 0, 0);
		}
	
	public static void afficheReseauVille(Ville v, int numSpace, int i){
	
		System.out.print(v.getNom());
	
		numSpace += v.getNom().length();
		//numSpace += 5;
			
		if( ! v.pasChemin()){
		
			boolean space = false;
		
			//for(Ville temp : v.getVoisinsSortants()){
			for(Ville temp : v.getVoisSort()){
			
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
				
					afficheReseauVille(temp, numSpace ,i+1);
				
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

	public static Ville rechListe( String nom){
		
		Ville temp;
	
		for(Ville v: Ville.villes){
			temp = v.recherche(nom);
			if(temp != null)
				return temp;
		
		}
	
		return null;
	
	}
	public void modifieVille(){
		int choice = 1;
		Scanner in = new Scanner(System.in);
	
		do{
			System.out.printf("What do you want to change?: %n 1) Nom 2) Wilaya 3) Superficie 4) Type de ville 0) Abort.%n Votre choix: ");
			choice = in.nextInt();
		
			if(choice < 0 || choice > 4)
				System.out.println("Erreur!! Please enter a valide choice!");
		
		}while(choice < 0 || choice > 4);
		
		switch(choice){
		case 1: 
			System.out.println("Enter the new name:  ");
			this.setNom(in.next());
			break;
		case 2: 
			System.out.println("Enter the new wilaya:  ");
			this.setWilaya(in.next());
			break;
		case 3: 
			System.out.println("Enter the new :  ");
			this.setSuperficie(in.nextDouble());
			break;
		case 4: 
			int type = 1;
			do{
				System.out.printf("Enter the new type:  1) Agricole, 2) Touristique, 3) Industrielle, 4) Ordinaire.%n Votre choix: ");
				type = in.nextInt();
				if(type < 1 || type >4)
					System.out.println("Error!! Enter a valid type!");
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
	
		System.out.println("Done!");
		in.close();
	}

}