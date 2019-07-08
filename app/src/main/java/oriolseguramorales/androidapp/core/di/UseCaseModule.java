package oriolseguramorales.androidapp.core.di;

import dagger.Module;
import dagger.Provides;
import oriolseguramorales.androidapp.features.expenses.data.repository.ExpensesRepository;
import oriolseguramorales.androidapp.features.expenses.domain.usecase.GetExpensesListUseCase;
import oriolseguramorales.androidapp.features.expenses.domain.usecase.SaveExpenseUseCase;

@Module
public class UseCaseModule {

    @Provides
    GetExpensesListUseCase provideGetExpensesListUseCase(ExpensesRepository repository){
        return new GetExpensesListUseCase(repository);
    }

    @Provides
    SaveExpenseUseCase provideSaveExpenseUseCase(ExpensesRepository repository){
        return new SaveExpenseUseCase(repository);
    }
}
