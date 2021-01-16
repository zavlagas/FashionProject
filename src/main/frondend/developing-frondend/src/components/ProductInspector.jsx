import React, { Component } from "react";
import axios from "axios";
import CloudinaryWidget from "./CloudinaryWidget";
class ProductInspector extends Component {
  constructor(props) {
    super(props);
    this.state = {
      productList: [],
      productIsDeleted: false,
      popUpForEdit: false,
      productId: 0,
      productName: "",
      productImagePath: "",
      productImageList: [],
      productDescr: "",
    };
    this.handleClick = this.handleClick.bind(this);
    this.handleUpdate = this.handleUpdate.bind(this);
    this.handleChange = this.handleChange.bind(this);
    this.handleExit = this.handleExit.bind(this);
  }

  handleClick(event) {
    const buttonAction = event.target.textContent;
    const targetedProduct = event.target.value;
    if (buttonAction === "delete") {
      const endPoint = `http://localhost:8080/FashionProject/api/products/${targetedProduct}`;
      axios.delete(endPoint).then((response) => {
        console.log(response);
        this.setState({
          productIsDeleted: response.data,
        });
      });
      const tempProductList = this.state.productList.filter((product) => {
        return product.id != targetedProduct;
      });
      this.setState({
        productList: tempProductList,
      });
    }
    if (buttonAction === "Edit") {
      const endPoint = `http://localhost:8080/FashionProject/api/products/${targetedProduct}`;
      axios.get(endPoint).then((response) => {
        console.log(response);
        this.setState({
          productId: response.data.id,
          productName: response.data.name,
          productImagePath: response.data.productImageList[0].imagePath,
          productDescr: response.data.descr,
          popUpForEdit: true,
        });
      });
    }
  }

  getAllProducts() {
    const endpoint = `http://localhost:8080/FashionProject/api/products/user/${this.props.user.id}`;

    axios.get(endpoint).then((response) => {
      console.log(response);
      this.setState({
        productList: response.data,
      });
    });
  }

  componentDidMount() {
    this.getAllProducts();
  }

  handleResponseFromCloudinaryWidget(urlImages) {
    const tempImageList = [];
    tempImageList.push({ imagePath: urlImages.info.secure_url });
    this.setState({
      productImageList: tempImageList,
      productImagePath: urlImages.info.secure_url,
    });
  }

  handleUpdate(event) {
    event.preventDefault();
    const endPoint = `http://localhost:8080/FashionProject/api/products/${this.state.productId}`;
    const Product_object = {
      name: this.state.productName,
      descr: this.state.productDescr,
      productImageList: this.state.productImageList,
    };

    axios.post(endPoint, Product_object).then((response) => {
      console.log(response);
      this.getAllProducts();
      this.setState({
        popUpForEdit: false,
      });
    });
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
            <img src={this.state.productImagePath} />
            <div className="image-cloudinary-btn">
              <CloudinaryWidget
                passResponse={(data) =>
                  this.handleResponseFromCloudinaryWidget(data)
                }
              />
            </div>
          </div>
          <div className="update-details">
            <label htmlFor="product-update-name">Title</label>
            <input
              className="update-input-first styled-input"
              onChange
              form="update-form"
              type="text"
              value={this.state.productName}
              onChange={this.handleChange}
              id="product-update-name"
              name="productName"
            />
            <label htmlFor="brand-update-name">Description</label>
            <textarea
              className="update-input-second styled-input"
              form="update-form"
              value={this.state.productDescr}
              onChange={this.handleChange}
              name="productDescr"
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
              <h2 className="title-list">Products List</h2>
              <table className="my-table" onClick={this.handleClick}>
                <thead>
                  <tr>
                    <th>Id</th>
                    <th>Image</th>
                    <th>Name</th>
                    <th>Brand</th>
                    <th>Edit</th>
                    <th>Delete</th>
                  </tr>
                </thead>
                <tbody>
                  {this.state.productList.map((product) => {
                    return (
                      <tr>
                        <td>{product.id}</td>
                        <td>
                          <img
                            src={
                              product.productImageList.length != 0
                                ? product.productImageList[0].imagePath
                                : null
                            }
                          />
                        </td>
                        <td>{product.name}</td>
                        <td>{product.brand.name}</td>
                        <td>
                          <button value={product.id}>Edit</button>
                        </td>
                        <td>
                          <button value={product.id}>delete</button>
                        </td>
                      </tr>
                    );
                  })}
                </tbody>
              </table>
              <p className="message">
                {this.state.productIsDeleted ? "Succesfully Deleted" : ""}
              </p>
            </>
          )}
        </div>
      </>
    );
  }
}

export default ProductInspector;
