package net.sportlife.repository;

import net.sportlife.model.UserDetailedInfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserDetailedInfoRepository extends JpaRepository<UserDetailedInfo, Long> {
}
