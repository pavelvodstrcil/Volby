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
     * @param voteDate - datum voleb(rok)
     * @return 1-vse probehlo spravne 3-chyba databaze
     */
    public int vote(int personId, int candId, int voteDate);
    
    /**
     * Overi zda volic volil.
     * @param personId - zahashovane cislo OP volice
     * @param date - datum voleb
     * @return 1-volic nehlasoval 4-volic hlasoval 3-chyba databaze
     */
    public int verifyVote(int personId, int date);
        
    /**
     * Vrati udaje o volici.
     * @param hashOP - zahashovane cislo OP volice
     * @return pole(string) - id, jmeno, prijmeni -- pokud vrati pouze 3 - chyba databaze
     */
    public String[] getPerson(String hashOP);   
    
    /**
     * Vrati id kandidatu.
     * @param voteDateId - id data voleb
     * @return pole(string) - seznam id kandidatu -- pokud vrati pouze 3 - chyba databaze -- pokud vrati pouze 2 - spatne voteDateId
     */
    public String[] getCandidatesId(int voteDateId);  
    
    /**
     * Vrati jmeno kandidata
     * @param candId - id vybraneho kandidata
     * @return pole(string) - jmeno, prijmeni -- pokud vrati pouze 3 - chyba databaze
     */
    public String[] getCandidateName(long candId);
    
    /**
     * Vrati pocet hlasu kandidata.
     * @param candId - id vybraneho kandidata
     * @param voteDate - datum voleb(rok)
     * @return pocet hlasu
     */
    public String getCandidateVotes(long candId, int voteDate);
    
    /**
     * Vrati nejnovejsi datum volebniho obdobi.
     * @return datum nejnovejsiho volebniho obdobi
     */
    public String currentVoteDate();
}
