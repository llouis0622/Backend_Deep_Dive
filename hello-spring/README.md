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