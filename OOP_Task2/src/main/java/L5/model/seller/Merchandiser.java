package L5.model.seller;

import java.util.ArrayList;
import java.util.List;

import L5.model.Specialize;
import L5.model.buyer.Buyer;

public class Merchandiser extends Seller{
    Specialize specializeType;
    List<Buyer> buyers;

    public Merchandiser(Specialize specializeType) {
        this.specializeType = specializeType;
        this.buyers = new ArrayList<>();
    }

    @Override
    public Specialize getSpecializeType() {
        return specializeType;
    }

    @Override
    public List<Buyer> getBuyers() {
        return buyers;
    }

    @Override
    public void clearSeller() {
        buyers = new ArrayList<>();
    }

    @Override
    public void deleteBuyerToSeller(Buyer buyer) {
        for (Buyer buyer1 : buyers) {
            if (buyer.equals(buyer1)){
                buyers.remove(buyer);
            }
        }
    }

    @Override
    public void addBuyerToSeller(Buyer buyer) {
        buyers.add(buyer);
    }
}
