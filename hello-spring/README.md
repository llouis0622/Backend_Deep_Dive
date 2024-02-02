## 1. 프로젝트 환경 설정

### 1. 프로젝트 생성
- https://start.spring.io 활용
- Project
  - Project : Gradle-Groovy Project
  - Spring Boot : 3.2.2
  - Language : Java
  - Packaging : Jar
  - Java : 21
- Project Metadata
  - groupId : hello
  - artifactId : hello-spring
- Dependencies : Spring Web, Thymeleaf

### 2. 라이브러리 살펴보기
- 스프링 부트 라이브러리
  - spring-boot-starter-web
    - spring-boot-starter-tomcat : 톰캣(웹서버)
    - spring-webmvc : 스프링 웹 MVC
  - spring-boot-starter-thymeleaf : 타임리프 템플릿 엔진(View)
  - spring-boot-starter(공통) : 스프링 부트 + 스프링 코어 + 로깅
    - spring-boot
      - spring-core
    - spring-boot-starter-logging
      - logback, slf4j
- 테스트 라이브러리
  - spring-boot-starter-test
    - junit : 테스트 프레임워크
    - mockito : 목 라이브러리
    - assertj : 테스트 코드를 좀 더 편하게 작성하게 도와주는 라이브러리
    - spring-test : 스프링 통함 테스트 지원

### 3. View 환경설정
- Welcome Page 만들기
- thymeleaf 템플릿 엔진
- 컨트롤러에서 리턴 값으로 문자를 반환하면 뷰 리졸버가 화면을 찾아서 처리
  - 스프링 부트 템플릿엔진 기본 viewName 매핑
  - resources : templates/ + {ViewName} + .html

---

## 2. 스프링 웹 개발 기초

### 1. 정적 컨텐츠
- 파일을 그대로 웹브라우저로 전달
- 스프링 부트 정적 컨텐츠 기능

### 2. MVC와 템플릿 엔진
- MVC : Model, View, Controller
- View : 화면에 관련된 일
- Model, Controller : 비즈니스 로직 및 서버 관리

### 3. API
- `@ResponseBody`
  - HTTP의 BODY에 문자 내용을 직접 반환
  - `viewResolver` -> `HttpMessageConverter` 동작
  - 기본 문자처리 : `StringHttpMessageConverter`
  - 기본 객체처리 : `MappingJacson2HttpMessageConverter`
  - byte 처리 등 기타 여러 `HttpMessageConverter`가 기본으로 등록

---

## 3. 회원 관리 예제 - 백엔드 개발

### 1. 비즈니스 요구사항 정리
- 데이터 : 회원ID, 이름
- 기능 : 회원 등록, 조회
- 아직 데이터 저장소가 선정되지 않음(가상의 사니라오)
- 일반적인 웹 애플리케이션 계층 구조
  - 컨트롤러 : 웹 MVC의 컨트롤러 역할
  - 서비스 : 핵심 비즈니스 로직 구현
  - 리포지토리 : 데이터베이스에 접근, 도메인 객체를 DB에 저장하고 관리
  - 도메인 : 비즈니스 도메인 객체

### 2. 회원 도메인과 리포지토리 만들기

### 3. 회원 리포지토리 테스트 케이스 작성
- JUnit 프레임워크 -> 테스트 실행
- `@AfterEach` : 각 테스트가 종료될 때 마다 기능 실행, 메모리 DB에 저장된 데이터 삭제
- 테스트는 각각 독립적으로 실행

### 4. 회원 서비스 개발

### 5. 회원 서비스 테스트
- `@BeforeEach` : 각 테스트 실행 전에 호출, 테스트가 서로 영향이 없도록 항상 새로운 객체 생성, 의존관계 새로 맺어줌

---

## 4. 스프링 빈과 의존관계

### 1. 컴포넌트 스캔과 자동 의존관계 설정
- `@Autowired` : 스프링이 연관된 객체를 스프링 컨테이너에서 찾아서 넣어줌
- DI(Dependency Injection) : 의존성 주입, 객체 의존관계를 외부에서 넣어주는 것
- 컴포넌트 스캔과 자동 의존관계 설정
- 자바 코드로 직접 스프링 빈 등록하기

### 2. 자바 코드로 직접 스프링 빈 등록하기
- DI
  - 필드 주입
  - setter 주입
  - 생성자 주입
- 주로 정형화된 컨트롤러, 서비스, 리포지토리 같은 코드 -> 컴포넌트 스캔
- 정형화되지 않거나 상황에 따라 구현 클래스 변경 -> 설정을 통해 스프링 빈으로 등록

---

## 5. 회원 관리 예제 - 웹 MVC 개발

### 1. 회원 웹 기능 - 홈 화면 추가
- 컨트롤러가 정적 파일보다 우선순위가 높음

### 2. 회원 웹 기능 - 등록

### 3. 회원 웹 기능 - 조회