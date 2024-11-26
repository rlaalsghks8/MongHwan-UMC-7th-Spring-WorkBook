package umc.study.workbook.domain.dto;

import lombok.*;
import umc.study.workbook.domain.enums.MissionStatus;

import java.time.LocalDateTime;

public class MissionResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ChallengeMissionResultDTO{
        Long missionId;
        LocalDateTime createdAt;
    }

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public  static class AddNewMissionResultDTO{
        Long storeId;
        LocalDateTime createdAt;
    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class StoreMissionListDTO{
        Long missionId;
        Integer point;
        String content;
        LocalDateTime createdAt;
    }

    @Builder
    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyMissionListDTO{
        Long missionId;
        MissionStatus status;
        LocalDateTime createdAt;
        LocalDateTime expiredAt;
    }
}
