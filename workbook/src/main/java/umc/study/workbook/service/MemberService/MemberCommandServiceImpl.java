package umc.study.workbook.service.MemberService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.workbook.apiPayload.code.status.ErrorStatus;
import umc.study.workbook.apiPayload.exception.handler.FoodCategoryHandler;
import umc.study.workbook.converter.MemberConverter;
import umc.study.workbook.converter.MemberPreferConverter;
import umc.study.workbook.domain.FoodCategory;
import umc.study.workbook.domain.Member;
import umc.study.workbook.domain.dto.MemberRequestDto;
import umc.study.workbook.domain.mapping.MemberPrefer;
import umc.study.workbook.repository.FoodCategoryRepository;
import umc.study.workbook.repository.MemberRepository;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MemberCommandServiceImpl implements MemberCommandService {

    private final MemberRepository memberRepository;

    private final FoodCategoryRepository foodCategoryRepository;


    @Override
    @Transactional
    public Member joinMember(MemberRequestDto.JoinDto request) {

        Member newMember = MemberConverter.toMember(request);
        List<FoodCategory> foodCategoryList = request.getPreferCategory().stream()
                .map(category -> {
                    return foodCategoryRepository.findById(category).orElseThrow(() -> new FoodCategoryHandler(ErrorStatus.FOOD_CATEGORY_NOT_FOUND));
                }).collect(Collectors.toList());

        List<MemberPrefer> memberPreferList = MemberPreferConverter.toMemberPreferList(foodCategoryList);

        memberPreferList.forEach(memberPrefer -> {memberPrefer.setMember(newMember);});

        return memberRepository.save(newMember);
    }
}

