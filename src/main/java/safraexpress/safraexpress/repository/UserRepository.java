package safraexpress.safraexpress.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import safraexpress.safraexpress.entity.User;
import java.util.UUID;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    Boolean existsByName(String name);
}