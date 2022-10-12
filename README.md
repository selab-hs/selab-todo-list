# SELAB TODO-LIST STUDY

---
### 환경
- 언어 : Java 17
- 프레임 워크 : Spring boot
- ORM : JPA
- DateBase : H2
- Swagger

### api 설명

| 기능        | 메서드    | 경로                   |
|----------------|----------------|---------------|
| 전체 검색     | get    | api/v1/todos         |
| 단일 검색     | get    | api/v1/todos/{id}    |
| TODO 생성   | post   | api/v1/todos         |
| TODO 수정   | patch  | api/v1/todos/{id}    |
| TODO 삭제   | delete | api/v1/todos/{id}    |

### 테이블

| Name           | Type          |
|----------------|---------------|
| id             | Long          | 
| content        | String        |
| isCompleted    | Boolean       |
| createDateTime | LocalDateTime |
| modifiedDate   | LocalDateTime |

---
