package oriolseguramorales.androidapp.features.expenses.data.datasource;

import java.util.List;

import io.reactivex.Observable;
import oriolseguramorales.androidapp.features.expenses.data.entity.ExpensesEntity;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;

public class DatabaseDataSource implements ExpensesDataSource {
    @Override
    public Observable<List<Expense>> getExpensesList() {
        return null;
    }

    @Override
    public Observable<String> saveNewExpense(ExpensesEntity expense) {
        return null;
    }
}
