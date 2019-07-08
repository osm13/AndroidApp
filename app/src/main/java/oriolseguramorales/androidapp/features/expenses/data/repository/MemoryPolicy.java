package oriolseguramorales.androidapp.features.expenses.data.repository;

import java.util.List;

import io.reactivex.Observable;
import oriolseguramorales.androidapp.features.expenses.data.datasource.DatabaseDataSource;
import oriolseguramorales.androidapp.features.expenses.data.datasource.ExpensesDataSource;
import oriolseguramorales.androidapp.features.expenses.data.datasource.RESTDataSource;
import oriolseguramorales.androidapp.features.expenses.data.entity.ExpensesEntity;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;

/**
 *
 * En esta clase decidimos como obtener los datos, por ejemplo podemos primero acceder a la base de
 * datos interna y en caso de no haber dator, invocamos una petición REST.
 */
public class MemoryPolicy implements ExpensesRepository{

    private ExpensesDataSource database;
    private ExpensesDataSource rest;

    public MemoryPolicy(){
        database = new DatabaseDataSource();
        rest = new RESTDataSource();
    }

    @Override
    public Observable<List<Expense>> getExpensesList() {
        Observable<List<Expense>> expenseList;
        expenseList = database.getExpensesList();
        if(expenseList == null) {
            expenseList = rest.getExpensesList();
        }
        return expenseList;
    }

    @Override
    public Observable<String> saveNewExpense(ExpensesEntity expense) {
        return rest.saveNewExpense(expense);
    }

}
