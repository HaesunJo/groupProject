import http from "../http-common.js";

class ManagerLogin {
  login(data) {
    return http.post("/loginmanager", data);
  }
}

export default new ManagerLogin();

