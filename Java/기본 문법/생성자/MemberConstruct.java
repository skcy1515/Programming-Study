package Constructor;

public class MemberConstruct {
    String name;
    int age;
    int grade;

    MemberConstruct(String name, int age, int grade) {
        this.age = age;
        this.name = name;
        this.grade = grade;
        System.out.println("생성자 호출 name=" + name + ",age=" + age + ",grade=" + grade);
    }

    MemberConstruct(String name, int age) { // 생성자 오버로딩
        this.name = name;
        this.age = age;
        this.grade = 50;
        System.out.println("생성자 호출 name=" + name + ",age=" + age + ",grade=" + grade);
    }
}
