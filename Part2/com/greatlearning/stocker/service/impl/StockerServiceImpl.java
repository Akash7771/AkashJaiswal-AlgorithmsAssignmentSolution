package com.greatlearning.stocker.service.impl;

import com.greatlearning.stocker.constants.GROWTHSTATUS;
import com.greatlearning.stocker.constants.ORDERBY;
import com.greatlearning.stocker.model.Company;
import com.greatlearning.stocker.service.SearchingService;
import com.greatlearning.stocker.service.SortingService;
import com.greatlearning.stocker.service.StockerService;

import java.util.List;

public class StockerServiceImpl implements StockerService {
    SearchingService searchingService;
    SortingService sortingService;

    @Override
    public Double[] displayCompanyStockPriceOrdeyBy(List<Company> companyList, ORDERBY orderby) {
        sortingService = new SortingServiceImpl();
        Double [] stockPrices = new Double[companyList.size()];
        for(int i =0 ; i < companyList.size() ; i ++){
            stockPrices[i] = companyList.get(i).getStorckPrice();
        }

        sortingService.mergeSortingUsingOrderBy(stockPrices , orderby);
        return stockPrices ;

    }

    @Override
    public Integer countCompanyStockPriceByGrowthStatus(List<Company> companyList, GROWTHSTATUS growthstatus) {
        Integer count =0;
        Boolean statusByGrowthStatus =Boolean.FALSE;
        if(growthstatus.equals(GROWTHSTATUS.ROSE))
            statusByGrowthStatus=Boolean.TRUE;
        else if(growthstatus.equals(GROWTHSTATUS.DECLINE))
            statusByGrowthStatus = Boolean.FALSE;
        for (Company company : companyList){
            if(company.getCurrentStockPriceGrowthStatus().equals(statusByGrowthStatus) ){
                count ++ ;
            }
        }
        return count;
    }

    @Override
    public Boolean searchStockByStockPrice(List<Company> companyList , Double stockPrice) {
        searchingService = new SearchingServiceImpl();
        sortingService = new SortingServiceImpl();
        Double [] stockPrices = new Double[companyList.size()];
        for(int i =0 ; i < companyList.size() ; i ++){
            stockPrices[i] = companyList.get(i).getStorckPrice();
        }
        sortingService.mergeSortingUsingOrderBy(stockPrices , ORDERBY.ASC);
        return searchingService.binarySearching(stockPrices , stockPrice);

    }
}
