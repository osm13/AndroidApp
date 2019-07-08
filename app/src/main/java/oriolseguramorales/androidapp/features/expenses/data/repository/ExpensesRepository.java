package oriolseguramorales.androidapp.features.expenses.data.repository;

import java.util.List;

import io.reactivex.Observable;
import oriolseguramorales.androidapp.features.expenses.data.entity.ExpensesEntity;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;

public interface ExpensesRepository {

    Observable<List<Expense>> getExpensesList();
    Observable<String> saveNewExpense(ExpensesEntity expense);
}
