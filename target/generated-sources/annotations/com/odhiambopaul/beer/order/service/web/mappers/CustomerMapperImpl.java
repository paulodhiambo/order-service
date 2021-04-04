package com.odhiambopaul.beer.order.service.web.mappers;

import com.odhiambopaul.beer.order.service.domain.BeerOrder;
import com.odhiambopaul.beer.order.service.domain.Customer;
import com.odhiambopaul.beer.order.service.web.model.CustomerDto;
import java.util.HashSet;
import java.util.Set;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-04-04T08:12:32+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class CustomerMapperImpl implements CustomerMapper {

    @Autowired
    private DateMapper dateMapper;

    @Override
    public CustomerDto customerToDto(Customer customer) {
        if ( customer == null ) {
            return null;
        }

        CustomerDto customerDto = new CustomerDto();

        customerDto.setId( customer.getId() );
        if ( customer.getVersion() != null ) {
            customerDto.setVersion( customer.getVersion().intValue() );
        }
        customerDto.setCreatedDate( dateMapper.asOffsetDateTime( customer.getCreatedDate() ) );
        customerDto.setLastModifiedDate( dateMapper.asOffsetDateTime( customer.getLastModifiedDate() ) );

        return customerDto;
    }

    @Override
    public Customer dtoToCustomer(Customer dto) {
        if ( dto == null ) {
            return null;
        }

        Customer customer = new Customer();

        customer.setId( dto.getId() );
        customer.setVersion( dto.getVersion() );
        customer.setCreatedDate( dto.getCreatedDate() );
        customer.setLastModifiedDate( dto.getLastModifiedDate() );
        customer.setCustomerName( dto.getCustomerName() );
        customer.setApiKey( dto.getApiKey() );
        Set<BeerOrder> set = dto.getBeerOrders();
        if ( set != null ) {
            customer.setBeerOrders( new HashSet<BeerOrder>( set ) );
        }

        return customer;
    }
}
