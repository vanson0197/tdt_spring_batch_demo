package com.example.demo.dao.db1;

import com.example.demo.entity.PersonEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface IPersonReponsitory extends JpaRepository<PersonEntity,Integer> {
}
