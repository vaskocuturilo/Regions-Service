import axios from "axios";

const apiToken = process.env.REACT_APP_TOKEN;
if (!apiToken) {
    console.error("REACT_APP_TOKEN is not defined.");
}

const apiClient = axios.create({
    baseURL: "/api/v1",
    headers: {
        "Content-Type": "application/json",
        "X-API-KEY": apiToken,
    },
    timeout: 5000,
});


apiClient.interceptors.request.use(
    (config) => {
        return config;
    },
    (error) => {
        return Promise.reject(error);
    }
);

apiClient.interceptors.response.use(
    (response) => {
        // Handle successful responses
        return response;
    },
    (error) => {
        console.error("API Error: ", error);
        return Promise.reject(error);
    }
);

export default apiClient;
