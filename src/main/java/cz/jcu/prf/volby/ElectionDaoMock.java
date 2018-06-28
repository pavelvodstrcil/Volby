package cz.jcu.prf.volby;

/**
 *
 * @author User
 */
public class ElectionDaoMock implements ElectionDao {

    public static ElectionDaoMock self = null;

    private ElectionDaoMock() {
    }

    ;
    
     public static ElectionDaoMock getInstance() {
        if (self == null) {
            self = new ElectionDaoMock();
        }
        return self;
    }

    @Override
    public int verifyUser(String hashOP, String passwd) {
        return 1;
    }

    @Override
    public int vote(int personId, int candId, int voteDate) {
        return 1;
    }

    @Override
    public int verifyVote(int personId, int date) {
        return 1;
    }

    @Override
    public String[] getPerson(String hashOP) {
        String[] a = new String[]{"132", "John", "Doe"};
        return a;
    }

    @Override
    public String[] getCandidatesId(int voteDateId) {
        String[] a = new String[]{"132", "123213", "4543",};
        return a;
    }

    @Override
    public String[] getCandidateName(long candId) {
        String[] a = new String[]{"John", "Doe"};
        return a;
    }

    @Override
    public int getCandidateVotes(long candId, int voteDate) {
        return 32;
    }
}
