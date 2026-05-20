package data.models;

import java.time.LocalDate;

public class Booking{
    private String id;
    private Guest guest;
    private models.Room room;
    private LocalDate checkInDate;
    private LocalDate checkOutDate;
    private Double totalAmount;
    private String status;

    public Booking() {}

    public String getId(){ return id; }
    public void setId(String id){ this.id = id; }

    public Guest getGuest(){ return guest; }
    public void setGuest(Guest guest){ this.guest = guest; }

    public models.Room getRoom(){ return room; }
    public void setRoom(models.Room room){ this.room = room; }

    public LocalDate getCheckInDate(){ return checkInDate; }
    public void setCheckInDate(LocalDate checkInDate){ this.checkInDate = checkInDate; }

    public LocalDate getCheckOutDate(){ return checkOutDate; }
    public void setCheckOutDate(LocalDate checkOutDate){ this.checkOutDate = checkOutDate; }

    public Double getTotalAmount(){ return totalAmount; }
    public void setTotalAmount(Double totalAmount){ this.totalAmount = totalAmount; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status = status; }
}
