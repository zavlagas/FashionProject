import React, { Component } from "react";
import { Link } from "react-router-dom";

class Navbar extends Component {
  constructor(props) {
    super(props);
    this.state = {
      url: this.props.url,
    };
  }

  render() {
    return (
      <>
        <nav id="navbar" role="navigation">
          <ul>
            <li>
              <Link className="hover-link" to={`${this.state.url}/home`}>
                Home
              </Link>
            </li>
            <li>
              <Link className="hover-link" to={`${this.state.url}/brands`}>
                Brands
              </Link>
            </li>
          </ul>
        </nav>
      </>
    );
  }
}

export default Navbar;
