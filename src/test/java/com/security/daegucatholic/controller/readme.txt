==== 단위 테스트(컨트롤러 & 서비스 등) -> 통합 테스트 ===

1. @MockBean 사용 시 빨간 줄이 나오는 이유

	•	Spring Boot 3.2.0부터 @MockBean 어노테이션이 **Deprecated(사용 중단 예정)**으로 표시되었습니다.
	이는 Spring Team에서 더 나은 방식으로 모킹(mocking)을 권장하기 위해 단계적으로 제거를 준비하고 있다는 뜻입니다.

2. @MockBean 경고를 무시

@MockBean을 계속 사용하고 싶다면 Deprecated 경고를 무시할 수 있습니다. 두 가지 방법이 있습니다:

방법 1: @SuppressWarnings 어노테이션 사용

테스트 클래스나 필드에 @SuppressWarnings("removal")를 추가하여 경고를 무시할 수 있습니다.

방법 2: IDE 설정에서 Deprecated 경고 비활성화

IDE에서 Deprecated 관련 경고를 비활성화할 수도 있습니다.
	•	IntelliJ IDEA:
	1.	Preferences > Editor > Inspections로 이동.
	2.	Deprecated API usage 항목을 검색.
	3.	체크 해제하여 경고를 비활성화.


======= 해결된 문제 ========
( 슈퍼유저 말고, 생성한 postgrsql 이라는 사용자, aws iam 같은)
에러의 원인은 애플리케이션이 PostgreSQL 데이터베이스의 users 테이블에 대한 권한이 부족하기 때문입니다.
 즉, 데이터베이스에 연결된 사용자가 users 테이블에 INSERT(데이터 삽입) 작업을 수행할 권한이 없어서 발생한 오류입니다.

	1.	데이터베이스 사용자 권한 확인:
PostgreSQL에 접속하여 현재 사용자의 권한을 확인하세요.

\du

	2.	users 테이블 권한 부여:
해당 사용자에게 users 테이블에 대한 필요한 권한을 부여합니다.

GRANT INSERT, SELECT, UPDATE, DELETE ON TABLE users TO your_database_user;

	3.	스키마 접근 권한 확인:
테이블이 특정 스키마(예: public)에 속해 있다면, 해당 사용자가 스키마에 접근할 수 있는지 확인하고 권한을 부여합니다.

GRANT USAGE ON SCHEMA public TO your_database_user;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO your_database_user;

	4.	Spring Boot 설정 확인:
application.properties 또는 application.yml에서 데이터베이스 연결 설정이 올바른지 확인하세요.

spring.datasource.url=jdbc:postgresql://localhost:5432/your_database
spring.datasource.username=your_database_user
spring.datasource.password=your_password