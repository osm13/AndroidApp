package oriolseguramorales.androidapp.core.di;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Scheduler;
import io.reactivex.android.schedulers.AndroidSchedulers;
import oriolseguramorales.androidapp.features.expenses.data.repository.ExpensesRepository;
import oriolseguramorales.androidapp.features.expenses.domain.usecase.GetExpensesListUseCase;
import oriolseguramorales.androidapp.features.expenses.domain.usecase.SaveExpenseUseCase;

@Module
public class UseCaseModule {

    @Provides
    GetExpensesListUseCase provideGetExpensesListUseCase(ExpensesRepository repository, Scheduler observeOnScheduler){
        return new GetExpensesListUseCase(repository, observeOnScheduler);
    }

    @Provides
    SaveExpenseUseCase provideSaveExpenseUseCase(ExpensesRepository repository, Scheduler observeOnScheduler){
        return new SaveExpenseUseCase(repository, observeOnScheduler);
    }

    @Provides
    @Singleton
    Scheduler providesScheduler() {
        return AndroidSchedulers.mainThread();
    }
}
