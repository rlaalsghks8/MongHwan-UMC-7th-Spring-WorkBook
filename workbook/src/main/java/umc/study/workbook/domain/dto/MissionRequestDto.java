package umc.study.workbook.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import umc.study.workbook.domain.Store;
import umc.study.workbook.domain.enums.MissionStatus;

public class MissionRequestDto {

    @Getter
    public static class MissionDto{

        @NotNull
        Long storeId;
        @NotBlank
        String title;
        @NotNull
        Integer point;
    }

    @Getter
    public static class MissionMemberDto{
        @NotNull
        Long memberId;
        @NotNull
        Long missionId;
        @NotNull
        MissionStatus missionStatus;
    }
}
