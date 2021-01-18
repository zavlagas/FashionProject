import React, { Component } from "react";
import StripeButton from "./StripeButton";
import axios from "axios";

class SignUp extends Component {
  constructor(props) {
    document.querySelector(".app-container").classList.add("background-image");
    super(props);
    this.state = {
      firstName: "",
      lastName: "",
      email: "",
      dob: "",
      password: "",
      username: "",
      role: "1",
      plan: {},
      formIsChecked: false,
      formSubmitted: false,
      userSubscribed: false,
    };
    this.sendPostRequest = this.sendPostRequest.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
  }

  checkIfFormIsFilled() {
    if (
      this.state.firstName.length > 1 &&
      this.state.lastName.length > 1 &&
      this.state.email.length > 1 &&
      this.state.dob.length > 1 &&
      this.state.password.length > 1 &&
      this.state.username.length > 1
    ) {
      this.setState({
        formIsChecked: true,
      });
    } else {
      this.setState({
        formIsChecked: false,
      });
    }
    this.showStripeButton();
  }

  handleChange(event) {
    this.checkIfFormIsFilled();
    this.setState({
      [event.target.name]: event.target.value,
    });
    this.checkIfFormIsFilled();
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
            <button onClick={() => this.sendPostRequest()}>
              Subscribe Now
            </button>
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
            {this.showStripeButton()}
          </div>
        </>
      );
    }
  }

  showStripeButton() {
    if (this.state.formIsChecked) {
      return (
        <>
          <StripeButton
            sendPost={this.sendPostRequest}
            email={this.state.email}
            fullname={`${this.state.firstName} ${this.state.lastName}`}
            price="20"
          />
        </>
      );
    } else {
      return (
        <>
          <button>Fill Out The Form</button>
        </>
      );
    }
  }

  sendPostRequest() {
    console.log("Send Post Request");
    const endpoint = "http://localhost:8080/FashionProject/signup";
    const user = {
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      email: this.state.email,
      dob: this.state.dob,
      username: this.state.username,
      password: this.state.password,
      createDate: new Date(),
      image:
        "https://i1.wp.com/www.awesomegreece.com/wp-content/uploads/2018/10/default-user-image.png",
      roleList: [{ id: parseInt(this.state.role) }],
      subscription: {
        startDate: new Date(),
        plan: { id: this.state.role },
      },
    };
    axios
      .post(endpoint, user)
      .then((res) => {
        console.log(res);
        this.setState({
          formSubmitted: true,
          userSubscribed: res.data,
        });
      })
      .catch((error) => {
        console.error(error);
      });
  }
  handleFormSubmit = (event) => {
    event.preventDefault();
  };

  render() {
    return (
      <>
        <main className="" id="signup-container">
          <h1 className="signup-title">Create an account</h1>
          {/* {this.state.userSubscribed ? "User Exists" : "Registration Completed"} */}
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
