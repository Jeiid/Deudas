package com.example.jahn.pantalladeudas;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
public class DebtsAdapter extends ArrayAdapter<DataDebts> implements DebtsIncomeDialog.DebtsIncomeListener{
    Calendar calendar;
    private ArrayList<DataDebts> dataDebtsList;
    private Context context;
    private int layoutId;

        public DebtsAdapter(@NonNull Context context, int resource, @NonNull List objects) {
            super(context, resource, objects);
            this.context=context;
            layoutId= resource;
            dataDebtsList= new ArrayList<>(objects);
        }
        static class ViewHolder{
            TextView dayOfMonthTextView ;
            TextView yearMonthTextView  ;
            TextView dayOfWeek  ;
            TextView descriptionText;
            TextView moneyText;

            public ViewHolder(View vista){
                dayOfMonthTextView = vista.findViewById(R.id.textDayMonth);
                yearMonthTextView = vista.findViewById(R.id.textYearMonth);
                dayOfWeek = vista.findViewById(R.id.textDayWeek);
                descriptionText = vista.findViewById(R.id.textDescription);
                moneyText = vista.findViewById(R.id.textMoney);
            }
        }
        @NonNull
        @Override
        public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
            ViewHolder holder;

            if(convertView ==null) {
                LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                convertView = inflater.inflate(layoutId, null);
                holder = new ViewHolder(convertView);
                convertView.setTag(holder);
            }else {
                holder = (ViewHolder) convertView.getTag();
            }
            DataDebts dataDebts = dataDebtsList.get(position);
                holder.dayOfMonthTextView.setText(dataDebts.getDayMonth());
                holder.yearMonthTextView.setText(dataDebts.getYearMonth());
                holder.dayOfWeek.setText(dataDebts.getDayWeek());
                holder.descriptionText.setText(dataDebts.);
                holder.moneyText.setText();
            return convertView;
        }
        
        private void drawDate(Date dateToDraw) {
            SimpleDateFormat dateFormatDayOfMonth = new SimpleDateFormat("dd");
            SimpleDateFormat dateFormatYearMonth = new SimpleDateFormat("yyyy.MM");
            SimpleDateFormat dateFormatDayOfWeek = new SimpleDateFormat("EEEE");

                dayOfMonthTextView.setText(dateFormatDayOfMonth.format(calendar.getTime()));
                yearMonthTextView.setText(dateFormatYearMonth.format(calendar.getTime()));
                dayOfWeek.setText(dateFormatDayOfWeek.format(calendar.getTime()));
            }
       @Override
        public void aplyTexts(String descriptionDataDialog, int moneyDataDialog) {
            descriptionText.setText(descriptionDataDialog);
            moneyText.setText(moneyDataDialog);
    }
}
