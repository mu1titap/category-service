package com.multitab.category.api.dto.in;

import com.multitab.category.api.domain.MiddleCategory;
import com.multitab.category.api.domain.TopCategory;
import com.multitab.category.api.vo.in.UpdateCategoryRequestVo;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
public class UpdateCategoryRequeestDto {

    private String parentCategoryCode;
    private String categoryCode;
    private String categoryName;
    private Integer categoryOrder;
    private String imageUrl;

    public static UpdateCategoryRequeestDto of(UpdateCategoryRequestVo updateCategoryRequestVo) {
        return UpdateCategoryRequeestDto.builder()
            .parentCategoryCode(updateCategoryRequestVo.getParentCategoryCode())
            .categoryCode(updateCategoryRequestVo.getCategoryCode())
            .categoryName(updateCategoryRequestVo.getCategoryName())
            .categoryOrder(updateCategoryRequestVo.getCategoryOrder())
            .imageUrl(updateCategoryRequestVo.getImageUrl())
            .build();
    }

    public TopCategory toTopCategory(Long id) {
        return TopCategory.builder()
            .id(id)
            .categoryCode(categoryCode)
            .categoryName(categoryName)
            .categoryOrder(categoryOrder)
            .imageUrl(imageUrl)
            .build();
    }

    public MiddleCategory toMiddleCategory(Long id) {
        return MiddleCategory.builder()
            .id(id)
            .categoryCode(categoryCode)
            .categoryName(categoryName)
            .categoryOrder(categoryOrder)
            .build();
    }


}
