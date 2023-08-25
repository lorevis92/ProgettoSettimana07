package Epicode.ProgettoSettimana07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Epicode.ProgettoSettimana07.sonda.SondaStandard;

@SpringBootApplication
public class ProgettoSettimana07Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoSettimana07Application.class, args);

		// Creazione sonde
		System.out.println("\nCreazioe delle sonde\n");
		SondaStandard sondaUno = new SondaStandard(1, "41.9028", "12.4964");
		sondaUno.messaggioCreazione();
		SondaStandard sondaDue = new SondaStandard(2, "41.9029", "12.4963");
		sondaDue.messaggioCreazione();
		SondaStandard sondaTre = new SondaStandard(3, "41.9030", "12.4964");
		sondaTre.messaggioCreazione();
		SondaStandard sondaQuattro = new SondaStandard(4, "41.9028", "12.4963");
		sondaQuattro.messaggioCreazione();
		SondaStandard sondaCinque = new SondaStandard(5, "41.9029", "12.4966");
		sondaCinque.messaggioCreazione();
		SondaStandard sondaSei = new SondaStandard(6, "41.9029", "12.4964");
		sondaSei.messaggioCreazione();

		System.out.println("\n------------------------------------\n");

		// Creazione Centri di Controllo Locali (ccl)
		System.out.println("Creazione dei Centri di Controllo Locali\n");
		ControlloLocale ccl1 = new ControlloLocale(1);
		ccl1.messaggioCreazione();

		System.out.println("\n------------------------------------\n");

		// Creazione Centro di Controllo Remoto ccr
		System.out.println("Creazione dei centri di Controllo Remoti\n");
		ControlloRemoto ccr = new ControlloRemoto(1);
		ccr.messaggioCreazione();

		System.out.println("\n------------------------------------\n");

		// Creazione Ufficio Personale
		System.out.println("Creazione dell'Ufficio Personale Gestione Emergenze");
		UfficioPersonale up = new UfficioPersonale(1, "Gestione Emergenze");
		up.messaggioCreazione();

		System.out.println("\n------------------------------------\n");

		// Registrazione del Centro di Controllo Locale alle singole sonde per poter
		// ricevere
		// gli aggiornamenti
		sondaUno.aggiungiCentroControlloLocale(ccl1);
		sondaDue.aggiungiCentroControlloLocale(ccl1);
		sondaTre.aggiungiCentroControlloLocale(ccl1);
		sondaQuattro.aggiungiCentroControlloLocale(ccl1);
		sondaCinque.aggiungiCentroControlloLocale(ccl1);
		sondaSei.aggiungiCentroControlloLocale(ccl1);

//		System.out.println("\n\n------------------------------------\n\n");
//
//		// Allacciamento sonde con il Centro di Controllo Locale
//		ccl1.aggiungiSonda(sondaUno);
//		ccl1.aggiungiSonda(sondaDue);
//		ccl1.aggiungiSonda(sondaTre);
//		ccl1.aggiungiSonda(sondaQuattro);
//		ccl1.aggiungiSonda(sondaCinque);
//		ccl1.aggiungiSonda(sondaSei);

		System.out.println("\n------------------------------------\n");

		// Collegamento del CCL al CCR
		ccl1.aggiungiControlloRemoto(ccr);

		System.out.println("\n\n------------------------------------\n");

		// Collegamento del CCR all'Ufficio Personale
		ccr.aggiungiUfficioPersonale(up);

		System.out.println("\n------------------------------------\n");

		// Aggiorno il livello del fumo in una sonda
		sondaUno.aggiornaLivelloFumoSonda(4);
	}

}
