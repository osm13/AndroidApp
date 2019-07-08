package oriolseguramorales.androidapp.features.expenses.data.datasource;

import java.util.ArrayList;
import java.util.List;

import io.reactivex.Observable;
import oriolseguramorales.androidapp.features.expenses.data.entity.ExpensesEntity;
import oriolseguramorales.androidapp.features.expenses.data.mapper.ExpensesEntityMapper;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;


public class RESTDataSource implements ExpensesDataSource {

    private static ArrayList<ExpensesEntity> expensesList;

    public RESTDataSource() {
        expensesList = new ArrayList<>();
        expensesList.add(new ExpensesEntity("01/03/2019", "Gasolina", "30", "€"));
        expensesList.add(new ExpensesEntity("24/02/2019", "2 Entradas de cine", "24.5", "€"));
        expensesList.add(new ExpensesEntity("24/02/2019", "Compra semana", "70", "€"));
    }

    @Override
    public Observable<List<Expense>> getExpensesList() {
        return Observable.create(emitter -> {
            try {
                if (expensesList != null) {
                    emitter.onNext(ExpensesEntityMapper.map(expensesList));
                    emitter.onComplete();
                } else {
                    emitter.onError(new Throwable("error"));
                }
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
    }

    @Override
    public Observable<String> saveNewExpense(ExpensesEntity expense) {
        expensesList.add(expense);
        return Observable.create(emitter -> {
            emitter.onNext("OK");
            emitter.onComplete();
        });
    }
}
