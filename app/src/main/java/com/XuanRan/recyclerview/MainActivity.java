package com.XuanRan.recyclerview;

import android.os.*;
import android.support.v7.app.*;
import android.support.v7.widget.*;
import java.util.*;

public class MainActivity extends AppCompatActivity
{
    private RecyclerView rv;
    Rvadapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
	{
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
		Toolbar toolbar=findViewById(R.id.toolbar);
		setSupportActionBar(toolbar);
        rv = (RecyclerView) findViewById(R.id.rv);
        //设置布局管理器
        rv.setLayoutManager(new LinearLayoutManager(this));//线性
//        rv.setLayoutManager(new GridLayoutManager(this,4));//线性
        rv.setLayoutManager(new StaggeredGridLayoutManager(4, StaggeredGridLayoutManager.VERTICAL));//线性
        adapter = new Rvadapter(this, initData());
        rv.setAdapter(adapter);

    }
    public static ArrayList<String> initData()
	{
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i=0;i < 500;i++)
		{
            arrayList.add("第" + i + "条数据");
        }
        return arrayList;
    }
}
