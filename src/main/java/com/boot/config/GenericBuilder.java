package com.boot.config;

import java.util.Objects;
import java.util.function.BiConsumer;
import java.util.function.Predicate;
import java.util.function.Supplier;

public final class GenericBuilder<T> {

    private final T t;

    private GenericBuilder(T t) {
        this.t = t;
    }

    public static <T> GenericBuilder<T> of(Supplier<T> supplier) {
        return new GenericBuilder<>(Objects.requireNonNull(supplier, "Supplier cannot be null").get());
    }

    public <E> GenericBuilder<T> setProperty(BiConsumer<T, E> setter, E element) {
        setter.accept(t, element);
        return this;
    }

    public T build() {
        return t;
    }

    public <E> GenericBuilder<T> setConditionalProperty(BiConsumer<T, E> setter, Predicate<E> predicate, E element) {
        if (predicate.test(element)) {
            setter.accept(t, element);
        }
        return this;
    }
}
