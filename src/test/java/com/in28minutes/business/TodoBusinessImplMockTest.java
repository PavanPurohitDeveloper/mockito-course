package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import org.junit.Test;
import java.util.Arrays;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.*;
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
        //created a Mock for TodoService using mock method.
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
        //mock returns when specific method is called with specific value then return.. This is dynamic stubbing
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        System.out.println("Size: "+ filteredTodos.size());
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD(){

        //Given ( is like setup )
        TodoService todoServiceMock = mock(TodoService.class);
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);
        TodoBusinessImpl todoBusinessImpl = new TodoBusinessImpl(todoServiceMock);
        //When -- In When I would call actual method ..action
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        //Then -- I would check
        System.out.println("Size: "+ filteredTodos.size());
        assertThat(filteredTodos.size(), is(2));
    }

    //Mocking List interface class:
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
