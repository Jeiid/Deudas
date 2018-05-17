package com.example.jahn.pantalladeudas;


import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;


public class MainActivity extends AppCompatActivity  {
    Calendar calendar;
    TextView dayOfMonthTextView = (TextView) findViewById(R.id.textDayMonth);
    TextView yearMonthTextView = (TextView) findViewById(R.id.textYearMonth);
    TextView dayOfWeek = (TextView) findViewById(R.id.textDayWeek);

    TextView descriptionText=findViewById(R.id.textDescription);
    TextView moneyText=findViewById(R.id.textMoney);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final ListView incomeExpensesListView = (ListView) findViewById(R.id.myListIncomeExpenses);
        final DebtsAdapter debtsAdapter = new DebtsAdapter(this, R.layout.deudas_layout, new ArrayList<DataDebts>());
        incomeExpensesListView.setAdapter(debtsAdapter);

        FloatingActionButton addDebts = (FloatingActionButton) findViewById(R.id.addDebt);

        addDebts.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {

                validateListView(debtsAdapter, incomeExpensesListView, dayOfMonthTextView, yearMonthTextView,dayOfWeek, descriptionText, moneyText);

            }
        });
    }

    private void validateListView(DebtsAdapter debtsAdapter, ListView incomeExpensesListView, TextView dayOfMonthTextView,
                                  TextView yearMonthTextView, TextView dayOfWeek, TextView  descriptionText, TextView moneyText  ){
            openDialog();

            debtsAdapter.add(new DataDebts(dayOfMonthString,yearMonthString,dayOfWeekString,descriptionString,moneyInt));
            debtsAdapter.notifyDataSetChanged();

            incomeExpensesListView.setSelection(debtsAdapter.getCount()-1);

    }



    private void openDialog(){
        DebtsIncomeDialog dialogFragmentDebtsIncome = new DebtsIncomeDialog();
        dialogFragmentDebtsIncome.show(getSupportFragmentManager(),"undialog");
    }


}
