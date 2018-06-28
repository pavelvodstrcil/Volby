package cz.jcu.prf.volby;

import java.util.Date;

/**
 *
 * @author User
 */
public class ElectionDaoMock implements ElectionDao{


    @Override
    public int verifyUser(String hashOP, String passwd) {
        return 1;
    }

    @Override
    public int vote(String hashOP, String candId) {
        return 1;
    }

    @Override
    public int verifyVote(String hashOP) {
        return 1;
    }

    @Override
    public String[] getPerson(String hashOP) {
        String[] a = new String[]{"132","John","Doe"};
        return a;
    }

    @Override
    public String[] getCandidates(Date voteDate) {
        String[] a = new String[]{"132","123213","121234","4543","542543"};
        return a;
    }

    @Override
    public String[][] getCandidatesNames(String[] candId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String[] getCandidateVote(String candId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
