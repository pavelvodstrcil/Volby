package cz.jcu.prf.volby;

import java.util.List;


/**
 *
 * @author User
 */

public interface ElectionService {
    
    /**
     * Načte kandidáty.
     * @return List kandidátů
     */
    public List<Candidate> getCanditates();
    
    /**
     * 
     * @param candidateID
     * @return 
     */
    public int getVotes(long candidateID);
    
    /**
     * Navratí jména zadaných kandidátů
     * @param candidateID
     * @return pole(string) jmen kandidátů
     */    
    public String[] getCadidateNames(long candidateID);
    
    /**
     * Načte počet hlasů.
     * @return počet hlasů určitého kandidáta.
     */
    public int getTotalVotes();
    
    /**
     * Prida hlas vybranemu kandidatovi.
     * @param personID - id cislo volice
     * @param candidateID - id vybraného kandidáta
     */
    public void vote(long personID, long candidateID) throws DuplicateVoteException, NotFoundException;
    
    /**
     * Ověří přihlašovací údaje voliče.
     * @param documentNumber - čílsloOP voliče
     * @param password - heslo voliče
     * @return 1-vse probehlo spravne 2- špatně zadané přihlašovací údaje 3-chyba databaze
     */
    public long authenticateUser(String documentNumber, String password);
    

}
