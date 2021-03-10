package com.zuhlke.assignment.model;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

import static javax.persistence.GenerationType.IDENTITY;

@Data
@EqualsAndHashCode
@Entity
@Table(name = "STORE_ORDER")
@JsonIgnoreProperties(ignoreUnknown = true)
public class StoreOrder {

    @Id
    @GeneratedValue(strategy = IDENTITY)
    @Column(name = "ID")
    Long _id;

    @EqualsAndHashCode.Include
    @JsonProperty(value = "Order ID")
    @Column(name = "ORDER_ID")
    String orderId;

    @JsonProperty(value = "Order Date")
    @JsonFormat(pattern = "dd.MM.yy")
    @Column(name = "ORDER_DATE")
    Date orderDate;

    @JsonProperty(value = "Ship Date")
    @JsonFormat(pattern = "dd.MM.yy")
    @Column(name = "SHIP_DATE")
    Date shipDate;

    @JsonProperty(value = "Ship Mode")
    @Column(name = "SHIP_MODE")
    String shipMode;

    @JsonProperty(value = "Customer ID")
    @Column(name = "CUSTOMER_ID")
    String customerId;

    @JsonProperty(value = "Customer Name")
    @Column(name = "CUSTOMER_NAME")
    String customerName;

    @JsonProperty(value = "Segment")
    @Column(name = "SEGMENT")
    String segment;

    @JsonProperty(value = "Country")
    @Column(name = "COUNTRY")
    String country;

    @JsonProperty(value = "City")
    @Column(name = "CITY")
    String city;

    @JsonProperty(value = "State")
    @Column(name = "STATE")
    String state;

    @JsonProperty(value = "Postal Code")
    @Column(name = "POSTAL_CODE")
    String postalCode;

    @JsonProperty(value = "Region")
    @Column(name = "REGION")
    String region;

    @JsonProperty(value = "Product ID")
    @Column(name = "PRODUCT_ID")
    String productId;

    @JsonProperty(value = "Category")
    @Column(name = "CATEGORY")
    String category;

    @JsonProperty(value = "Sub-Category")
    @Column(name = "SUB_CATEGORY")
    String subCategory;

    @JsonProperty(value = "Product Name")
    @Column(name = "PRODUCT_NAME")
    String productName;

    @JsonProperty(value = "Quantity")
    @Column(name = "QUANTITY")
    int quantity;

    @JsonProperty(value = "Sales")
    @Column(name = "SALES")
    BigDecimal sales;

    @JsonProperty(value = "Discount")
    @Column(name = "DISCOUNT")
    BigDecimal discount;

    @JsonProperty(value = "Profit")
    @Column(name = "PROFIT")
    BigDecimal profit;
}
