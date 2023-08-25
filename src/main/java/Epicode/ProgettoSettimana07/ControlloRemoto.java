package Epicode.ProgettoSettimana07;

import Epicode.ProgettoSettimana07.sonda.SondaStandard;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ControlloRemoto implements Subscriber {
	// Definizione attributi
	long id;
	// List<ControlloLocale> listaCCLAssociati = new ArrayList<>(); // CCL -->
	// Centro di Controllo Locale
	UfficioPersonale up;

	// Definitore costruttore con l'id
	public ControlloRemoto(long id) {
		this.id = id;
	}

	// Definizione metodi

	public void aggiornamentoDaControlloLocale(SondaStandard sonda) {
		System.out.println("Messaggio emesso dal Centro di Controllo Remoto " + this.id + ": la sonda " + sonda.getId()
				+ " nel ccl " + sonda.getCentroControlloLocale().id
				+ " ha subito una variazione nel livello di fumo. Livello di fumo attuale: " + sonda.getLivelloFumo()
				+ "\n");

	}

	public void messaggioCreazione() {
		System.out.println("Centro di Controllo Remoto " + this.id + " Creata con successo!");
	}

	public void aggiungiUfficioPersonale(UfficioPersonale up) {
		this.up = up;
		System.out.println("Centro di Controllo Remoto " + this.id
				+ " associato correttamente all'ufficio personale di nome" + up.getNomeUfficio() + "\n");
	}

	@Override
	public void receiveUpdate(SondaStandard sonda) {
		System.out.println("Messaggio emesso dal Centro di Controllo Remoto " + this.id + ": la sonda " + sonda.getId()
				+ " nel ccl " + sonda.getCentroControlloLocale().id
				+ " ha subito una variazione nel livello di fumo. Livello di fumo attuale: " + sonda.getLivelloFumo()
				+ "\n");
		if (sonda.getLivelloFumo() > 5) { // Scatta l'allarme
			this.up.receiveUpdate(sonda);
		}
	}

}
