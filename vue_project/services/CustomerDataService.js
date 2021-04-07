import http from "../http-common.js";

class CustomerDataService {
  get(id) {
    return http.get(`/customer/${id}`);
  }

  unregister(id, data){
    return http.post(`/${id}/classes`, data);
  }

  register(id, data) {
    return http.post(`/${id}/classes`, data);
  }
  
}

export default new CustomerDataService();
