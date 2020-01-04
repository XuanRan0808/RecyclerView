package com.XuanRan.recyclerview;

/**
 * Created by jzman on 2017/5/13 0013.
 */



import android.content.*;
import android.support.v7.widget.*;
import android.view.*;
import android.widget.*;
import java.util.*;
import android.view.View.*;
import android.graphics.*;

public class Rvadapter extends RecyclerView.Adapter<Rvadapter.DataViewHolder>
{
    private Context mContext;
    private ArrayList<String> mList;

    public Rvadapter() {
		
	}

    public Rvadapter(Context mContext, ArrayList<String> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    //用于创建ViewHolder
    @Override
    public DataViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(R.layout.Litem,null);
        //使用代码设置宽高（xml布局设置无效时）
        view.setLayoutParams(new ViewGroup.LayoutParams(
								 ViewGroup.LayoutParams.MATCH_PARENT,
								 ViewGroup.LayoutParams.WRAP_CONTENT));
        DataViewHolder holder = new DataViewHolder(view);
        return holder;
    }
    //绑定数据
    @Override
    public void onBindViewHolder(DataViewHolder holder, final int position) {
        holder.tv_data.setText(mList.get(position));
		if(holder.bn.getText().toString().equals("第2条数据")){
			holder.bn.setTextColor(Color.RED);
		}
		holder.bn.setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					if(position==2){
						throw new RuntimeException("点击了"+position);
					}
					
				}
			});
    }
    //数据总数
    @Override
    public int getItemCount() {
        return mList.size();
    }

    //创建ViewHolder
    public static class DataViewHolder extends RecyclerView.ViewHolder{
        TextView tv_data;
		Button bn;
        public DataViewHolder(View itemView) {
            super(itemView);
            tv_data = (TextView) itemView.findViewById(R.id.tv_recycle);
			bn=itemView.findViewById(R.id.tv_recycle);
        }
    }}
