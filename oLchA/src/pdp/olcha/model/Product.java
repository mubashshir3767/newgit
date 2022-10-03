package pdp.olcha.model;

import java.math.BigDecimal;

public class Product extends Base{
    private int categoryId;
    private BigDecimal price;
    private BigDecimal sumPrice;
    private boolean IsSale;
    private int count;

    public BigDecimal getSumPrice() {
        return sumPrice;
    }

    public void setSumPrice(BigDecimal sumPrice) {
        this.sumPrice = sumPrice.add(getPrice());
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Product() {
    }


    public boolean isSale() {
        return IsSale;
    }

    public void setSale(boolean sale) {
        IsSale = sale;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }


    @Override
    public String toString() {
        return "Product{" +
                "categoryId=" + categoryId +
                ", price=" + price +
                ", IsSale=" + IsSale +
                ", count=" + count +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
