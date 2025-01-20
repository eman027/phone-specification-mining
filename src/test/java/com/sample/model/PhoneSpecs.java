package com.sample.model;


public class PhoneSpecs {

    private String brand;

    private String model;

    private String lengthInches;

    private String widthInches;

    private String thicknessInches;

    private String dimension;

    private String sizeInches;

    private String lengthMm;

    private String widthMm;

    private String thicknessMm;

    private String cameraPosition;

    private String year;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getLengthInches() {
        return lengthInches;
    }

    public void setLengthInches(String lengthInches) {
        this.lengthInches = lengthInches;
    }

    public String getWidthInches() {
        return widthInches;
    }

    public void setWidthInches(String widthInches) {
        this.widthInches = widthInches;
    }

    public String getDimension() {
        return dimension;
    }

    public void setDimension(String dimension) {
        this.dimension = dimension;
    }

    public String getSizeInches() {
        return sizeInches;
    }

    public void setSizeInches(String sizeInches) {
        this.sizeInches = sizeInches;
    }

    public String getLengthMm() {
        return lengthMm;
    }

    public void setLengthMm(String lengthMm) {
        this.lengthMm = lengthMm;
    }

    public String getWidthMm() {
        return widthMm;
    }

    public void setWidthMm(String widthMm) {
        this.widthMm = widthMm;
    }

    public String getCameraPosition() {
        return cameraPosition;
    }

    public void setCameraPosition(String cameraPosition) {
        this.cameraPosition = cameraPosition;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getThicknessInches() {
        return thicknessInches;
    }

    public void setThicknessInches(String thicknessInches) {
        this.thicknessInches = thicknessInches;
    }

    public String getThicknessMm() {
        return thicknessMm;
    }

    public void setThicknessMm(String thicknessMm) {
        this.thicknessMm = thicknessMm;
    }

    @Override
    public String toString() {
        return "PhoneSpecs{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", lengthInches='" + lengthInches + '\'' +
                ", widthInches='" + widthInches + '\'' +
                ", thicknessInches='" + thicknessInches + '\'' +
                ", Dimension='" + dimension + '\'' +
                ", SizeInches='" + sizeInches + '\'' +
                ", lengthMm='" + lengthMm + '\'' +
                ", widthMm='" + widthMm + '\'' +
                ", thicknessMm='" + thicknessMm + '\'' +
                ", cameraPosition='" + cameraPosition + '\'' +
                ", year='" + year + '\'' +
                '}';
    }
}
