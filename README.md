# CDS-APP-2-SERVER

| 도소현 | 박경린 |
|:----------|:----------|
| ![image](https://github.com/DO-SOPT-CDS-APP-2/CDS-APP-2-SERVER/assets/102944310/95c70aff-1d63-477b-9519-2fa94b163f6a)| ![image](https://github.com/DO-SOPT-CDS-APP-2/CDS-APP-2-SERVER/assets/102944310/8b345b3b-6d42-478f-9f7b-c452665b53a3)|
| 안녕하세요 놀고 싶은 서버파트 OB 도소현입니다.| 꼬북 서버파트 YB 박경린입니다. |
| [GET] 카테고리 뷰 상품 | [GET] 홈 뷰 추천 상품 |
| [GET] 상품 상세 정보 | [PUT] 좋아요 생성 / 취소 |

### **Architecture**

![image](https://github.com/DO-SOPT-CDS-APP-2/CDS-APP-2-SERVER/assets/102944310/61c4cfe5-6c3b-453d-a568-b9d34f62b7f7)

### **ER Diagram**

![image](https://github.com/DO-SOPT-CDS-APP-2/CDS-APP-2-SERVER/assets/102944310/5fdc935c-49e7-4f52-9c37-0dbeaf87ac69)

### **Directory**

├── CdsServerApplication.java
├── 🗂️ category
│   ├── 🗂️ controller
│   ├── 🗂️ domain
│   ├── 🗂️ repository
│   └── 🗂️ service
├── 🗂️ common
│   ├── 🗂️ config
│   ├── 🗂️ domain
│   ├── 🗂️ dto
│   └── 🗂️ exception
│       ├── 🗂️ enums
│       └── 🗂️ model
├── 🗂️ heart
│   └── 🗂️ domain
├── 🗂️ member
│   └── 🗂️ domain
└── 🗂️ product
    ├── 🗂️ controller
    │   └── 🗂️ dto
    ├── 🗂️ domain
    ├── 🗂️ repository
    └── 🗂️ service


### **Git Convention & Code Convection**

카멜 케이스로 작성

❗️ **작업하고 커밋하기 전에 잊지 말 것**

- 코드 포맷팅 ⇒ window : ctrl + alt + l , mac : command + option + l
- 미사용 Import문 삭제 ⇒ 공통 : ctrl + alt + o

### **Code Convention**
- 객체 생성할 땐 팩토리 메서드 패턴 사용
  😇
- main
- feat
- feature branch는 이슈넘버를 사용하여 브랜치 삭제 및 생성을 반복합니다.
**형식** : [feat/#issue number] 
**커밋 예시** : [feat/#3] home 뷰 구현

### **Git 커밋 컨벤션**

*# feat : 기능 추가*

*# fix : 버그 수정*

*# docs : 문서 수정*

*# test : 테스트 코드 추가*

*# refactor : 코드 리팩토링*

*# style : 코드 의미에 영향을 주지 않는 변경사항*

*# chore : 빌드 부분 혹은 패키지 매니저 수정사항*

*# cicd : CI/CD 관련 설정*

### **Issue Number**

- **이슈 단위 커밋**으로 기능 개발을 관리합니다.
- GitHub에서 Issue Number를 커밋 메시지에 넣어줍니다.




