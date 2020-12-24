package tu.project.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tu.project.jobfinder.entities.Users;

public interface UserRepository extends JpaRepository<Users, Long> {

}
