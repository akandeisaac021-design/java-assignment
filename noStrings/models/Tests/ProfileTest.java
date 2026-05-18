import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProfileTest{

    private Profile profile;

    @BeforeEach
    public void setUp(){
        profile = new Profile("P123", "U456", "John Doe", "Male", 28);
    }

    @Test
    public void testGetUserId(){
        assertEquals("U456", profile.getUserId());
    }

    @Test
    public void testGetName(){
        assertEquals("John Doe", profile.getName());
    }

    @Test
    public void testGetGender(){
        assertEquals("Male", profile.getGender());
    }

    @Test
    public void testGetAge(){
        assertEquals(28, profile.getAge());
    }
}

