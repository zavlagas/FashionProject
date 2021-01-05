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
      userAuthentication: true,
    };
  }

  authenticateUser(userExists) {
    this.setState({
      userAuthentication: userExists,
    });
  }

  render() {
    return (
      <>
        <div className="app-context">
          <Router>
            <Route exact path="/" component={Login} />
            <Route exact path="/dashboard" component={Dashboard} />
          </Router>
        </div>
      </>
    );
  }
}
export default App;
