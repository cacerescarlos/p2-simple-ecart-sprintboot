import { useEffect, useState } from "react";
import { userServiceExample } from "../services/UserServiceExample";

export const useUserExample = () => {
  const [users, setUsersExample] = useState([]);

  useEffect(() => {
    getUsersExample();
  }, []);

  const getUsersExample = async () => {
    const resp = await userServiceExample.get("https://reqres.in/api/users");
    setUsersExample(resp.data.data);
    console.log(resp.data.data);
  };
  return {
    users,
  };
};
