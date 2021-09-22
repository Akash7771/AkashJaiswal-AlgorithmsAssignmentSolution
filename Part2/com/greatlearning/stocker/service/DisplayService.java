package com.greatlearning.stocker.service;

import com.greatlearning.stocker.constants.GROWTHSTATUS;
import com.greatlearning.stocker.constants.ORDERBY;

public interface DisplayService {
    void displayStockPriceOrderBy(Double [] stockPrices , ORDERBY orderby);
    void displayCountByGrowthStatus(Integer totalCount , GROWTHSTATUS growthstatus);
    void displaySearchResult(Double stockPrice , Boolean found);

}
