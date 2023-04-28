import { configureStore } from "@reduxjs/toolkit";
import { authApi } from "./apis/authApi";
import authReducer from "./slice/authSlice";


// Context API + useReducer có thể thay thế cho redux
const store = configureStore({
    reducer: {
        [authApi.reducerPath]: authApi.reducer,
        auth: authReducer
    },
    middleware: (getDefaultMiddleware) =>
        getDefaultMiddleware().concat(
            authApi.middleware
        ),
});

export default store;