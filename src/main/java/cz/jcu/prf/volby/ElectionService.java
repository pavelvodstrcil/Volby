package cz.jcu.prf.volby;

import cz.jcu.prf.volby.DuplicateVoteException;
import cz.jcu.prf.volby.Candidate;
import java.util.List;


/**
 *
 * @author User
 */
public interface ElectionService {
    
    public List<Candidate> getCanditates();
    
    public String getVotes(long candidateID);
    
    public int getTotalVotes();
    
    public void vote(long personID, long candidateID) throws DuplicateVoteException, NotFoundException;
    
    public long authenticateUser(String documentNumber, String password);
}
