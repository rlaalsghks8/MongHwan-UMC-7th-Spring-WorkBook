package umc.study.workbook.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.study.workbook.apiPayload.ApiResponse;
import umc.study.workbook.domain.dto.MissionResponseDto;
import umc.study.workbook.domain.dto.StoreResponseDto;
import umc.study.workbook.service.MissionService.MissionCommandService;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/stores")
public class StoreRestController {

    private final MissionCommandService missionCommandService;


    @GetMapping("/missions")
    public ApiResponse<Page<MissionResponseDto.StoreMissionListDTO>> getStoreMissionList(@RequestParam Long storeId,
                                                                                         @RequestParam int pageNo){
        Page<MissionResponseDto.StoreMissionListDTO> missionListDto = missionCommandService.storeMissions(storeId,pageNo);

        return ApiResponse.onSuccess(missionListDto);
    }





}
