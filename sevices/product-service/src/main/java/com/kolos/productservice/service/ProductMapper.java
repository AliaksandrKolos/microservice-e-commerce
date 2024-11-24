package com.kolos.productservice.service;

import com.kolos.productservice.data.entity.Category;
import com.kolos.productservice.data.entity.Product;
import com.kolos.productservice.service.dto.ProductPurchaseResponse;
import com.kolos.productservice.service.dto.ProductRequest;
import com.kolos.productservice.service.dto.ProductResponse;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

@Mapper(componentModel = "spring")
public interface ProductMapper {


    @Mapping(source = "categoryId", target = "category", qualifiedByName = "categoryFromId")
    Product toProduct(ProductRequest request);

    @Named("categoryFromId")
    default Category categoryFromId(Integer categoryId) {
        if (categoryId == null) {
            return null;
        }
        return Category.builder().id(categoryId).build();
    }

    @Mapping(source = "category.id", target = "categoryId")
    @Mapping(source = "category.name", target = "categoryName")
    @Mapping(source = "category.description", target = "categoryDescription")
    ProductResponse toProductResponse(Product product);

    ProductPurchaseResponse toProductPurchaseResponse(Product product, double quantity);
}
