package com.simbirsoft.spring_demo.service;


import com.simbirsoft.spring_demo.model.Publisher;

import java.util.List;

public interface PublisherService {

    List<Publisher> getAll();

    Publisher findById(Long id);

    void delete(Long id);

    Publisher save(Publisher publisher);
}
