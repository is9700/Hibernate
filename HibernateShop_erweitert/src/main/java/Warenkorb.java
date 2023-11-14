import jakarta.persistence.*;

@Entity(name="Hib_Warenkorb")
@IdClass (WarenkorbPK.class)
public class Warenkorb{
	@ManyToOne
	@JoinColumn(name="pnr", referencedColumnName = "pnr", insertable = false, updatable=false)
	private Kunde kunde;
	@ManyToOne
	@JoinColumn(name="artikelnummer", referencedColumnName = "artikelnummer", insertable = false, updatable=false)
	private Artikel artikel;
	@Column(name="anzahl", nullable=false)
	private Long anzahl;
	@Id
	@Column(name="artikelnummer", nullable=false)
	private Long artikelnummer;
	@Id
	@Column(name="pnr", nullable=false)
	private Long pnr;
	public Warenkorb() {
	}
	public Warenkorb(Kunde kunde, Artikel artikel, Long anzahl) {
		this.anzahl = anzahl;
		this.artikel = artikel;
		this.kunde = kunde;
		this.artikelnummer = artikel.getArtikelnummer();
		this.pnr = kunde.getPnr();
	}

	
	
	public void setArtikelnummer(Long artikelnummer)
	{
		this.artikelnummer = artikelnummer;
	}
	public void setPnr(Long pnr)
	{
		this.pnr = pnr;
	}
	public Artikel getArtikel() {
		return artikel;
	}
	public Kunde getKunde() {
		return kunde;
	}

}
