import axios from 'axios'

const API_URL = 'http://localhost:8080/ad'

class AdService {
  getAllAds () {
    return axios.get(API_URL + '/all')
  }
}

export default new AdService()
