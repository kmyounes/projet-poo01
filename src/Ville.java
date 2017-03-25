
import java.util.ArrayList;
import java.util.Arrays;

public class Ville {
  //=====================Types=============================
  private enum types{
	  agricole, touristique, industrielle, ordinaire
	  }


	//=====================Variables========================
	
	private String nom,wilaya;
	private double superficie;
	private int nombreFleurs, habitants, numEnt = 0, numSort = 0;  //numSort: last index in the Sortant table
	private Ville[] voisinsEntrants;
	private Ville[] voisinsSortants;
	private types typeV;
	private String couleur;
	private static int numero = 0;

  //=====================Constructeurs========================

	public Ville(String nom, String wilaya, double superficie, int habitants) {
		this.nom = nom;
		this.wilaya = wilaya;
		this.superficie = superficie;
		this.habitants = habitants;
		this.voisinsEntrants = new Ville[10];
		this.voisinsSortants = new Ville[10];
		numero ++;
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

	public int getNumero(){
		return numero;
	}
	
	
	
	//=====================Méthodes========================

	// *Reworked by Legend 
	public void couleurAffiche(){
		System.out.printf("Ville de couleur: ");
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
		System.out.print(this.couleur);
	}
	
	/*
	 * I edited this method since we should look for the number of cities that we go to! 
	 * 
	 */
	public boolean pasChemin(){
		for(Ville v : this.voisinsSortants){
			if(v != null)
				return false;
		}
		return true;
	}
	
	public boolean existe3Chemin(){
		int cpt = 0;
		for(Ville v : this.voisinsSortants){
			if(v != null)
				if(cpt == 3)
					return false;
				cpt++;
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
		
		for (Ville v : this.voisinsSortants){
			if (this.nombreFleurs < v.nombreFleurs){
				return false;
				}
			
		}
		return true;		
	}
	
	// *Reworked by Legend: Use method equals with strings!
	public boolean methodeBizzare(){
		//if (this.typeV !=types.valueOf("ordinaire") && this.couleur.equalsIgnoreCase("Vert")){
		if (!this.typeV.equals(types.valueOf("ordinaire")) && this.couleur.equalsIgnoreCase("Vert")){
			for(Ville v : this.voisinsEntrants){
				//if(v.couleur.equalsIgnoreCase("Rouge") == false){
				if( ! v.couleur.equalsIgnoreCase("Rouge")){
					return false;
					}
				}
			for(Ville v : this.voisinsSortants){
				//if(v.couleur.equalsIgnoreCase("Rouge") == false){
				if( ! v.couleur.equalsIgnoreCase("Rouge")){
					return false;
					}
				}
			return true;
			}
		else {
			return false;
			}
		}
	
	// *Made by Legend: Verifie si v appartient au liste des voisins Entrant
	public boolean voisinEnt(Ville v){
		for(Ville tampon : this.voisinsEntrants){
			if(tampon.equals(v)){
				return true;
			}
		}
		return false;
	}

	// *Made by Legend: Verifie si v appartient au liste des voisins Sortant
	public boolean voisinSort(Ville v){
		for(Ville tampon : this.voisinsSortants){
			if(tampon.equals(v)){
				return true;
			}
		}
		return false;
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
		return tampon.voisinSort(fin);
	}
	
	// *Made by Kmy: 
	//This isnt working
	public boolean existeChemin(Ville debut,Ville fin){
		Arrays.sort(voisinsSortants);
		boolean v=false;
		if(this.voisinsSortants.length==0 ){
			return false;
		}
		if (Arrays.binarySearch(voisinsSortants, fin)>=0){
			return true;
			}else
				{
					for(Ville V: debut.voisinsSortants){
				
			
					v=existeChemin(V,fin);
					if(v){
							return v;
			
						  }
		             }
		
	             }
		return false;
	}

	public void addVilleSort(Ville v){
		this.voisinsSortants[this.numSort] = v;
		this.numSort++;
	}
	
	public void addVilleEnt(Ville v){
		this.voisinsEntrants[this.numEnt] = v;
		this.numEnt++;
	}
	//====== Pratitionnement
	private boolean appartientPas(ArrayList<ArrayList<Ville>> parts){
		for(ArrayList<Ville>a : parts ) {
			if (a.contains(this)) return false;
		}
		return true;
	}

	/*static public ArrayList<ArrayList<Ville>> Partitons(){
		ArrayList<ArrayList<Ville>> G = new ArrayList<ArrayList<Ville>>();
		ArrayList<Ville> tmp = new ArrayList<Ville>();
		for (Ville v: Application.villes){
			if(v.appartientPas(G)) {

				tmp = new ArrayList<Ville>();
				tmp.add(v);
				if (v.voisinsSortants != null) {
					for (int i=0;i<v.voisinsSortants.length-1;i++) {
						if (v.voisinsSortants[i].voisinsSortants != null) {
							for (int j=0;j< v.voisinsSortants[i].voisinsSortants.length;j++) {
								if (v.voisinsSortants[i].voisinsSortants[j].equals(v)) tmp.add(v.voisinsSortants[i].voisinsSortants[j]);
							}
						}
					}

				}
			}
			G.add(tmp);
		}
      return G;

	}
 */

	public ArrayList<Ville> composantConnexe(){
 int i=0;
 int j=0;
		ArrayList<Ville> tmp= new ArrayList<Ville>();
		tmp.add(this);
		if (this.voisinsSortants != null) {
			while(this.voisinsSortants[i]!=null){
				Ville v=this.voisinsSortants[i];
				if (v.getVoisinsSortants() != null) {
					while(this.voisinsSortants[i].getVoisinsSortants()[j]!=null) {
						if (this.voisinsSortants[i].voisinsSortants[j].equals(this)) tmp.add(this.voisinsSortants[i]);
				        j++;
					}
				}
				i++;
			}
		}
return tmp;
	}

public static ArrayList<ArrayList<Ville>> partitionsConnexes(){
	ArrayList<ArrayList<Ville>> g = new ArrayList<ArrayList<Ville>>();
	for(Ville v: Application.villes) g.add(v.composantConnexe());

	return g;
}







}