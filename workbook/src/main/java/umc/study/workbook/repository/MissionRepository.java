package umc.study.workbook.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.workbook.domain.Mission;

import java.util.Optional;

public interface MissionRepository extends JpaRepository<Mission, Long> {


    Optional<Mission> findById(Long missionId);


    Page<Mission> findAllByStore(Long storeId, Pageable pageable);
}
