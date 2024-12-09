package com.multitab.category.api.vo.in;

import com.multitab.category.api.domain.CategoryType;
import lombok.Getter;
import lombok.ToString;

@ToString
@Getter
public class TopCategoryRequestVo {

    private String topCategoryName;
    private CategoryType categoryType;
    private String imageUrl;

}
