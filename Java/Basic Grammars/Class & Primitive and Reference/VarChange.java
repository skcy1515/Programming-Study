package PrimaryReference;

public class VarChange {
    public static void main(String[] args) {
        Data dataA = new Data(); // dataA 변수에 Data형 객체의 참조값 저장
        dataA.value = 10; // 객체의 value 값을 10으로 바꿔줌
        Data dataB = dataA; // dataA의 참조값을 복사하여 dataB에 저장
        // 즉, dataB가 가리키는 값은 dataA가 가리키는 값과 같아진다.

        System.out.println("dataA 참조값=" + dataA); // PrimaryReference.Data@2f4d3709
        System.out.println("dataB 참조값=" + dataB); // PrimaryReference.Data@2f4d3709
        System.out.println("dataA.value = " + dataA.value); // 10
        System.out.println("dataB.value = " + dataB.value); // 10

        //dataA 변경
        dataA.value = 20;
        System.out.println("변경 dataA.value = 20");
        System.out.println("dataA.value = " + dataA.value); // 20
        System.out.println("dataB.value = " + dataB.value); // 20

        //dataB 변경
        dataB.value = 30;
        System.out.println("변경 dataB.value = 30");
        System.out.println("dataA.value = " + dataA.value); // 30
        System.out.println("dataB.value = " + dataB.value); // 30
    }
}
