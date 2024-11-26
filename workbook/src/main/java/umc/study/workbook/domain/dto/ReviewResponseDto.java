package umc.study.workbook.domain.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.List;

public class ReviewResponseDto {

    @Builder
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class ReviewResultDTO{
        Long reviewId;
        LocalDateTime createdAt;
    }


    @Builder
    @Getter
    @Setter
    @NoArgsConstructor
    @AllArgsConstructor
    public static class MyReviewListDto{
        Long reviewId;
        String nickName;
        Float score;
        LocalDateTime createdAt;
        String content;
    }
}
