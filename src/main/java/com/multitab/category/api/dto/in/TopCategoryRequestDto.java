package com.multitab.category.api.dto.in;


import com.multitab.category.api.domain.CategoryType;
import com.multitab.category.api.domain.TopCategory;
import lombok.*;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TopCategoryRequestDto {

    private String topCategoryName;
    private CategoryType categoryType;
    private String imageUrl;

    // categoryCode 생성 로직은 제거합니다.
    // DTO는 데이터를 전달하는 역할만 수행하도록 유지합니다.

    public TopCategory toEntity(String categoryCode) {
        return TopCategory.builder()
            .categoryName(topCategoryName)
            .categoryCode(categoryCode)  // 서비스에서 생성된 코드를 주입합니다.
            .categoryType(categoryType)
            .imageUrl(imageUrl)
            .build();
    }

}
