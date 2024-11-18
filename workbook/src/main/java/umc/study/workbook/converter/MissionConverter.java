package umc.study.workbook.converter;

import umc.study.workbook.domain.Mission;
import umc.study.workbook.domain.dto.MissionResponseDto;
import umc.study.workbook.domain.mapping.MemberMission;

import java.time.LocalDateTime;

public class MissionConverter {

    public static MissionResponseDto.ChallengeMissionResultDTO  challegeMissionResultDto(MemberMission memberMission){
        return MissionResponseDto.ChallengeMissionResultDTO.builder()
                .missionId(memberMission.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static MissionResponseDto.AddNewMissionResultDTO addNewMissionResultDto(Mission mission){
        return MissionResponseDto.AddNewMissionResultDTO.builder()
                .storeId(mission.getStore().getId())
                .createdAt(LocalDateTime.now())
                .build();
    }


}
