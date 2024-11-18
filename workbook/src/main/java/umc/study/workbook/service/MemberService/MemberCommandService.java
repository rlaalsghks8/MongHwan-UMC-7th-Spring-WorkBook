package umc.study.workbook.service.MemberService;

import umc.study.workbook.domain.Member;
import umc.study.workbook.domain.dto.MemberRequestDto;

public interface MemberCommandService {
    Member joinMember(MemberRequestDto.JoinDto request);
}
