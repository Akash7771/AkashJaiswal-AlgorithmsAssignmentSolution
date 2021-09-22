package com.greatlearning.stocker.service;

import com.greatlearning.stocker.constants.GROWTHSTATUS;
import com.greatlearning.stocker.constants.ORDERBY;
import com.greatlearning.stocker.model.Company;

import java.util.List;

public interface StockerService {
    Double [] displayCompanyStockPriceOrdeyBy(List<Company> companyList , ORDERBY orderby);
    Integer countCompanyStockPriceByGrowthStatus(List<Company> companyList , GROWTHSTATUS growthstatus);
    Boolean searchStockByStockPrice(List<Company> companyList , Double stockPrice);

}
