# 하트 요정의 마법나라 (Android)

광고, 인앱 결제, 네트워크 권한이 없는 한국어 터치 모험 게임입니다. 오리지널 캐릭터를 Android Canvas로 직접 그립니다.

## 갤럭시에서 GitHub Actions로 APK 만들기
1. GitHub에서 새 **공개 또는 비공개 저장소**를 만듭니다.
2. 이 ZIP을 압축 해제하여 **내용물 전체**를 저장소 최상위에 업로드합니다. `.github/workflows/build-apk.yml` 경로를 그대로 유지하세요. (GitHub 웹 업로드에서 숨김 폴더가 누락되면 `.github/workflows/build-apk.yml`을 별도로 생성하세요.)
3. GitHub 저장소의 **Actions → Build Heart Fairy APK → Run workflow**를 실행합니다. 또는 main 브랜치에 업로드하면 자동으로 실행됩니다.
4. 성공한 실행 화면의 **Artifacts → HeartFairyMagic-APK**를 받아 압축을 풉니다.
5. `app-debug.apk`를 갤럭시에서 실행하여 설치합니다. 요청 시 '이 출처 허용'을 선택합니다.

## 게임 방법
홈에서 '모험 시작!'을 누릅니다. 화면을 터치하거나 좌우로 드래그하여 요정을 움직입니다. 내려오는 노란 별을 모으고 회색 먹구름을 피하세요. 별 목표를 채우면 다음 스테이지가 열립니다. 오른쪽 상단 Ⅱ 버튼은 홈으로 돌아갑니다. 진행한 스테이지는 기기에 저장됩니다.

## 개발 환경
Java 17, Gradle 8.9, Android Gradle Plugin 8.7.3, compileSdk 35, minSdk 24.

## 참고
APK는 GitHub Actions에서 빌드됩니다. 디버그 APK는 개인 테스트용이며 앱 스토어 배포용 서명 패키지가 아닙니다.
