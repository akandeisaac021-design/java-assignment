package data.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class Room{
    private String id;
    private String roomNumber;
    private String type;
    private Double pricePerNight;
    private String status;

}
