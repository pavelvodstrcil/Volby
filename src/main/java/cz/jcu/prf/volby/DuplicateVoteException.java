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
public class DuplicateVoteException extends Exception {

    public DuplicateVoteException() {
    }

    public DuplicateVoteException(String message) {
        super(message);
    }

    public DuplicateVoteException(String message, Throwable cause) {
        super(message, cause);
    }

    public DuplicateVoteException(Throwable cause) {
        super(cause);
    }
}
