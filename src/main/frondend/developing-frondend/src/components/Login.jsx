import React, { Component } from "react";
import axios from "axios";

class Login extends Component {
  constructor(props) {
    super(props);
    this.state = {
      username: "",
      password: "",
      hasError: false,
    };
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
  }

  changeReactValue = (event) => {
    if (event.target.getAttribute("name") === "username") {
      this.setState({ username: event.target.value.trim() });
    }
    if (event.target.getAttribute("name") === "password") {
      this.setState({ password: event.target.value.trim() });
    }
  };

  handleFormSubmit = (event) => {
    event.preventDefault();

    const endpoint = "http://localhost:8080/FashionProject/authenticate";

    const user_object = {
      username: this.state.username,
      password: this.state.password,
    };

    axios.post(endpoint, user_object).then((res) => {
      try {
        localStorage.setItem("authorization", res.data.token);
        return this.handleDashboard();
      } catch (error) {
        this.setState({ hasError: true });
      }
    });
  };

  handleDashboard() {
    axios.get("http://localhost:8080/FashionProject/dashboard").then((res) => {
      if (res.data === "success") {
        this.props.authenticationProtocol(true);
        this.props.history.push("/dashboard");
      } else {
        this.props.authenticationProtocol(false);
      }
    });
  }

  render() {
    return (
      <>
        <div className="login">
          <div className="container">
            <div className="d-flex justify-content-center h-100">
              <div className="card">
                <div className="card-header">
                  <h3 className="text-center">Log In</h3>
                </div>
                <div className="card-body">
                  <form
                    className="form-signin"
                    onSubmit={this.handleFormSubmit}
                  >
                    <div className="input-group form-group">
                      <div className="input-group-prepend">
                        <span className="input-group-text">
                          <i className="fas fa-user"></i>
                        </span>
                      </div>
                      <input
                        className="form-control"
                        type="text"
                        onChange={this.changeReactValue}
                        name="username"
                        placeholder="username"
                        autoComplete="on"
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
                        onChange={this.changeReactValue}
                        placeholder="password"
                        type="password"
                        name="password"
                        autoComplete="on"
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
                    <button className="text-warning">Sign Up</button>
                  </div>
                </div>
              </div>
            </div>
          </div>
        </div>
      </>
    );
  }
}
export default Login;
