
import java.util.ArrayList;
import java.util.Arrays;

public class Ville {
  //=====================Types=============================
  public enum types{
	  agricole, touristique, industrielle, ordinaire
	  };
  
	
	//=====================Variables========================
	
	private String nom,wilaya;
	private double superficie;
	private int nombreFleurs, habitants;  
	/*
	private Ville[] voisinsEntrants;
	private Ville[] voisinsSortants;
	//numSort: last index in the Sortant table
	private int numEnt = 0, numSort = 0;
	*/
	private ArrayList<Ville> voisEnt;
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
		/*
		this.voisinsEntrants = new Ville[10];
		this.voisinsSortants = new Ville[10];
		*/
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
		/*
		this.voisinsEntrants = new Ville[10];
		this.voisinsSortants = new Ville[10];
		*/
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
	
	/*
	public Ville[] getVoisinsEntrants() {
		return voisinsEntrants;
	}
	
	public void setVoisinsEntrants(Ville[] voisinsEntrants) {
		this.voisinsEntrants = voisinsEntrants;
	}
	
	public Ville[] getVoisinsSortants() {
		return voisinsSortants;
	}
	
	public void setVoisinsSortants(Ville[] voisinsSortants) {
		this.voisinsSortants = voisinsSortants;
	}
	*/
	
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
		/*
		this.voisinsSortants[this.numSort] = v;
		this.numSort++;
		*/
		this.voisSort.add(v);
	}
	
	public void addVilleEnt(Ville v){
		/*
		this.voisinsEntrants[this.numEnt] = v;
		this.numEnt++;
		*/
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
		/*
		 * Tab statique
		for(Ville v : this.voisinsSortants){
			if(v != null)
				return false;
		}
		*/
		for(Ville v : this.voisSort){
			if(v != null)
				return false;
		}
		return true;
	}
	
	public boolean existe3Chemin(){
		int cpt = 0;
		/*
		 * Tab statique
		for(Ville v : this.voisinsSortants){
			if(v != null)
				if(cpt == 3)
					return false;
				cpt++;
		}
		*/
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
        /*
         * //Partie1: verifie si les voisins sont diff de la ville elle meme		
		for (Ville v : this.voisinsEntrants){
			if (this.typeV == v.typeV) { 
				return false;
				}
			}
        for (Ville v : this.voisinsSortants){
        	if (this.typeV==v.typeV){
        		return false;
        		}
        	}
        */
        /*
         * 
         
        //Partie2: verifie si les voisins sont tts de type diff
        for(int i=0; i<this.voisinsEntrants.length; i++){
        	for(int j = i+1; j<this.voisinsEntrants.length; j++){
        		//if (this.voisinsEntrants[i] == this.voisinsEntrants[j]) { 
        		if (this.voisinsEntrants[i].equals(this.voisinsEntrants[j])) {
    				return false;
    				}
    			}
        	}
        for(int i=0; i<this.voisinsSortants.length; i++){
        	for(int j = i+1; j<this.voisinsSortants.length; j++){
        		//if (this.voisinsSortants[i] == this.voisinsSortants[j]) { 
        		if (this.voisinsSortants[i].equals(this.voisinsSortants[j])) {        		
    				return false;
    				}
    			}
        	}	
        */
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
		/*
		for (Ville v : this.voisinsEntrants){
			if (this.nombreFleurs < v.nombreFleurs){
				return false;
				}
			
		}
		*/
		/*
		 * 
		for (Ville v : this.voisinsSortants){
			if (this.nombreFleurs < v.nombreFleurs){
				return false;
				}
			
		}
		*/
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
			
			/*
			 * Tab Statique
			for(Ville v : this.voisinsEntrants){
				
				if( ! v.couleur.equalsIgnoreCase("Rouge")){
					return false;
					}
				}
			for(Ville v : this.voisinsSortants){
				
				if( ! v.couleur.equalsIgnoreCase("Rouge")){
					return false;
					}
				}
		    */
			
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
		/*
		 * Tab statique
		for(Ville tampon : this.voisinsEntrants){
			if(tampon.equals(v)){
				return true;
			}
		}		
		return false;
		*/
		return this.voisEnt.contains(v);
	}

	// *Made by Legend: Verifie si v appartient au liste des voisins Sortant
	public boolean voisinSort(Ville v){
		/*
		for(Ville tampon : this.voisinsSortants){
			if(tampon.equals(v)){
				return true;
			}
		}
		return false;
		*/
		return this.voisSort.contains(v);
	}
	
	public boolean cheminExiste(Ville fin, Ville... chemin){
		Ville tampon = this;
		/*
		for(int i = 0; i < chemin.length; i++){
			if(tampon.voisinSort(chemin[i])){
				tampon = chemin[i];
			} else {
				return false;
			}
		}
		if(tampon.voisinSort(fin)){
			return true;
		}
		return false;
		*/
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
			
}