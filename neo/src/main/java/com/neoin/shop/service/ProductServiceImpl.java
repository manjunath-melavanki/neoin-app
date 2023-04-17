package com.neoin.shop.service;

import com.neoin.shop.dao.ProductDao;
import com.neoin.shop.entity.Product;
import com.neoin.shop.model.ProductFilter;
import com.neoin.shop.model.ProductModel;
import com.neoin.shop.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    private ProductDao productDao;

    @Override
    public ProductModel createProduct(ProductModel productModel) {
        Product prod = mapToRequest(productModel)
                .createdAt(System.currentTimeMillis())
                .createdBy("Test User")
                .build();
        return mapToResponse(productRepository.save(prod));
    }


    @Override
    public ProductModel updateProduct(ProductModel productModel) {
        Optional<Product> product = productRepository.findById(productModel.getId());
        if (product.isPresent()) {
            Product input = product.get();
            Product prod = mapToRequest(productModel)
                    .createdAt(input.getCreatedAt())
                    .createdBy(input.getCreatedBy())
                    .modifiedAt(System.currentTimeMillis())
                    .modifiedBy("Test User")
                    .build();
            return mapToResponse(productRepository.save(prod));
        } else {
            throw new RuntimeException("Product no found");
        }
    }

    @Override
    public List<ProductModel> getProducts(ProductFilter productFilter) {
        return productDao.getProducts(productFilter).stream().map(this::mapToResponse).collect(Collectors.toList());
    }

    private Product.ProductBuilder<?, ?> mapToRequest(ProductModel model) {
        return Product.builder()
                .productSKU(model.getProductSKU())
                .productName(model.getProductName())
                .productType(model.getProductType())
                .productManufacturer(model.getProductManufacturer())
                .productPrice(model.getProductPrice())
                .discountId(model.getDiscountId())
                .vendorId(model.getVendorId())
                .productCategoryId(model.getProductCategoryId())
                .productShortDesc(model.getProductShortDesc())
                .productLongDesc(model.getProductLongDesc())
                .productThumb(model.getProductThumb())
                .productImage(model.getProductImage())
                .productUpdateDate(model.getProductUpdateDate())
                .productStatus(model.getProductStatus());
    }

    private ProductModel mapToResponse(Product output) {
        return ProductModel.builder()
                .id(output.getId())
                .productSKU(output.getProductSKU())
                .productName(output.getProductName())
                .productType(output.getProductType())
                .productManufacturer(output.getProductManufacturer())
                .productPrice(output.getProductPrice())
                .discountId(output.getDiscountId())
                .vendorId(output.getVendorId())
                .productCategoryId(output.getProductCategoryId())
                .productShortDesc(output.getProductShortDesc())
                .productLongDesc(output.getProductLongDesc())
                .productThumb(output.getProductThumb())
                .productImage(output.getProductImage())
                .productUpdateDate(output.getProductUpdateDate())
                .productStatus(output.getProductStatus())
                .build();
    }

}
