package test;

import org.junit.Test;
import JeuDeLaVie.Cellule;
import JeuDeLaVie.Coordonnees;
import JeuDeLaVie.UniversCirculaire;

public class TestUniversCirculaire extends TestUnivers {
	//public Cellule c;
	//public UniversCirculaire uni;

	public TestUniversCirculaire() {
		super();
	}

	@Test
	public void testCheckCoord() {
		uni = new UniversCirculaire();
		uni.setMincolonne(0);
		uni.setMinligne(0);
		uni.setNbligne(4);
		uni.setNbcolonne(4);
		Coordonnees s;
		c = new Cellule(new Coordonnees(2, -1), "vivante");
		s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(2, s.x);
		org.junit.Assert.assertEquals(2, 2);
		c.setCoord(new Coordonnees(-1, -1));
		s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(3, s.x);
		org.junit.Assert.assertEquals(3, s.y);
		c.setCoord(new Coordonnees(4, 4));
		s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(0, s.x);
		org.junit.Assert.assertEquals(0, s.y);
		c.setCoord(new Coordonnees(-1, 2));
		s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(3, s.x);
		org.junit.Assert.assertEquals(2, s.y);
		c.setCoord(new Coordonnees(-2, 4));
		s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(3, s.x);
		org.junit.Assert.assertEquals(0, s.y);
		c.setCoord(new Coordonnees(4, 1));
		s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(0, s.x);
		org.junit.Assert.assertEquals(1, s.y);
		c.setCoord(new Coordonnees(1, 4));
		s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(1, s.x);
		org.junit.Assert.assertEquals(0, s.y);
		c.setCoord(new Coordonnees(4, 4));
		s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(0, s.x);
		org.junit.Assert.assertEquals(0, s.y);
		c.setCoord(new Coordonnees(4, -1));
		s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(0, s.x);
		org.junit.Assert.assertEquals(3, s.y);
		c.setCoord(new Coordonnees(2, 4));
		s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(2, s.x);
		org.junit.Assert.assertEquals(0, s.y);
	}

}
