# -spring-quickstart-next-step

비밀번호(Password) 입력: Oracle123!

[DBT-11209] 현재 사용 가능한 메모리가 데이터베이스 생성에 필요한 사용 가능한 메모리 보다 작습니다.
----------------------------------------------------------------------------------
원인 - 다음 노드에는 필요한 사용 가능한 메모리가 없음: 노드:desktop-jfpuds1 사용 가능한 메모리:4.4751GB (4692504.0KB)   작업 - 데이터베이스가 다양한 메모리 매개변수를 사용하는 방법에 대한 자세한 내용은 Database Administration Guide를 참조하십시오.


좋아요, 정말 잘 오셨어요!
**"Spring Boot + MyBatis + Oracle"** 이 세 가지 기술을 **처음부터 아주 쉽게**, **초등학생도 따라할 수 있게** 설치부터 차근차근 설명해드릴게요.

---

# ✅ 0. 준비하기

### 💡 앞으로 만들 건?

* 웹 브라우저에서 사용할 수 있는 **간단한 회원관리 프로그램**
* **Spring Boot** = 백엔드 웹 서버 만드는 기술
* **MyBatis** = 데이터베이스와 연결해서 데이터 넣고/불러오는 기술
* **Oracle** = 데이터베이스 (정보 저장소)

---

# ✅ 1. Oracle 설치 (데이터 저장 창고)

## 🔸 1-1. Oracle Database Express Edition (XE) 설치

### 🔧 설치 파일 받기

1. 아래 링크로 이동
   👉 [https://www.oracle.com/database/technologies/xe-downloads.html](https://www.oracle.com/database/technologies/xe-downloads.html)
2. Windows 버전 클릭 → Oracle 계정 로그인 필요
   → 없다면 무료 회원가입 진행
3. `OracleXE213_Win64.zip` 다운받고 압축 풀기

### ⚙️ 설치하기

1. 압축을 풀고 `setup.exe` 실행
2. **계속 "다음" 누르기**, 특별한 설정은 없음
3. 설치 중 `비밀번호(password)` 설정 화면이 나옴
   👉 기억하기 쉬운 `oracle1234`로 설정 추천

### ✅ 설치 완료되면?

* Oracle이 백그라운드에서 실행 중
* `시작 > SQL Developer` 또는 `CMD`에서 테스트 가능

---

## 🔸 1-2. DB 연결 툴 DBeaver 설치 (선택)

> Oracle과 대화하기 쉬운 **도구**입니다

1. [https://dbeaver.io/download/](https://dbeaver.io/download/) 에서 Community Edition 설치
2. 설치 후 실행 → Oracle 접속 추가
3. JDBC 드라이버 자동 설치 → 아래 정보 입력:

```
호스트: localhost
포트: 1521
서비스 이름: XE
사용자: system
비밀번호: oracle1234 (아까 설정한 비번)
```

---

# ✅ 2. Java 설치 (Spring Boot의 기반)

### 🔧 설치 파일 받기

1. [https://adoptium.net/ko/temurin/releases/?version=17](https://adoptium.net/ko/temurin/releases/?version=17)
2. Windows x64 MSI 설치파일 다운로드

### ⚙️ 설치

1. `next → next → finish`로 기본 설치
2. 설치 후 환경변수 자동 등록됨
3. 확인: 명령어 창 열고 입력

```bash
java -version
```

---

# ✅ 3. IntelliJ 설치 (개발 툴)

### 🔧 설치

1. [https://www.jetbrains.com/idea/download](https://www.jetbrains.com/idea/download)
2. **Community 버전** 설치
3. 설치 후 실행 → 프로젝트 만들기 준비 완료!

---

# ✅ 4. Spring Boot 프로젝트 생성

### 방법 1: 웹에서 생성 후 다운로드

1. [https://start.spring.io](https://start.spring.io) 접속

2. 설정:

   * Project: **Maven**
   * Language: **Java**
   * Spring Boot: 최신 안정버전
   * Group: `com.example`
   * Artifact: `demo`

3. Dependencies (의존성 추가)

   * Spring Web
   * Spring Boot DevTools
   * MyBatis Framework
   * Oracle Driver
   * Lombok (선택)

4. **Generate 버튼 클릭** → ZIP 다운로드 → 압축 해제

5. IntelliJ로 열기

---

# ✅ 5. application.yml 설정하기

```yaml
spring:
  datasource:
    url: jdbc:oracle:thin:@localhost:1521:XE
    username: system
    password: oracle1234
    driver-class-name: oracle.jdbc.OracleDriver

  mybatis:
    mapper-locations: classpath:mapper/*.xml
    type-aliases-package: com.example.demo.model

server:
  port: 8080
```

---

# ✅ 6. 프로젝트 구조 예시

```
src
├── controller        ← 사용자 요청 처리
├── service           ← 비즈니스 로직
├── mapper            ← DB 쿼리 처리
├── model             ← 데이터 객체
└── resources
    ├── mapper        ← XML 쿼리
    └── application.yml
```

---

다음 단계부터는 다음 중 하나로 이어질 수 있어요:
-------------------------------------------------
1. 오라클에 사용자 테이블 만들기 (SQL)
2. MyBatis로 사용자 정보 저장/조회
3. Spring Boot로 API 만들기
4. 화면 없이 Postman으로 테스트하기
-------------------------------------------------
[사용자 (브라우저/Postman)]
   ↓
[UserController.java] ← 사용자의 요청을 받고
   ↓
[UserService.java] ← 어떤 처리를 해야 하는지 결정하고
   ↓
[UserMapper + Mapper.xml] ← DB에 실제로 저장하거나 조회함
   ↓
[ApiResponse.java] ← 결과를 정리해서 사용자에게 전달
-------------------------------------------------
C:\app\joamashi\product\21c\dbhomeXE\bin


SpringBoot+MyBatis+Oracle
https://next-step-2025.notion.site/SpringBoot-MyBatis-Oracle-219b5b5ccc2680e19e8fc5180766316a?pvs=73

JAVA 시작하기 100제
https://next-step-2025.notion.site/JAVA-100-20fb5b5ccc268003a147d6370458b348?pvs=74

Spring Boot 시작하기 100제
https://next-step-2025.notion.site/Spring-Boot-100-20fb5b5ccc26802188abfb207006cc7f?pvs=74

React.js의 렌더링 방식 살펴보기
https://next-step-2025.notion.site/React-js-211b5b5ccc268075b0a1c182bdca7596?pvs=74

왜 useCallback, React.memo, useMemo를 사용할까?
https://next-step-2025.notion.site/useCallback-React-memo-useMemo-211b5b5ccc268018a0decce293d65438?pvs=74

React + TypeScript 시작하기 100제
https://next-step-2025.notion.site/React-TypeScript-100-20fb5b5ccc2680a3a9e1d0e8448c41f4?pvs=74

React Router DOM 시작하기 100제
https://next-step-2025.notion.site/React-router-dom-100-211b5b5ccc26807ba4a1e97b97fd54d4

React REST API 사용가이드
https://next-step-2025.notion.site/React-REST-API-219b5b5ccc2680b2b79ae20ea718a078


테슬라 파워월로 진짜 하루 살 수 있을까?