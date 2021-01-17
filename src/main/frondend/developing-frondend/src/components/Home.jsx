import React, { Component } from "react";
import axios from "axios";
class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {
      productList: [],
      likedProducts: [],
      checkedLikedProducts: new Map(),
    };
    this.findTheLikedProducts = this.findTheLikedProducts.bind(this);
    this.handleLikes = this.handleLikes.bind(this);
    this.addLikesInDb = this.addLikesInDb.bind(this);
    this.removeLikesInDb = this.removeLikesInDb.bind(this);
  }

  componentDidMount() {
    const endPoint = "http://localhost:8080/FashionProject/api/products";
    axios.get(endPoint).then((response) => {
      console.log(" ?????", response.data);
      this.findTheLikedProducts(response.data);
      this.setState({
        productList: response.data,
      });
    });
  }

  findTheLikedProducts(productDataList) {
    axios
      .get(
        `http://localhost:8080/FashionProject/api/likes/user/${this.props.authUser.id}`
      )
      .then((response) => {
        console.log(response);
        const likedProducts = response.data;
        const allProducts = productDataList;
        const checkedLikedProducts = new Map();
        allProducts.forEach((product) => {
          if (
            likedProducts.some((likedProduct) => likedProduct.id == product.id)
          ) {
            checkedLikedProducts.set(product.id, true);
          } else {
            checkedLikedProducts.set(product.id, false);
          }
        });
        this.setState({
          checkedLikedProducts,
          likedProducts,
        });
      });
  }

  handleLikes(productId) {
    const checkedLikedProducts = this.state.checkedLikedProducts;
    if (!this.state.checkedLikedProducts.get(productId)) {
      checkedLikedProducts.set(productId, true);
      this.addLikesInDb(productId);
    } else {
      checkedLikedProducts.set(productId, false);
      this.removeLikesInDb(productId);
    }
    this.setState({
      checkedLikedProducts,
    });
  }

  addLikesInDb(productId) {
    const endPoint = `http://localhost:8080/FashionProject/api/likes/user/${this.props.authUser.id}/product/${productId}`;
    axios.get(endPoint).then((response) => {
      console.log(response);
    });
  }

  removeLikesInDb(productId) {
    const endPoint = `http://localhost:8080/FashionProject/api/likes/user/${this.props.authUser.id}/product/${productId}`;
    axios.delete(endPoint).then((response) => {
      console.log(response);
    });
  }

  render() {
    console.log(this.state.checkedLikedProducts);
    return (
      <>
        <main className="home-container">
          <div className="posts-list-container">
            {this.state.productList.map((product) => {
              return (
                <>
                  <article className="post-container">
                    <section className="post-header-user-container">
                      <img
                        className="brand-image"
                        src={product.brand.imagePath}
                      />
                      <p className="brand-dtls">{product.name}</p>
                    </section>
                    <section className="post-image-container">
                      <img
                        onDoubleClick={() => this.handleLikes(product.id)}
                        className="post-image"
                        src={product.productImageList[0].imagePath}
                      />
                    </section>
                    <section className="post-interact-container">
                      <div className="rating-section">
                        <svg
                          onClick={() => this.handleLikes(product.id)}
                          className={
                            this.state.checkedLikedProducts.get(product.id)
                              ? "heart liked"
                              : "heart"
                          }
                          viewBox="0 0 32 29.6"
                        >
                          <path
                            d="M23.6,0c-3.4,0-6.3,2.7-7.6,5.6C14.7,2.7,11.8,0,8.4,0C3.8,0,0,3.8,0,8.4c0,9.4,9.5,11.9,16,21.2
	                            c6.1-9.3,16-12.1,16-21.2C32,3.8,28.2,0,23.6,0z"
                          />
                        </svg>
                        <i></i>
                      </div>
                      <div className="product-description">{product.descr}</div>
                    </section>
                  </article>
                </>
              );
            })}
          </div>
          <aside>Aside</aside>
        </main>
      </>
    );
  }
}

export default Home;
