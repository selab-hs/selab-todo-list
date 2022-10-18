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

## 기능
### ToDo 생성
- Method : Post (api/todo)
- ResponseBody : TodoResponseDto
### Todo 전체 조회
- Method : Get (api/todo/all)
- ResponseBody : InquiryTodoResponseDto
### Todo 페이지 조회
- Method : Get (api/todo?page=0)
- ResponseBody : InquiryTodoPageResponseDto
### Todo 값 변경
- Method : Patch (api/todo/{id})
- ResponseBody : TodoResponseDto
### Todo 값 삭제
- Method : Delete (APi/todo/{id})
- ResponseBody : Long