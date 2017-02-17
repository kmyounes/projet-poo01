//char inChar = in.next().toLowerCase().charAt(0); 

import java.util.Arrays;

public class Ville {
  //=====================Types=============================
  private enum types{agricole,touristique,industrielle,ordinaire};
 
  
	
	//=====================Variables========================
	
	private String nom,wilaya;
	private double superficie,habitants;
	private int nombreFleurs;
	private Ville[] voisins;
	private types type;
	private String couleur;

  //=====================Constructeurs========================

	public Ville(String nom, String wilaya, double superficie, double habitants) {
		this.nom = nom;
		this.wilaya = wilaya;
		this.superficie = superficie;
		this.habitants = habitants;
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
	
	public double getHabitants() {
		return habitants;
	}
	
	public void setHabitants(double habitants) {
		this.habitants = habitants;
	}
	
	public String getType() {
		return type.name();
	}
	
	public void setType(String type) {
		this.type = types.valueOf(type);
		
	}
	
	public int getNombreFleurs() {
		return nombreFleurs;
	}
	
	public void setNombreFleurs(int nombreFleurs) {
		this.nombreFleurs = nombreFleurs;
	}
	
	public Ville[] getVoisins() {
		return voisins;
	}
	
	public void setVoisins(Ville[] voisins) {
		this.voisins = voisins;
	}

  
	
	@Override
	public String toString() {
		return "Ville [nom=" + nom + ", wilaya=" + wilaya + ", superficie=" + superficie + ", habitants=" + habitants
				+ ", type=" + type + ", nombreFleurs=" + nombreFleurs + ", voisins=" + Arrays.toString(voisins) + "]";
	}
	
	//=====================Méthodes========================
	
	public void couleurAffiche(){
		if(this.type==types.valueOf("ordinaire") &&( this.nombreFleurs<=1)){
		
			System.out.println("\u001B[31m"+ this.toString()+ "\u001B[0m");
			this.couleur="rouge";
		}
		else if ((this.type==types.valueOf("ordinaire") && this.nombreFleurs>0) || (this.type!=types.valueOf("ordinaire") && this.nombreFleurs==0 ) ){
     		//afficher en orange	
			this.couleur="orange";
		}
		else {
			//afficher en vert
			this.couleur="vert";
		}
	}
	
	
	public boolean existeChemin(){
		return (this.voisins.length==0);
	}
	public boolean existeChemin3(){
		return(this.voisins.length==3);
	
	}
	
	public boolean voisinDifferent(){
for (Ville v : this.voisins){
			if (this.type==v.type) { return false;}
			
		}
		return true;
	}
	
	public boolean plusFleurie(){
		for (Ville v : this.voisins){
			if (this.nombreFleurs<v.nombreFleurs) { return false;}
			
		}
		return true;
	}
	
public boolean methodeBizzare(){
	if (this.type!=types.valueOf("ordinaire") && this.couleur=="vert"){
		for(Ville v : this.voisins){
			if(v.couleur!="rouge"){
				return false;
			}
		
		}
		return true;
	}
		else {return false;}
}
}
