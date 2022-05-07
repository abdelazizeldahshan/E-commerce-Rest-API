package gov.iti.jets.service.interfaces;

import java.util.List;

import gov.iti.jets.Models.order.OrderPostRequest;
import gov.iti.jets.Models.order.Oredr;

public interface OrderServiceInt {

    List<Oredr> getAllOredrs();

    Oredr getOrderById(int id);

    boolean addOrder(OrderPostRequest orderPostRequest);
}
