import React, { Component } from "react";
import "./App.css";
import { BrowserRouter as Router, Route } from "react-router-dom";

import Login from "./components/Login";
import Dashboard from "./components/Dashboard";
import interceptors from "./Interceptors";

class App extends Component {
  constructor() {
    super();
    this.state = {
      userAuthentication: false,
    };
  }

  authenticateUser(e) {
    this.setState({ userAuthentication: e });
  }

  render() {
    return (
      <>
        <div className="app-context">
          <Router>
            <Route
              exact
              path="/login"
              render={(props) => (
                <Login
                  {...props}
                  authenticationProtocol={(e) => this.authenticateUser(e)}
                />
              )}
            />
            <Route
              exact
              path="/dashboard"
              render={(props) => (
                <Dashboard
                  {...props}
                  authenticationProtocol={(e) => this.authenticateUser(e)}
                  loggedInStatus={this.state.userAuthentication}
                />
              )}
            />
          </Router>
        </div>
      </>
    );
  }
}
export default App;
