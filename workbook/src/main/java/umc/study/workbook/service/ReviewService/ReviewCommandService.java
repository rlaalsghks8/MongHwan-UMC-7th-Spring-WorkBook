package umc.study.workbook.service.ReviewService;

import umc.study.workbook.domain.Review;
import umc.study.workbook.domain.dto.ReviewRequestDto;

public interface ReviewCommandService {

    Review writeReview(ReviewRequestDto.ReviewDto request);

}
