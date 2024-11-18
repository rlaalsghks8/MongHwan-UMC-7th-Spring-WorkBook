package umc.study.workbook.converter;

import umc.study.workbook.domain.Review;
import umc.study.workbook.domain.dto.MemberResponseDto;
import umc.study.workbook.domain.dto.ReviewResponseDto;

import java.time.LocalDateTime;

public class ReviewConverter {

    public static ReviewResponseDto.ReviewResultDTO toAddResultDto(Review review) {
        return ReviewResponseDto.ReviewResultDTO.builder()
                .reviewId(review.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }
}
