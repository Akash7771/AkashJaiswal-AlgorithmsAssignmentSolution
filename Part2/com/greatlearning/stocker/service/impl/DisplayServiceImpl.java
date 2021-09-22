package com.greatlearning.stocker.service.impl;

import com.greatlearning.stocker.constants.GROWTHSTATUS;
import com.greatlearning.stocker.constants.ORDERBY;
import com.greatlearning.stocker.service.DisplayService;

public class DisplayServiceImpl implements DisplayService {
    @Override
    public void displayStockPriceOrderBy(Double[] stockPrices, ORDERBY orderby) {
        String Seperator = " ";
        String order ="";

        if(orderby.equals(ORDERBY.ASC))
            order = "ascending";
        else if(orderby.equals(ORDERBY.DESC)){
            order = "descending";
        }
        System.out.println("Stock prices in "+order+" are");
        for(int i =0 ; i< stockPrices.length ; i++){
            System.out.print(stockPrices[i] + Seperator);
        }
        System.out.println();
    }

    @Override
    public void displayCountByGrowthStatus(Integer totalCount, GROWTHSTATUS growthstatus) {
        String growth = "";
        if(growthstatus.equals(GROWTHSTATUS.ROSE))
            growth = "rose";
        else if(growthstatus.equals(GROWTHSTATUS.DECLINE))
            growth = "decline";

        System.out.println("Total no of companies whose stock price "+ growth +" today : "+totalCount);
    }

    @Override
    public void displaySearchResult(Double stockPrice, Boolean found) {
        String status = " ";
        if(!found)
            status = " not ";
        System.out.println("Stock of value "+ stockPrice +" is"+ status +"present");
    }
}
