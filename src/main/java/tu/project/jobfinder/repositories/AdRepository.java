package tu.project.jobfinder.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tu.project.jobfinder.entities.Ad;

import java.util.Optional;

public interface AdRepository extends JpaRepository<Ad,Long> {

    //@Query("SELECT a FROM ad a WHERE lower(a.title) = :title")
    Optional<Ad> findAdByTitle(String title);
}
