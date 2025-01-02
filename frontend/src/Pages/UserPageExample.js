import React from 'react'
import UserRowExample from '../components/UserRowExample';
import { useUserExample } from '../hooks/useUserExample';

const UserPageExample = () => {
    const { users } = useUserExample();

  return (
    <div className='mt-5' >
      <h1>Usuarios</h1>
      <hr></hr>
        <table className='table' >
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nombre</th>
                    <th>Descripción</th>
                    <th>Imagen</th>
                </tr>
            </thead>
            <tbody>

                {
                    users.map(user=>(
                    <UserRowExample 
                        key={user.email}
                        user={user}
                    />
                    ))
                }
                
            </tbody>
        </table>
    </div>
  )
}

export default UserPageExample
