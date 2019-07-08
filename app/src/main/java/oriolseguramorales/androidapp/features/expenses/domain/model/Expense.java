package oriolseguramorales.androidapp.features.expenses.domain.model;

import java.util.Date;

public class Expense {

    private Date date;
    private String name;
    private float value;
    private String valueType;

    public Expense(Date date, String name, float value, String valueType) {
        this.date = date;
        this.name = name;
        this.value = value;
        this.valueType = valueType;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getValue() {
        return value;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public String getValueType() {
        return valueType;
    }

    public void setValueType(String valueType) {
        this.valueType = valueType;
    }
}
