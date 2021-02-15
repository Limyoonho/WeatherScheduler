
<div align=center>
  
![header](https://capsule-render.vercel.app/api?type=soft&color=feee7d&fontColor=a5dff9&height=130&section=header&text=%20Weather　Scheduler%20&animation=scaleIn&fontSize=40&fontAlign=50&fontAlignY=50)

</div>
<br>

## 🌈 날씨 시간표 🕰
#### 전국의 날씨를 시간별로 쉽게 알 수 있는 프로그램 📟
> 2학년 2학기 기초프로젝트 기말 과제📔

<br>

#### 📚 개요
> 날씨 시간표(Weather Schedule)는 간단한 조작만으로 전국의 날씨를 시간별로 쉽게 알 수 있는 프리웨어 프로그램임

``` 
+ 프로그램은 서버와 클라이언트로 구성되어 있으며 클라이언트의 대부분의 요청 동작은 서버를 통해서 이루어짐
+ 전국의 지역에 대한 분류가 많기 때문에 상당한 양의 지역좌표 데이터를 저장해야하므로 DBMS를 사용하여 주소에 따른 좌표 조회, 관리가 용이하게 함
+ 클라이언트는 서버를 통해서만 기능 사용이 가능하기 때문에 DBMS에 직접적으로 접근하지 못하며 공공API 사용 시 필요한 Key 값 또한 클라이언트에서 확인할 방법이 없어 보안성이 향상됨
+ 서버에서 클라이언트로 보내야할 날씨 정보량이 매우 많고 형식 또한 복잡하여 자바에서 제공하는 RMI(Remote Method Invocation)을 통신수단으로 사용 
```

#### 🛠 동작 방식

<div align=center>
  
![동작방식](https://user-images.githubusercontent.com/28488288/107987281-0d033100-7011-11eb-937d-6b092fa50528.png)

` 날씨 시간표는 크게 클라이언트, 서버, DB, 동네예보조회서비스 API로 구성됨  `

</div>

#### 🔗 접근 방식

<div align=center>
  
![접근방식](https://user-images.githubusercontent.com/28488288/107988305-0d9cc700-7013-11eb-855b-4be4221d1a88.png)

` 보안성 향상  `

</div>

<br>

## 🛰 서버
---

#### 🖇 클래스 다이어그램 (Class Diagrams)

<div align=center>
  
![클래스다이어그램](https://user-images.githubusercontent.com/28488288/107987284-0e345e00-7011-11eb-8c23-884e67d8727e.png)

</div>

#### ⚙ 클래스 구성
<div align=center>
  
![클래스구성](https://user-images.githubusercontent.com/28488288/107987283-0d9bc780-7011-11eb-91e4-b6822dc1822c.png)

</div>

#### :factory: 구성도
<div align=center>
  
![구성도](https://user-images.githubusercontent.com/28488288/107987280-0d033100-7011-11eb-9c51-cdb6d15d97e3.png)

</div>

#### 💽 각 클래스 역할 (Data Flow Diagrams)
<div align=center>
  
![MyDatabaseClass 역할](https://user-images.githubusercontent.com/28488288/107987274-0b396d80-7011-11eb-9c16-a8b4a9e422ce.png)
` MyDatabase `
![RMI클래스역할](https://user-images.githubusercontent.com/28488288/107987277-0c6a9a80-7011-11eb-9d0f-037461c7e5c5.png)
` RMI `
![WeatherClass 역할](https://user-images.githubusercontent.com/28488288/107987278-0c6a9a80-7011-11eb-99aa-8293296ca353.png)
` Weather `

</div>

<br>

## 🛰 클라이언트
---

#### :recycle: 동작 방식

<div align=center>
  
![클라이언트 세부동작순서](https://user-images.githubusercontent.com/28488288/107987282-0d9bc780-7011-11eb-9ae9-420d2e1a0ad9.png)

</div>

#### :school_satchel: 사용 API
```
* json-simple - JSON 데이터 
* 동네예보조회서비스 - 기상 정보 
```

### :exclamation: 자세한 내용은 계획서를 확인해주세요. :exclamation:
#### :ledger: [날씨 시간표 계획서](https://github.com/OtterBK/WeatherScheduler/tree/master/%EB%B3%B4%EA%B3%A0%EC%84%9C)

<br>

#### 📹 실행 예시
[![유튜브](http://img.youtube.com/vi/FGQQyYeYFJo/0.jpg)](https://youtu.be/FGQQyYeYFJo?t=0s) 



