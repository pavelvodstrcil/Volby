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
    public String[] getCandidatesId(Date voteDate) {
        String[] a = new String[]{"132","123213","4543",};
        return a;
    }

    @Override
    public String[][] getCandidatesNames(String[] candId) {
        String[][] a = new String[][]{{"132","John","Doe"},{"123213","John2","Doe2"},{"4543","John3","Doe3"}};
        return a;
    }

    @Override
    public String[][] getCandidateVote(String candId) {
        String[][] a = new String[][]{{"132","41"},{"123213","54"},{"4543","104"}};
        return a;
    }
    
}
