package oriolseguramorales.androidapp.features.expenses.data.entity;

public class ExpensesEntity {
    private final String date;
    private final String name;
    private final String value;
    private final String valueType;

    public ExpensesEntity(String date, String name, String value, String valueType) {
        this.date = date;
        this.name = name;
        this.value = value;
        this.valueType = valueType;
    }

    public String getDate() {
        return date;
    }

    public String getName() {
        return name;
    }

    public String getValue() {
        return value;
    }

    public String getValueType() {
        return valueType;
    }
}
