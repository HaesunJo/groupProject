import http from "../http-common.js";

class RegistrationDataService {
  get(id, registered) {
    return http.get(`/${id}/classes?registered=${registered}`);
  }
}

export default new RegistrationDataService();
