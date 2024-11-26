package umc.study.workbook.service.ReviewService;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import umc.study.workbook.domain.Review;
import umc.study.workbook.domain.dto.ReviewRequestDto;
import umc.study.workbook.domain.dto.ReviewResponseDto;

public interface ReviewCommandService {

    Review writeReview(ReviewRequestDto.ReviewDto request);

    Page<ReviewResponseDto.MyReviewListDto> getMyReviews(Long memberId, int pageNo);



}
