import java.util.ArrayList;

public class Application {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//Stockage de villes dans un tableau dynamique
		ArrayList<Ville> villes=new ArrayList();
		Ville v = new Ville("Babez", "", 365.72, 10000);
		villes.add(v);
		v.setNombreFleurs(0);
		v.setType("ordinaire");
		
		v.couleurAffiche();
		
		
	}

}
