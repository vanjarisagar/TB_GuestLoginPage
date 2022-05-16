package com.TruebasicNew.regression;

 

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;

 
import com.healthkart.extentReportUtil.ExtentReportingBaseUtil;
import com.healthkart.hkAutomation.util.WebDriverUtil;

public class TB_Test_FullOrderPlacementWithLogin_COD extends ExtentReportingBaseUtil {
	private String gatewayOrderId = null;
	private int cartCount;

	@Test
	public void TB_FullOrderPlaceWithGuestLoginP() {
	 System.out.println("*** Test Start **");
		homeStepB.searchProduct(TBKeyword);
		Assert.assertTrue(listingStep.verifyListingPage(),"Fail to load Category page.."); 
		System.out.println("Keyword present in category list");
		listingStep.visitPDPPageForFirstVariant();
		Assert.assertTrue(listingStep.verifyPDPPageLoaded(), "Fail to load PDP page");
		System.out.println("Product details page loaded");
		System.out.println("10");
		listingStep.addVariantToCart();
		System.out.println("11");
		WebDriverUtil.staticWait(3);
	    cartCount = homeStepB.getCartCountForUser();
  		if(cartCount != 0) {
  			 System.out.println( "There are items in user's cart..");
  			homeStepB.proceedToCart();
  			System.out.println("12");
  			Assert.assertTrue(cartStepB.verifyCartPageLoaded(), "Fail to load Cart page..");
  			System.out.println("13");
  			 cartStepB.makeCartEmpty();
  			System.out.println("14");
  		  cartStepB.continueShopping();
  			System.out.println("15");
  			Assert.assertTrue(homeStepB.verifyHomePageloaded(), "home page not loaded..");
  			System.out.println("16");
  			 System.out.println("user cart is empty now..");
  		}else {
  			 System.out.println("User cart is found empty..");
  		}
		System.out.println("17");
		  cartStepB.ProceedToCheckout();
		  System.out.println("18");
           homeStepB.performLoginWithMobileOtp(testdata.get("Login_User_Mobile"));
	  		System.out.println("19");
	  		Assert.assertTrue(homeStepB.verifyUserLogin(), "User failed to Login");
	  		 
  		    }
  		 
		 
	}

