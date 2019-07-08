package oriolseguramorales.androidapp.features.expenses.domain.usecase;

import io.reactivex.Observable;
import io.reactivex.Scheduler;
import oriolseguramorales.androidapp.core.base.BaseUseCase;
import oriolseguramorales.androidapp.features.expenses.data.mapper.ExpensesEntityMapper;
import oriolseguramorales.androidapp.features.expenses.data.repository.ExpensesRepository;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;

public class SaveExpenseUseCase extends BaseUseCase<String, Expense> {

    private ExpensesRepository repository;

    public SaveExpenseUseCase(ExpensesRepository repository, Scheduler observeOnScheduler) {
        super(observeOnScheduler);
        this.repository = repository;
    }

    @Override
    public Observable<String> buildUseCaseObservable(Expense expense) {
        return repository.saveNewExpense(ExpensesEntityMapper.map(expense));
    }
}
