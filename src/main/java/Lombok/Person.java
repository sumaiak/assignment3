package Lombok;

import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.AllArgsConstructor;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Person {
    private String firstName;
    private String lastName;
    private int age;
}
//For those who want to explore further, try adding more Lombok annotations to the Person class like @EqualsAndHashCode, and @Builder and observe the functionalities they bring.