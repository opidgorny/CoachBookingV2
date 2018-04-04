package net.sportlife.repository;

import net.sportlife.model.UserCoach;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserCoachRepository extends JpaRepository<UserCoach, Long> {
}
