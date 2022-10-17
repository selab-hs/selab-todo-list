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

## domain package

- ### Item
  - 고유 ID(Id), 할 일(title), 순서(order), 완료 여부(completed)

## repository package

- ### ItemRepository Interface
  - JpaRepository를 상속 받아 ItemRepository를 생성한다.

- ### ItemSaveRequestDto Class
  - 새로운 Item(할 일)을 생성할 때 쓰는 DTO. (리퀘스트 요청 시 사용)

- ### ItemSaveResponseDto Class
  - 새로운 Item(할 일)을 생성할 때 쓰는 DTO. (응답 반환 시 사용)

- ### ItemUpdateRequestDto Class
  - Item(할 일)을 수정할 때 쓰는 DTO. (리퀘스트 요청 시 사용)

- ### ItemUpdateResponseDto Class
  - Item(할 일)을 수정할 때 쓰는 DTO. (응답 반환 시 사용)

## service package

- ### ItemService Class
  - 비즈니스 로직 부분 구현
    - save(): Item(할 일)을 생성하는 메서드. RequestDto를 받아 itemRepository에 저장하고 ResponseDto로 반환값을 보여준다.
    - update(): Id와 RequestDto를 받아 null이 아닌, 변경값이 있는 파라미터를 수정한다.
    - findById(): Id를 받아 itemRepository에서 해당 Id의 값을 검색한다.
    - findItems(): 전체 Item을 검색한다.
    - deleteById(): Id를 받아 itemRepository에서 해당 Id의 값을 삭제한다.
    - deleteAll(): 모든 Item을 삭제한다.

## web package
- ### HomeController Class
  - home(): 기본 화면(/items)으로 갈 경우 전체 Item 목록을 보여준다.

- ### ItemController Class
  - items(): 전체 Item 목록을 보여준다.
  - item(): item Id로 검색하면 해당 Id의 값을 보여준다.
  - addItem(): 새로운 값(할 일 목록)을 추가한다.
  - edit(): 해당 Id의 값(title, order, completed)을 수정한다.
  - deleteById(): 해당 Id의 값을 삭제한다.
  - deleteAll(): 모든 Item을 삭제한다.