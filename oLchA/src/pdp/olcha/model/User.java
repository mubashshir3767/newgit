package pdp.olcha.model;

import java.math.BigDecimal;

public class User extends Base{
    private String role;
    private String number;
    private String password;
    private String masterCard;
    private BigDecimal amount;


    public User() {
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getMasterCard() {
        return masterCard;
    }

    public void setMasterCard(String masterCard) {
        this.masterCard = masterCard;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    @Override
    public String toString() {
        return "User{" +
                "role='" + role + '\'' +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", masterCard=" + masterCard +
                ", amount=" + amount +
                ", id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
