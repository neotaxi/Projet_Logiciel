package metro;

public class Portion {
	public Station Station_depart;
	public Station Station_arrive;
	public int nb_min;
	public boolean incident;
	public Portion(Station station_depart, Station station_arrive, int nb_min) {
		Station_depart = station_depart;
		Station_arrive = station_arrive;
		this.nb_min = nb_min;
		this.incident=false;
	}


}
