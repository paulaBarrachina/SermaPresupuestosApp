package com.example.SermaPresupuestosApp.repository.spec;

import lombok.Data;

@Data
public class SearchCriteria {
    private String Key;
    private Object value;
    private SearchOperation operation;

    public SearchCriteria() {
    }

    public SearchCriteria(String key, Object value, SearchOperation operation) {
        this.Key = key;
        this.value = value;
        this.operation = operation;
    }
}
