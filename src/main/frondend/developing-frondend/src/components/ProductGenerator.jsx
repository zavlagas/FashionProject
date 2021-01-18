import React, { Component } from "react";
import axios from "axios";
import CloudinaryWidget from "./CloudinaryWidget";
class ProductGenerator extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      descr: "",
      brandList: [],
      brand: 0,
      productImageList: [],
      imageContainerDisplay: false,
    };
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  handleResponseFromCloudinaryWidget(urlImages) {
    const imageList = this.state.productImageList;
    imageList.push({ imagePath: urlImages.info.secure_url });
    this.setState({
      productImageList: imageList,
      imageContainerDisplay: true,
    });
  }

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value,
    });
  }
  componentDidMount() {
    axios
      .get(
        `http://localhost:8080/FashionProject/api/brands/user/${this.props.user.id}`
      )
      .then((res) => {
        if (res.status === 200) {
          this.setState({
            brandList: res.data,
          });
        } else {
          console.log("not showing");
        }
      });
  }

  handleFormSubmit(event) {
    event.preventDefault();
    const endpoint = "http://localhost:8080/FashionProject/api/products";
    const product_object = {
      name: this.state.name,
      descr: this.state.descr,
      brand: { id: this.state.brand },
      productImageList: this.state.productImageList,
    };
    axios.put(endpoint, product_object).then((res) => {});
    event.target.reset();
  }

  render() {
   
    return (
      <>
        <div className="create-section">
          <form
            id="form-product-creator"
            onSubmit={this.handleFormSubmit}
          ></form>
          <div className="input-section">
            <label htmlFor="product-input-name">Title</label>
            <input
              className="styled-input"
              form="form-product-creator"
              onChange={this.handleChange}
              type="text"
              id="product-input-name"
              name="name"
            />
          </div>
          <div className="input-section">
            <label htmlFor="product-input-descr">Description</label>
            <textarea
              className="styled-input"
              form="form-product-creator"
              onChange={this.handleChange}
              type="text"
              id="product-input-descr"
              name="descr"
            />
          </div>
          <div className="input-section">
            <label htmlFor="product-brand">Brand</label>
            <select
              className="styled-input"
              form="form-product-creator"
              onChange={this.handleChange}
              id="product-brand"
              name="brand"
            >
              <option value="" selected disabled hidden>
                Choose here
              </option>
              {this.state.brandList.map((brand) => {
                return <option value={brand.id}>{brand.name}</option>;
              })}
            </select>
          </div>
          <div className="input-section">
            <label htmlFor="brand-image">Image</label>
            <CloudinaryWidget
              passResponse={(data) =>
                this.handleResponseFromCloudinaryWidget(data)
              }
            />
          </div>
          <button className="create-btn" form="form-product-creator">
            Submit
          </button>
        </div>
      </>
    );
  }
}

export default ProductGenerator;
