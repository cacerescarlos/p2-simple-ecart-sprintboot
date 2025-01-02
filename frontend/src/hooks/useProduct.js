import axios from "axios";
import { useEffect, useState } from "react";

const useProduct = () => {
  const [data, setList] = useState([]);

  useEffect(() => {
    findAll();
  }, []);

  const findAll = async () => {
    const service = axios.create();
    const resp = await service.get("http://localhost:8085/products/pageable?page=0&size=20");    
    setList(resp.data.content);    
  };

  return {
    data,
  };
};

export default useProduct;
