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

## 2. 커넥션풀과 데이터소스 이해

### 1. 커넥션 풀 이해
- 커넥션을 관리하는 풀
- 적절한 커넥션 풀 숫자 -> 성능 테스트를 통해 정함
- 서버당 최대 커넥션 수 제한 가능 -> DB에 무한정 연결 생성 보호
- commons-dbcp2, tomcat-jdbc pool, HikariCP

### 2. DataSource 이해
- `DriverManager` 직접 사용, 커넥션 풀 사용
- 커넥션을 획득하는 방법 추상화
- 커넥션 조회 기능

### 3. DataSource - DriverManager
- 설정 : DataSource 제작, 필요한 속성 사용
- 사용 : `getConnection()` 호출

## 3. 트랜잭션 이해

### 1. 트랜잭션 - 개념 이해
- 데이터베이스에서 하나의 거래를 안전하게 처리하도록 보장해주는 것
- 커밋 : 모든 작업 성공 -> 데이터베이스에 정상 반영
- 롤백 : 작업 중 하나라도 실패해서 거래 이전으로 되돌리는 것
- 원자성(Atomicity) : 트랜잭션 내 실행한 작업은 하나의 작업처럼 모두 성공하거나 실패함
- 일관성(Consistency) : 모든 트랜잭션은 일관성 있는 데이터베이스 상태 유지
- 격리성(Isolation) : 동시에 실행되는 트랜잭션들이 서로에게 영향을 미치지 않도록 격리함
- 지속성(Durability) : 트랜잭션을 성공적으로 끝내면 그 결과가 항상 기록되어야 함
- READ UNCOMMITTED
- READ COMMITTED
- REPEATABLE READ
- SERIALIZABLE

### 2. 데이터베이스 연결 구조와 DB 세션
- 클라이언트 -> 데이터베이스 서버 접근
- 서버 연결 요청 -> 커넥션
- 트랜잭션 시작, 커밋 및 롤백으로 트랜잭션 종료
- 커넥션 종료 -> 세션 종료

### 3. 트랜잭션 - DB 예제 1 - 개념 이해
- 데이터 변경 쿼리 실행, 데이터베이스 결과 반영
- 커밋 호출 전까지는 임시로 데이터 저장
- 변경 : 등록, 수정, 삭제

### 4. 트랜잭션 - DB 예제 2 - 자동 커밋, 수동 커밋
- 자동 커밋 : 각각의 쿼리 실행 직후에 자동으로 커밋 호출
- 수동 커밋 : 트랜잭션

