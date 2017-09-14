package infoglobo.com.br.infoglobo.adapters;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import infoglobo.com.br.infoglobo.domain.model.Notice;
import infoglobo.com.br.infoglobo.view.NoticeActivity;

/**
 * Created by Bruno Santiago on 13/09/17.
 */

public class InfoAdapter <T, VM extends ViewDataBinding> extends RecyclerView.Adapter<InfoAdapter.RecyclerViewHolder> {
    private ArrayList<T> items;
    private int layoutId;
    private RecyclerCallback<T, VM> bindingInterface;

    public InfoAdapter(ArrayList<T> items, int layoutId, RecyclerCallback<T, VM> bindingInterface) {
        this.items = items;
        this.layoutId = layoutId;
        this.bindingInterface = bindingInterface;
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder {
        VM binding;

        public RecyclerViewHolder(View view) {
            super(view);
            binding = DataBindingUtil.bind(view);
        }

        public void bindData(final T model) {
            bindingInterface.bindData(model, binding);
            binding.getRoot().setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (model instanceof Notice) {
                        Intent intent = new Intent(binding.getRoot().getContext(), NoticeActivity.class);
                        final Notice notice = (Notice) model;
                        final String json = notice.toJson();
                        intent.putExtra("notice",json);
                        binding.getRoot().getContext().startActivity(intent);
                    }
                }
            });
        }

    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent,
                                                 int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(layoutId, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(InfoAdapter.RecyclerViewHolder holder, int position) {
        T item = items.get(position);
        holder.bindData(item);
    }

    @Override
    public int getItemCount() {
        if (items == null) {
            return 0;
        }
        return items.size();
    }
}
