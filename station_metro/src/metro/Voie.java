package metro;

import java.util.ArrayList;
import java.util.Collections;

public class Voie {
	private int numLigne;
	private ArrayList<Portion> Itin�raire;
	
	public Voie(int numLigne, ArrayList<Portion> Itin�raire){
		this.numLigne=numLigne;
		this.Itin�raire=Itin�raire;
	}

	public Voie(int numLigne, Portion[] portions) {
		this.numLigne=numLigne;
		Itin�raire = new ArrayList<Portion>();
		Collections.addAll(Itin�raire, portions); ;
	}

}
