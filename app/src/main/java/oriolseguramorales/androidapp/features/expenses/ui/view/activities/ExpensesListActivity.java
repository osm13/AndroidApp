package oriolseguramorales.androidapp.features.expenses.ui.view.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;

import java.util.List;

import oriolseguramorales.androidapp.R;
import oriolseguramorales.androidapp.core.application.AndroidAppApplication;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;
import oriolseguramorales.androidapp.features.expenses.ui.presenter.ExpensesListPresenter;

public class ExpensesListActivity extends AppCompatActivity implements ExpensesListPresenter.View {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_list);

        initInjection();
        bindViews();
        initRecyclerview();
    }

    private void initInjection() {
        ((AndroidAppApplication)getApplication()).getAppComponent().inject(this);
    }
    private void bindViews() {
    }
    private void initRecyclerview() {
    }

    @Override
    public void onGetExpensesListOK(List<Expense> expenseList) {

    }

    @Override
    public void onGetExpensesListError(Exception e) {

    }
}
