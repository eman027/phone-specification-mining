package com.sample.steps.gsm.common;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Arrays;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

@Getter
public enum PhoneBrandEnum {
    SAMSUNG("SAMSUNG", "//*[@id=\"body\"]/aside/div[1]/ul/li[2]/a"),
    APPLE("APPLE", "//*[@id=\"body\"]/aside/div[1]/ul/li[2]/a"),
    XIAOMI("XIAOMI", "//*[@id=\"body\"]/aside/div[1]/ul/li[10]/a"),
    HUAWEI("HUAWEI", "//*[@id=\"body\"]/aside/div[1]/ul/li[3]/a"),
    TECNO("TECNO", "//*[@id=\"body\"]/aside/div[1]/ul/li[31]/a"),
    INFINIX("INFINIX", "//*[@id=\"body\"]/aside/div[1]/ul/li[28]/a"),
    VIVO("VIVO", "//*[@id=\"body\"]/aside/div[1]/ul/li[16]/a"),
    REALME("REALME", "//*[@id=\"body\"]/aside/div[1]/ul/li[14]/a"),
    ASUS("ASUS", "//*[@id=\"body\"]/aside/div[1]/ul/li[12]/a");


    private static final Map<String, PhoneBrandEnum> PHONE_BRAND_MAP;


    static {
        PHONE_BRAND_MAP = Arrays.stream(values()).collect(Collectors.toMap(PhoneBrandEnum::getBrand, Function.identity()));
    }

    private final String brand;

    private final String location;


    PhoneBrandEnum(String brand, String location) {
        this.brand = brand;
        this.location = location;
    }

    public static WebElement getPhoneLocation(WebDriver webDriver, String brand) {
        PhoneBrandEnum phoneBrandEnum = PHONE_BRAND_MAP.get(brand.toUpperCase());
        return webDriver.findElement(By.xpath(phoneBrandEnum.getLocation()));

    }
}
