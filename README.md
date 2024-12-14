# 프로젝트 설정 가이드

## 1. 프로젝트 생성 및 설정
- **Spring Initializr**를 사용하여 프로젝트를 생성합니다.
- `application.properties` 또는 `application.yml` 파일에 **PostgreSQL 데이터베이스 연결 설정**을 추가합니다.

---

## 2. 데이터베이스 테이블 설계 및 생성
1. **PostgreSQL 데이터베이스 설계**
   - 데이터베이스와 테이블 설계를 진행합니다.
2. **SQL 스크립트 실행**
   - PostgreSQL Shell(SQL Shell 또는 Command Line)에서 설계된 스크립트를 실행합니다.

---

## 3. MyBatis Mapper 작성
- `resources/mapper` 디렉토리에 MyBatis SQL 매퍼 파일 생성  
  - 예: `UserMapper.xml`

---

## 4. 도메인 모델 생성
- 데이터베이스 테이블과 매핑되는 **엔티티 클래스**를 생성합니다.

---

## 5. MyBatis Mapper 인터페이스 작성
- `com.security.daegucatholic.mapper` 패키지에 인터페이스를 생성  
  - 예: `UserMapper.java`

---

## 6. 서비스 계층 생성
- `com.security.daegucatholic.service` 패키지에 서비스 클래스를 생성  
  - 예: `UserService.java`

---

## 7. 컨트롤러 생성
- `com.security.daegucatholic.controller` 패키지에 컨트롤러 클래스를 생성  
  - 예: `UserController.java`

---

## 8. 프론트엔드 (Thymeleaf 템플릿 생성)
- `src/main/resources/templates` 디렉토리에 HTML 파일 생성  
  - 예: `users.html`

---

## 9. 애플리케이션 실행
- 애플리케이션을 실행한 후, **http://localhost:8080/users**에 접속하여 동작을 확인합니다.

---

## 10. 추가 개선
- **입력 값 검증**: Bean Validation 적용
- **보안 추가**: Spring Security 적용
- **테스트 코드 작성**: JUnit 사용

---

# PostgreSQL 설정 가이드

## PostgreSQL 설치 및 설정(MAC cmd)
1. **설치**
   ```bash
   $ brew install postgresql@15
   $ echo 'export PATH="/opt/homebrew/opt/postgresql@15/bin:$PATH"' >> ~/.zshrc
   $ source ~/.zshrc
   $ postgres --version
   $ brew services start postgresql@15


2. **실행**
   ```bash
   $ createdb yourdbname (now running in background)
   $ psql || $ psql -d postgres
   $ \du (사용자 목록 확인)
   $ CREATE ROLE postgres WITH LOGIN PASSWORD '123456'; (사용자 생성)
   $ ALTER ROLE postgres CREATEDB; (권한 부여)


# DBeaver 설정 가이드
## DBeaver 설치
	•	DBeaver 다운로드
- https://dbeaver.io/download/

### PostgreSQL 연결
- 1.	새 연결 생성
	*	우클릭 → Create → Connection
	*	데이터베이스 유형: PostgreSQL
- 2.	접속 정보 입력
	*	사용자 이름, 비밀번호, 데이터베이스 이름 입력

