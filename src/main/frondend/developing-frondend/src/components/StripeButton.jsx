import React, { Component } from "react";
import StripeCheckout from "react-stripe-checkout";
import axios from "axios";
import interceptors from "../Interceptors";

class StripeButton extends Component {
  constructor(props) {
    super(props);
    this.state = {
      publ_stripe_key:
        "pk_test_51I6V9NDhiMmdhGSnrszydNErU0Bpd6NdaSf356KAL4xhC6UxvGlQtFZlceFQS8IkhuVdfqj6eSpEkfRa5z0ZST2j003zvBa1cU",
      stripePrice: this.props.price * 100,
    };
    this.onToken = this.onToken.bind(this);
  }

  onToken(token) {
    const endPoint = "http://localhost:8080/FashionProject/payment";
    const priceObject = {
      amount: this.state.stripePrice,
      token,
    };
    axios
      .post(endPoint, priceObject)
      .then((response) => {
        if (response.status === 200) {
          this.props.sendPost();
          this.props.history.push("/");
        }
      })
      .catch((error) => {});
  }
  render() {
    return (
      <StripeCheckout
        amount={this.state.stripePrice}
        label="Pay Now"
        email={this.props.email}
        name={this.props.fullname}
        image=""
        type="button"
        panelLabel="Pay Now"
        token={this.onToken}
        stripeKey={this.state.publ_stripe_key}
        currency="EUR"
      />
    );
  }
}

export default StripeButton;
