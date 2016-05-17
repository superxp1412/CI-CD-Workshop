package hello;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Matchers;
import org.mockito.Mock;
import org.springframework.ui.Model;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.MockitoAnnotations.initMocks;

/**
 * Created by peixu on 5/17/16.
 */
public class GreetingControllerTest {

    @Mock
    private Model mockedModel;

    @Before
    public void setUp() throws Exception {
        initMocks(this);
    }

    @Test
    public void testGreeting() throws Exception {
        //given
        GreetingController greetingController = new GreetingController();
        //when
        String result = greetingController.greeting("testVal", mockedModel);
        //then
        assertThat(result, is("greeting"));

        verify(mockedModel).addAttribute(Matchers.eq("name"),Matchers.eq("testVal"));
        verify(mockedModel,times(1)).addAttribute(Matchers.eq("name"),Matchers.eq("testVal"));
    }
}