import React from 'react'
import ReactDOM from 'react-dom/client'
import App from './App'
import { BrowserRouter } from 'react-router-dom'
import store from './app/store';
import { Provider } from 'react-redux';
import "./App.css"
import 'bootstrap/dist/css/bootstrap.min.css'
import 'bootstrap/dist/js/bootstrap.bundle.min'; 

ReactDOM.createRoot(document.getElementById("root")).render(
  <React.StrictMode>
      <Provider store={store}>
          <BrowserRouter>
              <App />
          </BrowserRouter>
      </Provider>
  </React.StrictMode>
);