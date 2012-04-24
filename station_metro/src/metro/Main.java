package metro;

import java.awt.Point;
import java.util.Scanner;

public class Main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Plan p=new Plan();
		Utilisateur u=new Utilisateur(new Point(905,660),true);
		
		System.out.println("Selectionner une station de départ");
		System.out.println("1: Automatiquement");
		System.out.println("2: Dans la liste");
		Scanner sc=new Scanner(System.in);
		int rep=sc.nextInt();
		Station Depart=null;
		Station Arrive=null;
		switch (rep){
			case 1:
				break;
			case 2:
				int i=0;
				for (Station s: p.Stations){
					System.out.println(i+": "+s.getNom());
					
					i++;
				}
				rep=sc.nextInt();
				Depart=p.Stations[rep];
				break;
		}
		System.out.println(Depart.getNom());

		System.out.println("Selectionner une station d'arrivée");
	}

}
