package test;

import org.junit.Test;
import JeuDeLaVie.Cellule;
import JeuDeLaVie.Coordonnees;

public class CelluleTest {
	protected Cellule c;

	@Test
	public void testGetCoord() {

		c = new Cellule(new Coordonnees(1, 4), "vivante");
		org.junit.Assert.assertEquals(1, c.getCoord().x);
		org.junit.Assert.assertEquals(4, c.getCoord().y);
	}

	@Test
	public void testSetCoord() {
		c = new Cellule(new Coordonnees(1, 1), "vivante");
		Coordonnees s;
		c.setCoord(s = new Coordonnees(2, 2));
		org.junit.Assert.assertEquals(s, c.getCoord());
	}

	@Test
	public void testGetEtat() {
		c = new Cellule(new Coordonnees(1, 1), "vivante");
		org.junit.Assert.assertEquals("vivante", c.getEtat());
		c = new Cellule(new Coordonnees(1, 2), "morte");
		org.junit.Assert.assertEquals("morte", c.getEtat());
	}

	@Test
	public void testGetEtat_suivant() {
		c = new Cellule(new Coordonnees(2, 1), "morte");
		c.setEtat_suivant("vivante");
		org.junit.Assert.assertEquals("vivante", c.getEtat_suivant());
	}

	@Test
	public void testSetEtat_suivant() {
		c = new Cellule(new Coordonnees(1, 1), "vivante");
		c.setEtat_suivant("morte");
		org.junit.Assert.assertEquals("morte", c.getEtat_suivant());
	}

	@Test
	public void testSetEtat() {
		c = new Cellule(new Coordonnees(1, 1), "vivante");
		c.setEtat("morte");
		org.junit.Assert.assertEquals("morte", c.getEtat());
	}

	@Test
	public void testCompareTo() {
		c = new Cellule(new Coordonnees(1, 3), "vivante");
		Cellule c2 = new Cellule(new Coordonnees(2, 5), "vivante");
		org.junit.Assert.assertEquals(c.getCoord().x - c2.getCoord().x,
				c.compareTo(c2));
		c2.setCoord(new Coordonnees(1, 5));
		org.junit.Assert.assertEquals(c.getCoord().y - c2.getCoord().y,
				c.compareTo(c2));
	}

	@Test
	public void testEqualsObject() {

	}

}
