package com.in28minutes.data.api;

import java.util.Arrays;
import java.util.List;

/**
 * Stub is nothing but a sample implementation of TodoService.
 * Create an class which implements this particular interface.
 * A Stub is only used for Unit testing.
 * Stub is nothing but a class which returns some kind of dummy data. dummy implementation class
 */
public class TodoServiceStub implements TodoService{

    @Override
    public List<String> retrieveTodos(String user) {
        return Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
    }

    @Override
    public void deleteTodo(String todo) {

    }
}
