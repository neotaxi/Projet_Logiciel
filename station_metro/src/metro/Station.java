package metro;

import java.awt.Point;

public class Station {
	private String nom;
	private Point Pos_station;
	
	public Station(String nom,Point Pos_station) {
		this.nom = nom;
		this.Pos_station=Pos_station;
	}

	public Point getPos_station() {
		return Pos_station;
	}

	public void setPos_station(Point pos_station) {
		Pos_station = pos_station;
	}

	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public boolean equals (Station S2) {
		return this.nom.equals(S2.nom);
		
		}
}
