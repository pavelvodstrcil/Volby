/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.prf.volby;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author User
 */
public class ElectionServiceTest {

    /**
     * Test of getCanditates method, of class ElectionService.
     */
    @Test
    public void testGetCanditates() {
        ElectionService es = new ElectionServiceMock();
        List<Candidate> listCandid = es.getCanditates();
        
        List<Candidate> testedCandid = new ArrayList<Candidate>();
        testedCandid.add(new Candidate(0, "Jana", "Čínsková", 3));
        testedCandid.add(new Candidate(1, "Pavel", "Vodstrčil", 2));
        testedCandid.add(new Candidate(2, "Tereza", "Králová", 1));
        testedCandid.add(new Candidate(3, "Adrian", "Czarnomski", 0));
        
        for(int i = 0; i < listCandid.size(); i++){
            assertEquals(listCandid.get(i).getAllAbout(), testedCandid.get(i).getAllAbout());
        }
        
        testedCandid.set(0, new Candidate(0, "Halina", "Pawlovská", 0));
        
        assertNotEquals(listCandid.get(0).getAllAbout(), testedCandid.get(0).getAllAbout());
        
    }

    /**
     * Test of getVotes method, of class ElectionService.
     */
    @Test
    public void testGetVotes() {
        ElectionService es = new ElectionServiceMock();
        
        assertEquals(es.getVotes(0), 3);
        
        assertNotEquals(es.getVotes(0), 9);
    }

    /**
     * Test of getCadidateNames method, of class ElectionService.
     */
    @Test
    public void testGetCadidateNames() {
    }

    /**
     * Test of getTotalVotes method, of class ElectionService.
     */
    @Test
    public void testGetTotalVotes() {
    }

    /**
     * Test of vote method, of class ElectionService.
     */
    @Test
    public void testVote() throws Exception {
    }

    /**
     * Test of authenticateUser method, of class ElectionService.
     */
    @Test
    public void testAuthenticateUser() {
    }

    public class ElectionServiceImpl implements ElectionService {

        public List<Candidate> getCanditates() {
            return null;
        }

        public int getVotes(long candidateID) {
            return 0;
        }

        public String[] getCadidateNames(long candidateID) {
            return null;
        }

        public int getTotalVotes() {
            return 0;
        }

        public void vote(long personID, long candidateID) throws DuplicateVoteException, NotFoundException {
        }

        public long authenticateUser(String documentNumber, String password) {
            return 0L;
        }
    }
    
}
