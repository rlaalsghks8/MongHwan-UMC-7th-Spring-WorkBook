package umc.study.workbook.web.controller;


import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.study.workbook.apiPayload.ApiResponse;
import umc.study.workbook.converter.MissionConverter;
import umc.study.workbook.converter.ReviewConverter;
import umc.study.workbook.domain.Mission;
import umc.study.workbook.domain.Review;
import umc.study.workbook.domain.dto.MissionRequestDto;
import umc.study.workbook.domain.dto.MissionResponseDto;
import umc.study.workbook.domain.dto.ReviewRequestDto;
import umc.study.workbook.domain.dto.ReviewResponseDto;
import umc.study.workbook.domain.mapping.MemberMission;
import umc.study.workbook.service.MissionService.MissionCommandService;

@RestController
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionController {

    private final MissionCommandService missionCommandService;

    @PostMapping("/")
    public ApiResponse<MissionResponseDto.ChallengeMissionResultDTO> challegeMission(@RequestBody @Valid MissionRequestDto.MissionMemberDto request){
        MemberMission memberMission = missionCommandService.challengeMission(request);
        return ApiResponse.onSuccess(MissionConverter.challegeMissionResultDto(memberMission));
    }

    @PostMapping("/newMission")
    public ApiResponse<MissionResponseDto.AddNewMissionResultDTO> addNewMission(@RequestBody @Valid MissionRequestDto.MissionDto request){

        Mission mission = missionCommandService.addMission(request);
        return ApiResponse.onSuccess(MissionConverter.addNewMissionResultDto(mission));

    }


}
