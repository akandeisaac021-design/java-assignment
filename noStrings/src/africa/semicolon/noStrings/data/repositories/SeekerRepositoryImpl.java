package semicolon.noStrings.data.repositories;

import semicolon.noStrings.data.models.Seeker;

import java.util.ArrayList;
import java.util.List;

public class SeekerRepositoryImpl implements SeekerRepository {

    private final List<Seeker> seekers = new ArrayList<>();

    private int idCounter = 1;

    @Override
    public Seeker save(Seeker seeker) {
        if (seeker.getId() == 0) {
            seeker.setId(idCounter++);
            seekers.add(seeker);
            return seeker;
        }


        for (int i = 0; i < seekers.size(); i++) {
            if (seekers.get(i).getId() == seeker.getId()) {
                // Swap the old Seeker at this position with the updated one
                seekers.set(i, seeker);
                return seeker;
            }
        }
        seekers.add(seeker);
        return seeker;
    }

    @Override
    public Seeker findById(int id) {
        for (Seeker seeker : seekers) {
            if (seeker.getId() == id) {
                return seeker; // Found — return immediately
            }
        }
        return null;
    }

    @Override
    public List<Seeker> findAll() {
        return new ArrayList<>(seekers);
    }

    @Override
    public void deleteById(int id) {
        seekers.removeIf(seeker -> seeker.getId() == id);
    }

    @Override
    public void deleteAll() {
        seekers.clear();
    }

    @Override
    public int count() {
        return seekers.size();
    }
}
