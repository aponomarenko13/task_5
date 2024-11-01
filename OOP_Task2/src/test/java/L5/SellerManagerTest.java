package L5;

import L5.exception.SellerIsBusyException;
import L5.model.Specialize;
import L5.model.buyer.Buyer;
import L5.model.seller.Consultant;
import L5.model.seller.Seller;
import org.junit.jupiter.api.*;
import L5.service.SellerManager;

import java.time.LocalDate;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class SellerManagerTest {

    private static final Seller consultant = new Consultant(Specialize.CONSULTANT);
    private static final Seller merchandiser = new Consultant(Specialize.MERCHANDISER);
    private static final LocalDate birthday = LocalDate.of(2000, 8, 10);
    private static final LocalDate date = LocalDate.of(2024, 11, 10);
    private static final Buyer buyer = new Buyer("FIO", Specialize.CASHIER, birthday, date);
    private static final Buyer buyer2 = new Buyer("FIO", Specialize.MERCHANDISER, birthday, date);
    private static final Buyer buyer3 = new Buyer("FIO", Specialize.CONSULTANT, birthday, date);
    private static final SellerManager sellerManager = new SellerManager();
    List<Seller> sellers = List.of(consultant, merchandiser);


    @AfterEach
    void clearShelves() {
        sellers.forEach(Seller::clearSeller);
    }

    @Test
    @DisplayName("Проверим, у всех консультантов есть покупатели")
    void allSellersHaveCorrectBuyers() {
        assertDoesNotThrow(() ->
                sellerManager.addBuyerToSeller(consultant, buyer3));
        assertDoesNotThrow(() ->
                sellerManager.addBuyerToSeller(merchandiser, buyer2));
        for (Seller seller : sellers) {
            for (Buyer buyer : seller.getBuyers()) {
                Assertions.assertEquals(seller.getSpecializeType(), buyer.getPreferences());
            }
        }
    }


    @Test
    @DisplayName("Ошибка добавления покупателя к консультанту")
    void sellerDoesNotExistsForBuyer() {
        assertThrows(SellerIsBusyException.class,
                () -> sellerManager.addBuyerToSeller(consultant, buyer));
    }

}

