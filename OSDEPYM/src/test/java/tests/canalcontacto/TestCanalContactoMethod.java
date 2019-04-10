package tests.canalcontacto;

import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.AnnotationConfigWebContextLoader;
import org.springframework.test.context.web.WebAppConfiguration;

import com.osdepym.configuration.ConfiguracionSpring;

@RunWith( SpringJUnit4ClassRunner.class )
@WebAppConfiguration
@ContextConfiguration(classes = {ConfiguracionSpring.class},loader = AnnotationConfigWebContextLoader.class)
public class TestCanalContactoMethod {

}
