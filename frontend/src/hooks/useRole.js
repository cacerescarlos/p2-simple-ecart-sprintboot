import axios from "axios";
import { useEffect, useState } from "react";

const useRole = () => {
  const [list, setList] = useState([]);

  useEffect(() => {
    findAll();
  }, []);

  const findAll = async () => {
    const service = axios.create();
    const resp = await service.get("http://localhost:8085/roles");
    setList(resp.data);    
  };

  return {
    list,
  };
};

export default useRole;
