package org.techtrybe.data;


import java.time.LocalDateTime;

public class Transaction {
    private String id;
    private String sender;
    private String recipient;
    private String amount;
    private LocalDateTime time;

    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", sender='" + sender + '\'' +
                ", recipient='" + recipient + '\'' +
                ", amount='" + amount + '\'' +
                ", time='" + time +'\'' +
                '}';
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getRecipient() {
        return recipient;
    }

    public void setRecipient(String recipient) {
        this.recipient = recipient;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(String amount) {
        this.amount = amount;
    }

    public LocalDateTime getTime(){
        return this.time;
    }

    public void setTime(LocalDateTime time){
         this.time =time;
    }
}
