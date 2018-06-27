import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;


/**
 *
 * @author User
 */


public class ElectionServiceMock implements ElectionService{

    private Set<Long> votedPersons;
    private Map<Long, Integer> candidateVotes;
    private List<Candidate> candidates;
   // List<Candidate> candidates = Arrays.asList(new Candidate(1), new Candidate(2), new Candidate(3));
 
    public ElectionServiceMock(List<Candidate> candidates){
        votedPersons = new TreeSet<>();
        candidateVotes = new HashMap<>();
        this.candidates = candidates;
        this.candidates.forEach((candidate) -> {
            candidateVotes.put(candidate.getID(), 0);
        });
    }
    
    public void vote(long personID, long candidateID) throws DuplicateVoteException,NotFoundException{
        if(votedPersons.contains(personID)){
            throw new DuplicateVoteException();
        }else if(!candidateVotes.containsKey(candidateID)){
            throw new NotFoundException();
        }else{
            candidateVotes.put(candidateID, candidateVotes.get(candidateID)+1);
        }
    }
    
   public long autenticateUser(String documentNumber, String password){
       return 0;
   }
   
   public int getVotes(long candidateID){
       return candidateVotes.get(candidateID);
   }

    public List<Candidate> getCanditates() {
        return candidates;  
    }
    
 
    
    
}
