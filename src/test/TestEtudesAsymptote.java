package test;

import static org.junit.Assert.*;
import org.junit.Test;
import JeuDeLaVie.Univers;
import JeuDeLaVie.Cellule;
import JeuDeLaVie.Coordonnees;
import JeuDeLaVie.EtudesAsymptote;

public class TestEtudesAsymptote {

	@Test
	public void testEtudesAsymptote() {
		fail("Not yet implemented");
	}

	@Test
	public void testMort() {
		Univers uni = new Univers();
		EtudesAsymptote et = new EtudesAsymptote(uni);
		org.junit.Assert.assertTrue(et.Mort(uni));
	}

	@Test
	public void testStable() {
		Univers a = new Univers();
		Univers b = new Univers();
		Cellule c = new Cellule(new Coordonnees(1, 1), "vivante");
		Cellule h = new Cellule(new Coordonnees(1, 2), "vivante");
		Cellule e = new Cellule(new Coordonnees(2, 1), "vivante");
		Cellule f = new Cellule(new Coordonnees(2, 2), "vivante");
		a.getLemonde().add(c);
		a.getLemonde().add(h);
		a.getLemonde().add(e);
		a.getLemonde().add(f);
		b.getLemonde().add(c);
		b.getLemonde().add(h);
		b.getLemonde().add(e);
		b.getLemonde().add(f);
		// b.getLemonde().addAll(a.getLemonde());
		EtudesAsymptote et = new EtudesAsymptote(a);
		org.junit.Assert.assertFalse(et.Stable(b));
		org.junit.Assert.assertTrue(et.Stable(a));

	}

	@Test
	public void testOscillateur() {
		Univers s = new Univers();
		Cellule a = new Cellule(new Coordonnees(2, 1), "vivante");
		Cellule b = new Cellule(new Coordonnees(2, 2), "vivante");
		Cellule c = new Cellule(new Coordonnees(2, 3), "vivante");
		s.getLemonde().add(a);
		s.getLemonde().add(b);
		s.getLemonde().add(c);
		EtudesAsymptote et = new EtudesAsymptote(s);
		org.junit.Assert.assertFalse(et.Oscillateur(s));
	}

	@Test
	public void testVaisseau() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerif_deplacement() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculePeriode() {
		fail("Not yet implemented");
	}

	@Test
	public void testCalculePeriodeVaisseau() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeplacementX() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeplacementY() {
		fail("Not yet implemented");
	}

	@Test
	public void testDeplacement() {
		fail("Not yet implemented");
	}

}
