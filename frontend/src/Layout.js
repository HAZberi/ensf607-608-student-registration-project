import React from "react";
import { Suspense } from "react";
import { useLoaderData, Outlet, Await } from "react-router-dom";
import { AuthProvider } from "./hooks/useAuth";

import Header from "./Header";

const Layout = () => {
  const { userPromise } = useLoaderData();
  return (
    <>
      <Suspense fallback={<div>Loading</div>}>
        <Await
          resolve={userPromise}
          errorElement={<div>Something went wrong</div>}
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
