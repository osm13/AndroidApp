package oriolseguramorales.androidapp.features.expenses.ui.view.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.List;

import javax.inject.Inject;

import oriolseguramorales.androidapp.R;
import oriolseguramorales.androidapp.core.application.AndroidAppApplication;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;
import oriolseguramorales.androidapp.features.expenses.ui.presenter.ExpensesListPresenter;
import oriolseguramorales.androidapp.features.expenses.ui.view.adapter.ExpansesListAdapter;

public class ExpensesListActivity extends AppCompatActivity implements ExpensesListPresenter.View {

    public static final int REQUEST_CODE = 0001;
    public static final String EXTRA_SAVED = "ExtraSaved";

    private RecyclerView recyclerView;
    private ExpansesListAdapter adapter;
    private Button button;

    @Inject
    ExpensesListPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_expenses_list);

        initInjection();
        bindViews();
        initPresenter();
        initRecyclerview();
        initButton();
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(presenter != null) {
            presenter.getExpensesList();
        }
    }

    private void initPresenter() {
        presenter.setView(this);
        presenter.getExpensesList();
    }

    private void initInjection() {
        ((AndroidAppApplication)getApplication()).getAppComponent().inject(this);
    }
    private void bindViews() {
        recyclerView = findViewById(R.id.recyclerview);
        button = findViewById(R.id.new_expense_button);
    }
    private void initRecyclerview() {
        adapter = new ExpansesListAdapter();
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private void initButton() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ExpensesListActivity.this, NewExpenseActivity.class);
                startActivityForResult(intent, REQUEST_CODE);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_CODE && resultCode == RESULT_OK){
            if(data != null && data.hasExtra(EXTRA_SAVED)) {
                if(data.getBooleanExtra(EXTRA_SAVED, false)) {
                    presenter.getExpensesList();
                }
            }
        }
    }

    @Override
    public void onGetExpensesListOK(List<Expense> expenseList) {
        adapter.setData(expenseList);
        adapter.notifyDataSetChanged();
    }

    @Override
    public void onGetExpensesListError(Throwable e) {
        //se deberia tratar el error obtenido, pero para la prueba se muestra un toast.
        Toast.makeText(this, "Error al cargar los datos", Toast.LENGTH_SHORT).show();
    }
}
