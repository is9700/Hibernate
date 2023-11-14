import java.util.Objects;

public class WarenkorbPK{
	private Long artikelnummer;
	private Long pnr;
	
	public boolean equals(Object other) {
		if(other instanceof WarenkorbPK) {
			final WarenkorbPK otherWarenkorbPK = (WarenkorbPK) other;
			final boolean areEqual=
					(otherWarenkorbPK.artikelnummer.equals(artikelnummer))
					&& otherWarenkorbPK.pnr.equals(pnr);
			return areEqual;
		}
		return false;
	}
	
	@Override
	public int hashCode() {
		return Objects.hash(artikelnummer, pnr);
	}
}
