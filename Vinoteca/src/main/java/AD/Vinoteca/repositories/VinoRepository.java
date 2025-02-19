package AD.Vinoteca.repositories;

import AD.Vinoteca.models.Vino;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VinoRepository extends JpaRepository<Vino, Integer> {
}
