package oriolseguramorales.androidapp.core.di;

import dagger.Module;
import dagger.Provides;
import oriolseguramorales.androidapp.features.expenses.data.repository.ExpensesRepository;
import oriolseguramorales.androidapp.features.expenses.data.repository.MemoryPolicy;

@Module
public class RepositoryModule {

    @Provides
    ExpensesRepository providesExpensesRepository(){
        return new MemoryPolicy();
    }
}
