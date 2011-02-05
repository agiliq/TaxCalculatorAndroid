package com.agiliq.taxcalc;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

public class TaxCalculator extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        System.out.println("10");
        setContentView(R.layout.main);
        
        
    }
    
    public void onClick(){
    	EditText income = (EditText)findViewById(R.id.income);
        EditText investments = (EditText)findViewById(R.id.investments);
        EditText infraInvestments = (EditText)findViewById(R.id.infraInvestment);
        EditText housingInterest = (EditText)findViewById(R.id.housingInterest);
        EditText medicalPremium = (EditText)findViewById(R.id.medicalPremium);
        
        int income_i, investments_i, infraInvestments_i;
        int housingInterest_i, medicalPremium_i;
        income_i = Integer.parseInt(income.toString());
        investments_i = Integer.parseInt(investments.toString());
        infraInvestments_i = Integer.parseInt(infraInvestments.toString());
        housingInterest_i = Integer.parseInt(housingInterest.toString());
    }
}