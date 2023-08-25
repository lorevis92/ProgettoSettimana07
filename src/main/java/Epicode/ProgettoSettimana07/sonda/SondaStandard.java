package Epicode.ProgettoSettimana07.sonda;

import Epicode.ProgettoSettimana07.ControlloLocale;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class SondaStandard extends Sonda {
	long id;
	String latitudine;
	String longitudine;
	int livelloFumo;
	ControlloLocale centroControlloLocale;

	public SondaStandard(long id, String latitudine, String longitudine) {
		this.id = id;
		this.latitudine = latitudine;
		this.longitudine = longitudine;
	}

	@Override // sono i dati che trasfersce in quando PUBLISHER verso il SUBSCRIBER Centro di
				// controllo Locale Associato
	public int trasferisciDati() {
		System.out.println("Livelo di fumo registrato dalla sonda id " + this.id + ": " + this.livelloFumo);
		return this.livelloFumo;
	}

	public void messaggioCreazione() {
		System.out.println("Sonda " + this.id + " con coordinate " + this.latitudine + " e " + this.longitudine
				+ " Creata con successo!");
	}

	public void aggiungiCentroControlloLocale(ControlloLocale centroControlloLocale) {
		this.centroControlloLocale = centroControlloLocale;
		System.out.println("Centro di Controllo Locale " + centroControlloLocale.getId()
				+ " impostato correttamente sulla sonda " + this.id);
	}

	public void aggiornaLivelloFumoSonda(int livelloFumo) {
		this.livelloFumo = livelloFumo;
		this.centroControlloLocale.receiveUpdate(this);
	}
}
