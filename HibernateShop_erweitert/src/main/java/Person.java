import jakarta.persistence.Column;
import jakarta.persistence.DiscriminatorColumn;
import jakarta.persistence.DiscriminatorType;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Inheritance;
import jakarta.persistence.InheritanceType;
import jakarta.persistence.Table;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="PTyp", discriminatorType=DiscriminatorType.STRING)
@DiscriminatorValue("Person")
@Table(name ="Hib_Person")
public class Person {
	@Column(name="pnr")
	@Id
	@GeneratedValue
	private Long pnr;
	@Column(name="vorname")
	private String vorname;
	@Column(name="nachname")
	private String nachname;
	
	Person(){
		
	}
	
	Person(String vorname, String nachname)
	{
		this.vorname = vorname;
		this.nachname = nachname;
	}
	

	public String getVorname() {
		return vorname;
	}

	public void setVorname(String vorname) {
		this.vorname = vorname;
	}

	public String getNachname() {
		return nachname;
	}

	public void setNachname(String nachname) {
		this.nachname = nachname;
	}

	public long getPnr() {
		return pnr;
	}


	


}
