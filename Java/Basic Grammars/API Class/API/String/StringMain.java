package API.String;

public class StringMain {
    public static void main(String[] args) {
        String a = " C#";
        String b = " C++";

        System.out.println(a + "의 길이는 " + a.length()); // 문자열의 길이(문자 개수), 3
        System.out.println(a.contains("#")); // 문자열의 포함 관계, true

        a = a.concat(b); // 문자열 연결
        System.out.println(a); //  C# C++

        a = a.trim(); // 문자열 앞 뒤의 공백 제거
        System.out.println(a); // C#C++

        a = a.replace("C#", "Java"); // 문자열 대치
        System.out.println(a); // Java C++

        char c = a.charAt(2); // 인덱스 2의 문자 리턴
        System.out.println(c); // v

        System.out.println(a.indexOf("Java")); // 문자열이 처음 등장하는 인덱스 반환, 0

        System.out.println(a.toUpperCase()); // 대문자로 변환하여 출력 (원본 문자열 변경 X), JAVA C++
        System.out.println(a.toLowerCase()); // 소문자로 변환하여 출력 (원본 문자열 변경 X), java c++
    }
}
