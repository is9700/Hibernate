import java.util.Objects;

public class BestellpositionPK{
	private Long pos;
	private Long bestellnummer;
	
	public boolean equals(Object other) {
		if(other instanceof BestellpositionPK) {
			final BestellpositionPK otherWarenkorbPK = (BestellpositionPK) other;
			final boolean areEqual=
					(otherWarenkorbPK.pos.equals(pos))
					&& otherWarenkorbPK.bestellnummer.equals(bestellnummer);
			return areEqual;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(pos, bestellnummer);
	}
}
