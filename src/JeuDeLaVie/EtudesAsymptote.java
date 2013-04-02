package JeuDeLaVie;
import java.util.ArrayList;
import java.util.Iterator;



public class EtudesAsymptote{
	Univers verif_stable;
	Univers verif_oscillateur;
	Univers verif_vaisseau;
	public EtudesAsymptote(Univers a, String file){
		if (a instanceof UniversCirculaire){
			verif_stable=new UniversCirculaire(file,2);
			verif_oscillateur=new UniversCirculaire(file,2);
			verif_vaisseau=new UniversCirculaire(file,2);
		}else{
			if (a instanceof UniversFrontiere){
				verif_stable=new UniversFrontiere(file,3);
				verif_oscillateur=new UniversFrontiere(file,3);
				verif_vaisseau=new UniversFrontiere(file,3);
				
			}else{
				verif_stable=new Univers(file,1);
				verif_oscillateur=new Univers(file,1);
				verif_vaisseau=new Univers(file,1);
			}
		}
	}

	public boolean Mort(Univers a){
		return a.getLemonde().isEmpty();
	}
	
	public boolean Stable (Univers a){
		verif_stable.nextGeneration();
	return a.getLemonde().equals(verif_stable.getLemonde());
	}
	
	public boolean Oscillateur(Univers a){
		verif_oscillateur.nextGeneration();
		verif_oscillateur.nextGeneration();
		return a.getLemonde().equals(verif_oscillateur.getLemonde());
	}
	
	public boolean Vaisseau(Univers a){	
		verif_vaisseau.nextGeneration();
		verif_vaisseau.nextGeneration();
		return verif_deplacement(a.getLemonde(),verif_vaisseau.getLemonde());
		}

public boolean verif_deplacement(ArrayList<Cellule> a, ArrayList<Cellule>b){
	boolean identique;
	
	Iterator<Cellule> it = a.iterator();
	Iterator<Cellule> it1 = b.iterator();
	
	if (a.size()== b.size()) {
	int deplacementX = it.next().getCoord().x - it1.next().getCoord().x;
	int deplacementY = it.next().getCoord().y - it1.next().getCoord().y;
	identique=true;
	while (it.hasNext() && identique) {
	Cellule c1 = (Cellule) it.next();
	Cellule c2 = (Cellule) it1.next();
	if (c1.getCoord().x-c2.getCoord().x!=deplacementX || c1.getCoord().y- c2.getCoord().y!=deplacementY) {
	identique = false;
	}
	}
	return identique;
	
	} else {
	return false;
	
}
		
		}
	
	public int calculePeriode(Univers a){
		ArrayList<Cellule> liste;
		liste=new ArrayList<Cellule>();
		int periode=1;
		Iterator <Cellule> it = a.getLemonde().iterator();
		while (it.hasNext()){
			Cellule cel = (Cellule)it.next();
			liste.add(new Cellule(new Coordonnees(cel.getCoord().x,cel.getCoord().y),"vivante"));
		
	}
		a.nextGeneration();

		while (!a.getLemonde().equals(liste)){
			a.nextGeneration();
			periode++;
		}
	
	
	return periode;
	}
	
	
	public int calculePeriodeVaisseau(Univers a){
		Univers b= new Univers();
		Iterator <Cellule> it1=a.getLemonde().iterator();
		while (it1.hasNext()){
			Cellule a2=(Cellule) it1.next();
			b.getLemonde().add(new Cellule(new Coordonnees(a2.getCoord().x,a2.getCoord().y),"vivante"));
		}
		ArrayList<Cellule> liste;
		liste=new ArrayList<Cellule>();
		int periode=1;
		Iterator <Cellule> it = b.getLemonde().iterator();
		while (it.hasNext()){
			Cellule cel = (Cellule)it.next();
			liste.add(new Cellule(new Coordonnees(cel.getCoord().x,cel.getCoord().y),"vivante"));
		
	}
		b.nextGeneration();

		while (!verif_deplacement(liste,b.getLemonde())){
			
			b.nextGeneration();
			periode++;
		}
	
	return periode;
	}
	
	public int deplacementX(Univers a){
		
		Iterator<Cellule> it = a.getLemonde().iterator();
		Iterator<Cellule> it1 = verif_vaisseau.getLemonde().iterator();
		return it.next().getCoord().x - it1.next().getCoord().x;
	}
	
	public int deplacementY(Univers a){
		Iterator<Cellule> it = a.getLemonde().iterator();
		Iterator<Cellule> it1 = verif_vaisseau.getLemonde().iterator();
		return it.next().getCoord().y - it1.next().getCoord().y;
	}
	
	public String deplacement(Univers a){
		return "("+deplacementX(a)+","+deplacementY(a)+")";
	}
		
	
	
}

