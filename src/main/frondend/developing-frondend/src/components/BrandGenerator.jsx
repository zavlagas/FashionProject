import React, { Component } from "react";
import axios from "axios";
class BrandGenerator extends Component {
  constructor(props) {
    super(props);
    this.state = {
      name: "",
      descr: "",
      image: "",
    };
    this.handleFormSubmit = this.handleFormSubmit.bind(this);
    this.handleChange = this.handleChange.bind(this);
  }

  handleChange(event) {
    this.setState({
      [event.target.name]: event.target.value,
    });
  }

  handleFormSubmit(event) {
    event.preventDefault();
    const endpoint = "http://localhost:8080/FashionProject/api/brands";
    const brand_object = {
      name: this.state.name,
      descr: this.state.descr,
      imagePath: this.state.image,
      user: this.props.user.id,
    };
    axios.put(endpoint, brand_object).then((res) => {
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
        <form className="form-brand-creator" onSubmit={this.handleFormSubmit}>
          <div className="brand-name-input-container">
            <label htmlFor="brand-name">Title</label>
            <input
              onChange={this.handleChange}
              type="text"
              id="brand-name"
              name="name"
            />
          </div>
          <div className="brand-descr-input-container">
            <label htmlFor="brand-descr">Description</label>
            <input
              onChange={this.handleChange}
              type="text"
              id="brand-descr"
              name="descr"
            />
          </div>
          <div className="brand-image-input-container">
            <label htmlFor="brand-image">Image</label>
            <input
              onChange={this.handleChange}
              type="text"
              id="brand-image"
              name="image"
            />
          </div>
          <button>Submit</button>
        </form>
      </>
    );
  }
}

export default BrandGenerator;
