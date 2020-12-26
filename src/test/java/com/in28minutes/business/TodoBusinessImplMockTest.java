package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import com.in28minutes.data.api.TodoServiceStub;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

//Creating a unit test using Stub
//Use the stub to do the testing
public class TodoBusinessImplMockTest {
    //What is mocking?
    //mocking is creating objects that simulate the behavior of real objects.
    //Unlike stubs, mocks can be dynamically created from code - at runtime.
    //Mocks offer more functionality than stubbing.
    //You can verify method calls and a lot of other things.

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock(){
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        System.out.println("Size: "+ filteredTodos.size());
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_WithEmptyList(){
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList();
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        System.out.println("Size: "+ filteredTodos.size());
        assertEquals(0, filteredTodos.size());
    }
}
