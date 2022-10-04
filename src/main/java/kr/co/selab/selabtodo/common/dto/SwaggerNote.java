package kr.co.selab.selabtodo.common.dto;

public class SwaggerNote {
    public final static String TODO_READ_ALL_NOTE = """
                모든 Todo list 조회
                GET /api/v1/todos/
            
                ResponseBody
                {
                    "todos": [
                        {
                            "createdAt": "2022-09-23T20:10:30",
                            "modifiedAt": "2022-09-23T20:57:42",
                            "id": 1,
                            "title": "todo1",
                            "order": 1,
                            "completed": false
                        },
                        {
                            "createdAt": "2022-10-04T15:45:10",
                            "modifiedAt": "2022-10-04T15:45:10",
                            "id": 2,
                            "title": "오프라인 발표 준비",
                            "order": 3,
                            "completed": false
                        }
                    ]
                }
            """;

    public final static String TODO_READ_ONE_NOTE = """
                Todo list 단건 조회
                GET /api/v1/todos/{id}
            
                ResponseBody
                {
                    "createdAt": "2022-09-23T20:10:30",
                    "modifiedAt": "2022-09-23T20:57:42",
                    "id": 1,
                    "title": "todo1",
                    "order": 1,
                    "completed": false
                }
            """;

    public final static String TODO_CREATE_NOTE = """
                    Todo 생성하기
                    POST /api/v1/todos/           
                        
                    Request Body
                    {
                        "title" : "할일 제목",
                        "order" : 3     // 할 일 순서
                    }
                        
                    Response Body
                    {
                           "createdAt": "2022-10-04T15:45:10.4434779",
                           "modifiedAt": "2022-10-04T15:45:10.4434779",
                           "id": 2,
                           "title": "할일 제목",
                           "order": 3,
                           "completed": false
                    }          
            """;

    public final static String TODO_DELTE_ALL_NOTE = """
                    Todo 삭제하기
                    DELETE /api/v1/todos/           
                                            
                    Response Body
                    {
                    }          
            """;

    public final static String TODO_DELTE_NOTE = """
                    Todo 단건 삭제하기
                    DELETE /api/v1/todos/{id}        
                                            
                    Response Body
                    {
                    }          
            """;

    public final static String TODO_UPDATE_NOTE = """
                    Todo 단건 수정하기
                    PATCH /api/v1/todos/{id}        
                    
                    Request Body
                    {
                        "title" : "todo2",
                        "order" : 2
                    }
                    
                    Response Body
                    {
                        "createdAt": "2022-10-04T16:12:58",
                        "modifiedAt": "2022-10-04T16:15:25.3755603",
                        "id": 3,
                        "title": "todo2",
                        "order": 2,
                        "completed": false
                    }          
            """;
}
