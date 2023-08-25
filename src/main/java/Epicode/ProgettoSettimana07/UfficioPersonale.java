package Epicode.ProgettoSettimana07;
import Epicode.ProgettoSettimana07.sonda.SondaStandard;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class UfficioPersonale implements Subscriber {
	long id;
	String nomeUfficio;

	@Override
	public void receiveUpdate(SondaStandard sonda) {
		System.out.println("ATTENZIONE!!! \nLa sonda " + sonda.getId()
				+ " ha superato il limite di fumo consentito. Di seguito i dati relativi alla sonda:\n Livello fumo: "
				+ sonda.getLivelloFumo() + "\n Centro di Controllo Locale: " + sonda.getCentroControlloLocale().getId()
				+ "\n Centro di Controllo Remoto: " + sonda.getCentroControlloLocale().getCcr().getId()
				+ "\n Longitudine: " + sonda.getLongitudine() + "\n Latitudine: " + sonda.getLatitudine() + "\n");
		System.out.println("http://host/alarm/?idsonda=" + sonda.getId() + "&lat=" + sonda.getLatitudine() + "&lon="
				+ sonda.getLongitudine() + "&smokelevel=" + sonda.getLivelloFumo() + "\n");
	}

	public void messaggioCreazione() {
		System.out.println("Ufficio Personale di nome " + this.nomeUfficio + " creato con successo!");
	}

}
