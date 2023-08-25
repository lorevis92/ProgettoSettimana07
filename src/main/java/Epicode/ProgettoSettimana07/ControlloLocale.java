package Epicode.ProgettoSettimana07;

import java.util.ArrayList;
import java.util.List;

import Epicode.ProgettoSettimana07.sonda.SondaStandard;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ControlloLocale {
	// Definizione attributi
	long id;
	List<SondaStandard> listaSonde = new ArrayList<>();

	// Definizione costruttore con il solo ID
	public ControlloLocale(long id) {
		this.id = id;
	}

	public void messaggioCreazione() {
		System.out.println("Centro di Controllo Locale " + this.id + " Creata con successo!");
	}

	// Definizione metodi per la trasmissione di valori
	public void aggiungiSonda(SondaStandard sonda) {
		this.listaSonde.add(sonda);
		System.out.println("Sonda " + sonda.getId() + " aggiunta con successo al centro di controllo " + this.id);
	}

	public void rimuoviSonda(SondaStandard sonda) {
		this.listaSonde.remove(sonda);
		System.out.println("Sonda " + sonda.getId() + " rimossa con successo!");
	}

	public List<SondaStandard> passaDatiSonde(List<SondaStandard> listaSonde) {
		System.out.println("Dati sonde passati correttamente");
		return listaSonde;
	}

}
