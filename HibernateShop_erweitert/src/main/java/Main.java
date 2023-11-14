import java.util.LinkedList;
import java.util.List;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.PersistenceUnit;
import jakarta.persistence.Query;
import jakarta.transaction.Transactional;

public class Main {
@PersistenceUnit
private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("PersistenceUnit");
@PersistenceContext
static EntityManager em;
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Kunde k = new Kunde("Robin", "Brosche", "robin@gmail.com");
		Artikel a = new Artikel(1L, "Cola", 2.00);
		Artikel a2 = new Artikel(2L, "Fanta", 3.00);

		kundeEinfuegen(k);
		
		Bestellung b = new Bestellung(2002L, "25.1.2022", k);
		
		Bestellposition pos = new Bestellposition(1L, b, a);
		Bestellposition pos2 = new Bestellposition(2L, b, a2);
		
		b.bestellpositionEinfuegen(pos);
		b.bestellpositionEinfuegen(pos2);
		
		bestellungEinfuegen(b);
		
		showBestellung(b);
		bestellungLoeschen(b);
		
	}

	public static EntityManager getEntityManager() {
		return emf.createEntityManager();
	}
	@Transactional
	public static void kundeEinfuegen(Kunde kunde) {
		
		em = getEntityManager();
		em.getTransaction().begin();
		em.persist(kunde);
		em.getTransaction().commit();
		em.close();
	}
	
	public static void bestellungEinfuegen(Bestellung bestellung) {
		
		em = getEntityManager();
		em.getTransaction().begin();
		em.persist(bestellung);
		em.getTransaction().commit();
		em.close();
	}
	public static void bestellpositionEinfuegen(Bestellposition bestellposition) {
		
		em = getEntityManager();
		em.getTransaction().begin();
		em.persist(bestellposition);
		em.getTransaction().commit();
		em.close();
	}
	
	public static Kunde getKunde(Long id)
	{
		EntityManager em = getEntityManager();
		Kunde kunde = em.find(Kunde.class, id);
		em.detach(kunde);
		return kunde;
	}
	
	public static void showKundeWarenkorb(Long pnr)
	{
		Kunde k = getKunde(pnr);
		List<Warenkorb> warenkorbList = k.getWarenkorbList();
		System.out.println("Warenkorb von " + k.getVorname() + " " + k.getNachname() + " " + k.getEmail());
		for(Warenkorb warenkorbItem : warenkorbList)
		{
			System.out.println(warenkorbItem.getArtikel().getArtikelname());
		}
	}
	
	public static void artikelEinfuegen(Artikel artikel) {

		em = getEntityManager();
		em.getTransaction().begin();
		em.persist(artikel);
		em.getTransaction().commit();
		em.close();


	}
	public static void warenkorbEinfuegen(Warenkorb warenkorb) {
		EntityManager em = getEntityManager();
		em.getTransaction().begin();
		em.persist(warenkorb);
		em.getTransaction().commit();

	}
	public static Kunde getKundeFromDB(Long pnr) 
	{
		Kunde kunde = getEntityManager().find(Kunde.class, pnr);
		return kunde;
	}
	
	private static void showBestellung(Bestellung bestellung)
	{
		System.out.println(bestellung);
		for(Bestellposition bp: bestellung.getBestellpositionen())
		{
			System.out.println(bp);
		}
	}
	
	private static void bestellungLoeschen(Bestellung bestellung)
	{
		em = getEntityManager();
		em.getTransaction().begin();
		em.remove(em.contains(bestellung) ? bestellung: em.merge(bestellung));
		em.getTransaction().commit();
		em.close();
	}
	
	
	
}