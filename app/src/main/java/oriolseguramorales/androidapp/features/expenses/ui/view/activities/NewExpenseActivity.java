package oriolseguramorales.androidapp.features.expenses.ui.view.activities;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;

import javax.inject.Inject;

import oriolseguramorales.androidapp.R;
import oriolseguramorales.androidapp.core.application.AndroidAppApplication;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;
import oriolseguramorales.androidapp.features.expenses.ui.presenter.NewExpensePresenter;

public class NewExpenseActivity extends AppCompatActivity implements NewExpensePresenter.View{

    private EditText dateEditText;
    private EditText nameEditText;
    private EditText valueEditText;
    private Button saveButton;
    private int year;
    private int month;
    private int dayOfMonth;

    private boolean saved = false;

    @Inject
    NewExpensePresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_expense);

        initInjection();
        bindViews();
        initPresenter();
        initFields();

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    private void initInjection() {
        ((AndroidAppApplication)getApplication()).getAppComponent().inject(this);

    }

    private void bindViews() {
        dateEditText = findViewById(R.id.date_edittext);
        nameEditText = findViewById(R.id.name_editText);
        valueEditText = findViewById(R.id.value_editText);
        saveButton = findViewById(R.id.save_button);
    }

    private void initPresenter() {
        presenter.setView(this);
    }

    private void initFields() {
        Calendar cal = Calendar.getInstance();
        dateEditText.setText(cal.get(Calendar.YEAR)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DAY_OF_MONTH));
        dateEditText.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            DatePickerDialog datepicker = new DatePickerDialog(NewExpenseActivity.this, (view, year, month, dayOfMonth) -> {
                this.year = year;
                this.month = month;
                this.dayOfMonth = dayOfMonth;
                dateEditText.setText(year+"/"+(month+1)+"/"+dayOfMonth);
            },calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
            datepicker.show();
        });

        saveButton.setOnClickListener(v -> {
            Calendar calendar = Calendar.getInstance();
            calendar.set(Calendar.YEAR, year);
            calendar.set(Calendar.MONTH, month);
            calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            //Faltaría validar que todos los datos estén informados y tengan el formato correcto

            Expense expense = new Expense(calendar.getTime(), nameEditText.getText().toString(), Float.parseFloat(valueEditText.getText().toString()), "€");

            presenter.saveExpense(expense);
        });
    }

    @Override
    public void onSaveExpensesOK() {
        saved = true;
        Calendar cal = Calendar.getInstance();
        dateEditText.setText(cal.get(Calendar.YEAR)+"/"+(cal.get(Calendar.MONTH)+1)+"/"+cal.get(Calendar.DAY_OF_MONTH));
        nameEditText.setText("");
        valueEditText.setText("");
        Toast.makeText(this, "Gasto añadido", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onSaveExpensesError(Throwable e) {
        //mostrar error
    }
}
