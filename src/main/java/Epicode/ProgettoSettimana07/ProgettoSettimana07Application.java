package Epicode.ProgettoSettimana07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import Epicode.ProgettoSettimana07.sonda.SondaStandard;

@SpringBootApplication
public class ProgettoSettimana07Application {

	public static void main(String[] args) {
		SpringApplication.run(ProgettoSettimana07Application.class, args);

		// Creazione sonde
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

		// Creazione Centri di Controllo Locali (ccl)
		ControlloLocale ccl1 = new ControlloLocale(1);

		// Registrazione del Centro di Controllo alle singole sonde per poter ricevere
		// gli aggiornamenti
		sondaUno.aggiungiCentroControlloLocale(ccl1);
		sondaDue.aggiungiCentroControlloLocale(ccl1);
		sondaTre.aggiungiCentroControlloLocale(ccl1);
		sondaQuattro.aggiungiCentroControlloLocale(ccl1);
		sondaCinque.aggiungiCentroControlloLocale(ccl1);
		sondaSei.aggiungiCentroControlloLocale(ccl1);

		// Allacciamento sonde con il Centro di Controllo Locale
		ccl1.aggiungiSonda(sondaUno);
		ccl1.aggiungiSonda(sondaDue);
		ccl1.aggiungiSonda(sondaTre);
		ccl1.aggiungiSonda(sondaQuattro);
		ccl1.aggiungiSonda(sondaCinque);
		ccl1.aggiungiSonda(sondaSei);

	}

}
