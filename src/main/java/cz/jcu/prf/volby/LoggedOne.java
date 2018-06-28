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

    public LoggedOne(String[] array) {

        this.hashOP = array[0];
        this.firstName = array[1];
        this.lastName = array[2];
    }

}
