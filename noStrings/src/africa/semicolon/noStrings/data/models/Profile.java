package semicolon.noStrings.data.models;

public class Profile{
    private final String userId;
    private final String name;
    private final String gender;
    private final int age;

    public Profile(String id, String userId, String name, String gender, int age){
        this.userId = userId;
        this.name = name;
        this.gender = gender;
        this.age = age;
    }


    public String getUserId(){ return userId; }
    public String getGender(){ return gender; }
    public int getAge(){ return age; }
    public String getName(){ return name; }
}

