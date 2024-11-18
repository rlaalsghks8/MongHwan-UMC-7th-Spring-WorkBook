package umc.study.workbook.service.ReviewService;


import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.workbook.domain.Member;
import umc.study.workbook.domain.Review;
import umc.study.workbook.domain.Store;
import umc.study.workbook.domain.dto.ReviewRequestDto;
import umc.study.workbook.repository.MemberRepository;
import umc.study.workbook.repository.ReviewRepository;
import umc.study.workbook.repository.StoreRepository;

import java.util.Optional;

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


}
