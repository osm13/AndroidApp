package oriolseguramorales.androidapp.features.expenses.ui.view.adapter.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import oriolseguramorales.androidapp.R;
import oriolseguramorales.androidapp.core.utils.DateUtils;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;

public class ExpanseViewHolder extends RecyclerView.ViewHolder {

    private TextView dateTextView;
    private TextView nameTextView;
    private TextView valueTextView;
    private TextView valueTypeTextView;


    public ExpanseViewHolder(View itemView) {
        super(itemView);
        dateTextView = itemView.findViewById(R.id.expense_item_date);
        nameTextView = itemView.findViewById(R.id.expense_item_name);
        valueTextView = itemView.findViewById(R.id.expense_item_value);
        valueTypeTextView = itemView.findViewById(R.id.expense_item_value_type);
    }

    public void bindData(Expense expense) {
        dateTextView.setText(DateUtils.formatDate(expense.getDate()));
        nameTextView.setText(expense.getName());
        valueTextView.setText(String.valueOf(expense.getValue()));
        valueTypeTextView.setText(expense.getValueType());
    }
}
