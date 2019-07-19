// provided by Vivek Vishwanath

import com.sprint.demo.model.Role;
import com.sprint.demo.model.Todo;
import com.sprint.demo.model.User;
import com.sprint.demo.model.UserRole;
import com.sprint.demo.repos.RoleRepository;
import com.sprint.demo.repos.TodoRepository;
import com.sprint.demo.repos.UserRepository;

import java.util.ArrayList;

@Transactional
@Component
public class SeedData implements CommandLineRunner {
    RoleRepository rolerepos;
    UserRepository userrepos;
    TodoRepository todorepos;

    public SeedData(RoleRepository rolerepos, UserRepository userrepos, TodoRepository todorepos) {
        this.rolerepos = rolerepos;
        this.userrepos = userrepos;
        this.todorepos = todorepos;
    }

    @Override
    public void run(String[] args) throws Exception {
        Role r1 = new Role("admin");
        Role r2 = new Role("user");

        rolerepos.save(r1);
        rolerepos.save(r2);

        ArrayList<UserRole> users = new ArrayList<>();
        users.add(new UserRole(new User(), r2));
        User u1 = new User("barnbarn", "ILuvM4th!", users);
        u1.getTodo().add(new Todo("Finish java-orders-swagger", new Date(), u1));
        u1.getTodo().add(new Todo("Feed the turtles", new Date(), u1));
        u1.getTodo().add(new Todo("Complete the sprint challenge", new Date(), u1));
        userrepos.save(u1);

        ArrayList<UserRole> admins = new ArrayList<>();
        admins.add(new UserRole(new User(), r1));
        admins.add(new UserRole(new User(), r2));
        User u2 = new User("admin", "password", admins);
        u2.getTodos().add(new Todo("Walk the dogs", new Date(), u2));
        u2.getTodos().add(new Todo("provide feedback to my instructor", new Date(), u2));
        userrepos.save(u2);

        users = new ArrayList<>();
        users.add(new UserRole(new User(), r2));
        User u3 = new User("Bob", "password", users);
        userrepos.save(u3);

        users = new ArrayList<>();
        users.add(new UserRole(new User(), r2));
        User u4 = new User("Jane", "password", users);
        userrepos.save(u4);
    }
}
