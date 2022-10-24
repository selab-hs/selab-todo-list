package kr.co.selab.selabtodo.exception;

public class NotExistTodoException extends RuntimeException{
    public NotExistTodoException(){
        super("해당 Todo는 존재하지 않습니다");
    }
}
