package com.multitab.category.cate.presentation;

import com.multitab.category.cate.application.CategoryService;
import com.multitab.category.cate.common.entity.BaseResponse;
import com.multitab.category.cate.common.entity.BaseResponseStatus;
import com.multitab.category.cate.dto.in.MiddleCategoryRequestDto;
import com.multitab.category.cate.dto.in.TopCategoryRequestDto;
import com.multitab.category.cate.dto.out.*;
import com.multitab.category.cate.vo.in.MiddleCategoryRequestVo;
import com.multitab.category.cate.vo.in.TopCategoryRequestVo;
import com.multitab.category.cate.vo.out.*;
import io.swagger.v3.oas.annotations.Operation;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/category")
public class CategoryController {

    private final CategoryService categoryService;


    // 대 카테고리 생성
    @PostMapping("/top-category")
    @Operation(summary = "대 카테고리 생성", description = "대 카테고리 생성 카테고리명, 소개 입력")
    public BaseResponse<TopCategoryResponseVo> createTopCategory(
            @RequestBody TopCategoryRequestVo topCategoryRequestVo) {

        log.info("topCategoryRequestVo : {}", topCategoryRequestVo);
        TopCategoryRequestDto topCategoryRequestDto = TopCategoryRequestDto.builder()
                .topCategoryName(topCategoryRequestVo.getTopCategoryName())
                .categoryOrder(topCategoryRequestVo.getCategoryOrder())
                .build();
        ;
        return new BaseResponse<>(categoryService.createTopCategory(topCategoryRequestDto).toVo());
    }

    @Operation(summary = "대 카테고리 조회", description = "카테고리 코드로 대 카테고리 단건 조회")
    @GetMapping("/top-category/{topCategoryCode}")
    public BaseResponse<TopCategoryResponseVo> getTopCategory(
            @PathVariable("topCategoryCode") String topCategoryCode) {
        log.info("topCategoryCode : {}", topCategoryCode);
        return new BaseResponse<>(categoryService.getTopCategoryByCategoryCode(topCategoryCode).toVo());
    }

    @Operation(summary = "중 카테고리 생성", description = "중 카테고리 생성 카테고리명, 소개 , 대 카테고리 코드 입력")
    @PostMapping("/middle-category")
    public BaseResponse<Void> createMiddleCategory(
            @RequestBody MiddleCategoryRequestVo middleCategoryRequestVo) {

        MiddleCategoryRequestDto middleCategoryRequestDto = MiddleCategoryRequestDto.builder()
                .middleCategoryName(middleCategoryRequestVo.getMiddleCategoryName())
                .categoryOrder(middleCategoryRequestVo.getCategoryOrder())
                .topCategoryCode(middleCategoryRequestVo.getTopCategoryCode())
                .build();
        log.info("middleCategoryRequestDto : {}", middleCategoryRequestDto);
        categoryService.createMiddleCategory(middleCategoryRequestDto);

        return new BaseResponse<>(BaseResponseStatus.SUCCESS);
    }

    @GetMapping("/middle-category/{middleCategoryCode}")
    public BaseResponse<MiddleCategoryResponseVo> getMiddleCategory(
            @PathVariable("middleCategoryCode") String middleCategoryCode) {
        log.info("middleCategoryCode : {}", middleCategoryCode);
        return new BaseResponse<>(categoryService.getMiddleCategoryByCategoryCode(middleCategoryCode).toVo());
    }

    @GetMapping("/top-categories")
    public BaseResponse<List<TopCategoryResponseVo>> getTopCategories() {

        return new BaseResponse<>(
                categoryService.getTopCategories()
                        .stream()
                        .map(TopCategoryResponseDto::toVo)
                        .collect(Collectors.toList()));
    }

    @GetMapping("/middle-categories/{topCategoryCode}")
    public BaseResponse<List<MiddleCategoryResponseVo>> getMiddleCategories(
            @PathVariable("topCategoryCode") String topCategoryCode) {

        return new BaseResponse<>(
                categoryService.getMiddleCategories(topCategoryCode)
                        .stream()
                        .map(MiddleCategoryResponseDto::toVo)
                        .collect(Collectors.toList()));
    }

    @Operation(summary = "대 카테고리의 자식 카테고리 조회", description = "중 카테고리의 자식까지만 조회됨. 하 카테고리는 조회안됨")
    @GetMapping("/top-category/child/{categoryCode}")
    public BaseResponse<List<ChildCategoryResponseVo>> findChildCategoriesByTopCategoryV1(
            @PathVariable("categoryCode") String categoryCode) {

        return new BaseResponse<>(
                categoryService.findChildCategoriesByTopCategory(categoryCode)
                        .stream()
                        .map(ChildCategoryResponseDto::toVo)
                        .collect(Collectors.toList()));
    }

}