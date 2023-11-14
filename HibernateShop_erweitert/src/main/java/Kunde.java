import java.util.ArrayList;
import java.util.List;
import jakarta.persistence.*;
@Entity
@DiscriminatorValue("Kunde")
public class Kunde extends Person {
	@Column(name="email")
	private String email;
	public Kunde() {
		super();
	}
	public Kunde(String vorname, String nachname, String email) {
		super(vorname, nachname);
		this.email=email;
		
	}

	public String getEmail()
	{
		return email;
	}

	public void setEmail(String email)
	{
		this.email = email;
	}
	

	@OneToMany(mappedBy="kunde", fetch=FetchType.EAGER)
	private List<Warenkorb> warenkorbList = new ArrayList<Warenkorb>();
	
	
	public List<Warenkorb> getWarenkorbList()
	{
		return warenkorbList;
	}
	@Override
	public String toString()
	{
		return "Kundennr: " + super.getPnr()  + " Vorname" + super.getVorname();
	}


	
}
