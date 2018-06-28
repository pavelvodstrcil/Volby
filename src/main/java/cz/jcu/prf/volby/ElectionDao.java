package cz.jcu.prf.volby;

/**
 *
 * @author User
 */
public interface ElectionDao {
    
    /**
     * Overi zadane udaje prihlasovaneho volice.
     * @param hashOP - zahashovane cislo OP volice
     * @param passwd - heslo volice
     * @return 1-vse probehlo spravne 2-spatne zadane udaje 3-chyba databaze
     */
    public int verifyUser(String hashOP, String passwd);
    
    /**
     * Prida hlas vybranemu kandidatovi. Nastavi volicovi ze uz volil.
     * @param personId - id cislo volice
     * @param candId - id vybraneho kandidata
     * @param voteDate - datum voleb
     * @return 1-vse probehlo spravne 3-chyba databaze
     */
    public int vote(String personId, String candId, int voteDate);
    
    /**
     * Overi zda volic volil.
     * @param hashOP - zahashovane cislo OP volice
     * @return 1-volic nehlasoval 4-volic hlasoval 3-chyba databaze
     */
    public int verifyVote(String hashOP, int date);
        
    /**
     * Vrati udaje o volici.
     * @param hashOP - zahashovane cislo OP volice
     * @return pole(string) - hashOP, jmeno, prijmeni
     */
    public String[] getPerson(String hashOP);   
    
    /**
     * Vrati id kandidatu.
     * @param voteDate - datum voleb
     * @return pole(string) - seznam id kandidatu 
     */
    public String[] getCandidatesId(int voteDate);  
    
    /**
     * Vrati jmena kandidatu
     * @param candId - id vybraneho kandidata
     * @return pole(string) - candId, jmeno, prijmeni
     */
    public String[][] getCandidatesNames(String[] candId);
    
    /**
     * Vrati pocet hlasu kandidata.
     * @param candId - id vybraneho kandidata
     * @return pole(string) - candId, pocetHlasu
     */
    public String[][] getCandidatesVote(String candId);
}
