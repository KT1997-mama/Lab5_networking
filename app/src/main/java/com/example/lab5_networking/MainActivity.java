package com.example.lab5_networking;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.example.lab5_networking.adapter.RecycleAdapter;
import com.example.lab5_networking.api.ApiService;
import com.example.lab5_networking.model.Items;
import com.example.lab5_networking.model.Value;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private RecycleAdapter recycleAdapter;
    private LinearLayoutManager linearLayoutManager;
    private EditText edtSearch;
    private List<Value> mlist;
    private Button btnSearch;
    private ProgressBar progressBar;
    private boolean isLoading;
    private boolean isLastPage;
    private int currentPage = 1;
    private int totalPage = 5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();
        recycleAdapter = new RecycleAdapter();
        linearLayoutManager = new LinearLayoutManager(this);
        mlist = new ArrayList<>();
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickApi();
                hideKeyBroad();
            }
        });
        recyclerView.addOnScrollListener(new PageScrollListener(linearLayoutManager) {
            @Override
            public void loadMoreItem() {
                isLoading = true;
                progressBar.setVisibility(View.VISIBLE);
                currentPage += 1;
                loadNextPage();
            }

            @Override
            public boolean isLoading() {
                return isLoading;
            }

            @Override
            public boolean isLate() {
                return isLastPage;
            }
        });
    }

    private void loadNextPage() {
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                List<Value> list = getData(mlist);
                mlist.addAll(list);
                recycleAdapter.notifyDataSetChanged();
                isLoading = false;
                progressBar.setVisibility(View.GONE);
                if (currentPage == totalPage) {
                    isLastPage = true;
                }
            }
        }, 2000);
    }

    public void onClickApi() {
        String str = edtSearch.getText().toString().trim();
        ApiService.callApi.Call(str).enqueue(new Callback<Items>() {
            @Override
            public void onResponse(Call<Items> call, Response<Items> response) {
                Toast.makeText(MainActivity.this, "Successfully", Toast.LENGTH_SHORT).show();
                mlist = response.body().getValueList();
                recycleAdapter.setData(getData(mlist), MainActivity.this);
                recyclerView.setLayoutManager(linearLayoutManager);
                recyclerView.setAdapter(recycleAdapter);
            }

            @Override
            public void onFailure(Call<Items> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Erorr", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void initUI() {
        recyclerView = findViewById(R.id.recycle);
        edtSearch = findViewById(R.id.edtSearch);
        btnSearch = findViewById(R.id.btnSearch);
        progressBar = findViewById(R.id.progress);
    }

    public void hideKeyBroad() {
        InputMethodManager imm = (InputMethodManager) getSystemService(Activity.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), 0);
    }

    private List<Value> getData(List<Value> glist) {
        Toast.makeText(this, "Load data page:" + currentPage, Toast.LENGTH_SHORT).show();
        return glist;
    }
}