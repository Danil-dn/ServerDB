package com.daoProject.dao;

import com.daoProject.models.Person;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class PeopleDAO {
    private static int PEOPLE_COUNT;
    private final List<Person> people;

    {
        people = new ArrayList<>();
        people.add(new Person(++PEOPLE_COUNT, "Kravich",20,"kravich@mail.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Alexey",19,"Zelensky@undex.ru"));
        people.add(new Person(++PEOPLE_COUNT, "Danila",24,"Danidani@vk.com"));
        people.add(new Person(++PEOPLE_COUNT, "Vladimir",30,"vlad@bk.ru"));

    }

    public List<Person> index() {
        return people;
    }

    public Person show(int id) {
        return people.stream().filter(person -> person.getId() == id).findAny().orElse(null);
    }

    public void save(Person person) {
        person.setId(++PEOPLE_COUNT);
        people.add(person);
    }

    public void update(int id, Person updatePerson) {
        Person personBeUpdate = show(id);

        personBeUpdate.setName(updatePerson.getName());
        personBeUpdate.setAge(updatePerson.getAge());
        personBeUpdate.setEmail(updatePerson.getEmail());
    }

    public void delete(int id) {
        people.removeIf(person -> person.getId() == id);
    }
}
