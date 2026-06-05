package data.models;

import data.enums.Status;
import data.enums.RoomType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Room{
    private String id;
    private String roomNumber;
    private RoomType roomType;
    private Double pricePerNight;
    private Status status;

}
