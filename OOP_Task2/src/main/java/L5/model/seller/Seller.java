package L5.model.seller;

import lombok.extern.slf4j.Slf4j;
import lombok.Getter;
import lombok.NoArgsConstructor;
import L5.model.Specialize;
import L5.model.buyer.Buyer;

import java.util.List;

@Slf4j
@Getter
@NoArgsConstructor
public abstract class Seller {

    public abstract Specialize getSpecializeType();
    public abstract void addBuyerToSeller(Buyer buyer);
    public abstract void deleteBuyerToSeller(Buyer buyer);
    public abstract List<Buyer> getBuyers();
    public abstract void clearSeller();
    public void log(String message){
        log.info(message);
    }
}
