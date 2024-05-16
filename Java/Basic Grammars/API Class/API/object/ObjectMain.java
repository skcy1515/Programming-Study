package API.object;

public class ObjectMain {
    private String name;
    private int age;
    private String email;

    public ObjectMain(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    @Override
    public String toString() {
        return "직원{이름='" + name + "', 나이=" + age + ", 이메일='" + email + "'}";
    }

    @Override
    public boolean equals(Object obj) {
        ObjectMain person = (ObjectMain) obj;
        return age == person.age &&
                name.equals(person.name) &&
                email.equals(person.email);
    }

    public static void main(String[] args) {
        ObjectMain person1 = new ObjectMain("John Doe", 30, "john.doe@example.com");
        ObjectMain person2 = new ObjectMain("John Doe", 30, "john.doe@example.com");
        ObjectMain person3 = new ObjectMain("Chan Young", 23, "skcy151515@example.com");
        System.out.println(person1);

        System.out.println(person1.equals(person2));
        System.out.println(person1.equals(person3));
    }
}
