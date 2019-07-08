package oriolseguramorales.androidapp.core.di;

import dagger.Module;
import dagger.Provides;
import oriolseguramorales.androidapp.features.expenses.domain.usecase.GetExpensesListUseCase;
import oriolseguramorales.androidapp.features.expenses.domain.usecase.SaveExpenseUseCase;
import oriolseguramorales.androidapp.features.expenses.ui.presenter.ExpensesListPresenter;
import oriolseguramorales.androidapp.features.expenses.ui.presenter.NewExpensePresenter;
import oriolseguramorales.androidapp.features.expenses.ui.presenter.impl.ExpensesListPresenterImpl;
import oriolseguramorales.androidapp.features.expenses.ui.presenter.impl.NewExpensePresenterImpl;

@Module
public class PresenterModule {

    @Provides
    ExpensesListPresenter provideExpensesListPresenter(GetExpensesListUseCase getExpensesListUseCase){
        return new ExpensesListPresenterImpl(getExpensesListUseCase);
    }

    @Provides
    NewExpensePresenter provideNewExpensePresenter(SaveExpenseUseCase saveExpenseUseCase){
        return new NewExpensePresenterImpl(saveExpenseUseCase);
    }
}
