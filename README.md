# study-archive

2023–2024년에 프로그래밍을 공부하며 만든 개별 저장소 14개를 **원본 Git 이력과 함께** 한곳에 모아 둔 보관소입니다.
당시의 코드와 커밋을 그대로 보존하며, 리팩터링하거나 다시 정리하지 않습니다.

- 무엇이 있는지: [CATALOG.md](CATALOG.md)
- 원본 저장소, 커밋, 검증 기록: [metadata/repositories.json](metadata/repositories.json)
- 포함된 서드파티 구성 요소의 고지: [THIRD_PARTY_NOTICES.md](THIRD_PARTY_NOTICES.md)
- 보관소에 포함하지 않은 외부 라이브러리: [외부 의존성](#외부-의존성)

## 구조

```
study-archive/
├── README.md
├── CATALOG.md               # 분야별 목록과 설명
├── metadata/
│   ├── repositories.json    # 원본 URL, 브랜치, 원본 최종 SHA, 트리 해시, 편입 커밋, 검증 결과
│   └── sha-map/             # 정화로 다시 만들어진 커밋의 원본 SHA → 보관소 SHA 대응표
└── sources/
    └── <원본 저장소 이름>/   # 원본 저장소 기본 브랜치의 내용 (경로 그대로)
```

`sources/` 아래 디렉터리 이름은 원본 GitHub 저장소 이름과 같습니다
(`sources/java-study` ↔ `github.com/isaacslee/java-study`).

## 원본 이력을 보는 방법

각 저장소는 *subtree merge* 방식으로 편입했습니다. 원본 커밋은 편입 병합 커밋의 두 번째 부모로
연결되어 있고, 편입한 최종 커밋에는 `source/<이름>` 태그가 붙어 있습니다.

원본 커밋 안에서는 파일이 저장소 루트에 있었기 때문에 `sources/<이름>/` 경로로 이력을 찾으면
편입 커밋 하나만 보입니다. 원본 이력은 태그를 기준으로 원래 경로를 사용해 조회합니다.

```bash
# 원본 저장소의 전체 커밋
git log --oneline source/java-question

# 원본 시점의 파일 이력과 blame (경로는 원본 기준)
git log --oneline source/java-question -- Ex01.java
git blame source/java-question -- Ex01.java

# 원본 커밋 SHA로 직접 조회
git show e38ef87902c91b004069e2cc2245379874c033f4

# 보관소 자체의 변경만 보기
git log --first-parent --oneline
```

## 이력 정화

공개 전에 전체 이력을 검사했습니다. 실제 자격 증명과 개인 전화번호로 보이는 값만 바꿨고,
학습 소스 보존에 필요하지 않은 외부 JAR(Oracle JDBC 드라이버, COS)를 이력에서 제외했습니다.
그 밖의 파일, 경로, 작성자, 작성 시각, 메시지, 커밋 순서는 그대로입니다.

| 저장소 | 바꾼 내용 | 다시 만들어진 커밋 | 원본 SHA 유지 |
|---|---|---:|---:|
| java-study | `dummy/Ex76.java`의 data.go.kr 서비스 키 → `[REDACTED]` | 3 / 39 | 36 |
| oracle-study | `이승원_0157.sql`의 전화번호 3개 → `010-0000-000N`, 루트의 `ojdbc6.jar` 제외 | 22 / 29 | 7 |
| server | Eclipse 로컬 편집 이력(`.metadata/.../.history`)에 남은 외부 사이트 로그인 값 → `[REDACTED]`, 동봉된 `ojdbc6.jar`·`cos.jar` 제외 | 5 / 5 | 0 |
| server-jsp | `WEB-INF/lib/cos.jar` 제외 | 1 / 2 | 1 |

나머지 10개 저장소의 커밋은 모두 원본 SHA 그대로입니다.

java-study와 server-jsp에서 다시 만들어진 커밋의 원본 SHA는 [metadata/sha-map/](metadata/sha-map)에 있습니다.
oracle-study와 server의 원본 SHA는 공개하지 않습니다. 바뀐 값이 짧아서, 원본 SHA가 있으면
후보 값을 대입해 원래 값을 확인할 수 있기 때문입니다.

## 외부 의존성

아래 라이브러리는 재배포하지 않으므로 보관소에 들어 있지 않습니다. jar 파일만 이력에서 제외했고,
이를 사용하는 Java/JSP 소스와 Eclipse 프로젝트 설정(`.classpath` 등)은 원본 그대로입니다.
예제를 다시 실행하려면 직접 받아 원래 위치에 넣으세요.

| 라이브러리 | 원래 위치 | 받는 곳 |
|---|---|---|
| Oracle JDBC 드라이버 `ojdbc6.jar` (당시 11.2.0.2) | `sources/server/{AjaxTest,CrawlingTest,Memo,Todo,ToyProject,ToyProject test}/src/main/webapp/WEB-INF/lib/`, `sources/server/JDBCTest/lib/` | Maven Central `com.oracle.database.jdbc:ojdbc6:11.2.0.4`, 또는 Oracle Database XE 설치 폴더의 `jdbc/lib/` |
| COS `cos.jar` (com.oreilly.servlet, 2008-12-26 빌드) | `sources/server-jsp/WEB-INF/lib/`, `sources/server/{JSPTest,ToyProject,ToyProject test}/src/main/webapp/WEB-INF/lib/` | http://www.servlets.com/cos/ (비상업 용도 조건이 있는 라이선스) |

- `sources/server/JDBCTest/lib/`와 `sources/server-jsp/WEB-INF/lib/`는 jar 하나만 있던 폴더라 함께 사라졌습니다.
- `sources/server/AuthTest`와 `sources/server-jdbc`도 Oracle JDBC를 사용하지만, 원본에도 jar가 없었습니다.
- 실습 DB는 `localhost:1521:xe`의 Oracle Database Express Edition입니다.

## 원칙

- 원본 커밋은 재작성하지 않습니다. 위 정화가 유일한 예외입니다.
- 원본 파일은 수정하지 않습니다. 보관소에서 새로 쓰는 것은 README, CATALOG, THIRD_PARTY_NOTICES, metadata뿐입니다.
- 실습 코드의 DB 계정은 모두 `localhost` 실습용입니다.
- 실습 데이터의 주민등록번호 형식 값은 검증번호가 맞지 않는, 생성된 더미 데이터입니다.
- 원본 저장소의 Issues, PR, Release는 Git 데이터가 아니므로 편입되지 않습니다.
- 새 학습 저장소도 같은 방식(`sources/<이름>/`, `source/<이름>` 태그)으로 편입합니다.
