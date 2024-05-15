package com.example.retrofitwithrxjava.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofitwithrxjava.databinding.DataItemBinding;
import com.example.retrofitwithrxjava.model.User;

import java.util.ArrayList;
import java.util.List;

public class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    List<User> mData = new ArrayList<>();
    Context context;

    public DataAdapter(List<User> mData, Context context) {
        this.mData = mData;
        this.context = context;
    }

  public   void updateData(List<User> data) {
//        this.mData = data;
        mData.clear();
        mData.addAll(data);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        DataItemBinding binding = DataItemBinding.inflate(LayoutInflater.from(parent.getContext()), parent, false);

        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        User item = mData.get(position);
        holder.binding.name.setText(item.name);
        holder.binding.email.setText(item.email);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        DataItemBinding binding;

        public ViewHolder(@NonNull DataItemBinding itemView) {
            super(itemView.getRoot());
            this.binding = itemView;
        }
    }
}
