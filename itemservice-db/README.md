## 1. 데이터 접근 기술 - 시작

### 1. 데이터 접근 기술 진행 방식 소개
- SQLMapper
  - JdbcTemplate
  - MyBatis
- ORM 관련 기술
  - JPA, Hibernate
  - 스프링 데이터 JPA
  - Querydsl

### 2. 데이터베이스 테이블 생성
- 데이터베이스 기본 키 조건
  - null값 미허용
  - 유일성 만족
  - 불변 만족
- 테이블의 기본 키 선택
  - 자연 키(Natural Key) : 비즈니스에 의미가 있는 키
  - 대리 키(Surrogate Key) : 비즈니스와 관련 없는 임의로 만들어진 키, 대체 키

## 2. 데이터 접근 기술 - 스프링 JdbcTemplate

### 1. JdbcTemplate 소개와 설정
- 설정의 편리함 : 스프링으로 JDBC를 사용할 때 기본으로 사용하는 템플릿 활용 가능
- 반복 문제 해결
  - 템플릿 콜백 패턴 -> 반복 작업 처리
  - SQL 작성 -> 전달할 파라미터 정의, 응답 값 매핑
  - 커넥션 획득
  - statement 준비 및 실행
  - 결과 반복 루프 실행
  - 커넥션 종료, statement, resultset 종료
  - 트랜잭션 커넥션 동기화
  - 예외 발생 시 스프링 예외 변환기 실행
- 동적 SQL 해결 어려움

### 2. JdbcTemplate - 이름 지정 파라미터 1
- 기본 사용 시 파라미터 순서대로 바인딩
- `NamedParameterJdbcTemplate` : 이름 지정 파라미터 바인딩 가능
  - key : value 데이터 구조로 전달
  - key : 파라미터 이름
  - value : 파라미터 값
  - Map 사용 : 단순 Map 사용
  - MapSqlParameterSource 사용 : SQL에 좀 더 특화된 기능 제공
  - BeanPropertySqlParameterSource 사용 : 자바빈 프로퍼티 규약 -> 자동으로 파라미터 객체 생성

### 3. JdbcTemplate - SimpleJdbcInsert
- 직접 SQL을 작성하지 않아도 됨

### 4. JdbcTemplate 기능 정리
- JdbcTemplate : 순서 기반 파라미터 바인딩 지원
- NamedParameterJdbcTemplate : 이름 기반 파라미터 바인딩 지원, 권장
- SimpleJdbcInsert : INSERT SQL 편리하게 사용 가능
- SimpleJdbcCall : 스토어드 프로시저 편리하게 호출 가능

## 3. 데이터 접근 기술 - 테스틑

### 1. 테스트 - 데이터베이스 연동
- 실제 데이터베이스에 접근해서 데이터를 잘 저장하고 조회할 수 있는지 확인 필요

### 2. 테스트 - 데이터베이스 분리
- 테스트 전용 데이터베이스 별도 운영
- 테스트는 다른 테스트와 격리해야 함
- 테스트는 반복해서 실행할 수 있어야 함

### 3. 테스트 - 데이터 롤백
- 트랜잭션 -> 테스트 이후 데이터 제거

### 4. 테스트 - @Transactional
- 테스트 데이터 초기화를 위해 트랜잭션을 적용하고 롤백하는 방식
- 테스트 이후 개발자가 직접 데이터를 삭제하지 않아도 됨
- 트랜잭션 커밋하지 않음
- 트랜잭션 범위 안에서 테스트 진행 -> 동시에 다른 테스트 가능

### 5. 테스트 - 임베디드 모드 DB
- DB를 애플리케이션에 내장해서 함께 실행

### 6. 테스트 - 스프링 부트와 임베디드 모드
- 데이터베이스에 별다른 설정 없음 -> 임베디드 데이터베이스 사용

## 4. 데이터 접근 기술 - MyBatis

### 1. MyBatis 소개
- JdbcTemplate보다 더 많은 기능을 제공하는 SQL Mapper
- SQL을 XML에 편리하게 작성 가능
- 동적 쿼리 편리하게 작성 가능

### 2. MyBatis 설정
- mybatis-spring-boot-starter 라이브러리 사용

### 3. MyBatis 적용
- 마이바티스를 스프링에 편리하게 통합해서 사용 가능
- 매퍼 구현체 사용 -> 스프링 예외 추상화 함께 적용
- 데이터베이스 커넥션, 트랜잭션과 관련된 기능 함께 연동 및 동기화

### 4. MyBatis 기능 정리 1 - 동적 쿼리
- 동적 SQL
  - if
  - choose(when, otherwise)
  - trim(where, set)
  - foreach

### 5. MyBatis 기능 정리 2 - 기타 기능
- 어노테이션으로 SQL 작성 : @Insert, @Update, @Delete, @Select
- 문자열 대체 : #{}, ${}
- 재사용 가능한 SQL 조각
- Result Maps

## 5. 데이터 접근 기술 - JPA

### 1. JPA 시작
- ORM 데이터 접근 기술 제공
- 스프링 데이터 JPA + Querydsl

### 2. ORM 개념
- SQL 중심적인 개발의 문제점 : 무한 반복, 지루한 코드
- 객체와 관계형 데이터베이스 차이
  - 상속
  - 연관관계
  - 데이터 타입
  - 데이터 식별 방법
- JPA : 자바 진영의 ORM 기술 표준
  - 애플리케이션과 JDBC 사이에서 동작
  - 인터페이스 모음 : Hibernate, EclipseLink, DataNucleus
- ORM(Object-Relational Mapping) : 객체 관계 매핑
  - 객체는 객체대로 설계
  - 관계형 데이터베이스는 관계형 데이터베이스대로 설계
  - 중간에서 매핑
- JPA 사용 이유
  - 생산성 : JPA와 CRUD
  - 유지보수 : 필드만 추가, SQL 자동 처리
  - 패러다임의 불일치 해결 : 상속, 연관관계, 객체 그래프 탐색, 비교
  - 성능
  - 데이터 접근 추상화와 벤더 독립성
  - 표준

### 3. JPA 설정
- spring-boot-starter-data-jpa 라이브러리를 사용

### 4. JPA 적용
- JPQL : 객체지향 쿼리 언어, 여러 데이터를 복잡한 조건으로 조회
- JPA 사용 but 동적 쿼리 문제 존재

## 6. 데이터 접근 기술 - 스프링 데이터 JPA

### 1. 스프링 데이터 JPA 소개
- 스프링 : 현재 EJB 컨테이너 대체, 단순함의 승리
- 하이버네이트 : EJB 엔티티빈 기술 대체, JPA라는 새로운 표준 정의
- Spring Data JPA
  - CRUD + 쿼리
  - 동일한 인터페이스
  - 페이징 처리
  - 메서드 이름으로 쿼리 생성
  - 스프링 MVC에서 id 값만 넘겨도 도메인 클래스로 바인딩
  - 코딩량 감소
  - 도메인 클래스를 중요하게 다룸
  - 비즈니스 로직 이해 쉬움
  - 더 많은 테스트 케이스 작성 가능
  - JPA 이해 필요
  - 데이터베이스 설계 이해
  - 영속성 컨텍스트 이해
  - 변경 감지
  - 언제 영속성 컨텍스트가 플러시 되는가
  - 연관관계 매핑중에 mappedBy 이해
  - JPQL 한계 인식

### 2. 스프링 데이터 JPA 주요 기능
- 공통 인터페이스 기능 : 기본적인 CRUD 기능 제공
- 쿼리 메서드 기능 : 조회, COUNT, EXISTS, 삭제, DISTINCT, LIMIT

## 7. 데이터 접근 기술 - Querydsl

### 1. Querydsl 소개
- Query 문제점 : 문자, 타입 체크 불가능, 실행하기 전까지 작동여부 확인 불가
- Querydsl : 쿼리를 자바로 Type-Safe 하게 개발할 수 있게 지원하는 프레임워크
  - 쿼리 + 도메인 + 특화 + 언어
  - 단순, 간결, 유챵
  - 다양한 저장소 쿼리 기능 통합
- Querydsl-JPA : JPA 쿼리를 Type-Safe 하게 작성하는 데 사용
  - 단순함, 쉬움
  - Q코드 생성을 위한 APT 설정 필요

### 2. Querydsl 적용
- 동적 쿼리 깔끔하게 사용 가능
- 쿼리 문장에 오류 존재 -> 컴파일 시점에 오류 예방
- 메서드 추출 -> 코드 재사용 가능

