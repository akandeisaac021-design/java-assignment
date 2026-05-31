package data.repositories;

import data.models.Room;

import java.util.List;

public interface RoomRepository {

    List<Room> findByType(String type);

    List<Room> findByStatus(String status);

    List<Room> findByTypeAndStatus(String type, String status);

    List<Room> findByPricePerNightLessThanEqual(Double maxPrice);
}
