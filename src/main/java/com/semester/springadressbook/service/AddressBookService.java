package com.semester.springadressbook.service;

import com.semester.springadressbook.entity.AddressBook;
import com.semester.springadressbook.repository.AddressBookRepository;
import javassist.NotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AddressBookService {
    @Autowired
    private AddressBookRepository repository;

    public List<AddressBook> getAll() {
        return this.repository.findAll();
    }

    public List<AddressBook> findByAttributes(Optional<String> text) {
        return this.repository.findAllByNameIsLikeOrSurnameIsLikeOrNumberIsLike(text.get(), text.get(), text.get());
    }

    public Optional<AddressBook> getOne(Integer id) {
        return this.repository.findById(id);
    }

    public AddressBook create(AddressBook pupil) {
        return this.repository.save(pupil);
    }

    public AddressBook update(Integer id, AddressBook pupil) throws NotFoundException {
        Optional<AddressBook> data = this.repository.findById(id);

        if (data.isEmpty()) {
            throw new NotFoundException("Entity not found");
        }

        data.get().setName(pupil.getName());
        data.get().setNumber(pupil.getNumber());
        data.get().setSurname(pupil.getSurname());
        data.get().setName(pupil.getName());

        return this.repository.save(data.get());
    }

    public String delete(Integer id) {
        this.repository.deleteById(id);
        return "Deleted";
    }
}
