package com.greatlearning.stocker.service;

import com.greatlearning.stocker.model.Company;

import java.util.List;

public interface SearchingService {
    Boolean binarySearching(Double [] stockPrices , Double stockPrice);
}
