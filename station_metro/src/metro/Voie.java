package metro;

import java.util.ArrayList;
import java.util.Collections;

public class Voie {
	private int numLigne;
	private ArrayList<Portion> Itinéraire;
	
	public Voie(int numLigne, ArrayList<Portion> Itinéraire){
		this.numLigne=numLigne;
		this.Itinéraire=Itinéraire;
	}

	public Voie(int numLigne, Portion[] portions) {
		this.numLigne=numLigne;
		Itinéraire = new ArrayList<Portion>();
		Collections.addAll(Itinéraire, portions); ;
	}

}
