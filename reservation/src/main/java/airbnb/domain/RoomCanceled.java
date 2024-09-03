package airbnb.domain;

import airbnb.domain.*;
import airbnb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.*;

//<<< DDD / Domain Event
@Data
@ToString
public class RoomCanceled extends AbstractEvent {

    private Long id;
    private String customerId;
    private Long roomId;
    private Date date;

    public RoomCanceled(Reservation aggregate) {
        super(aggregate);
    }

    public RoomCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
