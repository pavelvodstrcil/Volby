package cz.jcu.prf.volby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
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
    // ID kandidáta a počet jeho hlasů
    private Map<Long, Integer> candidateVotes;
    private List<Candidate> candidates;
    private ElectionDao ElectionDao = ElectionDaoMock.getInstance();
 
 
    
    public ElectionServiceMock(/*List<Candidate> candidates*/){
        //GENERATE CANDIDATES
        votedPersons = new TreeSet<>();
        candidateVotes = new HashMap<>();
        this.candidates = new ArrayList<>();
        
        candidates.add(new Candidate(0, "Jana", "Čechová", 3));
        candidates.add(new Candidate(1, "Pavel", "Vodstrčil", 2));
        candidates.add(new Candidate(2, "Tereza", "Králová", 1));
        candidates.add(new Candidate(3, "Andrian", "Polák", 0));
        
        this.candidates.forEach((candidate) -> {
            candidateVotes.put(candidate.getID(), 0);
        });
    }
    
    @Override
    public void vote(long personID, long candidateID) throws DuplicateVoteException,NotFoundException{
        if(votedPersons.contains(personID)){
            throw new DuplicateVoteException();
        }else if(!candidateVotes.containsKey(candidateID)){
            throw new NotFoundException();
        }else{
            candidateVotes.put(candidateID, candidateVotes.get(candidateID)+1);
            votedPersons.add(personID); //přidat toho člověka, který už hlasoval
        }
    }
    
    @Override
   public long authenticateUser(String documentNumber, String password){
      return ElectionDao.verifyUser(password, password);
   }
   
    @Override
   public String getVotes(long candidateID){
       return Integer.toString(candidateVotes.get((int)candidateID));
   }

   public int getTotalVotes(){
       int pomVotes = 0;
        for(Candidate c: candidates){
            pomVotes+=Integer.parseInt(getVotes(c.getID()));
        }
        return pomVotes;
   }
   
    @Override
    public List<Candidate> getCanditates() {
        return candidates;  
    }
    
 
    
    
}
