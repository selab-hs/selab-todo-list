package kr.co.selab.selabtodo.presentation;


import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import java.util.List;
import java.util.Optional;
import kr.co.selab.selabtodo.application.ToDoListService;
import kr.co.selab.selabtodo.common.converter.ResponseConverter;
import kr.co.selab.selabtodo.common.dto.ResponseDto;
import kr.co.selab.selabtodo.common.dto.ResponseMessage;
import kr.co.selab.selabtodo.domain.ToDoList;
import kr.co.selab.selabtodo.dto.request.CreateToDoRequest;
import kr.co.selab.selabtodo.dto.request.UpdateToDoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@ApiResponses({
    @ApiResponse(code = 200, message = "Success"),
    @ApiResponse(code = 400, message = "Bad Request"),
    @ApiResponse(code = 500, message = "Internal Server Error")
})
@Api("todo")
@RestController
@RequestMapping("/api/v1/todos")
@RequiredArgsConstructor
public class ToDoListController {

  private final ToDoListService toDoListService;
  private final ResponseConverter responseConverter;

  @ApiOperation("ToDo 전체 검색")
  @GetMapping(value = "/searchAll", produces = MediaType.APPLICATION_PROBLEM_JSON_VALUE)
  public ResponseEntity<ResponseDto> getAllTodos() {
    List<ToDoList> toDoLists = toDoListService.getTodos(Sort.by(Direction.ASC, "id"));
    return responseConverter.toResponseEntity(
        ResponseMessage.READ_ALL_TODO_SUCCESS,
        toDoLists
    );
  }

  @ApiOperation("ToDo paging")
  @GetMapping
  public ResponseEntity<ResponseDto> getPaging(
      @PageableDefault(sort = "id", direction = Direction.DESC)
          Pageable pageable) {
    Page<ToDoList> pageables = toDoListService.pageable(pageable);
    return responseConverter.toResponseEntity(
        ResponseMessage.READ_ALL_TODO_SUCCESS,
        pageables
    );
  }

  @ApiOperation("ToDo 검색")
  @GetMapping("/{id}")
  public ResponseEntity<ResponseDto> getTodo(@PathVariable("id") Long id) {
    Optional<ToDoList> toDo = toDoListService.findTodoById(id);
    return responseConverter.toResponseEntity(
        ResponseMessage.READ_TODO_SUCCESS,
        toDo
    );
  }

  @ApiOperation("ToDo 생성")
  @PostMapping
  public ResponseEntity<ResponseDto> postToDo(@RequestBody CreateToDoRequest createToDoRequest) {
    toDoListService.createToDo(createToDoRequest);
    return responseConverter.toResponseEntity(ResponseMessage.CREATE_TODO_SUCCESS, "ok");
  }

  @ApiOperation("ToDo 수정")
  @PatchMapping("/{id}")
  public ResponseEntity<ResponseDto> patchToDo(@PathVariable("id") Long id,
      @RequestBody UpdateToDoRequest updateToDoRequest) {
    toDoListService.updateToDo(id, updateToDoRequest);
    return responseConverter.toResponseEntity(ResponseMessage.UPDATE_TODO_SUCCESS, "ok");
  }

  @ApiOperation("ToDo 삭제")
  @DeleteMapping("/{id}")
  public ResponseEntity<ResponseDto> deleteToDo(@PathVariable("id") Long id) {
    toDoListService.deleteTodo(id);
    return responseConverter.toResponseEntity(ResponseMessage.DELETE_TODO_SUCCESS, "ok");
  }
}