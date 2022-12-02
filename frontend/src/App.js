import React from "react";
import {
  createBrowserRouter,
  RouterProvider,
  createRoutesFromElements,
  Route,
  defer,
} from "react-router-dom";

import Layout from "./Layout";
import CourseCatalogue from "./CourseCatalogue";
import RegisteredCourses from "./RegisteredCourses";
import NotSignedIn from "./NotSignedIn";

const getUserData = () =>
  new Promise((resolve) =>
    setTimeout(() => {
      const user = window.localStorage.getItem("user");
      resolve(user);
    }, 1000)
  );

const router = createBrowserRouter(
  createRoutesFromElements(
    <Route
      element={<Layout />}
      loader={() => defer({ userPromise: getUserData() })}
    >
      <Route
        path="/"
        element={
          <>
            <div className="d-flex justify-content-center mt-5 mb-5">
              <h1 className="text-center">
                Welcome to Course Registeration System
              </h1>
            </div>
            <NotSignedIn />
          </>
        }
      />
      <Route path="/courses" element={<CourseCatalogue />} />
      <Route path="/reg-courses" element={<RegisteredCourses />} />
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
