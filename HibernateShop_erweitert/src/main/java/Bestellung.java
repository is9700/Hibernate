import java.util.LinkedList;
import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name="Hib_Bestellung")
public class Bestellung {
	@Id
	@Column(length = 50, nullable=false)
	private Long bestellnummer;
	
	@Column
	private String bestelldatum;
	
	@ManyToOne
	@JoinColumn(name="kundennummer")
	Kunde Kunde;
	
	@OneToMany(mappedBy="bestellung", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	List<Bestellposition> bestellpositionen = new LinkedList<Bestellposition>();
	
	
	public List<Bestellposition> getBestellpositionen() {
		return bestellpositionen;
	}
	public Bestellung()
	{
	}
	public Long getBestellnummer() {
		return bestellnummer;
	}
	public void setBestellnummer(Long bestellnummer) {
		this.bestellnummer = bestellnummer;
	}
	public String getBestelldatum() {
		return bestelldatum;
	}
	public void setBestelldatum(String bestelldatum) {
		this.bestelldatum = bestelldatum;
	}
	public Kunde getKunde() {
		return Kunde;
	}
	public void setKunde(Kunde kunde) {
		Kunde = kunde;
	}
	public Bestellung(String bestelldatum) {
		this.bestelldatum = bestelldatum;
	}
	public Bestellung(Long bestellnummer, String bestelldatum, Kunde kunde) {
		this.bestelldatum = bestelldatum;
		this.Kunde = kunde;
		this.bestellnummer = bestellnummer;
	}

	public void bestellpositionEinfuegen(Bestellposition bp)
	{
		bestellpositionen.add(bp);
		bp.setBestellung(this);
	}
	
	public void bestellpositionLoeschen(Bestellposition bp)
	{
		bestellpositionen.remove(bp);
		bp.setBestellung(null);
	}
	
	@Override
	public String toString()
	{
		return "Bestellnummer: " + bestellnummer + " Bestellungsdatum: " + bestelldatum;
	}

	


}
