package LMS.entities;

public class InternationalDelivery extends Delivery{

    private float custom=1;

    public InternationalDelivery(long id, String from, String to) {
        super(id, from, to);
    }

    public InternationalDelivery(long id, String from, String to,float custom) {
        super(id, from, to);
        this.custom =custom;
    }

    @Override
    public int getTotal() {
        int totalValue = 0;
        if(getGoods().size() > 0){
            for(Item i: getGoods()){
                totalValue+=i.totalValue()*custom;
            }
            return totalValue;
        }
        return -1;
    }
}
