프로젝트 실행 안내 (GoTome)

1. 개발환경
   - Java JDK 17 이상
   - IntelliJ IDEA 또는 Gradle 지원 IDE
   - H2 Database (TCP 서버 모드 사용)

2. 프로젝트 실행 순서

① H2 데이터베이스 서버 실행 (※ 필수)
   아래 명령어를 터미널에 입력하여 H2 서버를 먼저 실행해 주세요:

   예시 (Mac 기준):
   java -cp ~/Downloads/h2/bin/h2-1.4.199.jar org.h2.tools.Server

   실행 후:
      - 대부분의 환경에서 브라우저가 자동으로 열립니다
        → http://localhost:8082 (H2 Web Console)

② Spring Boot 애플리케이션 실행

   방법 1: IntelliJ에서
   - 프로젝트 폴더(go-tome) 열기
   - `GoTomeApplication.java` 클래스에 ▶️ 버튼 클릭 (또는 bootRun)

   방법 2: 터미널에서
   - (Mac/Linux)  ./gradlew bootRun
   - (Windows)    gradlew.bat bootRun

③ 브라우저에서 애플리케이션 접속
   → http://localhost:8081

④ H2 Console 접속
   → http://localhost:8081/h2-console

   접속 정보:
   - JDBC URL: jdbc:h2:tcp://localhost/~/gotome
   - User Name: sa
   - Password: (빈칸)

4. 주요 테스트 기능
  - 회원가입 (멘토/멘티 선택 가능)
  - 로그인 (역할에 따라 기능 분기)
  - 멘티 → 멘토링 요청 등록
  - 멘토 → 요청 목록 조회, 신청, 답글 달기
  - 멘티 → 답글 확인
