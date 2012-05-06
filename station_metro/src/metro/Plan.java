package metro;

import java.awt.Point;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
;public class Plan {
	public Station[] Stations;
	public Voie[] Reseau;
	/**
	 * @param args
	 */
	public Plan() {
		Station[] Stations={
						new Station("La Defense", new Point(137,318)),
						new Station("Charles de Gaule", new Point(281,465)),
						new Station("Chatelet", new Point(603,580)),
						new Station("Gare de Lyon", new Point(765,721)),
						new Station("Nation", new Point(900,667)),
						new Station("Gare du Nord", new Point(700,351)),
						new Station("Saint-Denis", new Point(540,95)),
						new Station("Denfert", new Point(582,831))};
		this.Stations=Stations;
		Voie[] Reseau={new Voie(1,  new Portion[] {new Portion(this.get_station("La Defense"),this.get_station("Charles de Gaule"),5),
				                                   new Portion(get_station("Charles de Gaule"),get_station("Chatelet"),10),
				                                   new Portion(get_station("Chatelet"),get_station("Gare de Lyon"),5),
				                                   new Portion(get_station("Gare de Lyon"),get_station("Nation"),7)}),
				       new Voie(2,  new Portion[] {new Portion(get_station("Charles de Gaule"),get_station("Gare du Nord"),12),
					                               new Portion(get_station("Gare du Nord"),get_station("Nation"),15)}),
					   new Voie(3,  new Portion[] {new Portion(get_station("Saint-Denis"),get_station("Gare du Nord"),8),
							   					   new Portion(get_station("Gare du Nord"),get_station("Chatelet"),7),
							   					   new Portion(get_station("Chatelet"),get_station("Denfert"),9)}),
					   new Voie(4,  new Portion[] {new Portion(get_station("Charles de Gaule"),get_station("Denfert"),15),
									   			   new Portion(get_station("Denfert"),get_station("Nation"),9)})	   					   
					   
				       };
		
		this.Reseau=Reseau;
		
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
 
			if(Math.pow(s.getPos_station().x-p.getLocation().x,2)+Math.pow(s.getPos_station().y-p.getLocation().y,2)
			 > Math.pow(x.getPos_station().x-p.getLocation().x,2)+Math.pow(x.getPos_station().y-p.getLocation().y,2))
				s=x;
		}
		return s;
	}
	public int getCaseStation(String s){
		int i=0;
		for(Station x: this.Stations){
			if(s==x.getNom())
				return i;
			i++;
		}
		return i;
	}
	public ArrayList<Station> Chemin_le_plus_court(Station depart,Station arrive){
		LinkedList<Station> StationsAVisiter=new LinkedList<Station>(Arrays.asList(this.Stations));
		Station[] Parent= new Station[this.Stations.length];
		int[] Poids_actuel=new int[this.Stations.length];
		int i=0;
		Station StationEnTest;
		for(int p: Poids_actuel){
			Poids_actuel[i]=10000;
			Parent[i]=null;
			i++;
		}
		i=0;
		Poids_actuel[this.getCaseStation(depart.getNom())]=0;
		while (!StationsAVisiter.isEmpty()){
			
			i=0;
			StationEnTest=StationsAVisiter.get(0);
			for (int p: Poids_actuel){
				
				Station s=Stations[i];
				System.out.println("s="+s.getNom()+" "+StationsAVisiter.contains(s)+"y");
				System.out.println("p="+p+" "+Poids_actuel[this.getCaseStation(s.getNom())]);
				if(p<Poids_actuel[this.getCaseStation(StationEnTest.getNom())]&&StationsAVisiter.contains(s))
					StationEnTest=s;
				i++;
			}
			System.out.println(StationsAVisiter.contains(StationEnTest)+" ");
			//Station x   sommet de la liste visite avec d(x) minimal.
			System.out.println("stationen test"+StationEnTest.getNom());
			StationsAVisiter.remove(StationEnTest);
			System.out.println(StationsAVisiter.contains(StationEnTest)+"z");
			//SupprimerDansListe(visite, x)
			for(Voie v: this.Reseau){
				for(Portion p: v.getItinéraire()){
					if(p.S1.equals(StationEnTest)||p.S2.equals(StationEnTest)){//donc c'est une portion atteignable
						//Nous allons peut etre mettre à jour le poid de la station S1 ou S2
						if(p.S1.equals(StationEnTest)){//La station S2 sera peut-etre maj
							System.out.println("azerty");
							if(Poids_actuel[this.getCaseStation(p.S1.getNom())]+p.nb_min<Poids_actuel[this.getCaseStation(p.S2.getNom())]){
								System.out.println("gare maj="+p.S2.getNom()+"gare pere="+p.S1.getNom());
								Poids_actuel[this.getCaseStation(p.S2.getNom())]=Poids_actuel[this.getCaseStation(p.S1.getNom())]+p.nb_min;
								Parent[this.getCaseStation(p.S2.getNom())]=p.S1;
								System.out.println("new pere="+Parent[this.getCaseStation(p.S2.getNom())]+" "+this.getCaseStation(p.S2.getNom()));
								
							}
						}
						else{
							if(Poids_actuel[this.getCaseStation(p.S2.getNom())]+p.nb_min<Poids_actuel[this.getCaseStation(p.S1.getNom())]){
								System.out.println("gare maj="+p.S1.getNom()+"gare pere="+p.S2.getNom());
								Poids_actuel[this.getCaseStation(p.S1.getNom())]=Poids_actuel[this.getCaseStation(p.S2.getNom())]+p.nb_min;
								
								Parent[this.getCaseStation(p.S1.getNom())]=p.S2;
							}
						}
					}
				}
			}
		}
		
		System.out.println(arrive.getNom()+" est a "+Poids_actuel[this.getCaseStation(arrive.getNom())]);
		ArrayList <Station> Chemin_Le_Plus_Court=new ArrayList<Station>();
		while (arrive!=null){
			System.out.println("arrive="+arrive.getNom());
			//System.out.println(Parent[this.getCaseStation(arrive.getNom())]==null?Parent[this.getCaseStation(arrive.getNom())].getNom():"");
			//System.out.println(this.getCaseStation(s.getNom()));
			Chemin_Le_Plus_Court.add(arrive);
			arrive=Parent[this.getCaseStation(arrive.getNom())];
		}
		Collections.reverse(Chemin_Le_Plus_Court);
		System.out.println("res="+Chemin_Le_Plus_Court);
		return Chemin_Le_Plus_Court;
		
	}
	public void AfficheChemin(ArrayList<Station> chemin_Le_Plus_Court) {
		System.out.println("En partant de "+chemin_Le_Plus_Court.get(0).getNom());
		System.out.println("Pour aller à "+chemin_Le_Plus_Court.get(chemin_Le_Plus_Court.size()-1).getNom());
		int voie_actu=0;
		ArrayList<Station> cp_chemin_Le_Plus_Court=new ArrayList<Station>(chemin_Le_Plus_Court);
		while (cp_chemin_Le_Plus_Court.size()>1){
			System.out.println("go"+cp_chemin_Le_Plus_Court.get(0).getNom());
			for(Voie v: this.Reseau){
				for(Portion p: v.getItinéraire()){
					if(p.S1==cp_chemin_Le_Plus_Court.get(0)&&p.S2==cp_chemin_Le_Plus_Court.get(1))
						if(v.getNumLigne()!=voie_actu){
							System.out.println("A "+cp_chemin_Le_Plus_Court.get(0).getNom()+" prenez la voie " + v.getNumLigne() );
							voie_actu=v.getNumLigne();
						}
					if(p.S2==cp_chemin_Le_Plus_Court.get(0)&&p.S1==cp_chemin_Le_Plus_Court.get(1))
						if(v.getNumLigne()!=voie_actu){
							System.out.println("A "+cp_chemin_Le_Plus_Court.get(0).getNom()+" prenez la voie " + v.getNumLigne()+"." );
							voie_actu=v.getNumLigne();
						}
				}
			}
			cp_chemin_Le_Plus_Court.remove(0);
			if(cp_chemin_Le_Plus_Court.size()==1)
				System.out.println("Vous ètes arrivé à "+cp_chemin_Le_Plus_Court.get(0).getNom());
			
		}
	}
	public int LongueurChemin(ArrayList<Station> chemin_Le_Plus_Court) {
		System.out.println("En partant de "+chemin_Le_Plus_Court.get(0).getNom());
		System.out.println("Pour aller à "+chemin_Le_Plus_Court.get(chemin_Le_Plus_Court.size()-1).getNom());
		int poids_total=0;
		ArrayList<Station> cp_chemin_Le_Plus_Court=new ArrayList<Station>(chemin_Le_Plus_Court);
		while (cp_chemin_Le_Plus_Court.size()>1){
			System.out.println("go"+cp_chemin_Le_Plus_Court.get(0).getNom());
			for(Voie v: this.Reseau){
				for(Portion p: v.getItinéraire()){
					if(p.S1==cp_chemin_Le_Plus_Court.get(0)&&p.S2==cp_chemin_Le_Plus_Court.get(1)||p.S2==cp_chemin_Le_Plus_Court.get(0)&&p.S1==cp_chemin_Le_Plus_Court.get(1))
						poids_total+=p.nb_min;
				}
			}
			cp_chemin_Le_Plus_Court.remove(0);
			
		}
		return poids_total;
	}
}
