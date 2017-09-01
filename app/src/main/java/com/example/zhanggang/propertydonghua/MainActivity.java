package com.example.zhanggang.propertydonghua;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.wuxiaolong.pullloadmorerecyclerview.PullLoadMoreRecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    PullLoadMoreRecyclerView recyclerView;
    List<String> list = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();

        recyclerView = (PullLoadMoreRecyclerView) findViewById(R.id.recyclerview);

        recyclerView.setLinearLayout();

        final MyAdapter adapter = new MyAdapter(list);
        recyclerView.setAdapter(adapter);

        recyclerView.setOnPullLoadMoreListener(new PullLoadMoreRecyclerView.PullLoadMoreListener() {
            @Override
            public void onRefresh() {
                list.clear();
                init();
                recyclerView.setPullLoadMoreCompleted();
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onLoadMore() {
                init();
                recyclerView.setPullLoadMoreCompleted();
                adapter.notifyDataSetChanged();
            }
        });
    }

    private void init() {
        for (int i = 0; i < 100; i++) {
            list.add("第" + i);
        }
    }
}
