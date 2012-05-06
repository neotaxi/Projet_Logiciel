package metro;

public class Portion {
	public Station S1;
	public Station S2;
	public int nb_min;
	public boolean incident;
	public Portion(Station S1, Station S2, int nb_min) {
		this.S1 = S1;
		this.S2 = S2;
		this.nb_min = nb_min;
		this.incident=false;
	}


}
