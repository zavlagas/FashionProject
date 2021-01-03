import React, { Component } from "react";
import axios from "axios";

class login extends Component {
  constructor() {
    super();

    this.state = {
      username: "admin",
      password: "admin",
    };
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
  }

  handleFormSubmit = (event) => {
    event.preventDefault();

    const endpoint = "http://localhost:8080/FashionProject/api/authenticate";

    const username = this.state.username;
    const password = this.state.password;

    const user_object = {
      username: username,
      password: password,
    };

    axios.post(endpoint, user_object).then((res) => {
      localStorage.setItem("authorization", res.data.token);
      return this.handleDashboard();
    });
  };

  handleDashboard() {
    axios
      .get("http://localhost:8080/FashionProject/api/dashboard")
      .then((res) => {
        if (res.data === "success") {
          this.props.history.push("/dashboard");
        } else {
          alert("Authentication failure");
        }
      });
  }

  render() {
    return (
      <>
        <div className="container">
          <div className="d-flex justify-content-center h-100">
            <div className="card">
              <div className="card-header">
                <h3 className="text-center">Log In</h3>
              </div>
              <div className="card-body">
                <form className="form-signin" onSubmit={this.handleFormSubmit}>
                  <div className="input-group form-group">
                    <div className="input-group-prepend">
                      <span className="input-group-text">
                        <i className="fas fa-user"></i>
                      </span>
                    </div>
                    <input
                      className="form-control"
                      type="text"
                      defaultValue="admin"
                      name="username"
                      placeholder="username"
                    />
                  </div>
                  <div className="input-group form-group">
                    <div className="input-group-prepend">
                      <span className="input-group-text">
                        <i className="fas fa-key"></i>
                      </span>
                    </div>
                    <input
                      className="form-control"
                      defaultValue="admin"
                      placeholder="password"
                      type="password"
                      name="password"
                    />
                  </div>
                  <div className="row align-items-center remember">
                    <input type="checkbox" />
                    Remember Me
                  </div>
                  <div className="form-group">
                    <button
                      className="btn float-right glow-on-hover"
                      type="submit"
                    >
                      Login
                    </button>
                  </div>
                </form>
              </div>
              <div className="card-footer">
                <div className="d-flex justify-content-center links">
                  Don't have an account?
                  <a className="text-warning">Sign Up</a>
                </div>
                <div className="d-flex justify-content-center links">
                  <a className="text-warning" href="#">
                    Forgot your password?
                  </a>
                </div>
              </div>
            </div>
          </div>
        </div>
      </>
    );
  }
}
export default login;
