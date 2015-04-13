
import com.epam.rd.transportcompany.entities.User;
import com.epam.rd.transportcompany.entities.UserRole;
import com.epam.rd.transportcompany.repositories.UserRepository;
import com.epam.rd.transportcompany.services.UserService;
import java.util.logging.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author amd
 */
public class Apptest {
    
    @Autowired
    @Qualifier("userService")
    private static UserService userService;
    
   // static final Logger logger = Logger.getLogger(Apptest.class);  

    @Override
    public String toString() {
        return "Apptest";
    }
    
    public static void main(String ...args){
       ConfigurableApplicationContext appContext 
                = new ClassPathXmlApplicationContext("/WEB-INF/SpringConfig.xml");

       UserService userService = appContext.getBean("userService", UserService.class);
        
        User user1 = new User("root", "123456", "0672380835", UserRole.ADMIN);
        System.out.println(user1);
        
        userService.saveUser(user1);
        
        System.out.println(user1);
    }
    
}
