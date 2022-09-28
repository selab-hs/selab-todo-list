# SELAB TODO-LIST STUDY
> Made By 김동건, 궁금하신 내용이 있다면 연락주세요!!

### 필수 구현 요구사항
- JAVA 17 기준으로 진행해주세요 (18버전에서 에러를 발견했습니다.)
- TODOLIST CRUD API를 구현하세요(생성, 수정, 삭제, 단건조회, 전체조회)
- RESTFUL한 API를 구현하도록 노력해보세요
- 클린코드란 무엇일까요? 고민해보면서 좋을 것 같아요
- 객체지향 패러다임을 고민하며 구현을 진행해요
- 기본적인 요구사항을 충족하면서, 본인이 생각하는 todo-list 요구사항을 추가적으로 구현해보세요!!
- README를 작성해주세요 (요구사항, 스펙, 동작방법, api 설명 등...)

### REVIEW 진행해주시면 감사하겠습니다!
- SELAB 구성원 모두가 편하게 리뷰를 진행해주시면 될 것 같아요!
- 스터디를 참여하는 인원에게 도움이 될 수 있는 리뷰를 부탁드려요!
- [Review 진행방법](https://github.com/selab-hs/selab-git)

---

### TodoEntity Class
고유 ID(Id), 할 일(title), 순서(order), 처리 여부(checked)

### TodoRepository Class
JpaRepository를 상속 받아 TodoRepository를 생성한다.

### TodoService Class
repository를 주입 받아 생성, 수정, 삭제, 조회를 실행한다.

### TodoController Class
URL Mapping을 통해 알맞은 화면을 보여준다.