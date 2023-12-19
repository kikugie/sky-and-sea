package com.example.util;

import com.example.Reference;
import com.google.common.collect.ImmutableList;
import org.jetbrains.annotations.Nullable;

import java.lang.reflect.Field;
import java.util.List;

public class ReflectionUtils {
    public static <T> List<? extends T> filterFields(Class<?> source, Class<T> type) {
        return filterFields(source, type, null);
    }

    public static <T> List<? extends T> filterFields(Class<?> source, Class<T> type, @Nullable Object object) {
        ImmutableList.Builder<T> builder = ImmutableList.builder();
        for (Field field : source.getDeclaredFields()) {
            field.setAccessible(true);
            try {
                Object val = field.get(object);
                if (val.getClass().isInstance(type))
                     builder.add(type.cast(val));
            } catch (IllegalAccessException | ClassCastException e) {
                Reference.LOGGER.warn("Couldn't get value for field %s.%s".formatted(source.getSimpleName(), field.getName()));
            }
        }
        return builder.build();
    }
}