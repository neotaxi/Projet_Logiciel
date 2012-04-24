package metro;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Hashtable;
import java.lang.Math.*
;public class Plan {
	public Station[] Stations;
	public Voie[] Réseau;
	/**
	 * @param args
	 */
	public Plan() {
		Station[] Stations={
						new Station("La Défense", new Point(137,318)),
						new Station("Charles de Gaule", new Point(281,465)),
						new Station("Chatelet", new Point(603,580)),
						new Station("Gare de Lyon", new Point(765,721)),
						new Station("Nation", new Point(900,667)),
						new Station("Gare du Nord", new Point(700,351)),
						new Station("Saint-Denis", new Point(540,95)),
						new Station("Denfert", new Point(582,831))};
		this.Stations=Stations;
		Voie[] Réseau={new Voie(1, 
				new Portion[] {
											       new Portion(this.get_station("La Défense"),this.get_station("Charles de Gaule"),5),
				                                   new Portion(get_station("Charles de Gaule"),get_station("Chatelet"),10),
				                                   new Portion(get_station("Chatelet"),get_station("Gare de Lyon"),8),
				                                   new Portion(get_station("Gare de Lyon"),get_station("Nation"),7)}),
				       new Voie(2,  new Portion[] {new Portion(get_station("Charles de Gaule"),get_station("Gare du Nord"),12),
					                               new Portion(get_station("Gare du Nord"),get_station("Nation"),10)}),
					   new Voie(3,  new Portion[] {new Portion(get_station("Saint-Denis"),get_station("Gare du Nord"),8),
							   					   new Portion(get_station("Gare du Nord"),get_station("Chatelet"),7),
							   					   new Portion(get_station("Chatelet"),get_station("Denfert"),9)}),
					   new Voie(3,  new Portion[] {new Portion(get_station("Charles de Gaule"),get_station("Denfert"),15),
									   			   new Portion(get_station("Denfert"),get_station("Nation"),9)})	   					   
					   
				       };
		

	}
	public Station get_station(String station){
		for(Station s: this.Stations)
			if(s.getNom()==station)
				return s;
		return null;
	}
	public Station get_station_voisine(Point p){
		Station s = new Station("Init", new Point(-1000,-1000));
		for(Station x: this.Stations){
			System.out.println("1="+"s="+s.getNom()+" "+(Math.pow(s.getPos_station().x-p.getLocation().x,2)+Math.pow(s.getPos_station().y-p.getLocation().y,2)));
			System.out.println("2="+"x="+x.getNom()+" "+(Math.pow(x.getPos_station().x-p.getLocation().x,2)+Math.pow(x.getPos_station().y-p.getLocation().y,2)));
			System.out.println("p="+p.toString());
			System.out.println("x="+x.getPos_station().toString());

			System.out.println("s="+s.getPos_station().toString());

			if(Math.pow(s.getPos_station().x-p.getLocation().x,2)+Math.pow(s.getPos_station().y-p.getLocation().y,2)
			 > Math.pow(x.getPos_station().x-p.getLocation().x,2)+Math.pow(x.getPos_station().y-p.getLocation().y,2))
				s=x;
		}
		return s;
	}

}
