package com.odhiambopaul.beer.order.service.web.mappers;

import com.odhiambopaul.beer.order.service.domain.BeerOrder;
import com.odhiambopaul.beer.order.service.web.model.BeerOrderDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {
    @Mapping(target = "customerId", source = "customer.id")
    BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);
}
