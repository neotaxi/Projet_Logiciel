package metro;

import java.util.ArrayList;
import java.util.Collections;

public class Voie {
	private int numLigne;
	private ArrayList<Portion> Itineraire;
	
	public int getNumLigne() {
		return numLigne;
	}

	public void setNumLigne(int numLigne) {
		this.numLigne = numLigne;
	}

	public ArrayList<Portion> getItinéraire() {
		return Itineraire;
	}

	public void setItineraire(ArrayList<Portion> itineraire) {
		Itineraire = itineraire;
	}

	public Voie(int numLigne, ArrayList<Portion> Itineraire){
		this.numLigne=numLigne;
		this.Itineraire=Itineraire;
	}

	public Voie(int numLigne, Portion[] portions) {
		this.numLigne=numLigne;
		Itineraire = new ArrayList<Portion>();
		Collections.addAll(Itineraire, portions); ;
	}

}
