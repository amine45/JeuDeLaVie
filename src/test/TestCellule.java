package test;

import org.junit.Test;
import JeuDeLaVie.Cellule;
import JeuDeLaVie.Coordonnees;


public class TestCellule {
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
		Coordonnees s = new Coordonnees(3, 3);
		c = new Cellule(new Coordonnees(1, 3), "vivante");
		Cellule c2 = new Cellule(new Coordonnees(2, 5), "vivante");
		org.junit.Assert.assertEquals(c.getCoord().x - c2.getCoord().x,
				c.compareTo(c2));
		c2.setCoord(new Coordonnees(1, 5));
		org.junit.Assert.assertEquals(c.getCoord().y - c2.getCoord().y,
				c.compareTo(c2));
		org.junit.Assert.assertEquals(Integer.MAX_VALUE, c.compareTo(s));
	}

	@Test
	public void testEqualsObject() {
		Object o = null;
		c = new Cellule(new Coordonnees(1, 1), "vivante");
		Cellule s = new Cellule(new Coordonnees(1, 1), "vivante");
		Cellule m = new Cellule(new Coordonnees(2, 1), "vivante");
		Cellule n = new Cellule(new Coordonnees(1, 2), "vivante");
		Coordonnees coord = new Coordonnees(2, 3);
		org.junit.Assert.assertFalse(c.equals(o));
		org.junit.Assert.assertTrue(c.equals(s));
		org.junit.Assert.assertFalse(c.equals(coord));
		org.junit.Assert.assertFalse(c.equals(m));
		org.junit.Assert.assertFalse(c.equals(n));
		org.junit.Assert.assertTrue(c.equals(c));
	}

	@Test
	public void testSetCoordonnees() {
		c = new Cellule(new Coordonnees(1, 1), "vivante");
		c.setCoord(new Coordonnees(2, 2));
		org.junit.Assert.assertEquals(2, c.getCoord().x);
		org.junit.Assert.assertEquals(2, c.getCoord().y);
	}

	@Test
	public void testToString() {
		c = new Cellule(new Coordonnees(1, 1), "vivante");
		c.setEtat_suivant("morte");
		String s = "Cellule [x=1, y=1, état=vivante, état_suivant=morte]";
		org.junit.Assert.assertEquals(s, c.toString());
	}
}
