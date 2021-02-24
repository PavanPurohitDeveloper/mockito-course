package com.in28minutes.business;

import com.in28minutes.data.api.TodoService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.*;
import org.mockito.runners.MockitoJUnitRunner;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;
import static org.mockito.BDDMockito.*;
import org.mockito.ArgumentCaptor;

@RunWith(MockitoJUnitRunner.class)
public class TodoBusinessImplMockitoInjectMocksTest {

    @Mock
    TodoService todoServiceMock; //automatically creates a mock of this kind and it will be available for me.

    @InjectMocks
    TodoBusinessImpl todoBusinessImpl;

    @Captor
    ArgumentCaptor<String> stringArgumentCaptor;

    @Test
    public void testRetrieveTodosRelatedToSpring_usingAMock(){
        //created a Mock for TodoService using mock method.
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
        //mock returns when specific method is called with specific value then return.. This is dynamic stubbing
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        System.out.println("Size: "+ filteredTodos.size());
        assertEquals(2, filteredTodos.size());
    }

    @Test
    public void testRetrieveTodosRelatedToSpring_usingBDD(){

        //Given ( is like setup )
        List<String> todos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn To Dance");
        given(todoServiceMock.retrieveTodos("Dummy")).willReturn(todos);

        //When -- In When I would call actual method ..action
        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");

        //Then -- I would check
        System.out.println("Size: "+ filteredTodos.size());
        assertThat(filteredTodos.size(), is(2));
    }

    //Mocking List interface class:
    @Test
    public void testRetrieveTodosRelatedToSpring_WithEmptyList(){
        List<String> todos = Arrays.asList();
        when(todoServiceMock.retrieveTodos("Dummy")).thenReturn(todos);

        List<String> filteredTodos = todoBusinessImpl.retrieveTodosRelatedToSpring("Dummy");
        System.out.println("Size: "+ filteredTodos.size());
        assertEquals(0, filteredTodos.size());
    }

    @Test
    public void letsTestDeleteNow() {

        List<String> allTodos = Arrays.asList("Learn Spring MVC",
                "Learn Spring", "Learn to Dance");

        when(todoServiceMock.retrieveTodos("Ranga")).thenReturn(allTodos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");

        verify(todoServiceMock).deleteTodo("Learn to Dance");

        verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring MVC");

        verify(todoServiceMock, Mockito.never()).deleteTodo("Learn Spring");

        verify(todoServiceMock, Mockito.times(1)).deleteTodo("Learn to Dance");
        // atLeastOnce, atLeast

    }

    @Test
    public void captureArgument() {
        List<String> allTodos = Arrays.asList("Learn Spring MVC", "Learn Spring", "Learn to Dance");
        Mockito.when(todoServiceMock.retrieveTodos("Ranga")).thenReturn(allTodos);

        todoBusinessImpl.deleteTodosNotRelatedToSpring("Ranga");
        Mockito.verify(todoServiceMock).deleteTodo(stringArgumentCaptor.capture());

        assertEquals("Learn to Dance", stringArgumentCaptor.getValue());
        System.out.println(stringArgumentCaptor.getValue());
    }
}
