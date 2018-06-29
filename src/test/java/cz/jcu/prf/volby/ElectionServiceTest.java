/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.prf.volby;

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
        
    }

    /**
     * Test of getVotes method, of class ElectionService.
     */
    @Test
    public void testGetVotes() {
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
