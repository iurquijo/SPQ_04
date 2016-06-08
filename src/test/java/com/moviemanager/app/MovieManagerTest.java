package es.deusto.server;


import org.junit.*;

import com.moviemanager.server.jdo.*;

import java.util.List;
import static org.junit.Assert.assertTrue;


public class MovieManagerTest {

    Mov agora;


    @Before
    public void setUp() {
       agora = new Mov();
    }

    @Test
    public void testInitializeMovie() {
        boolean test = false;
        String nameM = "Agora";
        String rate = "rate";
        String numRates = "1";
        String description = "this is a film";
        Drector director = new Drector();
        List<Comment> commentsM = null;
        List<Actor> actorsM = null;

        agora = new Mov(nameM, rate, numRates, description, director, commentsM, actorsM);

        if((agora.getNameM() == "Agora") && (agora.getRate() == "rate")){
            //for example few values
            test = true;
        }

        assertTrue(test);
    }


}