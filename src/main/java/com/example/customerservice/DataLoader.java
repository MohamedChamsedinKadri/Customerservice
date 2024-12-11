package com.example.customerservice;


import com.example.customerservice.repository.CustomerRepository;
import com.example.customerservice.repository.ReviewRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Override
    public void run(String... args) throws Exception {
        //insertData
        Customer alice = new Customer();
        alice.setName("Alice Johnson");
        alice.setEmail("alice.johnson@example.com");
        customerRepository.save(alice);

        Customer bob = new Customer();
        bob.setName("Bob Smith");
        bob.setEmail("bob.smith@example.com");
        customerRepository.save(bob);

        Customer charlie = new Customer();
        charlie.setName("Charlie Brown");
        charlie.setEmail("charlie.brown@example.com");
        customerRepository.save(charlie);

        //InsertReviewData
        Review review1 = new Review();
        review1.setRating(5);
        review1.setComments("Excellent service!");
        review1.setCustomer(alice);
        reviewRepository.save(review1);

        Review review2 = new Review();
        review2.setRating(4);
        review2.setComments("Good experience,");
        review2.setCustomer(bob);
        reviewRepository.save(review2);

        Review review3 = new Review();
        review3.setRating(3);
        review3.setComments("Average quality.");
        review3.setCustomer(charlie);
        reviewRepository.save(review3);

        Review review4 = new Review();
        review4.setRating(4);
        review4.setComments("Great follow-up support");
        review4.setCustomer(alice);
        reviewRepository.save(review4);

        //Update the comment of rating 5
        updateReviewComment();

        //delete the review with the id 2
        deleteReviewById(2L);

        //countReviews
        showReviewCount();








    }
    //reviewscount
    public void showReviewCount(){
        List<Object[]> results = customerRepository.countReviewsPerCustomer();
        for (Object[] result : results) {
            System.out.println("CustomerName: " + result[0] + ", ReviewCount: " + result[1]);
        }
    }


    //delete by id
    public void deleteReviewById(Long id) {
        reviewRepository.deleteById(id);
    }

    //Method of update comment of review
    public void updateReviewComment(){
        Review review = reviewRepository.findByRating(5);
        if(review != null){
            review.setComments("Fantastiic service!");
            reviewRepository.save(review);
        }

    }
}
