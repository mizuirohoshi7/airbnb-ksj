package airbnb.domain;

import airbnb.infra.AbstractEvent;
import java.time.LocalDate;
import java.util.*;
import lombok.Data;

@Data
public class RoomCanceled extends AbstractEvent {

    private Long id;
    private String customerId;
    private Long roomId;
    private Date date;
}
