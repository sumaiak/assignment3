package GLS;




import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.Date;


@NoArgsConstructor
@Getter
@Setter
@ToString
@EqualsAndHashCode
@Entity
@Table(name = "packages")
public class Package {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private int id;

    @Column(name = "tracking_number", nullable = false)
    private String trackingNumber;

    @Column(name = "sender_name", nullable = false)
    private String senderName;

    @Column(name = "receiver_name", nullable = false)
    private String receiverName;

    @Enumerated(EnumType.STRING)
    @Column(name = "delivery-status", nullable = false)
    private DeliveryStatus deliveryStatus;

    @Column(name = "in-transit", nullable = false)
    private LocalDate trackingDate;

    @Column(name = "delivered", nullable = false)
    private LocalDate deliveredDate;

    public enum DeliveryStatus {
        PENDING,
        IN_TRANSIT,
        DELIVERED
    }

    public Package(String trackingNumber, String senderName, String receiverName, DeliveryStatus deliveryStatus) {
        this.trackingNumber = trackingNumber;
        this.senderName = senderName;
        this.receiverName = receiverName;
        this.deliveryStatus = deliveryStatus;
    }


}