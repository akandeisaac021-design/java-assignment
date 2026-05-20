package semicolon.noStrings.data.models;

public class User{
    private String id;
    private String email;
    private String password;
    private Profile profile;

    public User(String id, String email, String password){
        this.id = id;
        this.email = email;
        this.password = password;
    }

    public String getId(){ return id; }
    public String getEmail(){ return email; }
    public String getPassword(){ return password; }
    public Profile getProfile(){ return profile; }
    public void setProfile(Profile profile){ this.profile = profile; }
}

