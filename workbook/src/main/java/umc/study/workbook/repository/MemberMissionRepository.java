package umc.study.workbook.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import umc.study.workbook.domain.mapping.MemberMission;

public interface MemberMissionRepository extends JpaRepository<MemberMission,Long> {
}
