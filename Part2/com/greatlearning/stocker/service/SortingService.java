package com.greatlearning.stocker.service;

import com.greatlearning.stocker.constants.ORDERBY;

public interface SortingService {
    void mergeSortingUsingOrderBy(Double[] stockPrices , ORDERBY orderby);
}
