package metro;
import java.awt.Point;
import java.util.ArrayList;

import junit.framework.TestCase;
public class PlanTest extends TestCase{
	public void testget_station_voisine() {
		Plan p=new Plan();
		Utilisateur u=new Utilisateur(new Point(905,660));
		assertEquals(p.get_station("Nation").getNom(), p.get_station_voisine(u.getGPS()).getNom());
		u.setGPS(new Point(582,831));
		assertEquals(p.get_station("Denfert"), p.get_station_voisine(u.GPS));
		u.setGPS(new Point(554,106));
		assertEquals(p.get_station("Saint-Denis"), p.get_station_voisine(u.GPS));
		  
	}
	public void testChemin_le_plus_court(){
		final Plan p=new Plan();
		assertEquals(p.Chemin_le_plus_court(p.get_station("La Defense"), p.get_station("Nation")),new ArrayList<Station>() {{ add(p.get_station("La Defense"));add(p.get_station("Charles de Gaule"));add(p.get_station("Chatelet"));add(p.get_station("Gare de Lyon"));add(p.get_station("Nation"));}});
		assertEquals(p.Chemin_le_plus_court(p.get_station("La Defense"), p.get_station("Denfert")),new ArrayList<Station>() {{ add(p.get_station("La Defense"));add(p.get_station("Charles de Gaule"));add(p.get_station("Denfert"));}});
		assertEquals(p.Chemin_le_plus_court(p.get_station("Nation"), p.get_station("Saint-Denis")),new ArrayList<Station>() {{ add(p.get_station("Nation"));add(p.get_station("Gare du Nord"));add(p.get_station("Saint-Denis"));}});
		
	}
	public void testLongueurChemin() {
		final Plan p=new Plan();
		assertEquals(27,p.LongueurChemin(new ArrayList<Station>() {{ add(p.get_station("La Defense"));add(p.get_station("Charles de Gaule"));add(p.get_station("Chatelet"));add(p.get_station("Gare de Lyon"));add(p.get_station("Nation"));}}));
		assertEquals(40,p.LongueurChemin(new ArrayList<Station>() {{ add(p.get_station("La Defense"));add(p.get_station("Charles de Gaule"));add(p.get_station("Chatelet"));add(p.get_station("Charles de Gaule"));add(p.get_station("Denfert"));}}));
		assertEquals(22,p.LongueurChemin(new ArrayList<Station>() {{ add(p.get_station("La Defense"));add(p.get_station("Charles de Gaule"));add(p.get_station("Chatelet"));add(p.get_station("Gare du Nord"));}}));

	}
}
