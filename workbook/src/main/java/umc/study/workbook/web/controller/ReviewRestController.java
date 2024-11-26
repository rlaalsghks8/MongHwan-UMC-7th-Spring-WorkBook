package umc.study.workbook.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;
import umc.study.workbook.apiPayload.ApiResponse;
import umc.study.workbook.converter.MemberConverter;
import umc.study.workbook.converter.ReviewConverter;
import umc.study.workbook.domain.Member;
import umc.study.workbook.domain.Review;
import umc.study.workbook.domain.dto.MemberRequestDto;
import umc.study.workbook.domain.dto.MemberResponseDto;
import umc.study.workbook.domain.dto.ReviewRequestDto;
import umc.study.workbook.domain.dto.ReviewResponseDto;
import umc.study.workbook.service.ReviewService.ReviewCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/reviews")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/")
    public ApiResponse<ReviewResponseDto.ReviewResultDTO> addReview(@RequestBody @Valid ReviewRequestDto.ReviewDto request){
        Review review = reviewCommandService.writeReview(request);
        return ApiResponse.onSuccess(ReviewConverter.toAddResultDto(review));
    }


    @GetMapping("/myreviewList")
    public ApiResponse<Page<ReviewResponseDto.MyReviewListDto>> myReviewList(@RequestParam Long userId,@RequestParam int pageNo){

        Page<ReviewResponseDto.MyReviewListDto> listdto = reviewCommandService.getMyReviews(userId,pageNo);


        return ApiResponse.onSuccess(listdto);
    }
}
