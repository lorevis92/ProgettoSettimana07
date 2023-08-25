package Epicode.ProgettoSettimana07;

import java.util.ArrayList;
import java.util.List;

import Epicode.ProgettoSettimana07.sonda.SondaStandard;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class ControlloLocale implements Subscriber {
	// Definizione attributi
	long id;
	List<SondaStandard> listaSonde = new ArrayList<>();
	List<SondaStandard> listaStatiSonde = new ArrayList<>();
	ControlloRemoto ccr;

	// Definizione costruttore con il solo ID
	public ControlloLocale(long id) {
		this.id = id;
	}

	public void messaggioCreazione() {
		System.out.println("Centro di Controllo Locale " + this.id + " creato con successo!");
	}

	// Definizione metodi
	public void aggiungiSonda(SondaStandard sonda) {
		this.listaSonde.add(sonda);
		System.out
				.println("Sonda " + sonda.getId() + " aggiunta con successo al centro di controllo Locale " + this.id);
	}

	public void aggiungiControlloRemoto(ControlloRemoto ccr) {
		this.ccr = ccr;
		System.out.println("Centro di Controllo Locale " + this.id
				+ " associato corettamente al Centro di Controllo Remoto " + ccr.getId() + "\n");
	}

	public void aggiornaStatoSonda(SondaStandard sonda) {
		this.listaStatiSonde.add(sonda);
		System.out.println("Messaggio emesso dal Centro di Controllo Locale " + this.id + ": la sonda " + sonda.getId()
				+ " ha subito una variazione nel livello di fumo. Livello di fumo attuale: " + sonda.getLivelloFumo()
				+ "\n");
	}

	public void rimuoviSonda(SondaStandard sonda) {
		this.listaSonde.remove(sonda);
		System.out.println("Sonda " + sonda.getId() + " rimossa con successo!");
	}

	public List<SondaStandard> passaDatiSonde(List<SondaStandard> listaSonde) {
		System.out.println("Dati sonde passati correttamente");
		return listaSonde;
	}


	@Override
	public void receiveUpdate(SondaStandard sonda) {
		aggiornaStatoSonda(sonda);
		sonda.getCentroControlloLocale().getCcr().receiveUpdate(sonda);
	}

}
