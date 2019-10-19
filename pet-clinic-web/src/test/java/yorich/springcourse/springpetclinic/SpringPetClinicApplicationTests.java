package yorich.springcourse.springpetclinic;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringPetClinicApplicationTests {

    @Test
    public void contextLoads() {
        assertEquals(1, 1);
    }

}
