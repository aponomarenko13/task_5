package L5.model.buyer;

import lombok.*;
import L5.model.Specialize;

import java.time.LocalDate;

@Data
@AllArgsConstructor
public class Buyer {
    private String FIO;
    private Specialize preferences;
    private LocalDate birthday;
    private LocalDate visit;

}
