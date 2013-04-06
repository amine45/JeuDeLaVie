package test;



import java.util.ArrayList;

import org.junit.Test;
import JeuDeLaVie.Cellule;
import JeuDeLaVie.Coordonnees;
import JeuDeLaVie.Univers;

public class TestUnivers{
	protected Cellule c;
	protected Univers uni;

	@Test
	public void testCellExists() {
		Coordonnees coord, coord1, coord2;
		coord2 = new Coordonnees(0, 0);
		c = new Cellule(coord = new Coordonnees(1, 2), "vivante");
		Cellule s = new Cellule(coord1 = new Coordonnees(2, 3), "morte");
		uni = new Univers();
		uni.getLemonde().add(c);
		uni.getCelmortes().add(s);
		org.junit.Assert.assertEquals(c, uni.cellExists(coord));
		org.junit.Assert.assertEquals(s, uni.cellExists(coord1));
		org.junit.Assert.assertEquals(new Cellule(coord2, "vivante"),
				uni.cellExists(coord2));
	}

	@Test
	public void testAddDeadCells() {
		c = new Cellule(new Coordonnees(1, 1), "vivante");
		uni = new Univers();
		uni.getLemonde().add(c);
		int taille = uni.getLemonde().size();
		uni.addDeadCells();
		org.junit.Assert.assertEquals("morte", c.getEtat_suivant());
		org.junit.Assert.assertEquals(uni.getLemonde().size(), taille);
		Cellule a, b;
		a = new Cellule(new Coordonnees(0, 1), "vivante");
		b = new Cellule(new Coordonnees(2, 1), "vivante");
		c = new Cellule(new Coordonnees(1, 1), "vivante");
		uni.getLemonde().add(a);
		uni.getLemonde().add(b);
		uni.getLemonde().add(c);
		uni.addDeadCells();
		org.junit.Assert.assertEquals(a.getEtat_suivant(), "morte");
		org.junit.Assert.assertEquals(b.getEtat_suivant(), "morte");
		org.junit.Assert.assertEquals(c.getEtat_suivant(), "vivante");

	}

	@Test
	public void testVerifyListDeadCells() {
		Cellule e, f, g;
		uni = new Univers();
		c = new Cellule(new Coordonnees(1, 1), "vivante");
		uni.getLemonde().add(c);
		uni.getLemonde().add(new Cellule(new Coordonnees(0, 1), "vivante"));
		uni.getLemonde().add(new Cellule(new Coordonnees(2, 1), "vivante"));
		uni.getCelmortes().add(e = new Cellule(new Coordonnees(1, 0), "morte"));
		uni.getCelmortes().add(f = new Cellule(new Coordonnees(1, 2), "morte"));
		uni.getCelmortes().add(g = new Cellule(new Coordonnees(4, 4), "morte"));
		uni.verifyListDeadCells();
		org.junit.Assert.assertEquals("vivante", e.getEtat_suivant());
		org.junit.Assert.assertEquals("vivante", f.getEtat_suivant());
		org.junit.Assert.assertEquals(g.getEtat(), g.getEtat_suivant());
	}

	@Test
	public void testChangeState() {
		uni = new Univers();
		c = new Cellule(new Coordonnees(1, 1), "vivante");
		c.setEtat_suivant("morte");
		ArrayList<Cellule> s = new ArrayList<Cellule>();
		s.add(c);
		uni.setLemonde(s);
		uni.changeState();
		org.junit.Assert.assertEquals("morte", c.getEtat());
		Cellule a, b;
		a = new Cellule(new Coordonnees(0, 1), "morte");
		b = new Cellule(new Coordonnees(2, 1), "morte");
		a.setEtat_suivant("vivante");
		b.setEtat_suivant("vivante");
		uni.getCelmortes().add(a);
		uni.getCelmortes().add(b);
		uni.changeState();
		org.junit.Assert.assertFalse(uni.getCelmortes().contains(a));
		org.junit.Assert.assertFalse(uni.getCelmortes().contains(b));
		org.junit.Assert.assertTrue(uni.getLemonde().contains(a));
		org.junit.Assert.assertTrue(uni.getLemonde().contains(a));
	}

	@Test
	public void testIsPresent() {
		uni = new Univers();
		c = new Cellule(new Coordonnees(1, 1), "vivante");
		ArrayList<Cellule> Ar = new ArrayList<Cellule>();
		Ar.add(c);
		uni.setLemonde(Ar);
		org.junit.Assert.assertTrue(uni.isPresent(c.getCoord().x,
				c.getCoord().y));
		org.junit.Assert.assertFalse(uni.isPresent(0, 0));
	}

	@Test
	public void testNextGeneration() {
		Cellule a, b,  f, g;
		uni = new Univers();
		a = new Cellule(new Coordonnees(0, 1), "vivante");
		b = new Cellule(new Coordonnees(2, 1), "vivante");
		c = new Cellule(new Coordonnees(1, 1), "vivante");
		f = new Cellule(new Coordonnees(1, 0), "morte");
		g = new Cellule(new Coordonnees(1, 2), "morte");
		uni.getLemonde().add(a);
		uni.getLemonde().add(b);
		uni.getLemonde().add(c);
		uni.getCelmortes().add(f);
		uni.getCelmortes().add(g);
		uni.nextGeneration();
		org.junit.Assert.assertEquals(3, uni.getLemonde().size());
		org.junit.Assert.assertEquals("vivante", f.getEtat());
		org.junit.Assert.assertEquals("vivante", g.getEtat());
		org.junit.Assert.assertEquals("vivante", c.getEtat());
		org.junit.Assert.assertEquals("morte", a.getEtat());
		org.junit.Assert.assertEquals("morte", b.getEtat());
	}

	@Test
	public void testCheckCoord() {
		Coordonnees s;
		uni = new Univers();
		c = new Cellule(s = new Coordonnees(1, 1), "vivante");
		org.junit.Assert.assertEquals(s.x, (uni.checkCoord(s.x, s.y)).x);
		org.junit.Assert.assertEquals(s.y, (uni.checkCoord(s.x, s.y)).y);
	}

	@Test
	public void testGetMinligne() {
		Univers s = new Univers();
		s.setMinligne(0);
		org.junit.Assert.assertEquals(0, s.getMinligne());
	}

	@Test
	public void testSetMinligne() {
		Univers s = new Univers();
		s.setMinligne(-3);
		org.junit.Assert.assertEquals(-3, s.getMinligne());
	}

	@Test
	public void testGetMincolonne() {
		uni = new Univers();
		uni.setMincolonne(0);
		org.junit.Assert.assertEquals(0, uni.getMincolonne());
	}

	@Test
	public void testSetMincolonne() {
		uni = new Univers();
		uni.setMincolonne(0);
		org.junit.Assert.assertEquals(0, uni.getMincolonne());
	}

	@Test
	public void testGetMaxcolonne() {
		uni = new Univers();
		uni.setNbcolonne(5);
		org.junit.Assert.assertEquals(5, uni.getNbcolonne());
	}

	@Test
	public void testSetMaxcolonne() {
		uni = new Univers();
		uni.setNbcolonne(10);
		org.junit.Assert.assertEquals(10, uni.getNbcolonne());
	}

	@Test
	public void testGetMaxligne() {
		uni = new Univers();
		uni.setNbligne(7);
		org.junit.Assert.assertEquals(7, uni.getNbligne());
	}

	@Test
	public void testSetMaxligne() {
		uni = new Univers();
		uni.setNbligne(10);
		org.junit.Assert.assertEquals(10, uni.getNbligne());
	}

	@Test
	public void testGetLemonde() {
		uni = new Univers();
		ArrayList<Cellule> s = new ArrayList<Cellule>();
		uni.setLemonde(s);
		org.junit.Assert.assertEquals(s, uni.getLemonde());
	}

	@Test
	public void testSetLemonde() {
		uni = new Univers();
		ArrayList<Cellule> s = new ArrayList<Cellule>();
		uni.setLemonde(s);
		org.junit.Assert.assertEquals(s, uni.getLemonde());

	}

	@Test
	public void testGetCelmortes() {
		uni = new Univers();
		ArrayList<Cellule> s = new ArrayList<Cellule>();
		uni.setCelmortes(s);
		org.junit.Assert.assertEquals(s, uni.getCelmortes());
	}

	@Test
	public void testSetCelmortes() {
		uni = new Univers();
		ArrayList<Cellule> s = new ArrayList<Cellule>();
		uni.setCelmortes(s);
		org.junit.Assert.assertEquals(s, uni.getCelmortes());
	}

}
