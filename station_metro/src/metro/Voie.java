package metro;

public class Voie {
	private String Station_destination;
	private int numLigne;
	private boolean incident;
	private int nb_min;
	public Voie(String station_destination, int numLigne, boolean incident,int nb_min) {
		this.Station_destination = station_destination;
		this.numLigne = numLigne;
		this.incident = incident;
		this.nb_min = nb_min;
	}
	public String getStation_destination() {
		return Station_destination;
	}
	public void setStation_destination(String station_destination) {
		this.Station_destination = station_destination;
	}
	public int getNumLigne() {
		return numLigne;
	}
	public void setNumLigne(int numLigne) {
		this.numLigne = numLigne;
	}
	public boolean isIncident() {
		return incident;
	}
	public void setIncident(boolean incident) {
		this.incident = incident;
	}
	public int getNb_min() {
		return nb_min;
	}
	public void setNb_min(int nb_min) {
		this.nb_min = nb_min;
	}

}
