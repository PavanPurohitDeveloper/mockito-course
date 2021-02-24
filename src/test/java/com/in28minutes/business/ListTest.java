package com.in28minutes.business;

import org.junit.Test;
import org.mockito.Mockito;
import java.util.List;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

import static org.mockito.BDDMockito.given;
import static org.mockito.Matchers.anyInt;
import static org.mockito.Mockito.when;

public class ListTest {

    @Test
    public void letsMockListSizeMethod(){
        List listMock = Mockito.mock(List.class);
        when(listMock.size()).thenReturn(2);
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
        assertEquals(2, listMock.size());
    }

    @Test
    public void letsMockListSize_ReturnMultipleValues(){
        List listMock = Mockito.mock(List.class);
        when(listMock.size()).thenReturn(2).thenReturn(3);
        assertEquals(2, listMock.size());
        assertEquals(3, listMock.size());
    }

    @Test
    public void letsMockListGet(){
        List listMock = Mockito.mock(List.class);
        when(listMock.get(0)).thenReturn("in28Minutes");
        assertEquals("in28Minutes", listMock.get(0));
        //assertEquals(null, listMock.get(0));
        assertEquals(null, listMock.get(1));
    }

    @Test
    public void letsMockListGet_usingBDD(){
        //Given
        List<String> listMock = Mockito.mock(List.class);
        given(listMock.get(0)).willReturn("in28Minutes");

        //When
        String firstElement = listMock.get(0);
        System.out.println("First Element: " + firstElement);;

        //Then
        assertThat(firstElement, is("in28Minutes"));
    }

    @Test
    public void letsMockListGetUsingArgumentMatcher(){
        List listMock = Mockito.mock(List.class);
        //Argument Matcher
        //when(listMock.get(0)).thenReturn("in28Minutes");
        when(listMock.get(anyInt())).thenReturn("in28Minutes");
        assertEquals("in28Minutes", listMock.get(0));
        assertEquals("in28Minutes", listMock.get(1));
    }

    @Test(expected = RuntimeException.class)
    public void letsMockList_throwAnException(){
        List listMock = Mockito.mock(List.class);
        //Argument Matcher
        when(listMock.get(anyInt())).thenThrow(new RuntimeException("Something"));
        //listMock.get(0);
        assertEquals(RuntimeException.class, listMock.get(0));
    }

    @Test(expected = RuntimeException.class)
    public void letsMockList_mixingUp(){
        List listMock = Mockito.mock(List.class);
        //Argument Matcher
        when(listMock.subList(anyInt(), 5)).thenThrow(new RuntimeException("Something"));
        listMock.get(0);
        //assertEquals(RuntimeException.class, listMock.get(0));
    }
}
