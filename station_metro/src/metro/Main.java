package metro;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Plan p=new Plan();
		Utilisateur u=new Utilisateur(new Point(905,660));
		
		System.out.println("Selectionnez la station de d�part");
		System.out.println("1: Automatiquement");
		System.out.println("2: Dans la liste");
		Scanner sc=new Scanner(System.in);
		int rep=sc.nextInt();
		int num_station_d=0;
		Station Depart=null;
		Station Arrive=null;
		int i=0;
		switch (rep){
			case 1:
				Station station=p.get_station_voisine(u.getGPS());
				
				for (Station s: p.Stations){
					if(station==s)
						break;
						i++;
				}
				num_station_d=i;
				System.out.println("Vous etes a "+(int)(Math.pow(station.getPos_station().x-u.getGPS().x,2)+Math.pow(station.getPos_station().y-u.getGPS().y,2))+" metres de la station "+station.getNom());
				Depart=station;
				break;
			case 2:
				for (Station s: p.Stations){
					System.out.println(i+": "+s.getNom());
					i++;
				}
				rep=sc.nextInt();
				num_station_d=rep;
				Depart=p.Stations[num_station_d];
				System.out.println("La station choisie est "+Depart.getNom());
				break;
		}
		
		System.out.println("Selectionnez la station d'arriv�e");
		i=0;
		int dec=0;
		for (Station s: p.Stations){
			if(i!=num_station_d){//la station de depart n'est pas affich�
				System.out.println((i+dec)+": "+s.getNom());
			}
			else
				dec=-1;//le num�ro de la station est d�cal�
			i++;
		}
		rep=sc.nextInt();
		if (rep>=num_station_d)
			Arrive=p.Stations[rep+1];
		else
			Arrive=p.Stations[rep];
		System.out.println("La station choisie est"+Arrive.getNom());
		Calendar cal = new GregorianCalendar(); 
		int tps_attente= 5-cal.get(Calendar.MINUTE)%5;
		System.out.println("Une nouvelle rame arrive dans "+tps_attente+" mintue(s)");
		ArrayList<Station> Chemin_Le_Plus_Court=p.Chemin_le_plus_court(Depart, Arrive);
		System.out.println("Longueur du chemin: "+p.LongueurChemin(Chemin_Le_Plus_Court)+" minutes.");
		p.AfficheChemin(Chemin_Le_Plus_Court);
	}

}
