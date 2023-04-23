# 서울시 WIFI 조회 및 관리 프로젝트

서울시 공공와이파이 서비스 위치 정보 open API를 사용하여, 사용자가 원하는 위치의 와이파이 정보를 조회하고 즐겨찾기로 관리할 수 있는 웹 애플리케이션입니다.

### 주요 기능
- 와이파이 정보 조회
- 위치 히스토리 조회
- 와이파이 상세 정보 보기
- 즐겨찾기 추가/수정/삭제
- 즐겨찾기 목록 조회


### 사용 기술
- Java Servlet
- JSP
- JavaScript
- SQLite

### 설정 및 실행 방법
1. 프로젝트를 원하는 디렉토리에 복사합니다.
2. 프로젝트 디렉토리에서 웹 서버를 실행합니다.
3. 웹 브라우저에서 http://localhost:8080/에 접속하여 프로젝트를 확인합니다.

### 구동 예시
1. 와이파이 정보 가져오기 및 조회
![image](https://user-images.githubusercontent.com/121083077/233823472-e78a9c04-8510-4c56-b9db-883df6bc44fa.png)
처음 시작 시 open API 와이파이 정보 가져오기를 통해 WifiInfo 테이블에 서울시 와이파이 정보 저장. 이후 내 위치 가져오기 또는 직접 위도, 경도 값을 입력한 후 근처 와이파이 정보 조회 가능.

2. 위치 히스토리 목록 기능 화면
![image](https://user-images.githubusercontent.com/121083077/233823537-45a28fb0-cf69-416a-a550-58a198f56684.png)
근처 WIFI 정보 보기 버튼 클릭 시 사용한 위도, 경도 값 및 조회 일자 확인 가능

3. 와이파이 상세 정보 보기 기능 화면
![image](https://user-images.githubusercontent.com/121083077/233823654-85f6ee6a-d6d3-4ac8-8266-4b62234c870a.png)
와이파이명 클릭 시 보다 가독성이 좋게 와이파이 정보를 볼 수 있으며, 북마크 그룹을 선택 한 후 추가하기 버튼 클릭 시 해당 북마크에 와이파이 추가 가능

4. 북마크 그룹 목록/추가/수정/삭제 화면
![image](https://user-images.githubusercontent.com/121083077/233823705-7d3bfea1-6518-4e46-9869-9ba84e97e3d9.png)
북마크 그룹 관리를 누를 시 추가했던 북마크 리스트를 확인할 수 있으며, 이를 수정 및 삭제 가능<br><br>
북마크 그룹 이름 추가 
![image](https://user-images.githubusercontent.com/121083077/233823747-0d897c57-d5a9-4a52-bc62-57f5c0f1e8fc.png)
사용하고자 하는 북마큼 이름과 순서를 입력한후, 추가 버튼을 통해 북마크 정보 저장 가능<br>
수정 및 삭제도 동일한 형식으로 사용 가능!

5. 북마크에 등록한 와이파이 조회 가능
![image](https://user-images.githubusercontent.com/121083077/233823801-eee0a0e8-d271-415b-8be6-89fa512ea92d.png)

