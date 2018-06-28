package cz.jcu.prf.volby;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author User
 */
public class LoggedOne {

    private String hashOP;
    private String jmeno;
    private String prijmeni;

    public String getHashOP() {
        return hashOP;
    }

    public String getJmeno() {
        return jmeno;
    }

    public String getPrijmeni() {
        return prijmeni;
    }

    public LoggedOne(String[] array) {

        this.hashOP = array[0];
        this.jmeno = array[1];
        this.prijmeni = array[2];
    }

}
