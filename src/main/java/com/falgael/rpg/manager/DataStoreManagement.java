package com.falgael.rpg.manager;

import org.jetbrains.annotations.Nullable;

import java.io.File;

public interface DataStoreManagement {

    @Nullable Object load(File file);

    void save(File file, Object o);


}
