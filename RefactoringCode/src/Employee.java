import java.util.Optional;

public class Employee {
    private String firstName;
    private String lastName;
    private int age;
    private String email;
    private Addresse addresse;


    public Employee(){}
    public Employee(String firstName,String lastName,int age, String email,Addresse addresse){
        this.firstName=firstName;
        this.lastName=lastName;
        this.age=age;
        this.email=email;
        this.addresse=addresse;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Optional<Addresse> getAddresse() {
        return Optional.ofNullable(addresse);
    }

    public void setAddresse(Addresse addresse) {
        this.addresse = addresse;
    }

    @Override
    public String toString() {
        return "Employee: " +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", email='" + email+
                ", addresse='" + addresse;
    }
}
