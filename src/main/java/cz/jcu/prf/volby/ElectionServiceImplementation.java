/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.prf.volby;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

/**
 *
 * @author User
 */
public class ElectionServiceImplementation implements ElectionService{

    private Set<Long> votedPersons;
    // ID kandidáta a počet jeho hlasů
    private Map<Long, Integer> candidateVotes;
    private List<Candidate> candidates;
    private ElectionDaoImplementaion ElectionDao;

    public ElectionServiceImplementation() {
        ElectionDao = new ElectionDaoImplementaion();
        votedPersons = new TreeSet<>();
        candidateVotes = new HashMap<>();
        candidates = new ArrayList<>();
        //Populate candidates
        //...
        
        
        this.candidates.forEach((candidate) -> {
            candidateVotes.put(candidate.getID(), 0);
        });
    }

    
    @Override
    public List<Candidate> getCanditates() {
        return candidates;  
    }
    
    @Override
    public void vote(long personID, long candidateID) throws DuplicateVoteException, NotFoundException {
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
    public long authenticateUser(String documentNumber, String password) {
        return ElectionDao.verifyUser(documentNumber, password);
    }

    @Override
    public int getTotalVotes() {
        int pomVotes = 0;
        for(Candidate c: candidates){
            pomVotes+=Integer.parseInt(getVotes(c.getID()));
        }
        return pomVotes;
    }

    @Override
    public String getVotes(long candidateID) {
        return Integer.toString(candidateVotes.get((int)candidateID));
    }
    
}
