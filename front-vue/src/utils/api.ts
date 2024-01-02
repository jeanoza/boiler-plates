// api.js
import axios, { AxiosError } from 'axios'

// Set your base URL or other Axios configurations here
axios.defaults.baseURL = 'http://localhost:8080/api' // Replace with your base URL

// Generic function to make an HTTP request
export const fetchData = async <T>(method: string, url: string, data?: T) => {
  return axios({
    method,
    url,
    data: data ?? null,
    withCredentials: true
  })
    .then((response) => response.data)
    .catch((error: Error | AxiosError) => {
      const msg = axios.isAxiosError(error) ? error?.response?.data : error?.message
      console.error(`Error ${method} request to ${url}: ${msg}`)
      throw Error(msg)
    })
}
