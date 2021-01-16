import React, { Component } from "react";
import axios from "axios";
import CloudinaryWidget from "./CloudinaryWidget";
class BrandsInspector extends Component {
  constructor(props) {
    super(props);
    this.state = {
      brandsList: [],
      brandIsDeleted: false,
      popUpForEdit: false,
      brandId: 0,
      brandName: "",
      brandimagePath: "",
      brandDescr: "",
    };
    this.handleClick = this.handleClick.bind(this);
    this.handleUpdate = this.handleUpdate.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.forceUpdateHandler = this.forceUpdateHandler.bind(this);
    this.handleExit = this.handleExit.bind(this);
  }

  handleClick(event) {
    const buttonAction = event.target.textContent;
    const targetedBrand = event.target.value;
    if (buttonAction === "delete") {
      const endPoint = `http://localhost:8080/FashionProject/api/brands/${targetedBrand}`;
      axios.delete(endPoint).then((response) => {
        console.log(response);
        this.setState({
          brandIsDeleted: response.data,
        });
      });
      const tempBrandList = this.state.brandsList.filter((brand) => {
        return brand.id != targetedBrand;
      });
      this.setState({
        brandsList: tempBrandList,
      });
    }
    if (buttonAction === "Edit") {
      const endPoint = `http://localhost:8080/FashionProject/api/brands/${targetedBrand}`;
      axios.get(endPoint).then((response) => {
        console.log(response);
        this.setState({
          brandId: response.data.id,
          brandName: response.data.name,
          brandimagePath: response.data.imagePath,
          brandDescr: response.data.descr,
          popUpForEdit: true,
        });
      });
    }
  }

  getAllBrands() {
    const endpoint = `http://localhost:8080/FashionProject/api/brands/user/${this.props.user.id}`;

    axios.get(endpoint).then((response) => {
      this.setState({
        brandsList: response.data,
      });
    });
  }

  componentDidMount() {
    this.getAllBrands();
  }

  handleResponseFromCloudinaryWidget(urlImages) {
    this.setState({
      brandimagePath: urlImages.info.secure_url,
    });
  }

  handleUpdate(event) {
    event.preventDefault();
    const endPoint = `http://localhost:8080/FashionProject/api/brands/${this.state.brandId}`;
    const Brand_object = {
      name: this.state.brandName,
      descr: this.state.brandDescr,
      imagePath: this.state.brandimagePath,
      user: this.props.user.id,
    };

    axios.put(endPoint, Brand_object).then((response) => {
      console.log(response);
      this.getAllBrands();
      this.setState({
        popUpForEdit: false,
      });
    });
  }

  forceUpdateHandler() {
    this.forceUpdate();
  }

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value,
    });
  }

  handleExit() {
    this.setState({
      popUpForEdit: false,
    });
  }

  popUpContainer() {
    return (
      <>
        <div className="popup-content">
          <i onClick={this.handleExit} class="far fa-times-circle exit-btn"></i>
          <form id="update-form" onSubmit={this.handleUpdate}></form>
          <div className="update-image-icon">
            <img src={this.state.brandimagePath} />
            <div className="image-cloudinary-btn">
              <CloudinaryWidget
                passResponse={(data) =>
                  this.handleResponseFromCloudinaryWidget(data)
                }
              />
            </div>
          </div>
          <div className="update-details">
            <label htmlFor="brand-update-name">Title</label>
            <input
              className="update-input-first styled-input"
              onChange
              form="update-brand-form"
              type="text"
              value={this.state.brandName}
              onChange={this.handleChange}
              id="brand-update-name"
              name="brandName"
            />
            <label htmlFor="brand-update-name">Description</label>
            <textarea
              className="update-input-second styled-input"
              form="update-brand-form"
              value={this.state.brandDescr}
              onChange={this.handleChange}
              name="brandDescr"
            />
            <button form="update-form" className="update-button">
              Update
            </button>
          </div>
        </div>
      </>
    );
  }

  render() {
    return (
      <>
        <div id="list-container">
          {this.state.popUpForEdit ? (
            this.popUpContainer()
          ) : (
            <>
              <h2 className="title-list">Brands List</h2>
              <table className="my-table" onClick={this.handleClick}>
                <thead>
                  <tr>
                    <th>Id</th>
                    <th>Logo</th>
                    <th>Name</th>
                    <th>Edit</th>
                    <th>Delete</th>
                  </tr>
                </thead>
                <tbody>
                  {this.state.brandsList.map((brand) => {
                    return (
                      <tr>
                        <td>{brand.id}</td>
                        <td>
                          <img src={brand.imagePath} />
                        </td>
                        <td>{brand.name}</td>
                        <td>
                          <button value={brand.id}>Edit</button>
                        </td>
                        <td>
                          <button value={brand.id}>delete</button>
                        </td>
                      </tr>
                    );
                  })}
                </tbody>
              </table>
              <p className="message">
                {this.state.brandIsDeleted ? "Succesfully Deleted" : ""}
              </p>
            </>
          )}
        </div>
      </>
    );
  }
}

export default BrandsInspector;
