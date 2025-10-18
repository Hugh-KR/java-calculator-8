# java-calculator-precourse

## 문자열 덧셈 계산기

### 구현할 기능 목록

1. **기본 구분자 처리**

   - 쉼표(,) 또는 콜론(:)을 구분자로 하는 문자열 처리
   - 빈 문자열 입력 시 0 반환
   - 예: "" => 0, "1,2" => 3, "1,2,3" => 6, "1,2:3" => 6

2. **커스텀 구분자 처리**

   - "//구분자\n숫자들" 형태의 입력 처리
   - 예: "//;\n1;2;3" => 6

3. **입력 검증 및 예외 처리**

   - 음수 입력 시 IllegalArgumentException 발생
   - 잘못된 값 입력 시 예외 처리

4. **MVC 패턴 구현**

   - Model: Calculator
   - View: InputView, OutputView
   - Controller: CalculatorController
   - Validation: InputValidator
   - Constants: CalculatorConstants (enum)

5. **사용자 입출력**

   - Console API를 사용한 입력 처리
   - "결과 : {합계}" 형태의 출력

6. **프로젝트 구조**

   ```
   calculator/
   ├── Application.java
   ├── constants/          # CalculatorConstants.java
   ├── controller/         # CalculatorController.java
   ├── model/              # Calculator.java
   ├── validation/         # InputValidator.java
   └── view/               # InputView.java, OutputView.java
   ```

7. **코드 품질 및 설계**
   - Google Java Style Guide 준수
   - 디미터 법칙 적용
   - 단일 책임 원칙 준수
   - 의존성 주입을 통한 테스트 가능한 구조
   - enum을 활용한 상수 관리
