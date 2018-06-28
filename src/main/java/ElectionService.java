import java.util.List;


/**
 *
 * @author User
 */
public interface ElectionService {
    
    public List<Candidate> getCanditates();
    
    public int getVotes(long candidateID);
    
    public void vote(long personID, long candidateID) throws DuplicateVoteException, NotFoundException;
    
    public long authenticateUser(String documentNumber, String password);
}
