# study-archive

프로그래밍 학습 과정에서 작성한 개별 저장소를 한곳에 모아 보존하는 아카이브입니다.
각 저장소의 소스 코드와 Git 커밋 이력을 작성 당시의 형태로 유지하는 것을 원칙으로 합니다.

## 구성

```
study-archive/
├── README.md                # 아카이브 소개
├── CATALOG.md               # 학습 프로젝트 목록
├── THIRD_PARTY_NOTICES.md   # 포함된 서드파티 구성 요소의 라이선스 고지
├── metadata/                # 원본 저장소와 이력 추적 정보
└── sources/
    └── <저장소 이름>/        # 원본 저장소의 내용
```

`sources/` 아래의 디렉터리 이름은 원본 GitHub 저장소의 이름과 같습니다.

## 탐색

- [CATALOG.md](CATALOG.md): 학습 분야별 프로젝트 목록과 설명
- [metadata/repositories.json](metadata/repositories.json): 원본 저장소 주소, 편입 시점의 커밋, 이력 보존 현황

## Git 이력 확인

각 저장소는 subtree merge 방식으로 편입되어 원본 커밋이 이 저장소의 이력에 연결되어 있습니다.
편입한 원본의 마지막 커밋에는 `source/<저장소 이름>` 태그가 붙어 있습니다.

원본 커밋에서는 파일이 저장소 최상위에 있었기 때문에, 원본 이력은 태그와 원래 경로를 기준으로 조회합니다.
`sources/<저장소 이름>/` 경로로 조회하면 아카이브에 편입된 이후의 변경만 표시됩니다.

```bash
# 원본 저장소의 커밋 목록
git log --oneline source/<저장소 이름>

# 원본 기준 경로로 파일 이력과 변경 내역 확인
git log --oneline source/<저장소 이름> -- <원본 경로>
git blame source/<저장소 이름> -- <원본 경로>

# 아카이브 자체의 변경 내역
git log --first-parent --oneline
```

## 참고 사항

- 공개에 앞서 일부 저장소의 이력에서 인증 정보와 개인 정보에 해당하는 값을 치환하고, 재배포하지 않는 서드파티 바이너리를 제외했습니다.
  이로 인해 해당 저장소의 일부 커밋은 원본 저장소와 SHA가 다르며, 대상 저장소와 영향 범위는 [metadata/repositories.json](metadata/repositories.json)에 기록되어 있습니다.
- 학습 당시의 코드이므로 현재의 라이브러리나 개발 환경에서는 그대로 실행되지 않을 수 있습니다.
- 이 저장소에는 별도의 라이선스를 부여하지 않았습니다. 포함된 서드파티 구성 요소의 라이선스는 [THIRD_PARTY_NOTICES.md](THIRD_PARTY_NOTICES.md)를 참고하세요.

## 외부 의존성

재배포하지 않아 아카이브에 포함되지 않은 라이브러리입니다.
이를 사용하는 소스 코드와 프로젝트 설정은 원본 그대로이므로, 예제를 실행하려면 라이브러리를 직접 받아 각 프로젝트의 라이브러리 폴더(`WEB-INF/lib` 또는 `lib`)에 넣습니다.

| 라이브러리 | 사용 프로젝트 | 구하는 곳 |
|---|---|---|
| Oracle JDBC 드라이버 (`ojdbc6.jar`) | Oracle Database에 접속하는 `server`, `server-jdbc`의 실습 | Maven Central `com.oracle.database.jdbc:ojdbc6`, 또는 Oracle Database 설치 경로의 `jdbc/lib` |
| COS (`cos.jar`, com.oreilly.servlet) | `server-jsp`, `server`의 파일 업로드 예제 | http://www.servlets.com/cos/ (라이선스의 사용 조건 확인 필요) |
