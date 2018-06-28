/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.jcu.prf.volby;

public class Person {
        private long id; 
        private String firstName;
        private String lastName;
        private int countVotes;
        
        public Person(long id){
            this.id = id;
        }
        
        public Person(long id, String firstName, String lastName, int countVotes){
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
        
        public String getName(){
            return firstName;
        }
        
        public  String getSurname(){
            return lastName;
        }
        
        public int getCount(){
            return countVotes;
        }
}
