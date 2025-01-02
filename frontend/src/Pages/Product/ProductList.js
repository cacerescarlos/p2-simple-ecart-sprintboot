import React from 'react'
import useProduct from '../../hooks/useProduct';

export default function ProductList() {
  const { data } = useProduct();
  console.log(data);
  const title = "Productos";

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
          <th>Imagen</th>
          <th>Precio</th>
          <th>Stock</th>
          <th>Estado</th>
          <th>Categoria</th>
          <th>Acción</th>
        </tr>
      </thead>
      <tbody>
        {        
        
        data.map((item) => (
          <tr key={item.id}>
            <td> {item.id} </td>
            <td> {item.name} </td>
            <td> {item.description} </td>
            <td>
                <img
                  src={item.imageUrl}
                  className="img-thumbnail"
                  style={{
                    width: 50,
                  }}
                  alt={item.name}
                />              
            </td>
            <td> {item.price} </td>
            <td> {item.stock} </td>
            <td> {item.active} </td>
            <td> {item.category.name} - {item.category.description}  </td>
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
  )
}
