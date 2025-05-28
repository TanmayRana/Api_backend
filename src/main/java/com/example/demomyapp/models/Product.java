package com.example.demomyapp.models;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

import com.example.demomyapp.utils.JsonToMapConverter;

@Entity
@Table(name = "products")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    private Integer id;

    private String title;
    private String description;
    private String category;

    @Column(precision = 10, scale = 2)
    private BigDecimal price;

    @Column(name = "discount_percentage")
    private Float discountPercentage;

    private Float rating;
    private Integer stock;
    private String brand;
    private String sku;
    private Float weight;
    private Float width;
    private Float height;
    private Float depth;

    @Column(name = "warranty_information")
    private String warrantyInformation;

    @Column(name = "shipping_information")
    private String shippingInformation;

    @Column(name = "availability_status")
    private String availabilityStatus;

    @Column(name = "return_policy")
    private String returnPolicy;

    @Column(name = "minimum_order_quantity")
    private Integer minimumOrderQuantity;

    @Convert(converter = JsonToMapConverter.class)
    private Map<String, Object> meta;

    @ElementCollection
    @CollectionTable(name = "product_tags", joinColumns = @JoinColumn(name = "product_id"))
    @Column(name = "tag")
    private List<String> tags;

    private String thumbnail;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductImage> images;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<ProductReview> reviews;
}
