import React, { Component } from "react";
import { Role } from "../variables/Roles";
import { Link, Route } from "react-router-dom";
import BrandGenerator from "./BrandGenerator";
import ProductGenerator from "./ProductGenerator";
import BrandsInspector from "./BrandsInspector";
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
    console.log(this.props);
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
                Brand
                <ul>
                  <li>
                    <Link
                      className="hover-link"
                      to={`${match.url}/profile/brands`}
                    >
                      Your Brands
                    </Link>
                  </li>
                  <li>
                    <Link
                      className="hover-link"
                      to={`${match.url}/profile/brands/create`}
                    >
                      Create Brand
                    </Link>
                  </li>
                </ul>
              </li>
              <li>
                Product
                <ul>
                  <li>
                    <Link
                      className="hover-link"
                      to={`${match.url}/profile/products/create`}
                    >
                      Create Product
                    </Link>
                  </li>
                </ul>
              </li>
            </ul>
          </aside>
          <article className="article-container">
            <Route
              path={`${match.path}/profile/brands/create`}
              {...this.props}
              render={() => (
                <BrandGenerator {...this.props} user={this.props.authUser} />
              )}
            />
            <Route
              exact
              path={`${match.path}/profile/brands`}
              {...this.props}
              render={() => (
                <BrandsInspector {...this.props} user={this.props.authUser} />
              )}
            />
            <Route
              path={`${match.path}/profile/products/create`}
              {...this.props}
              render={() => (
                <ProductGenerator {...this.props} user={this.props.authUser} />
              )}
            />
          </article>
        </main>
      </>
    );
  }
}

export default Profile;
