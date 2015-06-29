package Config;

import com.mycompany.mobileinfrastructure.CheckInService;
import com.mycompany.mobileinfrastructure.SchoolService;
import com.mycompany.mobileinfrastructure.StudentService;
import com.mycompany.mobileinfrastructure.TestService;
import java.util.HashSet;
import java.util.Set;
import javax.ws.rs.ApplicationPath;
import javax.ws.rs.core.Application;

@ApplicationPath("resources")
public class RESTConfig extends Application {

    public Set<Class<?>> getClasses() {
        Set<Class<?>> s = new HashSet<Class<?>>();
        s.add(TestService.class);
        s.add(SchoolService.class);
        s.add(StudentService.class);
        s.add(CheckInService.class);

        return s;
    }
}
