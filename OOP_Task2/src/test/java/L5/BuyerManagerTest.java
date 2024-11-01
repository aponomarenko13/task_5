package L5;

import L5.exception.WrongDateException;
import L5.model.Specialize;
import L5.model.buyer.Buyer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import L5.service.BuyerManager;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BuyerManagerTest {
    private static final LocalDate birthday = LocalDate.of(2000, 8, 10);
    private static final LocalDate date = LocalDate.of(2024, 11, 10);
    private static final Buyer buyer = new Buyer("FIO", Specialize.CASHIER, birthday, date);
    private static final String VALID_DATE = "2024-11-10";
    private static final String INVALID_DATE = "2024/08/10";
    private static final String INVALID_DATE2 = "1999-08-10";
    private final BuyerManager buyerManager = new BuyerManager();

    @Test
    @DisplayName("Дата записи валидная, ошибки не будет")
    void setDateOfReceptionValid() {
        buyerManager.setDateOfReception(buyer, VALID_DATE);
        assertEquals(buyer.getVisit(), LocalDate.parse(VALID_DATE));
    }


    @Test
    @DisplayName("Ошибка валидации формата даты записи")
    void setDateOfReceptionInValid() {
        assertThrows(WrongDateException.class,
                () -> buyerManager.setDateOfReception(buyer, INVALID_DATE));
    }

    @Test
    @DisplayName("Ошибка валидации даты записи")
    void setDateOfReceptionInvalidPast() {
        assertThrows(WrongDateException.class,
                () -> buyerManager.setDateOfReception(buyer, INVALID_DATE2));
    }
}
