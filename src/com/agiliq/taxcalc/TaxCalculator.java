package com.agiliq.taxcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.Math;

public class TaxCalculator extends Activity 
		implements Button.OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("10");
        setContentView(R.layout.main);
        
        
    }
    
    public void onClick(View v){
    	EditText income = (EditText)findViewById(R.id.income);
        EditText investments = (EditText)findViewById(R.id.investments);
        EditText infraInvestments = (EditText)findViewById(R.id.infraInvestment);
        EditText housingInterest = (EditText)findViewById(R.id.housingInterest);
        EditText medicalPremium = (EditText)findViewById(R.id.medicalPremium);
        TextView calculatedTax = (TextView)findViewById(R.id.calculated_tax);
        
        int income_i, investments_i, infraInvestments_i;
        int housingInterest_i, medicalPremium_i;
        try{
        	income_i = Integer.parseInt(income.getText().toString());
        }
        catch (NumberFormatException e) {
			income_i = 0;
		}
        try {
        	investments_i = Integer.parseInt(investments.getText().toString());
		} catch (NumberFormatException e) {
			investments_i = 0;
		}
        try {
        	infraInvestments_i = Integer.parseInt(infraInvestments.getText().toString());
		} catch (NumberFormatException e) {
			infraInvestments_i = 0;
		}
        try {
        	housingInterest_i = Integer.parseInt(housingInterest.getText().toString());
		} catch (NumberFormatException e) {
			housingInterest_i = 0;
		}
        try {
        	medicalPremium_i =  Integer.parseInt(medicalPremium.getText().toString());
		} catch (NumberFormatException e) {
			medicalPremium_i = 0;
		}
        
        int final_tax = calculateTax(income_i, investments_i, infraInvestments_i, housingInterest_i, medicalPremium_i); 
        calculatedTax.setText("" + final_tax);
        
    }
    
    public int calculateTax(int income, int investments, int infraInvestments, int housingInterest, int medicalPremium){
    	investments = Math.min(0, Math.max(investments, 100000));
    	infraInvestments = Math.min(0, Math.max(infraInvestments, 20000));
    	housingInterest =  Math.min(0, Math.max(housingInterest, 15000));
    	medicalPremium =   Math.min(0, Math.max(housingInterest, 35000));
    	int taxableIncome = income - (investments+infraInvestments+housingInterest+medicalPremium);
    	
    	return (int)getTax(taxableIncome);
    }
    
    public double getTax(int taxableIncome){
        double taxOnThisSlab;
        if (taxableIncome < 160000) {
            return 0;
        }
        else if (taxableIncome < 500000){
            taxOnThisSlab = 0.1 * (taxableIncome - 160000);
            return taxOnThisSlab;
        }
        else if (taxableIncome < 800000){
            taxOnThisSlab = 0.2 * (taxableIncome - 500000);
            return taxOnThisSlab + 34000;
        
        }
        else {
            taxOnThisSlab = 0.3 * (taxableIncome - 800000);
            return taxOnThisSlab + 94000;
        }
        
    }
}