package com.stock;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class StockPriceApplication {

	public static void main(String[] args) {
		SpringApplication.run(StockPriceApplication.class, args);

		int[] priceArray = { 10, 7, 5, 8, 11, 9 };
		System.out.println("Maximum profit: " + getMaxProfit(priceArray));

		assertEquals(6, getMaxProfit(priceArray));
		assertNotEquals(7, getMaxProfit(priceArray));
	}

	public static int getMaxProfit(int[] priceArray) {

		int maxDiff = Integer.MIN_VALUE;
		int max = Integer.MIN_VALUE;
		int bottom = priceArray[0];
		int diff = 0;

		for (int i = 1; i < priceArray.length; i++) {
			diff += priceArray[i] - priceArray[i - 1];

			if (diff > maxDiff) {
				maxDiff = diff;
				max = priceArray[i];
			}

			if (priceArray[i] < bottom) {
				bottom = priceArray[i];
				diff = 0;
			}
		}

		int buy = max - maxDiff;
		int sell = max;
		int maxProfit = sell - buy;

		System.out.println("Buy at : " + buy + "  Sell at: " + sell);

		return maxProfit;

	}

}
