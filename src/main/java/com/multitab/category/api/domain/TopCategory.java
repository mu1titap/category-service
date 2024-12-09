package com.multitab.category.api.domain;


import com.multitab.category.common.entity.BaseEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@ToString
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "top_category", uniqueConstraints = {
    @UniqueConstraint(columnNames = "category_name")})
public class TopCategory extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "category_name", nullable = false, length = 30)
    private String categoryName;
    @Column(name = "category_order", nullable = true)
    private Integer categoryOrder;
    @Column(name = "category_code", nullable = false, length = 20)
    private String categoryCode;
    @Column(name = "category_type")
    @Enumerated(EnumType.STRING)
    private CategoryType categoryType;
    @Column(name = "image_url")
    private String imageUrl;


}