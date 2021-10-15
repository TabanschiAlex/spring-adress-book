package com.semester.springadressbook.repository;

import com.semester.springadressbook.entity.AddressBook;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBook, Integer> {
    List<AddressBook> findAllByNameIsLikeOrSurnameIsLikeOrNumberIsLike(String name, String surname, String number);
}
