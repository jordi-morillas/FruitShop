package com.application.fruitShop.fileMapping;

import java.util.Map;

public interface FileToHashMap<T> {
    void mapToValue(String value, Map<String, T> map);
}
