package com.example.jahn.pantalladeudas;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.support.v4.app.DialogFragment;
import android.support.annotation.NonNull;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;


public class DebtsIncomeDialog extends DialogFragment {

    private DebtsIncomeListener debtsIncomeListenerDialog;
    @NonNull
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        View view = getActivity().getLayoutInflater().inflate(R.layout.request_debts_or_icome_dialog,null);
        builder.setView(view);

        final EditText addDescriptionDialog = (EditText) view.findViewById(R.id.addDescriptionDialog);
        final EditText addMoneyDialog = (EditText) view.findViewById(R.id.addEfectiveDialog);

        final ImageView addMoneyDialogIcon = (ImageView) view.findViewById(R.id.addMoneyDialogIcon);
        ImageView decresesDialogIcon = (ImageView) view.findViewById(R.id.decresesMoneyDialogIcon);

        addMoneyDialogIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descriptionDataDialog = addDescriptionDialog.getText().toString();
                addMoneyDialog.setTextColor(Color.GREEN);
                int resultPositve = Integer.parseInt(addMoneyDialog.getText().toString());
                debtsIncomeListenerDialog.aplyTexts(descriptionDataDialog ,resultPositve);



            }
        });

        decresesDialogIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String descriptionDataDialog = addDescriptionDialog.getText().toString();
                int addMoneyDialogIconPositive = Integer.parseInt(addMoneyDialog.getText().toString());
                addMoneyDialog.setTextColor(Color.RED);
                int resultNegative = addMoneyDialogIconPositive*(-1);
                debtsIncomeListenerDialog.aplyTexts(descriptionDataDialog ,resultNegative);


            }
        });
        return builder.create();
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        try {
            debtsIncomeListenerDialog = (DebtsIncomeListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString()+"must implement DebtsIncomeListener") ;
        }


    }




    public interface DebtsIncomeListener{
        void aplyTexts (String descriptionDataDialog, int moneyDataDialog);

    }
}
