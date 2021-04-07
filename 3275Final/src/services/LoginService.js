import http from "../http-common.js";

class LoginService {
  login(data) {
    return http.post("/login", data);
  }
  loginManager(data) {
    return http.post("/loginmanager", data);
  }
}

export default new LoginService();