/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.prf.volby;

import java.util.ArrayList;
import java.util.Arrays;
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
    
        String[] pomN = ElectionDao.getCandidateName(2018);
        System.out.println("ARRAY:" + Arrays.toString(pomN));
        //FOR DATABASE ERROR, TEST!!
        if (pomN[0].equals("3")){
            System.out.println("DATABASE LOAD CANDIDATE ERROR");
            //DATABASE ERROR TEST
                candidates.add(new Candidate(0, "Základní", "Test", 0));
                candidates.add(new Candidate(1, "Strana", "Zelených", 0));
                candidates.add(new Candidate(2, "Strana", "Modrých", 0));
        }
        int sizeCandi = pomN.length;
        String[] candiNames=null;
        String candiVote="0";
        for (int i = 0; i < sizeCandi; i++) {
            if (pomN[i]!=null){
                if (ElectionDao!=null)
                        if(ElectionDao.getCandidateName(Long.parseLong(pomN[i]))!=null ||
                                !ElectionDao.getCandidateName(Long.parseLong(pomN[i]))[0].equals("3")){
                            candiNames = ElectionDao.getCandidateName(i);
                }else{
                    candiNames = new String[]{"", ""};
                }
                if (ElectionDao!=null) 
                        if(ElectionDao.getCandidateVotes(Long.parseLong(pomN[i]), 2018)!=null){
                            candiVote = ElectionDao.getCandidateVotes(Long.parseLong(pomN[i]), 2018);
                }else{
                    candiVote = "0";
                }

            System.out.println("NAMES: " + Arrays.toString(candiNames));
            System.out.println("VOTES: " + candiVote);
            
            candidates.add(new Candidate(Long.parseLong(pomN[i]), candiNames[i], candiNames[i], Integer.valueOf(candiVote)));
            }
        }

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
            pomVotes += c.getCountVotes();
        }
        return pomVotes;
    }

    @Override
    public int getVotes(long candidateID) {
        return 0;
    }

    @Override
    public String[] getCadidateNames(long candidateID) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getCurrentVoteDate() {
        return 0;
    }
    
}
