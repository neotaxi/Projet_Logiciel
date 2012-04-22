package metro;

import java.awt.Point;

public class Station {
	private String nom;
	private Point Pos_station;
	private Voie[] Ligne_Adjacentes;
	
	public Station(String nom,Point Pos_station, Voie[] ligne_Adjacentes) {
		this.nom = nom;
		this.Pos_station=Pos_station;
		Ligne_Adjacentes = ligne_Adjacentes;
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
	public Voie[] getLigne_Adjacentes() {
		return Ligne_Adjacentes;
	}
	public void setLigne_Adjacentes(Voie[] ligne_Adjacentes) {
		Ligne_Adjacentes = ligne_Adjacentes;
	}
}
