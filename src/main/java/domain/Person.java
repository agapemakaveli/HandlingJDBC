package domain;

public class Person {
    private int idPerson;
    private String name;
    private String lastname;
    private String email;
    private String telephone;

    //
    //
    public Person() {
    }

//For deleting a person we only need the id
    public Person(int idPerson) {
        this.idPerson = idPerson;
    }

//for inserting a new person we do not need the id cuz it is auto-increment
    public Person(String name, String lastname, String email, String telephone) {
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
    }

//for updating the register
    public Person(int idPerson, String name, String lastname, String email, String telephone) {
        this.idPerson = idPerson;
        this.name = name;
        this.lastname = lastname;
        this.email = email;
        this.telephone = telephone;
    }

    public int getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(int idPerson) {
        this.idPerson = idPerson;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "idPerson=" + idPerson +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", email='" + email + '\'' +
                ", telephone='" + telephone + '\'' +
                '}';
    }

//End of the class
}
