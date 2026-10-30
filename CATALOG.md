# CATALOG

원본 저장소 단위 목록입니다. 기간은 원본 커밋의 첫 커밋–마지막 커밋 날짜(KST)이고, 모두 편입·검증을 마쳤습니다.
†는 공개 전 정화(값 치환 또는 파일 제외)로 일부 커밋이 다시 만들어진 저장소입니다 ([README](README.md#이력-정화)).

## Java

| 디렉터리 | 기간 | 커밋 | 내용 |
|---|---|---:|---|
| [java-study](sources/java-study) † | 2023-07-18 – 2023-08-26 | 39 | 자료형·연산자·메서드·제어문·배열·문자열 예제(`Ex01`–), 컬렉션·정규식·공공데이터 API, 콘솔 프로젝트 `Daitso`, `auth`, `calendar` |
| [java-question](sources/java-question) | 2023-07-19 – 2023-08-08 | 34 | 문제 풀이 `Q001`–. 기초 예제 96개 파일은 java-study와 같음 |
| [java-summary](sources/java-summary) | 2023-07-21 | 2 | 요약 노트 `S0001`–`S0004` |
| [java-core-programming-study](sources/java-core-programming-study) | 2024-02-24 | 4 | 디버깅·변수 테스트 |

## Database

| 디렉터리 | 기간 | 커밋 | 내용 |
|---|---|---:|---|
| [oracle-study](sources/oracle-study) † | 2023-08-25 – 2023-09-22 | 29 | Oracle SQL 일차별 실습, ANSI SQL, PL/SQL, View, ERD 팀 실습(eXERD, draw.io), 실습용 데이터 스크립트 |

## Frontend

| 디렉터리 | 기간 | 커밋 | 내용 |
|---|---|---:|---|
| [client-html](sources/client-html) | 2023-09-19 – 2023-10-04 | 10 | HTML 태그·폼·테이블·미디어 예제, 문제 풀이 |
| [client-css](sources/client-css) | 2023-09-22 – 2023-10-04 | 5 | 선택자·박스 모델·배치·애니메이션 |
| [client-javascript](sources/client-javascript) | 2023-10-04 – 2023-10-13 | 28 | 자료형·함수·BOM·DOM·이벤트, 문제 풀이 |
| [client-jquery](sources/client-jquery) | 2023-10-17 | 1 | 효과·조작·탐색 |

## Backend

| 디렉터리 | 기간 | 커밋 | 내용 |
|---|---|---:|---|
| [server-jsp](sources/server-jsp) † | 2023-10-17 – 2023-10-18 | 2 | JSP 기본·내장 객체 (server의 `JSPTest`와 대부분 같음) |
| [server-jdbc](sources/server-jdbc) | 2023-10-20 | 1 | JDBC Statement·PreparedStatement·CallableStatement (server의 `JDBCTest`와 같음) |
| [server](sources/server) † | 2023-10-24 – 2023-11-01 | 5 | Eclipse 워크스페이스: Servlet, JSP, JDBC, MVC, Ajax, Auth, Crawling, Memo, Todo, ToyProject. IDE 상태(`.metadata`) 포함 |
| [spring-boot-study](sources/spring-boot-study) | 2024-10-23 – 2024-10-26 | 3 | Spring Boot 3.3 · Java 17 · MyBatis · Thymeleaf 지도 기능 실습 |

## Mobile

| 디렉터리 | 기간 | 커밋 | 내용 |
|---|---|---:|---|
| [react-native-study](sources/react-native-study) | 2024-10-20 – 2024-10-25 | 2 | 이름과 달리 React Native가 아닌 **Android 네이티브(Java, Gradle Kotlin DSL)** 기본 프로젝트 |

## 참고

- `server/JDBCTest/bin/com/test/jdbc`는 원본에 있던 내장 저장소 흔적(gitlink)입니다. server-jdbc의 커밋 `033645f`를 가리키며, 이 커밋은 `sources/server-jdbc`로 함께 보관되어 있습니다.
- 편입하지 않은 저장소: `spring-boot-react-study`(커밋이 없는 빈 저장소)
