package com.example.jahn.pantalladeudas;

import android.widget.TextView;

public class DataDebts {

    public DataDebts(String dayMonth, String yearMonth, String dayWeek, String descriptionText, int moneyIncomeExpenses) {
        this.dayMonth = dayMonth;
        YearMonth = yearMonth;
        this.dayWeek = dayWeek;
        this.descriptionText = descriptionText;
        this.moneyIncomeExpenses = moneyIncomeExpenses;
    }

    public String getDayMonth() {
        return dayMonth;
    }

    public void setDayMonth(String dayMonth) {
        this.dayMonth = dayMonth;
    }

    public String getYearMonth() {
        return YearMonth;
    }

    public void setYearMonth(String yearMonth) {
        YearMonth = yearMonth;
    }

    public String getDayWeek() {
        return dayWeek;
    }

    public void setDayWeek(String dayWeek) {
        this.dayWeek = dayWeek;
    }

    public String getDescriptionText() {
        return descriptionText;
    }

    public void setDescriptionText(String descriptionText) {
        this.descriptionText = descriptionText;
    }

    public int getMoneyIncomeExpenses() {
        return moneyIncomeExpenses;
    }

    public void setMoneyIncomeExpenses(int moneyIncomeExpenses) {
        this.moneyIncomeExpenses = moneyIncomeExpenses;
    }

    private String dayMonth;
    private String YearMonth;
    private String dayWeek;
    private String descriptionText;
    private int moneyIncomeExpenses;



}
