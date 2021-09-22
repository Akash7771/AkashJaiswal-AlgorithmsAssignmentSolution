package com.greatlearning.stocker.model;

public class Company {
    private Integer companyId;
    private Double storckPrice;
    private Boolean currentStockPriceGrowthStatus;

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public Double getStorckPrice() {
        return storckPrice;
    }

    public void setStorckPrice(Double storckPrice) {
        this.storckPrice = storckPrice;
    }

    public Boolean getCurrentStockPriceGrowthStatus() {
        return currentStockPriceGrowthStatus;
    }

    public void setCurrentStockPriceGrowthStatus(Boolean currentStockPriceGrowthStatus) {
        this.currentStockPriceGrowthStatus = currentStockPriceGrowthStatus;
    }
}
