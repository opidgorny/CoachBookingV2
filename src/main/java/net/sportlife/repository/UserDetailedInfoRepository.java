package net.sportlife.repository;

import net.sportlife.model.UserDetailedInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserDetailedInfoRepository extends JpaRepository<UserDetailedInfo, Long> {
}
