package test;

import static org.junit.Assert.*;

import org.junit.Test;
import JeuDeLaVie.Univers;
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
		fail("Not yet implemented");//hello
	}

	@Test
	public void testOscillateur() {
		fail("Not yet implemented");
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
