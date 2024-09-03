package airbnb.domain;

import airbnb.ReservationApplication;
import airbnb.domain.RoomCanceled;
import airbnb.domain.RoomReserved;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;

@Entity
@Table(name = "Reservation_table")
@Data
//<<< DDD / Aggregate Root
public class Reservation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String customerId;

    private Long roomId;

    private Date date;

    private String status;

    @PostPersist
    public void onPostPersist() {
        RoomReserved roomReserved = new RoomReserved(this);
        roomReserved.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        RoomCanceled roomCanceled = new RoomCanceled(this);
        roomCanceled.publishAfterCommit();
    }

    public static ReservationRepository repository() {
        ReservationRepository reservationRepository = ReservationApplication.applicationContext.getBean(
            ReservationRepository.class
        );
        return reservationRepository;
    }
}
//>>> DDD / Aggregate Root
