package com.odhiambopaul.beer.order.service.web.mappers;

import com.odhiambopaul.beer.order.service.domain.BeerOrder;
import com.odhiambopaul.beer.order.service.domain.BeerOrderLine;
import com.odhiambopaul.beer.order.service.domain.Customer;
import com.odhiambopaul.beer.order.service.web.model.BeerOrderDto;
import com.odhiambopaul.beer.order.service.web.model.BeerOrderLineDto;
import com.odhiambopaul.beer.order.service.web.model.OrderStatusEnum;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.UUID;
import javax.annotation.processing.Generated;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2021-05-24T21:54:57+0300",
    comments = "version: 1.3.0.Final, compiler: javac, environment: Java 15.0.2 (Oracle Corporation)"
)
@Component
public class BeerOrderMapperImpl implements BeerOrderMapper {

    @Autowired
    private DateMapper dateMapper;
    @Autowired
    private BeerOrderLineMapper beerOrderLineMapper;

    @Override
    public BeerOrderDto beerOrderToDto(BeerOrder beerOrder) {
        if ( beerOrder == null ) {
            return null;
        }

        BeerOrderDto beerOrderDto = new BeerOrderDto();

        beerOrderDto.setCustomerId( beerOrderCustomerId( beerOrder ) );
        beerOrderDto.setId( beerOrder.getId() );
        if ( beerOrder.getVersion() != null ) {
            beerOrderDto.setVersion( beerOrder.getVersion().intValue() );
        }
        beerOrderDto.setCreatedDate( dateMapper.asOffsetDateTime( beerOrder.getCreatedDate() ) );
        beerOrderDto.setLastModifiedDate( dateMapper.asOffsetDateTime( beerOrder.getLastModifiedDate() ) );
        beerOrderDto.setCustomerRef( beerOrder.getCustomerRef() );
        beerOrderDto.setBeerOrderLines( beerOrderLineSetToBeerOrderLineDtoList( beerOrder.getBeerOrderLines() ) );
        beerOrderDto.setOrderStatus( orderStatusEnumToOrderStatusEnum( beerOrder.getOrderStatus() ) );
        beerOrderDto.setOrderStatusCallbackUrl( beerOrder.getOrderStatusCallbackUrl() );

        return beerOrderDto;
    }

    @Override
    public BeerOrder dtoToBeerOrder(BeerOrderDto dto) {
        if ( dto == null ) {
            return null;
        }

        BeerOrder beerOrder = new BeerOrder();

        beerOrder.setId( dto.getId() );
        if ( dto.getVersion() != null ) {
            beerOrder.setVersion( dto.getVersion().longValue() );
        }
        beerOrder.setCreatedDate( dateMapper.asTimestamp( dto.getCreatedDate() ) );
        beerOrder.setLastModifiedDate( dateMapper.asTimestamp( dto.getLastModifiedDate() ) );
        beerOrder.setCustomerRef( dto.getCustomerRef() );
        beerOrder.setBeerOrderLines( beerOrderLineDtoListToBeerOrderLineSet( dto.getBeerOrderLines() ) );
        beerOrder.setOrderStatus( orderStatusEnumToOrderStatusEnum1( dto.getOrderStatus() ) );
        beerOrder.setOrderStatusCallbackUrl( dto.getOrderStatusCallbackUrl() );

        return beerOrder;
    }

    private UUID beerOrderCustomerId(BeerOrder beerOrder) {
        if ( beerOrder == null ) {
            return null;
        }
        Customer customer = beerOrder.getCustomer();
        if ( customer == null ) {
            return null;
        }
        UUID id = customer.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    protected List<BeerOrderLineDto> beerOrderLineSetToBeerOrderLineDtoList(Set<BeerOrderLine> set) {
        if ( set == null ) {
            return null;
        }

        List<BeerOrderLineDto> list = new ArrayList<BeerOrderLineDto>( set.size() );
        for ( BeerOrderLine beerOrderLine : set ) {
            list.add( beerOrderLineMapper.beerOrderLineToDto( beerOrderLine ) );
        }

        return list;
    }

    protected OrderStatusEnum orderStatusEnumToOrderStatusEnum(com.odhiambopaul.beer.order.service.domain.OrderStatusEnum orderStatusEnum) {
        if ( orderStatusEnum == null ) {
            return null;
        }

        OrderStatusEnum orderStatusEnum1;

        switch ( orderStatusEnum ) {
            case NEW: orderStatusEnum1 = OrderStatusEnum.NEW;
            break;
            case READY: orderStatusEnum1 = OrderStatusEnum.READY;
            break;
            case PICKED_UP: orderStatusEnum1 = OrderStatusEnum.PICKED_UP;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + orderStatusEnum );
        }

        return orderStatusEnum1;
    }

    protected Set<BeerOrderLine> beerOrderLineDtoListToBeerOrderLineSet(List<BeerOrderLineDto> list) {
        if ( list == null ) {
            return null;
        }

        Set<BeerOrderLine> set = new HashSet<BeerOrderLine>( Math.max( (int) ( list.size() / .75f ) + 1, 16 ) );
        for ( BeerOrderLineDto beerOrderLineDto : list ) {
            set.add( beerOrderLineMapper.dtoToBeerOrderLine( beerOrderLineDto ) );
        }

        return set;
    }

    protected com.odhiambopaul.beer.order.service.domain.OrderStatusEnum orderStatusEnumToOrderStatusEnum1(OrderStatusEnum orderStatusEnum) {
        if ( orderStatusEnum == null ) {
            return null;
        }

        com.odhiambopaul.beer.order.service.domain.OrderStatusEnum orderStatusEnum1;

        switch ( orderStatusEnum ) {
            case NEW: orderStatusEnum1 = com.odhiambopaul.beer.order.service.domain.OrderStatusEnum.NEW;
            break;
            case READY: orderStatusEnum1 = com.odhiambopaul.beer.order.service.domain.OrderStatusEnum.READY;
            break;
            case PICKED_UP: orderStatusEnum1 = com.odhiambopaul.beer.order.service.domain.OrderStatusEnum.PICKED_UP;
            break;
            default: throw new IllegalArgumentException( "Unexpected enum constant: " + orderStatusEnum );
        }

        return orderStatusEnum1;
    }
}
