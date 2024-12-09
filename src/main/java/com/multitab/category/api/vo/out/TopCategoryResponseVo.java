package com.multitab.category.api.vo.out;

import com.multitab.category.api.domain.CategoryType;
import lombok.*;

@Builder
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class TopCategoryResponseVo {

    private Long id;
    private String topCategoryCode;
    private String topCategoryName;
    private CategoryType categoryType;
    private String imageUrl;


}
