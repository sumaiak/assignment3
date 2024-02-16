package part2;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@ToString
@NoArgsConstructor
@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "first_name", nullable = false)
    private String firstName;

    @Column(name = "last_name", nullable = false)
    private String lastName;

    @Column(name = "e-mail", nullable = false, unique = true)
    private String eMail;

    @Column(name = "age", nullable = false)
    private int age;

    public Student(String firstName, String lastName, String eMail, int age) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.eMail = eMail;
        this.age = age;
    }

    //to check if email is valid we use Presist ,and if it is not then we throw an EXception
    @PrePersist
    @PreUpdate
    public void validator() {
        if (!isValidEmail(eMail)) {
            throw new IllegalArgumentException("Invalid email address");
        }
    }

    private boolean isValidEmail(String email) {
        return email != null && email.contains("@");
    }


}