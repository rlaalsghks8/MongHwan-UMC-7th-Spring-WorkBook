package umc.study.workbook.domain.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;

public class ReviewRequestDto {

    @Getter
    public static class ReviewDto{
        @NotNull
        Long storeId;
        @NotNull
        Long memberId;
        @NotBlank
        String title;

        Float Score;
    }
}
