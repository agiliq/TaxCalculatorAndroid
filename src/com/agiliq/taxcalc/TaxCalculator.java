package com.agiliq.taxcalc;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
        income_i = Integer.parseInt(income.getText().toString());
        investments_i = Integer.parseInt(investments.getText().toString());
        infraInvestments_i = Integer.parseInt(infraInvestments.getText().toString());
        housingInterest_i = Integer.parseInt(housingInterest.getText().toString());
        medicalPremium_i =  Integer.parseInt(medicalPremium.getText().toString());
        int final_tax = calculateTax(income_i, investments_i, infraInvestments_i, housingInterest_i, medicalPremium_i); 
        calculatedTax.setText("" + final_tax);
        
    }
    
    public int calculateTax(int income, int investments, int infraInvestments, int housingInterest, int medicalPremium){
    	return 1000;
    }
}