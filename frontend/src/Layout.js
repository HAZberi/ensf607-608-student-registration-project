import React from "react";
import { Suspense } from "react";
import { useLoaderData, Outlet, Await } from "react-router-dom";
import { AuthProvider } from "./hooks/useAuth";

import Header from "./Header";

const Layout = () => {
  const { userPromise } = useLoaderData();
  return (
    <>
      <Suspense
        fallback={
          <div className="d-flex justify-content-center">
            <div
              className="spinner-border"
              style={{ width: "5rem", height: "5rem", marginTop: "10rem" }}
              role="status"
            >
              <span className="visually-hidden">Loading...</span>
            </div>
          </div>
        }
      >
        <Await
          resolve={userPromise}
          errorElement={<h1>Something went wrong</h1>}
          children={(user) => (
            <AuthProvider userData={user}>
              <Header />
              <Outlet />
            </AuthProvider>
          )}
        />
      </Suspense>
    </>
  );
};

export default Layout;
