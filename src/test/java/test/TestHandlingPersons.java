package test;

import datos.PersonDAO;
import domain.Person;
import java.util.List;

public class TestHandlingPersons {
    public static void main(String[] args) {
        PersonDAO personDAO = new PersonDAO();

        //Inserting a new person object
        //Person personNew = new Person("Alan", "Zach", "azach@mail.com", "00045459696");
        //personDAO.insert(personNew);

//updating a existing person
        //Person personModified = new Person(4, "David", "Saan", "dsaan@mail.com", "00045459696");
        //personDAO.update(personModified);

        //Deleting a person object from db
        Person personDelete = new Person(2);
        personDAO.delete(personDelete);

        //List of persons
        List<Person> persons = personDAO.select();
        for (Person person: persons){
            System.out.println("Persona: " + person);
        }

       // persons.forEach(person -> {
       //     System.out.println("Person inside lambda: " + person);
       // });
    }
    //End of the class
}
