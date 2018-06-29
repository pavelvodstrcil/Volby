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
        testedCandid.add(new Candidate(3, "Adrian", "Czarnomski", 10));
        
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
        
        assertEquals(es.getVotes(es.getCanditates().get(0).getID()), 3);
        
        assertNotEquals(es.getVotes(es.getCanditates().get(0).getID()), 9);
    }

    /**
     * Test of getCadidateNames method, of class ElectionService.
     */
    @Test
    public void testGetCadidateNames() {
        ElectionService es = new ElectionServiceMock();
        assertArrayEquals(es.getCadidateNames(es.getCanditates().get(0).getID()), new String[]{"Jana", "Čínsková"});
    }

    /**
     * Test of getTotalVotes method, of class ElectionService.
     */
    @Test
    public void testGetTotalVotes() {
        ElectionService es = new ElectionServiceMock();
        assertEquals(es.getTotalVotes(), 16);
        assertNotEquals(es.getTotalVotes(), -16);
    }

    /**
     * Test of vote method, of class ElectionService.
     */
    @Test
    public void testVote() throws Exception {
        ElectionService es = new ElectionServiceMock();
        Person mama = new Person(45);
        
        assertEquals(es.getVotes(es.getCanditates().get(0).getID()), 3);
        
        es.vote(mama.getID(), 0);
        assertEquals(es.getVotes(es.getCanditates().get(0).getID()), 4);
        
        try{
            es.vote(mama.getID(), 0);
        }catch(DuplicateVoteException dve){
            assertNotEquals(es.getVotes(es.getCanditates().get(0).getID()), 5);
        }
    }

}
