package umc.study.workbook.service.MemberService;

import umc.study.workbook.domain.Member;

import java.util.Optional;

public interface MemberQueryService {

    Optional<Member> findMember(Long id);
}
