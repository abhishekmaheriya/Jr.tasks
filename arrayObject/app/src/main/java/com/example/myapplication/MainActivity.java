package com.example.myapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements ItemClickListener  {
    private static final String TAG = "MainActivity" ;
    RecyclerView recyclerView;
    ArrayList<Student> arrayList = new ArrayList<>();
    Adapter adapter;
    Button btnAdd, btnDelete, btnUpdate;
    AlertDialog.Builder builder;
//    private ItemClickListener itemClickListener;
    int selectedPositon;
    int selectedItems = 0;
    int temp = 0;

    ArrayList<EditText> editText1Main = new ArrayList<EditText>();   // for selected edittext
//    ArrayList<Integer> selectedList = new ArrayList<Integer>();

    @RequiresApi(api = Build.VERSION_CODES.N)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        builder = new AlertDialog.Builder(this);

        EditText editText = new EditText(getApplicationContext());

        // adding data manually in arraylist
        arrayList.add(new Student(1,"Ram"));
        arrayList.add(new Student(2,"Shyam"));
        arrayList.add(new Student(3,"Meet","Male",false));
        arrayList.add(new Student(4,"Teena","female",false));
        arrayList.add(new Student(5,"Parth","Male",false));


        // for deleting items
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (arrayList.size()>0) {
                    if (arrayList.get(selectedPositon).isSelected) {

//                    Log.d(TAG, "onClick: " + selectedList);
                            builder.setMessage(R.string.dialog_message).setTitle(R.string.dialog_title);
                            //Setting message manually and performing action on button click
                            builder.setMessage("Do you want to delete this item ?")
                                    .setCancelable(false)
                                    .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            ArrayList<Student> arrayListTemp = new ArrayList<>(); // for storing the selected items
                                            for (int i = 0; i < arrayList.size(); i++) {
                                                if (arrayList.get(i).isSelected) {
                                                    arrayListTemp.add(arrayList.get(i));
                                                }
                                            }
                                            arrayList.removeAll(arrayListTemp); // remove the items which is selected
                                            adapter.notifyDataSetChanged();  // update the whole recycler view
                                            Snackbar.make(getWindow().getDecorView().getRootView(), "Successfully deleted", Snackbar.LENGTH_LONG).show();

                                        }
                                    })
                                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                                        public void onClick(DialogInterface dialog, int id) {
                                            //  Action for No button
                                            Snackbar.make(getWindow().getDecorView().getRootView(), "You select No", Snackbar.LENGTH_LONG).show();

                                            dialog.cancel();
                                        }
                                    });
                            //Creating dialog box
                            AlertDialog alert = builder.create();
                            //Setting the title manually
                            alert.setTitle("Delete");
                            alert.show();

                    } else {
//                    Toast.makeText(MainActivity.this, "Please select", Toast.LENGTH_SHORT).show();
                        Snackbar.make(getWindow().getDecorView().getRootView(), "Please select", Snackbar.LENGTH_LONG).show();

                    }
                }else{
                    Snackbar.make(getWindow().getDecorView().getRootView(), "No items ", Snackbar.LENGTH_LONG).show();
                }
            }
        });
        // for dynamically add the items
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.add_data,null);

//                final EditText txt_inputText = (EditText)mView.findViewById(R.id.popupName);
                Button btn_okay = (Button)mView.findViewById(R.id.buttonOk);

                dialog.setView(mView);
                final AlertDialog alertDialog = dialog.create();

                alertDialog.setCanceledOnTouchOutside(false);
                btn_okay.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String name;
                        if (!editText.getText().toString().isEmpty()){
                            name = editText.getText().toString();
                            arrayList.add(new Student(1,name,"Male",false));
                            adapter.notifyDataSetChanged();
                            alertDialog.dismiss();
                        }else {
                            Snackbar.make(getWindow().getDecorView().getRootView(), "please enter the name", Snackbar.LENGTH_LONG).show();
                        }
                    }
                });
                alertDialog.show();
                adapter.notifyDataSetChanged();
            }
        });
        // for dynamically update the items



        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {if (arrayList.size() > 0) {

                ArrayList<Student> newlist = new ArrayList<>();

                for (int j = 0; j < arrayList.size(); j++) {
                    if (arrayList.get(j).isSelected)
                        newlist.add(arrayList.get(j));
                }
                if (arrayList.get(selectedPositon).isSelected) {

                    final AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                    View mView = getLayoutInflater().inflate(R.layout.add_data, null);
                    LinearLayout layout = (LinearLayout) mView.findViewById(R.id.linearLayoutChild);
//                    final EditText txt_inputText = (EditText) mView.findViewById(R.id.popupName);
                    Button btn_okay = (Button) mView.findViewById(R.id.buttonOk);
                    ArrayList<Student> student1 = new ArrayList<>();
                    editText1Main.clear();

                    for (int i = 0; i <newlist.size() ; i++) {
                        // dynamically generated edittext as per requirements
                        EditText editText1 = new EditText(getApplicationContext());
                        editText1.setLayoutParams(layout.getLayoutParams());
                        editText1.setPadding(10, 10, 10, 10);
                        editText1.setText(newlist.get(i).getName());
                        editText1.setId(i);
//                        student1.add(arrayList.get(i));
//                        student1.set(i, arrayList.get(i));
                        layout.addView(editText1);
                        editText1Main.add(editText1);

//                        arrayList.set(temp, student1);
                    }
                    student1.addAll(arrayList);
                    dialog.setView(mView);
                    final AlertDialog alertDialog = dialog.create();
                    alertDialog.setCanceledOnTouchOutside(false);
//                    txt_inputText.setText(newlist.get(temp).getName());

                    btn_okay.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            int k = 0;
                            
                            for (int i = 0; i < arrayList.size() ; i++) {
                                if (arrayList.get(i).isSelected) {
                                    student1.get(i).setName(editText1Main.get(k).getText().toString());
                                    arrayList.set(i, student1.get(i));
                                    k++;
                                }
                            }


                             adapter.notifyDataSetChanged();
                             alertDialog.dismiss();

//                            }else {
//                                Snackbar.make(getWindow().getDecorView().getRootView(), "please enter the name", Snackbar.LENGTH_LONG).show();
//                            }
                        }
                    });
                    alertDialog.show();
                    adapter.notifyDataSetChanged();
                } else {
                    Snackbar.make(getWindow().getDecorView().getRootView(), "please select", Snackbar.LENGTH_LONG).show();
                }
            }else {
                Snackbar.make(getWindow().getDecorView().getRootView(), "No items", Snackbar.LENGTH_LONG).show();

            }


            }
        });


        adapter = new Adapter(arrayList, this);
        LinearLayout linearLayout = new LinearLayout(this);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
    }
    @Override
    public void onItemClick(int position) {
//            selectedList.add(position);
            selectedPositon = position;

            // for selecting tab
            if (arrayList.get(position).isSelected) {
                arrayList.get(position).isSelected = false;
            } else {
                arrayList.get(position).isSelected = true;
            }
        adapter.notifyDataSetChanged();
    }
}