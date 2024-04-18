package com.example.dev_jpa.common.repository;


import jakarta.annotation.Nullable;
import lombok.NonNull;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;

@NoRepositoryBean
public interface MyRepository<T,Id extends Serializable> extends Repository<T,Id> {

    <E extends T> E save(@NonNull E entity);

    List<T> findAll();

    @Nullable
    <E extends T> E findById(Id id);

}
