package test;

import static org.junit.Assert.*;

import java.util.ArrayList;

import org.junit.Test;
import JeuDeLaVie.Cellule;
import JeuDeLaVie.Coordonnees;
import JeuDeLaVie.Univers;

public class UniversTest {
	protected Cellule c;
    protected Univers uni ;
	@Test
	public void testCellExists() {
		Coordonnees coord,coord1,coord2;
		coord2 = new Coordonnees (0,0);
		c = new Cellule (coord=new Coordonnees(1,2),"vivante");
		Cellule s = new Cellule(coord1=new Coordonnees(2,3),"morte");
		uni = new Univers();
		uni.getLemonde().add(c);
		uni.getCelmortes().add(s);
		org.junit.Assert.assertEquals(c,uni.cellExists(coord));
		org.junit.Assert.assertEquals(s,uni.cellExists(coord1));
		org.junit.Assert.assertEquals(new Cellule(coord2,"vivante"),uni.cellExists(coord2));
	}

	@Test
	public void testAddDeadCells() {
		fail("Not yet implemented");
	}

	@Test
	public void testVerifyListDeadCells() {
		fail("Not yet implemented");
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
	}

	@Test
	public void testIsPresent() {
		uni = new Univers();
		c = new Cellule(new Coordonnees(1, 1), "vivante");
		ArrayList<Cellule> Ar = new ArrayList<Cellule>();
		Ar.add(c);
		uni.setLemonde(Ar);
		org.junit.Assert.assertEquals(true,
		uni.isPresent(c.getCoord().x, c.getCoord().y));
		org.junit.Assert.assertEquals(false, uni.isPresent(0, 0));
	}

	@Test
	public void testNextGeneration() {
		fail("Not yet implemented");
	}

	@Test
	public void testCheckCoord() {
		Coordonnees s;
		uni = new Univers ();
		c = new Cellule(s = new Coordonnees(1, 1), "vivante");
        org.junit.Assert.assertEquals(s.x, (uni.checkCoord(s.x,s.y)).x);
        org.junit.Assert.assertEquals(s.y, (uni.checkCoord(s.x,s.y)).y);
	}

	@Test
	public void testGetMinligne() {
		Univers s = new Univers ();
		s.setMinligne(0);
		org.junit.Assert.assertEquals(0, s.getMinligne());
	}

	@Test
	public void testSetMinligne() {
		Univers s = new Univers ();
		s.setMinligne(-3);
		org.junit.Assert.assertEquals(-3, s.getMinligne());
	}

	@Test
	public void testGetMincolonne() {
	uni = new Univers ();
	uni.setMincolonne(0);
	org.junit.Assert.assertEquals(0, uni.getMincolonne());
	}

	@Test
	public void testSetMincolonne() {
	uni = new Univers () ;
	uni.setMincolonne(0);
	org.junit.Assert.assertEquals(0, uni.getMincolonne());
	}

	@Test
	public void testGetMaxcolonne() {
		uni = new Univers ();
		uni.setNbcolonne(5);
		org.junit.Assert.assertEquals(5, uni.getNbcolonne());
		}
	

	@Test
	public void testSetMaxcolonne() {
		uni = new Univers () ;
		uni.setNbcolonne(10);
		org.junit.Assert.assertEquals(10, uni.getNbcolonne());
	}

	@Test
	public void testGetMaxligne() {
		uni = new Univers () ;
		uni.setNbligne(7);
		org.junit.Assert.assertEquals(7, uni.getNbligne());
	}

	@Test
	public void testSetMaxligne() {
		uni = new Univers () ;
		uni.setNbligne(10);
		org.junit.Assert.assertEquals(10, uni.getNbligne());
	}

	@Test
	public void testGetLemonde() {
		uni = new Univers ();
		ArrayList<Cellule> s = new ArrayList<Cellule>();
		uni.setLemonde(s);
	    org.junit.Assert.assertEquals(s,uni.getLemonde());
	}

	@Test
	public void testSetLemonde() {
		uni = new Univers();
		ArrayList<Cellule> s = new ArrayList<Cellule>();
		uni.setLemonde(s);
	    org.junit.Assert.assertEquals(s,uni.getLemonde());
		
	}

	@Test
	public void testGetCelmortes() {
		uni = new Univers ();
		ArrayList<Cellule> s = new ArrayList<Cellule>();
		uni.setCelmortes(s);
	    org.junit.Assert.assertEquals(s,uni.getCelmortes());
	}

	@Test
	public void testSetCelmortes() {
		uni = new Univers();
		ArrayList<Cellule> s = new ArrayList<Cellule>();
		uni.setCelmortes(s);
	    org.junit.Assert.assertEquals(s,uni.getCelmortes());
	}

}
