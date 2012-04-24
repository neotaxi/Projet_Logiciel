package metro;
import java.awt.Point;

import junit.framework.TestCase;
public class PlanTest extends TestCase{
	public void testget_station_voisine() {
		  Plan p=new Plan();
		  Utilisateur u=new Utilisateur(new Point(905,660),true);
		  assertEquals(p.get_station("Nation").getNom(), p.get_station_voisine(u.getGPS()).getNom());
		  u.setGPS(new Point(582,831));
		  assertEquals(p.get_station("Denfert"), p.get_station_voisine(u.GPS));
		  u.setGPS(new Point(554,106));
		  assertEquals(p.get_station("Saint-Denis"), p.get_station_voisine(u.GPS));
		  
	}

}
