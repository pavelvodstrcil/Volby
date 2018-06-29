package cz.jcu.prf.volby;

public class Person {
        private long id; 
        private String firstName;
        private String lastName;
        private int countVotes;
       /**
        * Testvací konstruktor osoby
        * @param id ID z databáze
        */    
        
        public Person(long id){
            this.id = id;
        }
        /**
         * Kontruktor Osoby
         * @param id ID z databáze
         * @param firstName jméno
         * @param lastName   přijmení
         * @param countVotes drží stav hlasů 
         */
        public Person(long id, String firstName, String lastName, int countVotes){
            this.id = id;
            this.firstName = firstName;
            this.lastName = lastName;
            this.countVotes = countVotes;
        }
        /**
         * getter ID osoby
         * @return Vraci ID int
         */
        public long getID(){
            return this.id;
        }
        /**
         * getter celeho jmena -> pro zjednoduseni
         * @return string celeho jmena
         */
        public String getFullName(){
            return firstName + " " + lastName;
        }
        /**
         * getter jména 
         * @return string firstName
         */
        public String getName(){
            return firstName;
        }
        /**
         * getter prijmeni
         * @return string lastName
         */
        public  String getSurname(){
            return lastName;
        }
        /**
         * Getter poštu hlasů
         * @return int countVotes
         */
        public int getCount(){
            return countVotes;
        }
}
