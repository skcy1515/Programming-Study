public class Main1 {
    public static void main(String[] args) {
        int[][] nums = new int[4][4]; // 2차원 배열 생성

        for (int i=0; i< 10; i++) {
            int a = (int)( Math.random()*4); // 0~3까지의 랜덤한 숫자를 생성
            int b = (int)( Math.random()*4); // 0~3까지의 랜덤한 숫자를 생성
            if (nums[a][b] == 0) {
                nums[a][b] = (int)( Math.random()*10 + 1 ); // 랜덤한 위치가 0일시 1~10 사이의 랜덤한 값 삽입
            } else { // 0이 아닐 시 다음 숫자를 시도하기 위해 i의 숫자를 감소
                i = i - 1;
            }
        }

        for (int i=0; i<nums.length; i++) { // 출력
            for (int j=0; j<nums[i].length; j++){
                System.out.print(nums[i][j] + " ");
            }
            System.out.println();
        }
    }
}
