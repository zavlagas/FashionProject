import React, { Component } from "react";
import axios from "axios";

class SignUp extends Component {
  render() {
    return (
      <>
        <main className="" id="signup-container">
          <h1 className="signup-title">Create an account</h1>
          <section className="form-container">
            <form className="form-signup" onSubmit={this.handleFormSubmit}>
              <div id="firstname-input-section" class="input-form-group ">
                <label className="signup-label" for="firstname">
                  First Name :
                </label>
                <input
                  required
                  type="text"
                  name="fname"
                  className="signup-input"
                  id="firstname"
                />
              </div>
              <div id="lastname-input-section" class="input-form-group">
                <label className="signup-label" for="lastname">
                  Last Name :
                </label>
                <input
                  required
                  type="text"
                  name="lname"
                  className="signup-input"
                  id="lastname"
                />
              </div>
              <div id="dob-input-section" class="input-form-group ">
                <label className="signup-label" for="dob">
                  Birth Date :
                </label>
                <input
                  required
                  type="date"
                  name="dob"
                  className="signup-input"
                  id="dob"
                />
              </div>
              <div id="email-input-section" class="input-form-group ">
                <label className="signup-label" for="signup-email">
                  Email :
                </label>
                <input
                  required
                  type="email"
                  name="email"
                  className="signup-input"
                  id="signup-email"
                />
              </div>
              <div id="username-input-section" class="input-form-group ">
                <label className="signup-label" for="signup-username">
                  Username :
                </label>
                <input
                  required
                  type="text"
                  name="username"
                  className="signup-input"
                  id="signup-username"
                />
              </div>
              <div id="password-input-section" class="input-form-group ">
                <label className="signup-label" for="signup-password">
                  Password :
                </label>
                <input
                  required
                  type="password"
                  name="password"
                  className="signup-input"
                  id="signup-password"
                />
              </div>
              <div id="roles-input-section" class="input-form-group ">
                  <p>Please Select Your Role :</p>
                  <input
                    type="radio"
                    name="role"
                    class="sr-only"
                    id="fashion-lover"
                  />
                  <label id="fashionlover-label" for="fashion-lover">
                    <img src="https://i.imgur.com/TdJ21oq.gif" />
                  </label>
                  <input
                    type="radio"
                    name="role"
                    class="sr-only"
                    id="fashion-maker"
                  />
                  <label id="fashionmaker-label" for="fashion-maker">
                    <img src="https://i.imgur.com/HvbINLy.gif" />
                  </label>
              </div>
            </form>
          </section>
          <section className="signup-footer">footer goes here</section>
        </main>
      </>
    );
  }
}

export default SignUp;
