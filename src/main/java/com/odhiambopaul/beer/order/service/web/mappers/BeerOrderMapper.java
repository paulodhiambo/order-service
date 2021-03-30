package com.odhiambopaul.beer.order.service.web.mappers;

import com.odhiambopaul.beer.order.service.domain.BeerOrder;
import com.odhiambopaul.beer.order.service.web.model.BeerOrderDto;
import org.mapstruct.DecoratedWith;
import org.mapstruct.Mapper;

@Mapper(uses = {DateMapper.class, BeerOrderLineMapper.class})
public interface BeerOrderMapper {

    BeerOrderDto beerOrderToDto(BeerOrder beerOrder);

    BeerOrder dtoToBeerOrder(BeerOrderDto dto);
}
