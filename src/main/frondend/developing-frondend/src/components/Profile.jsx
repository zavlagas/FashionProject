import React, { Component } from "react";
import { Role } from "../variables/Roles";
import { Link, Route } from "react-router-dom";
import BrandGenerator from "./BrandGenerator";
import ProductGenerator from "./ProductGenerator";
import BrandsInspector from "./BrandsInspector";
import ProductInspector from "./ProductInspector";
import CloudinaryWidget from "./CloudinaryWidget";
import axios from "axios";
class Profile extends Component {
  constructor(props) {
    super(props);
    this.state = {
      isAdmin: false,
      firstName: this.props.authUser.firstName,
      lastName: this.props.authUser.lastName,
      email: this.props.authUser.email,
      dob: new Date(this.props.authUser.dob).toISOString().slice(0, 10),
      username: this.props.authUser.username,
      password: this.props.authUser.password,
      image: this.props.authUser.image,
      isUpdated: false,
    };

    this.adminLayout = this.adminLayout.bind(this);
    this.userLayout = this.userLayout.bind(this);
    this.handleOnInputChange = this.handleOnInputChange.bind(this);
    this.handleUpdateUser = this.handleUpdateUser.bind(this);
    this.handleDeleteUser = this.handleDeleteUser.bind(this);
  }

  componentDidMount() {
    const { roleList } = this.props.authUser;
    if (roleList.some((e) => e.type === Role.Admin)) {
      this.setState({
        isAdmin: false,
      });
    }
    console.log(this.props);
  }

  adminLayout() {
    const { match } = this.props;
    return (
      <>
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
                    to={`${match.url}/profile/products`}
                  >
                    Your Products
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
          <Route
            exact
            path={`${match.path}/profile/products`}
            {...this.props}
            render={() => (
              <ProductInspector {...this.props} user={this.props.authUser} />
            )}
          />
        </article>
      </>
    );
  }

  handleOnInputChange(event) {
    this.setState({
      [event.target.name]: event.target.value,
    });
  }

  handleResponseFromCloudinaryWidget(urlImages) {
    this.setState({
      image: urlImages.info.secure_url,
    });
  }

  handleUpdateUser() {
    const endPoint = `http://localhost:8080/FashionProject/api/user/${this.props.authUser.id}`;

    const user_object = {
      firstName: this.state.firstName,
      lastName: this.state.lastName,
      email: this.state.email,
      dob: this.state.dob,
      username: this.state.username,
      password: this.state.password,
      image: this.state.image,
    };

    axios.put(endPoint, user_object).then((response) => {
      this.setState({
        isUpdated: response.data,
      });
    });
  }

  handleDeleteUser() {
    const endPoint = `http://localhost:8080/FashionProject/api/user/${this.props.authUser.id}`;

    axios.delete(endPoint).then((response) => {
      if (response.data === true) {
        localStorage.clear();
        this.props.history.push("/");
      }
    });
  }

  userLayout() {
    const { match } = this.props;
    const user = this.props.authUser;
    return (
      <>
        <div className="not-admin-user-container">
          <div className="not-admin-user-content-container">
            <div className="image-user-profile">
              <img className="image-user-profile" src={this.state.image} />
              <div className="cloudinary-absolute-position-container">
                <CloudinaryWidget
                  passResponse={(data) =>
                    this.handleResponseFromCloudinaryWidget(data)
                  }
                />
              </div>
            </div>

            <div className="user-details">
              <div className="user-details-profile-inputs">
                <label
                  className="search-label"
                  htmlFor="profile-firstname-input"
                >
                  First Name
                </label>
                <input
                  type="text"
                  id="profile-firstname-input"
                  className="styled-input"
                  name="firstName"
                  value={this.state.firstName}
                  onChange={this.handleOnInputChange}
                />
              </div>

              <div className="user-details-profile-inputs">
                <label
                  className="search-label"
                  htmlFor="profile-lastName-input"
                >
                  Last Name
                </label>
                <input
                  type="text"
                  name="lastName"
                  id="profile-lastName-input"
                  className="styled-input"
                  value={this.state.lastName}
                  onChange={this.handleOnInputChange}
                />
              </div>
              <div className="user-details-profile-inputs">
                <label className="search-label" htmlFor="profile-email-input">
                  Email
                </label>
                <input
                  name="email"
                  type="email"
                  id="profile-email-input"
                  className="styled-input"
                  value={this.state.email}
                  onChange={this.handleOnInputChange}
                />
              </div>
              <div className="user-details-profile-inputs">
                <label className="search-label" htmlFor="profile-dob-input">
                  Birth Date
                </label>
                <input
                  name="dob"
                  type="date"
                  id="profile-dob-input"
                  className="styled-input"
                  value={this.state.dob}
                  onChange={this.handleOnInputChange}
                />
              </div>
              <div className="user-details-profile-inputs">
                <label
                  className="search-label"
                  htmlFor="profile-username-input"
                >
                  Username
                </label>
                <input
                  name="username"
                  type="text"
                  id="profile-username-input"
                  className="styled-input"
                  value={this.state.username}
                  onChange={this.handleOnInputChange}
                />
              </div>
              <div className="user-details-profile-inputs">
                <label
                  className="search-label"
                  htmlFor="profile-password-input"
                >
                  Password
                </label>
                <input
                  name="password"
                  type="password"
                  id="profile-password-input"
                  className="styled-input"
                  value={this.state.password}
                  onChange={this.handleOnInputChange}
                />
              </div>
              <p className="message user-message">
                {this.state.isUpdated ? "Successfully Updated" : ""}
              </p>

              <button onClick={this.handleUpdateUser} className="create-btn">
                Submit
              </button>
              <i
                onClick={this.handleDeleteUser}
                class="far fa-times-circle exit-btn delete-user"
              ></i>
            </div>
          </div>
        </div>
      </>
    );
  }

  render() {
    return (
      <>
        <main className="profile-container">
          {this.state.isAdmin ? this.adminLayout() : this.userLayout()}
        </main>
      </>
    );
  }
}

export default Profile;
