import React from "react";
import useCategory from "../../hooks/useCategory";

const CategoryList = () => {
  const { list } = useCategory();
  const title = "Categorias";

  return (
    <div className="mt-5">
      <h1>{title}</h1>
      <hr></hr>
      <table className="table">
        <thead>
          <tr>
            <th>ID</th>
            <th>Nombre</th>
            <th>Descripción</th>
            <th>Acción</th>
          </tr>
        </thead>
        <tbody>
          {
          
          
          
          list.map((item) => (
            <tr key={item.id}>
              <td> {item.id} </td>
              <td> {item.name} </td>
              <td> {item.description} </td>
              <td>
                <button>editar</button>&nbsp;
                <button>X</button>
              </td>
            </tr>
          ))
          
          }
        </tbody>
      </table>
    </div>
  );

};

export default CategoryList;
