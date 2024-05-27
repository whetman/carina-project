package com.solvd.gui.models;

public class PaymentInformation {

    private String nameOnCard;
    private String cardNumber;
    private String cvcNumber;
    private String expirationMonth;
    private String expirationYear;

    public PaymentInformation(String nameOnCard, String cardNumber, String cvcNumber, String expirationMonth, String expirationYear) {
        this.nameOnCard = nameOnCard;
        this.cardNumber = cardNumber;
        this.cvcNumber = cvcNumber;
        this.expirationMonth = expirationMonth;
        this.expirationYear = expirationYear;
    }

    public String getNameOnCard() {
        return nameOnCard;
    }

    public void setNameOnCard(String nameOnCard) {
        this.nameOnCard = nameOnCard;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvcNumber() {
        return cvcNumber;
    }

    public void setCvcNumber(String cvcNumber) {
        this.cvcNumber = cvcNumber;
    }

    public String getExpirationMonth() {
        return expirationMonth;
    }

    public void setExpirationMonth(String expirationMonth) {
        this.expirationMonth = expirationMonth;
    }

    public String getExpirationYear() {
        return expirationYear;
    }

    public void setExpirationYear(String expirationYear) {
        this.expirationYear = expirationYear;
    }

    @Override
    public String toString() {
        return "PaymentInformation{" +
                "nameOnCard='" + nameOnCard + '\'' +
                ", cardNumber='" + cardNumber + '\'' +
                ", cvcNumber='" + cvcNumber + '\'' +
                ", expirationMonth='" + expirationMonth + '\'' +
                ", expirationYear='" + expirationYear + '\'' +
                '}';
    }

}
