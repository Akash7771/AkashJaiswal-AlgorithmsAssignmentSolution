package com.greatlearning.stocker.service.impl;

import com.greatlearning.stocker.service.SearchingService;

public class SearchingServiceImpl implements SearchingService {
    @Override
    public Boolean binarySearching(Double [] stockPrices , Double stockPrice) {

        return binarySearch(stockPrices , 0 , stockPrices.length - 1 , stockPrice);
    }

    boolean binarySearch(Double arr[], int first, int last, Double key){
        Boolean found = false;
        int mid = (first + last)/2;
        while( first <= last ){
            if ( arr[mid].compareTo(key) < 0 ){
                first = mid + 1;
            }else if ( arr[mid].compareTo(key) == 0 ){
                found = true;
                break;
            }else{
                last = mid - 1;
            }
            mid = (first + last)/2;
        }

        return found;
    }
}
