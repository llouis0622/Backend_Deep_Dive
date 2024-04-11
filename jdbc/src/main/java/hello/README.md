## 1. JDBC 이해

### 1. 프로젝트 생성
- Gradle-Groovy
- Java 21
- Spring Boot 3.2.4
- JDBC API, H2 Database, Lombok

### 2. H2 데이터베이스 설정

### 3. JDBC 이해
- 데이터베이스를 다른 종류의 데이터베이스로 변경 시 데이터베이스 사용 코드도 변경해야 함
- 개발자가 각각의 데이터베이스마다 커넥션 연결, SQL 전달, 결과 응답 새로 학습해야 함
- JDBC(Java Database Connectivity) : 자바에서 데이터베이스에 접속할 수 있도록 하는 자바 API
  - 데이터베이스에서 자료 쿼리 및 업데이트 방법 제공
  - `java.sql.Connection` : 연결
  - `java.sql.Statement` : SQL을 담은 내용
  - `java.sql.ResultSet` : SQL 요청 응답

### 4. JDBC와 최신 데이터 접근 기술
- SQL Mapper
  - JDBC를 편리하게 사용 가능
  - SQL 응답 결과 -> 객체로 변환
  - JDBC 반복 코드 제거
  - 개발자가 SQL 직접 작성
  - 스프링 JDBC Template, MyBatis
- ORM
  - 객체를 관계형 데이터베이스 테이블과 매핑해주는 기술
  - SQl 동적 실행
  - JPA, 하이버네이트, 이클립스링크

### 5. 데이터베이스 연결
- JDBC -> 라이브러리 등록된 DB 드라이버 관리, 커넥션 획득

### 6. JDBC 개발 - 등록
- `getConnection()` : 커넥션 획득
- `save()` : SQL 전달

### 7. JDBC 개발 - 조회
- `findById()` : 쿼리 실행
- `excuteQuery()`

### 8. JDBC 개발 - 수정, 삭제
