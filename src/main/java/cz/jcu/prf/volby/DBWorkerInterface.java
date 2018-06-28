package cz.jcu.prf.volby;

import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public interface DBWorkerInterface {
    
    /**
     * Overi zadane udaje prihlasovaneho volice.
     * @param hashOP - zahashovane cislo OP volice
     * @param passwd - heslo volice
     * @return 1-vse probehlo spravne 2-spatne zadane udaje 3-chyba databaze
     */
    public int verifyUser(String hashOP, String passwd);
    
    /**
     * Prida hlas vybranemu kandidatovi. Nastavi volicovi ze uz volil.
     * @param hashOP - zahashovane cislo OP volice
     * @param candId - id vybraneho kandidata
     * @return 1-vse probehlo spravne 3-chyba databaze
     */
    public int vote(String hashOP, String candId);
    
    /**
     * Overi zda volic volil.
     * @param hashOP - zahashovane cislo OP volice
     * @return 1-volic nehlasoval 4-volic hlasoval 3-chyba databaze
     */
    public int VerifyVote(String hashOP);
        
    /**
     * Vrati udaje o volici.
     * @param hashOP - zahashovane cislo OP volice
     * @return pole(string) - hashOP, jmeno, prijmeni
     */
    public String[] getPerson(String hashOP);   
    
    /**
     * Vrati id kandidatu.
     * @param voteDate - datum voleb
     * @return list(string) - seznam id kandidatu
     */
    public String[] getCandidates(Date voteDate);  
    
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
    public String[] getCandidateVote(String candId);
}
