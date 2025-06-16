프로젝트 실행 안내 (GoTome)

1. 개발환경
   - JDK 17 이상
   - IntelliJ 또는 Gradle 지원 IDE
   - H2 데이터베이스 (내장 사용)

2. 실행 방법
   ① IntelliJ에서 프로젝트 폴더(go-tome)를 [Open]합니다.
   ② Gradle 탭 > Tasks > application > bootRun 실행
       또는 아래 명령어 중 하나 사용:
         (Mac/Linux) ./gradlew bootRun
         (Windows)   gradlew.bat bootRun
   ③ 정상 실행되면 브라우저에서 아래 주소로 접속:
       → http://localhost:8081

3. 참고 사항
   - DB는 H2(Localhost) 방식으로 자동 생성됩니다.
   - 기본 포트는 8081로 설정되어 있습니다.
   - 초기 사용자 등록은 직접 회원가입 페이지에서 진행해야 합니다.
   - H2 콘솔 URL:
     http://localhost:8081/h2-console
     JDBC URL: jdbc:h2:tcp://localhost/~/gotome
     User Name: sa
     Password:  (빈칸)

4. 주요 테스트 기능
  - 회원가입 (멘토/멘티 선택 가능)
  - 로그인 (역할에 따라 기능 분기)
  - 멘티 → 멘토링 요청 등록
  - 멘토 → 요청 목록 조회, 신청, 답글 달기
  - 멘티 → 답글 확인
