import React, { Component } from "react";
import { Role } from "../variables/Roles";
import { Link, Route } from "react-router-dom";
import BrandGenerator from "./BrandGenerator";
import ProductGenerator from "./ProductGenerator";
class Profile extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isAdmin: false,
    };
  }

  componentDidMount() {
    const { roleList } = this.props.authUser;
    if (roleList.some((e) => e.type === Role.Admin)) {
      this.setState({
        isAdmin: true,
      });
    }
  }

  render() {
    const { match } = this.props;
    return (
      <>
        <main className="profile-container">
          <aside className="sidebar-container">
            <h5 className="sidebar-heading">Dashboard</h5>
            <ul>
              <li>
                <Link
                  className="hover-link"
                  to={`${match.url}/profile/brands/create`}
                >
                  Create Brand
                </Link>
              </li>
              <li>
                <Link
                  className="hover-link"
                  to={`${match.url}/profile/products/create`}
                >
                  Create Product
                </Link>
              </li>
            </ul>
          </aside>
          <article>
            <Route
              path={`${match.path}/profile/brands/create`}
              component={BrandGenerator}
            />
            <Route
              path={`${match.path}/profile/products/create`}
              component={ProductGenerator}
            />
          </article>
        </main>
      </>
    );
  }
}

export default Profile;
