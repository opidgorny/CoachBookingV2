package net.sportlife.repository;

import net.sportlife.model.UserCoach;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCoachRepository extends JpaRepository<UserCoach, Long> {
}
