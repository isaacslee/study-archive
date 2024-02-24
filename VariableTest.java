/**
 * VariableTest 클래스는 자바의 기본 데이터 타입을 변수로 선언하고 출력하는 간단한 프로그램입니다.
 * 각 변수는 특정한 타입으로 데이터를 저장하고 출력합니다.
 * 
 * @author 이승원
 * @since 2024.02.24.
 */
public class VariableTest {
    public static void main(String[] args) {
        
        // 각 변수에 대한 값 할당
        boolean isPassed = true;  // true or false
        char grade = 'A';  // 유니코드 문자(예: 'A', 'B', 'C')
        byte year = 3;  // 크기: 8비트, 범위: -128 ~ 127
        short score = 10;  // 크기: 16비트, 범위: -32,768 ~ 32,767
        int sumScore = 100;  // 크기: 32비트, 범위: 약 -21억 ~ 21억
        long currentTime = 12345678L;  // 크기: 64비트
        float avg = 80.25F;  // 실수형 리터럴에는 'F' 또는 'f'를 붙입니다.
        double examAvg = 80.513242;  // 더블형 리터럴에는 'D' 또는 'd'를 붙이거나 생략합니다.

        // 각 변수 출력
        System.out.println(isPassed);     // true
        System.out.println(grade);        // A
        System.out.println(year);         // 3
        System.out.println(score);        // 10
        System.out.println(sumScore);     // 100
        System.out.println(currentTime);  // 12345678
        System.out.println(avg);          // 80.25
        System.out.println(examAvg);      // 80.513242

    }
}
