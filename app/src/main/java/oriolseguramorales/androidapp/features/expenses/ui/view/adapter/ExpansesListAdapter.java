package oriolseguramorales.androidapp.features.expenses.ui.view.adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import oriolseguramorales.androidapp.R;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;
import oriolseguramorales.androidapp.features.expenses.ui.view.adapter.viewholder.ExpanseViewHolder;

public class ExpansesListAdapter extends RecyclerView.Adapter<ExpanseViewHolder> {

    private List<Expense> expenseList;

    public ExpansesListAdapter() {
        expenseList = new ArrayList<>();
    }

    @NonNull
    @Override
    public ExpanseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.expenses_list_item, parent, false);
        return new ExpanseViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ExpanseViewHolder holder, int position) {
        holder.bindData(expenseList.get(position));
    }

    @Override
    public int getItemCount() {
        return expenseList.size();
    }

    public void setData(List<Expense> data) {
        expenseList = data;
    }
}
