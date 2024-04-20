package com.example.dev_jpa.common.repository;


import jakarta.annotation.Nullable;
import lombok.NonNull;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.Repository;

import java.io.Serializable;
import java.util.List;


//이런식으로 공통 Repository 선언하여, 해당 MyRepository를 상속받아서 repository 작성하는 방법도 있음. (실제 사용되지 않는 레파지토리 명시를 위해서 @NoRepositoryBean 작성)
@NoRepositoryBean
public interface MyRepository<T,Id extends Serializable> extends Repository<T,Id> {

    <E extends T> E save(@NonNull E entity);

    List<T> findAll();

    @Nullable
    <E extends T> E findById(Id id);

}
