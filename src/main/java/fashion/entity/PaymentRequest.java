/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fashion.entity;

/**
 *
 * @author User
 */
public class PaymentRequest {
    public enum Currency{
		EUR,USD;
	}
	   private String description;
	    private int amount;
	    private Currency currency;
	    private String stripeEmail;
	    private Token token;
	    
		public String getDescription() {
			return description;
		}
		public void setDescription(String description) {
			this.description = description;
		}
		public int getAmount() {
			return amount;
		}
		public void setAmount(int amount) {
			this.amount = amount;
		}
		public Currency getCurrency() {
			return currency;
		}
		public void setCurrency(Currency currency) {
			this.currency = currency;
		}
		public String getStripeEmail() {
			return stripeEmail;
		}
		public void setStripeEmail(String stripeEmail) {
			this.stripeEmail = stripeEmail;
		}
		public Token getToken() {
			return token;
		}
		public void setToken(Token stripeToken) {
			this.token = stripeToken;
		}
}
