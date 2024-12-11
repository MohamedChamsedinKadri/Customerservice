package com.example.customerservice.repository;
import com.example.customerservice.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

    //customerQueryToCount reviews per customer
    @Query("SELECT c.name, COUNT(r) FROM Customer c LEFT JOIN c.reviews r GROUP BY c.name")
    List<Object[]> countReviewsPerCustomer();


}
