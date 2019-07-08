package oriolseguramorales.androidapp.features.expenses.domain.usecase;

import java.util.List;

import io.reactivex.Observable;
import oriolseguramorales.androidapp.core.base.BaseUseCase;
import oriolseguramorales.androidapp.features.expenses.data.repository.ExpensesRepository;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;

public class GetExpensesListUseCase extends BaseUseCase<List<Expense>, Void> {

    private ExpensesRepository repository;

    public GetExpensesListUseCase(ExpensesRepository repository) {
        super();
        this.repository = repository;
    }

    @Override
    public Observable<List<Expense>> buildUseCaseObservable(Void aVoid) {
        return repository.getExpensesList();
    }
}
