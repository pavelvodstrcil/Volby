package cz.jcu.prf.volby;

public class LoggedOne {

    private String hashOP;
    private String firstName;
    private String lastName;

    /**
     * Getter hashOP (nenihash, ale nemeneno)
     *
     * @return string hashOP
     */
    public String getHashOP() {
        return hashOP;
    }

    /**
     * Getter jmeno
     *
     * @return string firstName
     */
    public String getfirstName() {
        return firstName;
    }

    /**
     *Getter prijmeni
     * @return string lastName
     */
    public String getlastName() {
        return lastName;
    }

    /**
     * Objekt přihlášeného hlasujícího - konstruktor
     *
     * @param array pro zjednodušení se předává pole stringů - rozseká se a
     * uloží do prom.
     */
    public LoggedOne(String[] array) {

        this.hashOP = array[0];
        this.firstName = array[1];
        this.lastName = array[2];
    }

}
