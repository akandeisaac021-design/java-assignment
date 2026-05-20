package models;

public class Room{
    private String id;
    private String roomNumber;
    private String type;
    private Double pricePerNight;
    private String status;

    public Room(){}

    public String getId(){ return id; }
    public void setId(String id){ this.id = id; }

    public String getRoomNumber(){ return roomNumber; }
    public void setRoomNumber(String roomNumber){ this.roomNumber = roomNumber; }

    public String getType(){ return type; }
    public void setType(String type){ this.type = type; }

    public Double getPricePerNight(){ return pricePerNight; }
    public void setPricePerNight(Double pricePerNight){ this.pricePerNight = pricePerNight; }

    public String getStatus(){ return status; }
    public void setStatus(String status){ this.status = status; }
}
