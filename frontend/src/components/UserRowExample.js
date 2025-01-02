import React from "react";

const UserRowExample = ({ user }) => {
  return (
    <tr key={user.email}>
      <td> {user.id} </td>
      <td> {user.last_name} </td>
      <td> {user.email} </td>
      <td>
        <img
          src={user.avatar}
          className="img-thumbnail"
          style={{
            width: 50,
          }}
          alt={user.last_name}
        />
      </td>
    </tr>
  );
};

export default UserRowExample;
