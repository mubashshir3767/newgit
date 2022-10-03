package pdp.olcha.model;

import java.math.BigDecimal;

public class Basket extends Base{

    private String product;
    private String number;
    private BigDecimal sumPrice;
    private BigDecimal Price;
    private int count;


    public Basket() {
    }

    public int getCount() {
        return count;
    }

    public BigDecimal getPrice() {
        return Price;
    }

    public void setPrice(BigDecimal price) {
        Price = price;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getProduct() {
        return product;
    }

    public void setProduct(String product) {
        this.product = product;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice;
    }


}
