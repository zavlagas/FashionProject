/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.controllers;

import com.stripe.exception.StripeException;
import fashion.entity.PaymentRequest;
import fashion.services.PayMethodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/payment")
public class PaymentController {
        
    @Autowired
    private PayMethodService service;
    
    @PostMapping
	public ResponseEntity<String> completePayment(@RequestBody PaymentRequest request) throws StripeException {
		String chargeId= service.charge(request);
		return chargeId!=null? new ResponseEntity<>(chargeId,HttpStatus.OK):
			new ResponseEntity<>("Please check the credit card details entered",HttpStatus.BAD_REQUEST);
	}
	
	@ExceptionHandler
	public String handleError(StripeException ex) {
		return ex.getMessage();
	}
    
}
