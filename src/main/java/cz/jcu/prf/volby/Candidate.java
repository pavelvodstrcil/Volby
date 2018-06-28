package cz.jcu.prf.volby;

/**
 *
 * @author User
 */
   public class Candidate{
        private long id;
        private String firstName;
        private String lastName;
        private int countVotes;
        
        public Candidate(long id){
            this.id = id;
        }
        
        public Candidate(long id, String firstName, String lastName, int countVotes){
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.countVotes = countVotes;
        }
        
        public long getID(){
            return this.id;
        }
        
        public String getName(){
            return firstName + " " + lastName;
        }
        
        public int getCount(){
            return countVotes;
        }
}