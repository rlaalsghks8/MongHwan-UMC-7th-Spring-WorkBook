package umc.study.workbook.service.ReviewService;


import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import umc.study.workbook.domain.Member;
import umc.study.workbook.domain.Review;
import umc.study.workbook.domain.Store;
import umc.study.workbook.domain.dto.ReviewRequestDto;
import umc.study.workbook.domain.dto.ReviewResponseDto;
import umc.study.workbook.repository.MemberRepository;
import umc.study.workbook.repository.ReviewRepository;
import umc.study.workbook.repository.StoreRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ReviewCommandServiceImpl implements ReviewCommandService {

   private final ReviewRepository reviewRepository;

   private final MemberRepository memberRepository;

   private final StoreRepository storeRepository;


    @Override
    public Review writeReview(ReviewRequestDto.ReviewDto request) {

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Member ID입니다: " + request.getMemberId()));

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않은 store입니다: " + request.getStoreId()));

        Review newReview = new Review();
        newReview.setStore(store);
        newReview.setMember(member);
        newReview.setTitle(request.getTitle());
        newReview.setScore(request.getScore());


        return reviewRepository.save(newReview);
    }

    @Override
    public Page<ReviewResponseDto.MyReviewListDto> getMyReviews(Long memberId, int pageNo) {

        Member loginMember = memberRepository.findById(memberId)
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 Member입니다."));;

        Pageable pageable = PageRequest.of(pageNo,10);

        Page<Review> myReviews = reviewRepository.findAllByMemberId(memberId, pageable);

        List<ReviewResponseDto.MyReviewListDto> myReviewList = myReviews.stream()
                .map(review -> ReviewResponseDto.MyReviewListDto.builder()
                        .reviewId(review.getId())
                        .nickName(loginMember.getName())
                        .score(review.getScore())
                        .createdAt(LocalDateTime.now())
                        .content(review.getTitle())
                        .build())
                .collect(Collectors.toList());


        return new PageImpl<>(myReviewList,pageable,myReviews.getTotalElements());
    }


}
