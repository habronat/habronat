package com.habronat.common.config;

public interface ConfigLoader<T> {

    T load(String filename);
}
