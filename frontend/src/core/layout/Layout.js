import React from "react";
import { Outlet, Link } from "react-router-dom";

export default function Layout() {
  const menu = [""];

  return (
    <div>
      <nav>
        <ul>
          <li>
            <Link to="/categories">Categorias</Link>
          </li>
          <li>
            <Link to="/products">Productos</Link>
          </li>
          <li>
            <Link to="/roles">Roles</Link>
          </li>
          <li>
            <Link to="*">Default</Link>
          </li>
        </ul>
      </nav>
      <hr />
      <Outlet />
    </div>
  );
}
