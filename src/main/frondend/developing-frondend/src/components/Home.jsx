import React, { Component } from "react";

class Home extends Component {
  constructor(props) {
    super(props);
    this.state = {};
  }

  render() {
    return (
      <>
        <main className="home-container">
          <div className="posts-list-container">
            <article className="post-container">
              <section className="post-header-user-container">
                <img
                  className="user-image"
                  src="https://picsum.photos/100/100"
                />
                <p className="user-dtls">Nick Zavlagas</p>
              </section>
              <section className="post-image-container">
                <img
                  className="post-image"
                  src="https://picsum.photos/800/800"
                />
              </section>
              <section className="post-interact-container">
                <i class="far fa-heart"></i>
              </section>
            </article>
          </div>
          <aside>Aside</aside>
        </main>
      </>
    );
  }
}

export default Home;
