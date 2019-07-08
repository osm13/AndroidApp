package oriolseguramorales.androidapp.features.expenses.data.mapper;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import oriolseguramorales.androidapp.core.utils.DateUtils;
import oriolseguramorales.androidapp.features.expenses.data.entity.ExpensesEntity;
import oriolseguramorales.androidapp.features.expenses.domain.model.Expense;

public class ExpensesEntityMapper {

    public static List<Expense> map(List<ExpensesEntity> expensesEntityList){
        List<Expense> expenseList = new ArrayList<>();
        for(ExpensesEntity entity : expensesEntityList) {

            expenseList.add(new Expense(DateUtils.dateFromString(entity.getDate()),
                    entity.getName(), Float.parseFloat(entity.getValue()), entity.getValueType()));
        }

        return expenseList;
    }

    public static ExpensesEntity map(Expense expense) {
        return new ExpensesEntity(DateUtils.dateToString(expense.getDate()), expense.getName(),
                String.valueOf(expense.getValue()), expense.getValueType());
    }
}
