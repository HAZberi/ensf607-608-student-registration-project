import React from "react";
import {
  createBrowserRouter,
  RouterProvider,
  createRoutesFromElements,
  Route,
} from "react-router-dom";

import Layout from "./Layout";
import CourseCatalogue from "./CourseCatalogue";
import RegisteredCourses from "./RegisteredCourses";

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route element={<Layout />}>
      <Route
        path="/"
        element={
          <div className="d-flex justify-content-center mt-5">
            <h1 className="text-center">
              Welcome to Course Registeration System
            </h1>
          </div>
        }
      />
      <Route
        path="/courses"
        element={
          <CourseCatalogue />
        }
      />
      <Route
        path="/reg-courses"
        element={<RegisteredCourses />}
      />
    </Route>
  )
);

function App() {
  return (
    <>
      <RouterProvider router={router} />
    </>
  );
}

export default App;
