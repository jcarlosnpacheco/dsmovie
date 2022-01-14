import axios from 'axios';
import { useEffect, useState } from 'react';

import MovieCard from '../../components/MovieCard';
import Pagination from '../../components/Pagination';
import { BASE_URL } from '../../utils/requests';

function Listing() {
  //controla o ciclo de vida/estado da aplicação
  const [pageNumber, setPageNumber] = useState(0);

  //garante que somente será executado uma vez essa requisição abaixo
  useEffect(() => {
    axios.get(`${BASE_URL}/movies?size=12&page=0`).then((response) => {
      console.log(response.data);
    });
  }, []);

  return (
    <>
      <Pagination />

      <div className="container">
        <div className="row">
          <div className="col-sm-6 col-lg-4 col-xl-3">
            <MovieCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3">
            <MovieCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3">
            <MovieCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3">
            <MovieCard />
          </div>
          <div className="col-sm-6 col-lg-4 col-xl-3">
            <MovieCard />
          </div>
        </div>
      </div>
    </>
  );
}

export default Listing;
