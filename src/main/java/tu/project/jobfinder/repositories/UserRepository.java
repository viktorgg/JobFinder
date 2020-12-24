package tu.project.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tu.project.jobfinder.entities.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
