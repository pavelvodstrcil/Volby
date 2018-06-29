package cz.jcu.prf.volby;

public class Candidate {

    private long id;
    private String firstName;
    private String lastName;
    private int countVotes;

    /**
     * Konstrukto kandidata
     *
     * @param id id je prebrane z fatabaze - pro vytvoreni objektu
     * @param firstName firstName je prebrane z fatabaze - pro vytvoreni objektu
     * @param lastName lastName je prebrane z fatabaze - pro vytvoreni objektu
     * @param countVotes yountVotes je prebrane z fatabaze - pro vytvoreni
     * objektu
     */
    public Candidate(long id, String firstName, String lastName, int countVotes) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.countVotes = countVotes;
    }

    /**
     *getter ID 
     * @return string ID
     */
    public long getID() {
        return this.id;
    }

    /**
     *g getter celeho jmena pro zjednoduseni
     * @return string celeho jmena 
     */
    public String getFullName() {
        return firstName + " " + lastName;
    }

    /**
     *getter poctu hlasu
     * @return int countVotes
     */
    public int getCountVotes() {
        return countVotes;
    }

    /**
     * getter firstName
     * @return string firstName
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     *geter lastName
     * @return string lastName
     */
    public String getLastName() {
        return lastName;
    }

    public String getAllAbout(){
        String full = "";
        full += getID();
        full += getFullName();
        full += getCountVotes();
        return full;
    }
}
