package com.in28minutes.business;

import org.junit.Test;
import org.mockito.Spy;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class SpyTest {

    @Test
    public void test(){
        List arrayListMock = mock(ArrayList.class);
        assertEquals(0, arrayListMock.size());
        //mocks return default values when you dont stub.
        stub(arrayListMock.size()).toReturn(5);
        arrayListMock.add("Dummy");
        assertEquals(5, arrayListMock.size());
    }

    @Test
    public void testSpy(){
        List arrayListSpy = spy(ArrayList.class);
        assertEquals(0, arrayListSpy.size());
        //mocks return default values when you dont stub.
        arrayListSpy.add("Dummy");
        assertEquals(1, arrayListSpy.size());

        arrayListSpy.remove("Dummy");
        assertEquals(0, arrayListSpy.size());
    }

    @Test
    public void testSpy1(){
        List arrayListSpy = spy(ArrayList.class);
        stub(arrayListSpy.size()).toReturn(5);
        assertEquals(5, arrayListSpy.size());
    }

    @Test
    public void testSpy2(){
        List arrayListSpy = spy(ArrayList.class);
        arrayListSpy.add("Dummy");
        //checks add method is called
        verify(arrayListSpy).add("Dummy");
        //checks clear() method is never called
        verify(arrayListSpy, never()).clear();
    }

}
