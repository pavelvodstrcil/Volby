package cz.jcu.prf.volby;

/**
 *
 * @author User
 */
   public class Candidate{
       
        //private ElectionService es = new ElectionServiceMock();
       
        private long id;
        private String firstName;
        private String lastName;
        private int countVotes;
        
        
        /*
        public Candidate(long id){
            this.id = id;
            String[] names = es.getCadidateNames(this.id);
            this.firstName = names[0];
            this.lastName = names[1];
            this.countVotes = es.getVotes(this.id);

        }
        */
        
        public Candidate(long id, String firstName, String lastName, int countVotes){
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.countVotes = countVotes;
        }
        
        public long getID(){
            return this.id;
        }
        
        public String getFullName(){
            return firstName + " " + lastName;
        }

        public int getCountVotes(){
            return countVotes;
        }

        
        public String getFirstName(){
            return firstName;
        }
        
        public String getLastName(){
            return lastName;
        }
               
        /*private long id;
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
*/

        /*private long id;
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
*/


        /*private long id;
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
*/
}
 

