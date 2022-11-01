# Mission01 [내 위치 기반 공공 WIFI 정보를 제공하는 Web Service 개발하기
## 프로젝트 수행 목적
자바,JSP(Servlet),데이터베이스 등 다양한 언어와 스킬을 활용한 웹서비스 완성하기]

## 프로젝트 기간
2022.10.22 ~ 2022.10.31

## 개발 환경
- Language : Java,HTML,CSS,JavaScript
- DBMS : MariaDB
- Server : Apache Tomcat 8.5.83(WAS)
- IDE: Intellij IDEA 2022.2.2 (Ultimate Edition), Eclipse


## ERD

- wifi_info01


![](../../Library/Mobile Documents/com~apple~CloudDocs/ScreenShot/스크린샷 2022-11-01 오전 9.29.30.png)



- wifi_info02

![](../../Library/Mobile Documents/com~apple~CloudDocs/ScreenShot/스크린샷 2022-11-01 오전 9.29.47.png)



## 구현 영상

- 내 위치 가져오기(정해진 경도 위도 값 반환) // 시간 다소 소요(약 3초)

![화면 기록 2022-11-01 오전 4 55 21 (1)](https://user-images.githubusercontent.com/96874318/199132354-b6f0e711-ee02-46c8-a10d-70d3f19b0ac9.gif)









- Open API 데이터 기져오기(DBMS에 저장)

![화면 기록 2022-11-01 오전 4 56 45](https://user-images.githubusercontent.com/96874318/199132581-a7e44404-aca9-4301-a256-a11867255f37.gif)






- 위치 히스토리 목록 보기 및 삭제 기능 구현

![화면 기록 2022-11-01 오전 5 02 18](https://user-images.githubusercontent.com/96874318/199132626-44207e9d-d001-4d44-bf84-d038b2f56de2.gif)





## 프로젝트를 진행하면서 느낀점


진행 중간중간 막히는 부분이 굉장히 많았다. HTML 부터 시작해서 CSS,JS,Servlet 까지 어느 하나 자신 있는게 없었다.
특히 웹 브라우저와 웹 서버와의 관계에 대한 개념이 명확하지 않은 상태로 프로젝트에 돌입했기에... 중간중간 검색하면서 프로젝트를 완성시켰다.
하지만 매번 프로젝트나 과제를 하면서 느낀점은 책으로 공부하는 것보다 직접 부딪히며 해결해가는 부분에서 얻어가는 부분이 굉장히 많은 것 같다.
웹 페이지 구현이 처음이여서 그런지 내가 생각지도 못한 부분에서 오류가 즐비 했으며, 여러가지 tool과 언어를 혼합해서 써야 했기에, 머리가 조금은 아팠다.🥲
아직은 추가해야할 기능들이 눈에 보이고, 조금은 아쉽지만 조금 더 공부하고 이 프로젝트를 다시 수정할 예정이다.
프로젝트를 통해 가장 좋았던 점은 웹이라는 것에 대한 두려움을 해소할 수 있었다는 점이다. 즉 나도 백엔드 개발자가 될 수 있겠다 라는 자신감이 생겼다.🚀

