import React, { Component } from "react";
import axios from "axios";
import CloudinaryWidget from "./CloudinaryWidget";
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

  handleResponseFromCloudinaryWidget(urlImages) {
    this.setState({
      image: urlImages.info.secure_url,
    });
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
      creationDate: new Date(),
      imagePath: this.state.image,
      user: this.props.user.id,
    };

    

    axios.post(endpoint, brand_object).then((res) => {
      if (res.status === 200) {
        // console.log(res);
      } else {
        console.log("not showing");
      }
    });
    event.target.reset();
  }

  render() {
    return (
      <>
        <div className="create-section">
          <form id="form-brand-creator" onSubmit={this.handleFormSubmit}></form>
          <div className="input-section">
            <label htmlFor="brand-name">Title</label>
            <input
              className="styled-input"
              form="form-brand-creator"
              onChange={this.handleChange}
              type="text"
              id="brand-name"
              name="name"
            />
          </div>
          <div className="input-section">
            <label htmlFor="brand-descr">Description</label>
            <textarea
              className="styled-input"
              form="form-brand-creator"
              onChange={this.handleChange}
              type="text"
              id="brand-descr"
              name="descr"
            />
          </div>
          <div className="input-section">
            <label htmlFor="brand-image">Image</label>
            <CloudinaryWidget
              passResponse={(data) =>
                this.handleResponseFromCloudinaryWidget(data)
              }
            />
          </div>
          <button className="create-btn" form="form-brand-creator">
            Submit
          </button>
        </div>
      </>
    );
  }
}

export default BrandGenerator;
