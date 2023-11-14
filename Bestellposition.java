import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="Hib_Bestellposition")
@IdClass (BestellpositionPK.class)
public class Bestellposition {

	@Id
	@Column
	private Long pos;
	
	
	@Id
	@Column
	private Long bestellnummer;
	
	@Column
	private Long artikelnummer;
	
	
	
	@ManyToOne(cascade = CascadeType.ALL, fetch=FetchType.EAGER)
	@JoinColumn(name="bestellnummer", referencedColumnName = "bestellnummer", insertable = false, updatable=false)
	private Bestellung bestellung;
	
	@ManyToOne(cascade = CascadeType.PERSIST)
	@JoinColumn(name="artikelnummer", referencedColumnName = "artikelnummer", insertable = false, updatable=false)
	private Artikel artikel;

	public Bestellposition(Long pos, Bestellung bestellung, Artikel artikel) {
		this.bestellnummer = bestellung.getBestellnummer();
		this.pos = pos;
		this.artikelnummer = artikel.getArtikelnummer();
		this.artikel = artikel;
	}
	
	public Bestellposition()
	{
		
	}
	public Bestellung getBestellung() {
		return bestellung;
	}

	public void setBestellung(Bestellung bestellung) {
		this.bestellung = bestellung;
	}

	public Artikel getArtikel() {
		return artikel;
	}

	public void setArtikel(Artikel artikel) {
		this.artikel = artikel;
	}

	@Override
	public String toString()
	{
		return "Artikelnummer: " + artikel.getArtikelnummer() + " Artikelname: " + artikel.getArtikelname();
	}
}
