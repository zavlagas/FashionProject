import React, { Component } from "react";
import StripeButton from "./StripeButton";
import axios from "axios";

class SignUp extends Component {
  constructor(props) {
    super(props);
    this.state = {
      firstName: "",
      lastName: "",
      email: "",
      dob: "",
      password: "",
      username: "",
      role: "",
      plan: {},
      paymentStatus: false,
    };
    this.handleChange = this.handleChange.bind(this);
    this.handleRoleDetailsContainer = this.handleRoleDetailsContainer.bind(
      this
    );
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
  }

  handleAuthorizedPayment(isPaymentAuthorized) {
    this.setState({ paymentStatus: isPaymentAuthorized });
  }

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value,
    });
    console.log(`${event.target.name} has value of ${event.target.value}`);
    console.log(this.state.role);
  }

  handleRoleDetailsContainer() {
    if (this.state.role === "1") {
      return (
        <>
          <p className="role-description">
            This plan gives you the opportunity to become a real lover of
            fashion, you have the options to chat with the designer of each
            brand and with other lovers and evaluate their products
          </p>
          <div className="role-subscription">
            <span>Free Account</span>
            <button>Subscribe Now</button>
          </div>
        </>
      );
    } else {
      return (
        <>
          <p className="role-description">
            This plan gives you the opportunity to become a real fashion
            designer, you have the options to chat with fans and create new
            brands and products and make your dreams come true
          </p>
          <div className="role-subscription">
            <span>Premium Account</span>
            <StripeButton
              test={this.state.paymentStatus}
              payStatus={(boolean) => this.handleAuthorizedPayment(boolean)}
              email={this.state.email}
              fullname={`${this.state.firstName} ${this.state.lastName}`}
              price="20"
            />
          </div>
        </>
      );
    }
  }

  handleFormSubmit = (event) => {
    event.preventDefault();
    const endpoint = "http://localhost:8080/FashionProject/signup";
    const user = {
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      email: this.state.email,
      dob: this.state.dob,
      username: this.state.username,
      password: this.state.password,
      roleList: [
        this.state.role === "1"
          ? { id: 1, type: "LOVER" }
          : { id: 2, type: "MAKER" },
      ],
      subscription: {
        plan:
          this.state.role === "1"
            ? { id: 1, name: "FASHION LOVER", price: 0 }
            : { id: 1, name: "FASHION MAKER", price: 20 },
      },
    };
    axios.put(endpoint, user).then((res) => {
      try {
        console.log(user);
      } catch (error) {}
    });
  };

  render() {
    return (
      <>
        <main className="" id="signup-container">
          <h1 className="signup-title">Create an account</h1>
          <section className="form-container">
            <form className="form-signup" onSubmit={this.handleFormSubmit}>
              <div id="firstname-input-section" className="input-form-group ">
                <label className="signup-label" htmlFor="firstname">
                  First Name
                </label>
                <input
                  required
                  type="text"
                  name="firstName"
                  value={this.state.firstName}
                  onChange={this.handleChange}
                  className="signup-input"
                  id="firstname"
                />
              </div>
              <div id="lastname-input-section" className="input-form-group">
                <label className="signup-label" htmlFor="lastname">
                  Last Name
                </label>
                <input
                  required
                  type="text"
                  name="lastName"
                  value={this.state.lastName}
                  onChange={this.handleChange}
                  className="signup-input"
                  id="lastname"
                />
              </div>
              <div id="dob-input-section" className="input-form-group ">
                <label className="signup-label" htmlFor="dob">
                  Birth Date
                </label>
                <input
                  required
                  type="date"
                  name="dob"
                  value={this.state.dob}
                  onChange={this.handleChange}
                  className="signup-input"
                  id="dob"
                />
              </div>
              <div id="email-input-section" className="input-form-group ">
                <label className="signup-label" htmlFor="signup-email">
                  Email
                </label>
                <input
                  required
                  type="email"
                  name="email"
                  value={this.state.email}
                  onChange={this.handleChange}
                  className="signup-input"
                  id="signup-email"
                />
              </div>
              <div id="username-input-section" className="input-form-group ">
                <label className="signup-label" htmlFor="signup-username">
                  Username
                </label>
                <input
                  required
                  type="text"
                  name="username"
                  autoComplete="username"
                  value={this.state.username}
                  onChange={this.handleChange}
                  className="signup-input"
                  id="signup-username"
                />
              </div>
              <div id="password-input-section" className="input-form-group ">
                <label className="signup-label" htmlFor="signup-password">
                  Password
                </label>
                <input
                  required
                  type="password"
                  name="password"
                  value={this.state.password}
                  onChange={this.handleChange}
                  autoComplete="current-password"
                  className="signup-input"
                  id="signup-password"
                />
              </div>
              <div id="roles-input-section" className="input-form-group ">
                <p>Please Select Your Role</p>
                <input
                  type="radio"
                  name="role"
                  value={1}
                  onChange={this.handleChange}
                  className="sr-only"
                  id="fashion-lover"
                />
                <label id="fashionlover-label" htmlFor="fashion-lover">
                  <img src="https://i.imgur.com/TdJ21oq.gif" />
                </label>
                <input
                  type="radio"
                  name="role"
                  value={2}
                  onChange={this.handleChange}
                  className="sr-only"
                  id="fashion-maker"
                />
                <label id="fashionmaker-label" htmlFor="fashion-maker">
                  <img src="https://i.imgur.com/HvbINLy.gif" />
                </label>
              </div>
              <div className="role-details-container">
                {this.handleRoleDetailsContainer()}
              </div>
            </form>
          </section>
        </main>
      </>
    );
  }
}

export default SignUp;
