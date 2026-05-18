public class Profile{
    private String id;
    private String userId;
    private String name;
    private String gender;
    private int age;

    public Profile(String id, String userId, String name, String gender, int age){
        this.id = id;
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

