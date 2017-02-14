import java.util.Arrays;

public class Ville {
	
//=====================Constructeurs========================

    // commented
	public Ville(String nom, String wilaya, double superficie, double habitants) {
		this.nom = nom;
		this.wilaya = wilaya;
		this.superficie = superficie;
		this.habitants = habitants;
	}	
	
//variables	
	private String nom,wilaya;
	
	private double superficie,habitants;
	private String type;
	private int nombreFleurs;
	private Ville[] voisins;
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
		return type;
	}
	public void setType(String type) {
		this.type = type;
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
	
	//==============méthodes==============
	
	public void couleurAffiche(){
		switch (this.nombreFleurs){
		case  0 :
			System.out.println("\u001B[31m"+ this.toString()+ "\u001B[0m");
			break ;
		case 1:
			System.out.println("\u001B[31m"+ this.toString()+ "\u001B[0m");
			break;
		case 2:
			
		}
	}
	
}
