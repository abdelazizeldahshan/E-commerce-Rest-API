package gov.iti.jets.service.mappers;

import gov.iti.jets.Models.order.OrderPostRequest;
import gov.iti.jets.Models.order.Oredr;
import gov.iti.jets.repo.entities.OrderEntity;

public class OrderMappers {

    CustomerMapper customerMapper = new CustomerMapper();

    public Oredr oredrEntityTOredr(OrderEntity orderEntity) {
        Oredr oredr = new Oredr();
        oredr.setCreatedAt(orderEntity.getCreatedAt());
        oredr.setCustomer(customerMapper.customerEntityToCustomer(orderEntity.getCustomer()));
        oredr.setId(orderEntity.getId());
        oredr.setTotalPrice(orderEntity.getTotalPrice());
        oredr.setSubmitted(orderEntity.getIsSubmitted());
        return oredr;
    }

    public OrderEntity OderToOrderEntity(Oredr oredr) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCreatedAt(oredr.getCreatedAt());
        orderEntity.setCustomer(customerMapper.customerToCustomerEntity(oredr.getCustomer()));
        orderEntity.setIsSubmitted(oredr.isSubmitted());
        orderEntity.setTotalPrice(oredr.getTotalPrice());
        return orderEntity;
    }

    public OrderEntity orderPostRequestToOrderEntity(OrderPostRequest orderPostRequest){
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setCreatedAt(orderPostRequest.getCreatedAt());
        return orderEntity;
    }
}
