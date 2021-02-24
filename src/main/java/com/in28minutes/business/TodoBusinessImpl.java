package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;

import java.util.ArrayList;
import java.util.List;

//TodoBusinessImpl is SUT (SystemUnderTest)
//TodoService is Dependency
public class TodoBusinessImpl {

    private TodoService todoService;

    public TodoBusinessImpl(TodoService todoService) {
        this.todoService = todoService;
    }

    public List<String> retrieveTodosRelatedToSpring(String user){
        List<String> filteredTodos = new ArrayList<>();
        List<String> todos = todoService.retrieveTodos(user);
        todos.forEach(res ->System.out.println(res));
        System.out.println(todos.size());

        //filter the user.
        for(String todo: todos){
            if(todo.contains("Spring")){
                filteredTodos.add(todo);
            }
        }
        return filteredTodos;
    }

    public void deleteTodosNotRelatedToSpring(String user) {
        List<String> allTodos = todoService.retrieveTodos(user);
        for (String todo : allTodos) {
            if (!todo.contains("Spring")) {
                todoService.deleteTodo(todo);
            }
        }
    }
}
