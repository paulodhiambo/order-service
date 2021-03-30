package com.odhiambopaul.beer.order.service.services;

import com.odhiambopaul.beer.order.service.web.model.CustomerPagedList;
import org.springframework.data.domain.Pageable;

public interface CustomerService {

    CustomerPagedList listCustomers(Pageable pageable);

}