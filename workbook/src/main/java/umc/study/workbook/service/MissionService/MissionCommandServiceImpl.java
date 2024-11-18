package umc.study.workbook.service.MissionService;

import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.study.workbook.domain.Member;
import umc.study.workbook.domain.Mission;
import umc.study.workbook.domain.Store;
import umc.study.workbook.domain.dto.MissionRequestDto;
import umc.study.workbook.domain.enums.MissionStatus;
import umc.study.workbook.domain.mapping.MemberMission;
import umc.study.workbook.repository.MemberMissionRepository;
import umc.study.workbook.repository.MemberRepository;
import umc.study.workbook.repository.MissionRepository;
import umc.study.workbook.repository.StoreRepository;

import java.time.LocalDate;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class MissionCommandServiceImpl implements MissionCommandService{

    private final MemberRepository memberRepository;
    private final MissionRepository missionRepository;
    private final MemberMissionRepository memberMissionRepository;
    private final StoreRepository storeRepository;


    @Override
    public Mission addMission(MissionRequestDto.MissionDto request) {

        Store store = storeRepository.findById(request.getStoreId())
                .orElseThrow(()-> new IllegalArgumentException("존재하지 않는 Store입니다."+ request.getStoreId()));
        Mission newMission = new Mission();
        newMission.setStore(store);
        newMission.setReward(request.getPoint());
        newMission.setMissionSpec(request.getTitle());
        newMission.setDeadline(LocalDate.now().plusWeeks(1));


        return missionRepository.save(newMission);
    }

    @Override
    @Transactional
    public MemberMission challengeMission(MissionRequestDto.MissionMemberDto request) {

        Mission mission = missionRepository.findById(request.getMissionId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Mission ID입니다: " + request.getMissionId()));

        Member member = memberRepository.findById(request.getMemberId())
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 Member ID입니다: " + request.getMemberId()));
        MemberMission challengeMission = new MemberMission();
        challengeMission.setMission(mission);
        challengeMission.setMember(member);
        challengeMission.setStatus(MissionStatus.CHALLENGING);

        return memberMissionRepository.save(challengeMission);
    }
}
