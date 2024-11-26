package umc.study.workbook.service.MissionService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.workbook.domain.Mission;
import umc.study.workbook.domain.dto.MissionRequestDto;
import umc.study.workbook.domain.dto.MissionResponseDto;
import umc.study.workbook.domain.mapping.MemberMission;

public interface MissionCommandService {

    Mission addMission(MissionRequestDto.MissionDto request);

    MemberMission challengeMission(MissionRequestDto.MissionMemberDto request);

    Page<MissionResponseDto.StoreMissionListDTO> storeMissions(Long storeId, int pageNo);

    Page<MissionResponseDto.MyMissionListDTO> myMissions(Long userId, int pageNo);
}
