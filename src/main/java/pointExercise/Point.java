package pointExercise;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
@Entity
@Getter
@Setter
@NoArgsConstructor
@ToString
@Table(name = "point")
public class Point {



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "x", nullable = false)
    private int x;

    @Column(name = "y", nullable = false)
    private int y;




    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }


}