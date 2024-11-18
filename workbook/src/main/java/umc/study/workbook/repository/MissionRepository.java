package umc.study.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.workbook.domain.Mission;

import java.util.Optional;

public interface MissionRepository extends JpaRepository<Mission, Long> {


    Optional<Mission> findById(Long missionId);
}
