package pdp.olcha.model;

import java.math.BigDecimal;

public class Order extends Base{
    private BigDecimal paySum;
    private BigDecimal Sum;
    private String name;
    private String phoneNumber;
    private int count = 0;

    public Order() {
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public BigDecimal getPaySum() {
        return paySum;
    }

    public void setPaySum(BigDecimal paySum) {
        this.paySum = paySum;
    }

    public BigDecimal getSum() {
        return Sum;
    }

    public void setSum(BigDecimal sum) {
        Sum = sum;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Order{" +
                "paySum=" + paySum +
                ", Sum=" + Sum +
                ", name='" + name + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", count=" + count +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

