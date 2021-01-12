import React, { Component } from "react";
import axios from "axios";
class ProductGenerator extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      descr: "",
      brand: {},
      productImageList: [],
    };
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
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
          console.log(res);
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
      imagePath: this.state.productImageList,
      brand: this.state.brand,
    };
    axios.put(endpoint, product_object).then((res) => {
      if (res.status === 200) {
        console.log(res);
      } else {
        console.log("not showing");
      }
    });
    event.target.reset();
  }

  render() {
    return (
      <>
        <form className="form-product-creator" onSubmit={this.handleFormSubmit}>
          <div className="product-name-input-container">
            <label htmlFor="product-name">Title</label>
            <input
              onChange={this.handleChange}
              type="text"
              id="product-name"
              name="name"
            />
          </div>
          <div className="product-descr-input-container">
            <label htmlFor="product-descr">Description</label>
            <input
              onChange={this.handleChange}
              type="text"
              id="product-descr"
              name="descr"
            />
          </div>
          <div className="product-image-input-container">
            <label htmlFor="product-image">Image</label>
            <input
              onChange={this.handleChange}
              type="text"
              id="product-image"
              name="image"
            />
          </div>
          <div className="product-brand-input-container">
            <label htmlFor="product-descr">Description</label>
            <input
              onChange={this.handleChange}
              type="text"
              id="product-descr"
              name="descr"
            />
          </div>
          <button>Submit</button>
        </form>
      </>
    );
  }
}

export default ProductGenerator;
