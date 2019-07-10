package oriolseguramorales.androidapp.features.expenses.data.datasource;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import io.reactivex.Observable;
import io.reactivex.observers.TestObserver;
import oriolseguramorales.androidapp.features.expenses.data.entity.ExpensesEntity;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;


public class RESTDataSourceTest {

    private RESTDataSource restDataSource;

    @Before
    public void setUp(){
        restDataSource = new RESTDataSource();
    }

    @Test
    public void saveNewExpense() {
        ExpensesEntity expensesEntity = new ExpensesEntity("02/04/2019", "Test", "90", "€");


        Observable<String> observable = restDataSource.saveNewExpense(expensesEntity);
        TestObserver<String> testObserver = new TestObserver<>();
        observable.subscribe(testObserver);

        testObserver.assertNoErrors();
        testObserver.assertComplete();
        testObserver.assertValueCount(1);

        Assert.assertEquals("OK", testObserver.values().get(0));
    }

    @Test
    public void getExpensesListOK() {
        Observable<List<Expense>> observable = restDataSource.getExpensesList();
        TestObserver<List<Expense>> testObserver = new TestObserver<>();
        observable.subscribe(testObserver);

        testObserver.assertNoErrors();
        testObserver.assertComplete();
        testObserver.assertValueCount(1);

        Assert.assertEquals(3, testObserver.values().get(0).size());
        Assert.assertEquals("Gasolina", testObserver.values().get(0).get(0).getName());
    }

    @Test
    public void getExpensesListError() {

        //se cambia la visivilidad de los datos de RestDataSource para simular que vienen de una peticion REST
        RESTDataSource.expensesList = null;

        Observable<List<Expense>> observable = restDataSource.getExpensesList();
        TestObserver<List<Expense>> testObserver = new TestObserver<>();
        observable.subscribe(testObserver);

        testObserver.assertErrorMessage("error");
        testObserver.assertNotComplete();

    }


}