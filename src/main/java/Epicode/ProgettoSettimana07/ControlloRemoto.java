package Epicode.ProgettoSettimana07;

import java.util.ArrayList;
import java.util.List;

import Epicode.ProgettoSettimana07.sonda.SondaStandard;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ControlloRemoto implements Subscriber {
	// Definizione attributi
	long id;
	List<ControlloLocale> listaCCLAssociati = new ArrayList<>(); // CCL --> Centro di Controllo Locale

	// Definitore costruttore con l'id
	public ControlloRemoto(long id) {
		this.id = id;
	}

	// Definizione metodi

	public void aggiornamentoDaControlloLocale(SondaStandard sonda) {
		System.out.println("Messaggio emesso dal Centro di Controllo Remoto " + this.id + ": la sonda " + sonda.getId()
				+ " nel ccl " + sonda.getCentroControlloLocale().id
				+ " ha subito una variazione nel livello di fumo. Livello di fumo attuale: " + sonda.getLivelloFumo());

	}

	@Override
	public void receiveUpdate(SondaStandard sonda) {
		System.out.println("Messaggio emesso dal Centro di Controllo Remoto " + this.id + ": la sonda " + sonda.getId()
				+ " nel ccl " + sonda.getCentroControlloLocale().id
				+ " ha subito una variazione nel livello di fumo. Livello di fumo attuale: " + sonda.getLivelloFumo());
	}

}
