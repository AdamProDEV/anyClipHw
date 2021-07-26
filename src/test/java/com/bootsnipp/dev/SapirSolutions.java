package com.bootsnipp.dev;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;

public class SapirSolutions {

    @ParameterizedTest
    @CsvFileSource(resources = "/sapirSolutions/ford_escort.csv", numLinesToSkip = 1)
    void runTestOnCsvData(String year, String mileage, String price){

        System.out.println(year + ", " + mileage + ", " + price);
    }
}
