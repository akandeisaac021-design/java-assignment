package data.repositories;

import data.models.Room;

import java.util.List;

public class RoomRepositoryImpl implements RoomRepository{
    @Override
    public List<Room> findByType(String type) {
        return List.of();
    }

    @Override
    public List<Room> findByStatus(String status) {
        return List.of();
    }

    @Override
    public List<Room> findByTypeAndStatus(String type, String status) {
        return List.of();
    }

    @Override
    public List<Room> findByPricePerNightLessThanEqual(Double maxPrice) {
        return List.of();
    }
}
