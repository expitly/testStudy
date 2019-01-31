import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import java.util.LinkedList;
import java.util.List;

import static org.mockito.Mockito.*;


public class MockitoTest {
    @Mock private LinkedList mockedList;

    @Test
    public void mockTest(){
        Assert.assertEquals(1, 1);
        List mockList = mock(List.class);

        mockList.add("one");
        mockList.clear();

        verify(mockList).add("one");
        verify(mockList).clear();

        System.out.println(mockList.size());
    }

    @Test
    public void stubTest(){

        LinkedList mockedList = mock(LinkedList.class);

        when(mockedList.get(0)).thenReturn("first");
        when(mockedList.get(12)).thenReturn("zzzz");

        System.out.println(mockedList.get(0));

        System.out.println(mockedList.get(12));

        System.out.println(anyString());
    }


    @Test
    public void callCountTest(){
        List mockedList = mock(List.class);

        mockedList.add("once");
        mockedList.add("twice");
        mockedList.add("twice");
        mockedList.add("three times");
        mockedList.add("three times");
        mockedList.add("three times");

        verify(mockedList).add("once");
        verify(mockedList, times(1)).add("once");

        verify(mockedList, times(2)).add("twice");

        verify(mockedList, never()).add("never!!");
    }

    @Test
    public void throwTest(){
        List mockedList = mock(List.class);

        doThrow(new RuntimeException()).when(mockedList).add(anyInt());

        mockedList.get(123);
    }

    @Test
    public void spyTest(){
        List list = new LinkedList();
        List spy = spy(list);

        when(spy.size()).thenReturn(100);

        spy.add("one");
        spy.add("two");

        System.out.println(spy.get(0));

        System.out.println(spy.size());

        verify(spy).add("one");

    }
}
