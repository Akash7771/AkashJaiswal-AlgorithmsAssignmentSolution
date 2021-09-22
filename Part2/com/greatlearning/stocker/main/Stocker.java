package com.greatlearning.stocker.main;

import com.greatlearning.stocker.constants.GROWTHSTATUS;
import com.greatlearning.stocker.constants.ORDERBY;
import com.greatlearning.stocker.model.Company;
import com.greatlearning.stocker.service.DisplayService;
import com.greatlearning.stocker.service.StockerService;
import com.greatlearning.stocker.service.impl.DisplayServiceImpl;
import com.greatlearning.stocker.service.impl.StockerServiceImpl;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Stocker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        List<Company> companyList = new ArrayList<>();
        StockerService stockerService = new StockerServiceImpl();
        DisplayService displayService = new DisplayServiceImpl();
        String lineBreak = "\n\t";
        Integer n ;
        Integer ch ;

        try {
            System.err.println("enter the no of companies");
            n = sc.nextInt();
            for(int i=0 ; i < n ; i++){
                Company company = new Company();
                company.setCompanyId(i+1);
                System.out.println("Enter current stock price of the company " + company.getCompanyId() );
                Double stockPrice = sc.nextDouble();

                System.out.println("Whether company's stock price rose today compare to yesterday?" );
                Boolean currentStockPriceGrowthStatus = sc.nextBoolean();

                company.setStorckPrice(stockPrice);
                company.setCurrentStockPriceGrowthStatus(currentStockPriceGrowthStatus);

                companyList.add(company);
            }

        }catch (InputMismatchException ime){

        }catch (Exception e){
            System.err.println(e);
        }

        do {
            System.out.println(
                    "Enter the operation that you want to perform" + lineBreak +
                            "1. Display the companies stock prices in ascending order" + lineBreak +
                            "2. Display the companies stock prices in descending order" + lineBreak +
                            "3. Display the total no of companies for which stock prices rose today" + lineBreak +
                            "4. Display the total no of companies for which stock prices declined today" + lineBreak +
                            "5. Search a specific stock price" + lineBreak +
                            "6. press 0 to exit" + lineBreak
            );
            ch = sc.nextInt();
            switch(ch){
                case 1 :
                    Double [] stockPricesAsc =
                    stockerService.displayCompanyStockPriceOrdeyBy(companyList , ORDERBY.ASC);
                    displayService.displayStockPriceOrderBy(stockPricesAsc , ORDERBY.ASC);
                    break;
                case 2:
                    Double [] stockPricesDesc =
                    stockerService.displayCompanyStockPriceOrdeyBy(companyList , ORDERBY.DESC);
                    displayService.displayStockPriceOrderBy(stockPricesDesc , ORDERBY.DESC);
                    break;
                case 3:
                    Integer countRose =
                    stockerService.countCompanyStockPriceByGrowthStatus(companyList , GROWTHSTATUS.ROSE);
                    displayService.displayCountByGrowthStatus(countRose , GROWTHSTATUS.ROSE);
                    break;
                case 4:
                    Integer countDecline =
                    stockerService.countCompanyStockPriceByGrowthStatus(companyList , GROWTHSTATUS.DECLINE);
                    displayService.displayCountByGrowthStatus(countDecline , GROWTHSTATUS.DECLINE);
                    break;
                case 5:
                    System.out.println("enter the key value");
                    Double stockPrice = sc.nextDouble();
                    Boolean found =
                    stockerService.searchStockByStockPrice(companyList , stockPrice);
                    displayService.displaySearchResult(stockPrice , found);
                    break;
                case 6:
                    ch=0;
                    break;
                case 0:
                    break;
                default:
                    continue;

            }

        }while(ch != 0);

    }
}
