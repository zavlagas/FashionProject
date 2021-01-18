import React from "react";
class SearchPosts extends React.Component {
  constructor(props) {
    super(props);
    this.state = {
      productNameValue: "",
      productNameMessage: "",
      productDescriptionValue: "",
      productDescriptionMessage: "",
      productBrandValue: "",
    };
    this.handleOnInputChange = this.handleOnInputChange.bind(this);
  }

  searchTitle(query) {
    const filterList = this.props.data.filter((product) => {
      return product.name.toLowerCase().includes(query);
    });

    if (filterList.length === 0) {
      this.setState({
        productNameMessage: "This Title Does Not Exist",
        productNameValue: query,
      });
    } else {
      this.setState({
        productNameMessage: "",
        productNameValue: query,
      });
      this.props.filter(filterList);
    }
  }

  searchDescription(query) {
    const filterList = this.props.data.filter((product) => {
      return product.descr.toLowerCase().includes(query);
    });

    if (filterList.length === 0) {
      this.setState({
        productDescriptionMessage: "This Description Does Not Exist",
        productDescriptionValue: query,
      });
    } else {
      this.setState({
        productDescriptionMessage: "",
        productDescriptionValue: query,
      });
      this.props.filter(filterList);
    }
  }

  handleOnInputChange = (event) => {
    const query = event.target.value.toLowerCase();
    if (event.target.id === "search-title-input") {
      this.searchTitle(query);
    }
    if (event.target.id === "search-description-input") {
      this.searchDescription(query);
    }
  };

  render() {
    return (
      <>
        <div className="filter-child-container">
          <label className="search-label" htmlFor="search-title-input">
            Search Title
          </label>
          <input
            type="text"
            id="search-title-input"
            className="styled-input"
            placeholder="Satin Dress.."
            value={this.state.productNameValue}
            onChange={this.handleOnInputChange}
          />
          <p className="message">{this.state.productNameMessage}</p>
        </div>
        <div className="filter-child-container">
          <label htmlFor="search-description-input">Search Description</label>
          <input
            type="text"
            id="search-description-input"
            className="styled-input"
            placeholder="Fabric.."
            value={this.state.productDescriptionValue}
            onChange={this.handleOnInputChange}
          />
          <p className="message">{this.state.productDescriptionMessage}</p>
        </div>
        <div className="filter-child-container">
          <label htmlFor="search-brand-input">Search Brand</label>
          <select
            type="text"
            id="search-brand-input"
            className="styled-input"
            value={this.state.productBrandValue}
            onChange={this.handleOnInputChange}
          >
            <option value="" selected disabled hidden>
              Choose here
            </option>
            <option>1</option>
            <option>2</option>
            <option>3</option>
            <option>4</option>
            <option>5</option>
          </select>
          <p className="message">{this.state.productDescriptionMessage}</p>
        </div>
      </>
    );
  }
}
export default SearchPosts;