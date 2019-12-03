package com.sadataljony.app.android.showalertdialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnShowAlertDialogWithSingleButton, mBtnShowAlertDialogWithDoubleButton, mBtnShowAlertDialogWithTripleButton,
            mBtnShowAlertDialogWithIcon, mBtnShowAlertDialogWithTitleOnly, mBtnShowAlertDialogWithMessageOnly, mBtnShowAlertDialogWithCustomLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUi();
    }

    private void initUi() {
        //initialize ui component
        mBtnShowAlertDialogWithSingleButton = findViewById(R.id.btnSingleButton);
        mBtnShowAlertDialogWithDoubleButton = findViewById(R.id.btnDoubleButton);
        mBtnShowAlertDialogWithTripleButton = findViewById(R.id.btnListTripleButton);
        mBtnShowAlertDialogWithIcon = findViewById(R.id.btnIconOnly);
        mBtnShowAlertDialogWithTitleOnly = findViewById(R.id.btnTitleOnly);
        mBtnShowAlertDialogWithMessageOnly = findViewById(R.id.btnMessageOnly);
        mBtnShowAlertDialogWithCustomLayout = findViewById(R.id.btnCustomAlertDialog);

        //apply click listener to button
        mBtnShowAlertDialogWithSingleButton.setOnClickListener(this);
        mBtnShowAlertDialogWithDoubleButton.setOnClickListener(this);
        mBtnShowAlertDialogWithTripleButton.setOnClickListener(this);
        mBtnShowAlertDialogWithIcon.setOnClickListener(this);
        mBtnShowAlertDialogWithTitleOnly.setOnClickListener(this);
        mBtnShowAlertDialogWithMessageOnly.setOnClickListener(this);
        mBtnShowAlertDialogWithCustomLayout.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {

        if (v == mBtnShowAlertDialogWithSingleButton) {
            new AlertDialog.Builder(this)
                    .setTitle("Single Button")
                    .setMessage("AlertDialog with single button.")
                    .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"Close",Toast.LENGTH_LONG).show();
                        }
                    })
                    .show();
        }

        if (v == mBtnShowAlertDialogWithDoubleButton) {
            new AlertDialog.Builder(this)
                    .setTitle("Double Button")
                    .setMessage("AlertDialog with double button.")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"Ok",Toast.LENGTH_LONG).show();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_LONG).show();
                        }
                    })
                    .show();
        }

        if (v == mBtnShowAlertDialogWithTripleButton) {
            new AlertDialog.Builder(this)
                    .setTitle("Triple Button")
                    .setMessage("AlertDialog with triple button.")
                    .setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"Ok",Toast.LENGTH_LONG).show();
                        }
                    })
                    .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"Cancel",Toast.LENGTH_LONG).show();
                        }
                    })
                    .setNeutralButton("Continue", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"Continue",Toast.LENGTH_LONG).show();
                        }
                    })
                    .show();
        }

        if (v == mBtnShowAlertDialogWithIcon) {
            new AlertDialog.Builder(this)
                    .setIcon(R.drawable.icon_alert)
                    .setTitle("Showing Icon")
                    .setMessage("AlertDialog with Icon.")
                    .setNegativeButton("Close", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Toast.makeText(MainActivity.this,"Close",Toast.LENGTH_LONG).show();
                        }
                    })
                    .show();
        }

        if (v == mBtnShowAlertDialogWithTitleOnly) {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(MainActivity.this);
            }
            builder.setTitle("Title Only").show();
        }

        if (v == mBtnShowAlertDialogWithMessageOnly) {
            AlertDialog.Builder builder;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                builder = new AlertDialog.Builder(MainActivity.this, android.R.style.Theme_Material_Dialog_Alert);
            } else {
                builder = new AlertDialog.Builder(MainActivity.this);
            }
            builder.setMessage("Showing only Message.").show();
        }

        if (v == mBtnShowAlertDialogWithCustomLayout) {
            final Dialog dialog = new Dialog(MainActivity.this);
            dialog.setContentView(R.layout.custom_layout_for_alert_dialog);
            Button btCancel = dialog.findViewById(R.id.btnClose);
            btCancel.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    dialog.dismiss();
                    Toast.makeText(MainActivity.this,"Close",Toast.LENGTH_LONG).show();
                }
            });
            dialog.show();
        }
    }
}
