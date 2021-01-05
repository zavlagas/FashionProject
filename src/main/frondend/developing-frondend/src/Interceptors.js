const axios = require("axios");



axios.interceptors.request.use(
  function (config) {
    const jwtToken = localStorage.getItem("authorization");
    console.log({ jwtToken: jwtToken });
    if (jwtToken) {
      config.headers["authorization"] = "Bearer " + jwtToken;
    }
    return config;
  },
  function (err) {
    return Promise.reject(err);
  }
);
