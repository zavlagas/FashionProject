import React, { Component } from "react";
import axios from "axios";

class BrandsInspector extends Component {
  constructor(props) {
    super(props);
    this.state = {
      brandsList: [],
      brandIsDeleted: false,
      editBrand: {},
      popUpForEdit: false,
    };
    this.handleClick = this.handleClick.bind(this);
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
        this.setState({
          editBrand: response.data,
          popUpForEdit: true,
        });
      });
    }
  }

  componentDidMount() {
    const endpoint = "http://localhost:8080/FashionProject/api/brands";

    axios.get(endpoint).then((response) => {
      this.setState({
        brandsList: response.data,
      });
    });
  }

  popUpContainer() {
    return (
      <>
        <div className="popup-content">
          <h1>Hi from Popup</h1>
        </div>
      </>
    );
  }

  render() {
    return (
      <>
        <div id="brands-container">
          {this.state.popUpForEdit ? (
            this.popUpContainer()
          ) : (
            <>
              <h2 className="brands-title-list">Brands List</h2>
              <table className="brands-table" onClick={this.handleClick}>
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
