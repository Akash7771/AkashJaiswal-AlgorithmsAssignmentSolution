package com.greatlearning.stocker.service.impl;

import com.greatlearning.stocker.constants.ORDERBY;
import com.greatlearning.stocker.service.SortingService;

public class SortingServiceImpl implements SortingService {
    @Override
    public void mergeSortingUsingOrderBy(Double[] stockPrices, ORDERBY orderby) {
        int start = 0 , end = stockPrices.length-1;
        mergeSort(stockPrices ,  start , end , orderby);
    }

    private void merge(Double Arr[], int start, int mid, int end , ORDERBY orderby) {

        Double temp[] = new Double[end - start + 1];
        int i = start, j = mid+1, k = 0;

        while(i <= mid && j <= end) {
            if(orderby.equals(ORDERBY.DESC) ) {
                if (Arr[i].compareTo(Arr[j]) >= 0) { //  desc
                    temp[k] = Arr[i];
                    k += 1;
                    i += 1;
                } else {
                    temp[k] = Arr[j];
                    k += 1;
                    j += 1;
                }
            }
            else{
                if (Arr[i].compareTo(Arr[j]) <= 0) { //  asc
                    temp[k] = Arr[i];
                    k += 1;
                    i += 1;
                } else {
                    temp[k] = Arr[j];
                    k += 1;
                    j += 1;
                }

            }
        }

        while(i <= mid) {
            temp[k] = Arr[i];
            k += 1; i += 1;
        }

        while(j <= end) {
            temp[k] = Arr[j];
            k += 1; j += 1;
        }

        for(i = start; i <= end; i += 1) {
            Arr[i] = temp[i - start];
        }
    }

    public void mergeSort(Double Arr[], int start, int end , ORDERBY orderby) {

        if(start < end) {
            int mid = (start + end) / 2;
            mergeSort(Arr, start, mid , orderby);
            mergeSort(Arr, mid+1, end , orderby);
            merge(Arr, start, mid, end , orderby);
        }
    }
}
