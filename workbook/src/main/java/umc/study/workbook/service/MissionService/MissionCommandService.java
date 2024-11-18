package umc.study.workbook.service.MissionService;

import umc.study.workbook.domain.Mission;
import umc.study.workbook.domain.dto.MissionRequestDto;
import umc.study.workbook.domain.mapping.MemberMission;

public interface MissionCommandService {

    Mission addMission(MissionRequestDto.MissionDto request);

    MemberMission challengeMission(MissionRequestDto.MissionMemberDto request);
}
