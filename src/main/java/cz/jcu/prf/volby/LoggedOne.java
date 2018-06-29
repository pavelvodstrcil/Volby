package cz.jcu.prf.volby;

/**
 *
 * @author User
 */
public class LoggedOne {

    private String hashOP;
    private String firstName;
    private String lastName;

    public String getHashOP() {
        return hashOP;
    }

    public String getfirstName() {
        return firstName;
    }

    public String getlastName() {
        return lastName;
    }

    /**
     * Objekt přihlášeného hlasujícího - konstruktor
     *
     * @param array pro zjednodušení se předává pole stringů - rozseká se 
     * a uloží do prom.
     */
    public LoggedOne(String[] array) {

        this.hashOP = array[0];
        this.firstName = array[1];
        this.lastName = array[2];
    }

}
