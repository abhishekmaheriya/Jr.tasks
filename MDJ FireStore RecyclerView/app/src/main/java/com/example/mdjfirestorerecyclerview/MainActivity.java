package com.example.mdjfirestorerecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    ArrayList<model> datalist = new ArrayList<>();
    FirebaseFirestore db;
    MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new MyAdapter(this,datalist);
        db = FirebaseFirestore.getInstance();
        db.collection("students").get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        // we get the data from firebase to querydocumentSnapshot.. so we add that in list
                        List<DocumentSnapshot> list = queryDocumentSnapshots.getDocuments();
//                        System.out.println("dataset : "+ list);
                        // it will add sequentially according to the data
                        for (DocumentSnapshot d: list){
                            model obj = d.toObject(model.class);
                            datalist.add(obj);
                            System.out.println("new dataset : "+ datalist);

                        }
                        adapter.notifyDataSetChanged();
                    }
                });

    }
}