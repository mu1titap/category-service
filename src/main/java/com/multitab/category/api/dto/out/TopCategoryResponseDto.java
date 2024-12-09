package com.multitab.category.api.dto.out;


import com.multitab.category.api.domain.CategoryType;
import com.multitab.category.api.vo.out.TopCategoryResponseVo;
import lombok.*;

@ToString
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopCategoryResponseDto {

    private Long id;
    private String topCategoryName;
    private String topCategoryCode;
    private CategoryType categoryType;
    private String imageUrl;

    public TopCategoryResponseVo toVo() {
        return TopCategoryResponseVo.builder()
            .id(id)
            .topCategoryName(topCategoryName)
            .topCategoryCode(topCategoryCode)
            .categoryType(categoryType)
            .imageUrl(imageUrl)
            .build();
    }

}
