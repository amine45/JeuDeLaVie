package test;



import org.junit.Test;
import JeuDeLaVie.Cellule;
import JeuDeLaVie.UniversFrontiere;
import JeuDeLaVie.Coordonnees;

public class TestUniversFrontiere {
	public Cellule c;
	public UniversFrontiere uni;

	@Test
	public void testCheckCoord() {
		uni = new UniversFrontiere();
		uni.setNbcolonne(4);
		uni.setNbligne(4);
		c = new Cellule(new Coordonnees(0, 0), "vivante");
		Coordonnees s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(0, s.x);
		org.junit.Assert.assertEquals(0, s.y);
		org.junit.Assert.assertEquals(true, s.valide);
		c.setCoord(new Coordonnees(6, 6));
		s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(6, s.x);
		org.junit.Assert.assertEquals(6, s.y);
		org.junit.Assert.assertEquals(false, s.valide);
		c.setCoord(new Coordonnees(-1, 6));
		s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(-1, s.x);
		org.junit.Assert.assertEquals(6, s.y);
		org.junit.Assert.assertEquals(false, s.valide);
		c.setCoord(new Coordonnees(6, -1));
		s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(6, s.x);
		org.junit.Assert.assertEquals(-1, s.y);
		org.junit.Assert.assertEquals(false, s.valide);
		c.setCoord(new Coordonnees(2, 6));
		s = uni.checkCoord(c.getCoord().x, c.getCoord().y);
		org.junit.Assert.assertEquals(2, s.x);
		org.junit.Assert.assertEquals(6, s.y);
		org.junit.Assert.assertEquals(false, s.valide);
	}

}
