package day;

import java.util.Scanner;

public class MonthSchedule {
    private Day[] days;
    private int month;
    Scanner scanner = new Scanner(System.in);

    public MonthSchedule(int month) {
        this.month = month;
        this.days = new Day[month];
        for(int i=0; i<days.length; i++) {
            days[i] = new Day();
        }
    }

    private void input(){
        System.out.println("날짜를 입력하세요(1~30) : ");
        int day = scanner.nextInt();
        scanner.nextLine(); // 개행 문자 제거
        if(day < 1 || day > month) {
            System.out.println("날짜를 잘못 입력하였습니다.");
            return;
        }
        System.out.println("할일을 입력해 주세요 : ");
        String work = scanner.nextLine();
        days[day - 1].set(work);
    }

    private void finish(){
        scanner.close();
        System.out.println("프로그램을 종료합니다.");
    }

    private void view(){
        System.out.print("날짜를 입력하세요(1~30) : ");
        int day = scanner.nextInt();
        if(day < 1 || day > month) {
            System.out.println("날짜를 잘못 입력하였습니다.");
            return;
        }
        System.out.print(day + "일의 할 일은 ");
        days[day - 1].show();
    }

    public void run(){
        System.out.println("이번달 스케줄 관리 프로그램");
        while (true){
            System.out.println("할일(입력:1, 보기:2, 끝내기:3)");
            int n = scanner.nextInt();
            switch (n){
                case 1:
                    input();
                    break;
                case 2:
                    view();
                    break;
                case 3:
                    finish();
                    return;
                default:
                    System.out.println("잘못입력하였습니다.");
            }
        }
    }
}
