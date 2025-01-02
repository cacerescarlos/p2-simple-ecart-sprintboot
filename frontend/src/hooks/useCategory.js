import axios from "axios";
import { useEffect, useState } from "react";

const useCategory = () => {
  const [list, setList] = useState([]);

  useEffect(() => {
    findAll();
  }, []);

  const findAll = async () => {
    const service = axios.create();
    const resp = await service.get("http://localhost:8085/categories");
    setList(resp.data);    
  };

  return {
    list,
  };
};

export default useCategory;
