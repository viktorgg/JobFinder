package tu.project.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import tu.project.jobfinder.entities.Ad;

public interface AdRepository extends JpaRepository<Ad,Long> {
}
