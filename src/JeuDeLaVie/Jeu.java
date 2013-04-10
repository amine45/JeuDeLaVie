package JeuDeLaVie;

import java.awt.Event;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.Collections;
import java.util.Scanner;
import javax.swing.Timer;

/**
 * 
 * Décrire la classe !
 * 
 */
public class Jeu {

	public int option;

	public Jeu(String[] args) throws IOException {
		try {
			switch (Choix(args)) {
			case 1:
				ListeNom();
				break;
			case 2:
				ListeOption();
				break;
			case 3:
				Univers u = choixUnivers(args[2]);
				SimulationJeu(Integer.parseInt(args[1]), u);
				break;
			case 4:
				Univers u2 = choixUnivers(args[2]);
				EtudesAsymptote et = new EtudesAsymptote(u2, args[2]);
				Evolution(Integer.parseInt(args[1]), u2, et);
			case 5:
				GenerateHtml ml = new GenerateHtml();
				ml.openFile("index.html");
				break;

			}

		} catch (ArgException e) {
			System.out.println(e.getMessage());
		}

	}

	private final void ListeNom() {
		System.out.println("** LES MEMBRES DU GROUPE **");

		System.out.println("BOUFATAH Amine  ");
		System.out.println("MANIVANNIN Elsa");
		System.out.println("MARTIN Juliette");
	}

	private final void ListeOption() {
		System.out
				.println("** java -jar JeuDeLaVie.jar -name : affiche les noms et prénoms des membres du groupe**");
		System.out.println();
		System.out
				.println("** java -jar JeuDeLaVie.jar -h : rappelle la liste des options du programme  **");
		System.out.println();
		System.out
				.println("** java -jar JeuDeLaVie.jar -s d fichier.lif : éxécute une simulation du jeu d’une durée d affichant les configurations du jeu avec le numéro de génération");
		System.out.println();
		System.out
				.println("** java -jar JeuDeLaVie.jar -c max fichier.lif : calcule le type d’évolution du jeu avec ses caractéristiques (taille de la queue, période et déplacement), max représente la durée maximale de simulation pour déduire les résultats du calcul.");
		System.out.println();
		System.out
				.println("** java -jar JeuDeLaVie.jar -w max dossier : calcule le type d’évolution de tous les jeux contenus dans le dossier passé en paramètre et affiche les résultats sous la forme d’un fichier html");
		System.out.println();
	}

	public Univers choixUnivers(String file) {
		int monde;
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("Monde Infinis Taper 1");
			System.out.println("*****************");
			System.out.println("Monde Circulaire Taper 2");
			System.out.println("*****************");
			System.out.println("Monde Frontière Taper 3");
			monde = sc.nextInt();
		} while (monde != 1 && monde != 2 && monde != 3);
		Univers univers;
		if (monde == 1) {
			univers = new Univers(file, 1);
		} else {
			if (monde == 2) {
				univers = new UniversCirculaire(file, 2);
			} else {
				univers = new UniversFrontiere(file, 3);
			}
		}
		return univers;
	}

	private int Choix(String[] args) throws ArgException {
		if (args.length == 1) {
			if (args[0].equals("-name")) {
				return 1;
			} else if (args[0].equals("-h")) {
				return 2;
			} else {
				throw new ArgException("Erreur arguments");
			}
		} else if (args.length == 3) {
			if (args[0].equals("-s") && args[1].matches("^[0-9]+$")) {
				return 3;
			} else if (args[0].equals("-c") && args[1].matches("^[0-9]+$")) {
				return 4;
			} else if (args[0].equals("-w") && args[1].matches("^[0-9]+$")) {
				return 5;
			} else {
				throw new ArgException("Erreur d'arguments");
			}
		} else {
			throw new ArgException("Erreur arguments");
		}

	}

	public void SimulationJeu(final int duree, final Univers univers) {
		Collections.sort(univers.getLemonde());

		final Timer timer = new Timer(350, new ActionListener() {

			int generation = 0;

			public void actionPerformed(ActionEvent e) {
				if (generation != 0) {
					univers.display();
					System.out.println("Numero génération : " + generation);
					univers.nextGeneration();
				}
				generation = generation + 1;
				if (generation == duree + 1) {
					System.exit(0);
				}

				System.out.println((char) Event.ESCAPE + "8");
			}

		});
		timer.start();

		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

	public void Evolution(final int max, final Univers univers,
			final EtudesAsymptote et) {

		Collections.sort(univers.getLemonde());

		final Timer timer = new Timer(350, new ActionListener() {

			int generation = 0;

			public void actionPerformed(ActionEvent e) {

				if (generation != 0) {
					// univers.display();
					System.out.println("nb elements :"
							+ univers.getLemonde().size());

					System.out.println("Numero génération : " + generation);
				}
				if (et.Mort(univers)) {
					System.out.println("Jeu Mort");
					System.exit(0);
				} else {
					if (et.Stable(univers)) {
						System.out.println("Jeu Stable");
						System.exit(0);
					} else {
						if (generation != 0) {
							if (et.Oscillateur(univers)) {
								System.out.println("Jeu Oscillateur");
								System.out.println("La période est de "
										+ et.calculePeriode(univers));
								System.exit(0);
							} else {
								if (et.Vaisseau(univers)) {
									System.out.println("Jeu Vaisseau");
									System.out.println("La période est de "
											+ et.calculePeriodeVaisseau(univers));
									System.out.println("Déplacement :"
											+ et.deplacement(univers));
									System.exit(0);
								}
							}
							// univers.display();
						}
					}
				}
				univers.nextGeneration();

				generation = generation + 1;

				if (generation == max + 1) {
					System.out.print("Jeu Inconnu");
					System.exit(0);
				}

				System.out.println((char) Event.ESCAPE + "8");
			}
		});
		timer.start();

		try {
			System.in.read();
		} catch (Exception e) {
		}
	}

}