# houseInfo

<img src = "https://user-images.githubusercontent.com/26289683/93533602-465e4480-f97e-11ea-98e6-88c9692852e5.png" width = "50%" height="50%">

<img src = "https://user-images.githubusercontent.com/26289683/93533607-48280800-f97e-11ea-9f07-76a62132f29d.png" width = "50%" height="50%">

<img src = "https://user-images.githubusercontent.com/26289683/93533609-49593500-f97e-11ea-883d-e6d70389364b.png" width = "50%" height="50%">

## 기획배경

집을 사기 위해 웹에 접속했으나 화면ㄴ이 너무 난잡해 어디부터 봐야할지 모르겠다.

원하는 정보는 주변에 대중교통과 대형마트가 있는지 뿐인데 이것만 지도로 시각화한 곳을 찾고 싶다.

주거지를 구하면서 나라 또는 시에서 지원해주는 정책이나 프로그램이 뭐가 있는지 궁금하다.

## 서비스 목적

난잡하지 않게 본인이 원하는 지역 내 주택 및 아파트의 실거래가를 제공하고

그 주변 상가와 환경정보도 함께 알아볼 수 있게 함

## 개발환경

-개발언어 : Java, Vue.js

-IDE : Spring Tool Suite, Visual Studio Code

-DB : mySQL

-공공 데이터 : 국토고통부 아파트/ 연립다세대 실거래가 자료 , 법정동코드, 환경 지도점검 데이터, 상권정보
              

## 핵심기능

지역별 주택 및 아파트의 매매,전월세 등 실거래가 정보 제공

주변 상가,환경에 대한 정보 제공

주택 관련 지원 및 정책정보 제공

## 프로젝트 사용법

**Import**

`git clone https://github.com/yu01203/project_1.git`



**Vue.js**

```
cd project_1/HappyHouse_Vue
npm install
npm run serve
```



**Spring_boot**

*1. STS*(Spring Tool Suite)에서 git폴더 내 HappyHouseFinal 폴더 import

*2.* 프로젝트 "root 폴더 우클릭 -> Run As -> Spring Boot App"



**mysql**

*1. DB 생성 후 git 폴더 내 sql 폴더에 있는 sql문을 통해 테이블 생성

*2.* HappyHouseFinal\src\main\resources\application.properties 에서 4~7번째 줄 mysql db정보 수정"



**사이트 접속**

vue.js 를 실행시키며 생긴 localhost 주소로 접속





