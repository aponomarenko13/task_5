package L5.service;

import L5.exception.WrongDateException;
import L5.model.buyer.Buyer;

import java.time.LocalDate;
import java.util.regex.Pattern;

public class BuyerManager {

    private static final Pattern DATE_PATTER =
            Pattern.compile("[0-9]{4}-(0[1-9]|1[012])-(0[1-9]|1[0-9]|2[0-9]|3[01])");

    public void setDateOfReception(Buyer buyer, String date) {
        checkCorrectData(date);

        buyer.setBirthday(LocalDate.parse(date));
    }

    private void checkDataValid(String data) {
        if (!DATE_PATTER.matcher(data).matches()) {
            throw new WrongDateException("Формат даты: YYYY-MM-DD");
        }
    }

    private void checkCorrectData(String data) {
        if (!DATE_PATTER.matcher(data).matches()) {
            throw new WrongDateException("Формат даты: YYYY-MM-DD");
        }
        LocalDate dateNow = LocalDate.now();
        if (dateNow.isAfter(LocalDate.parse(data))) {
            throw new WrongDateException("Нельзя купить проданный товар.");
        }
    }

}
