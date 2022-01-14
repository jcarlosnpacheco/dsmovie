import axios from 'axios';
import { useEffect, useState } from 'react';

import MovieCard from '../../components/MovieCard';
import Pagination from '../../components/Pagination';
import { MoviePage } from '../../types/moviepage';
import { BASE_URL } from '../../utils/requests';

function Listing() {
  //controla o ciclo de vida/estado da aplicação // parâmetro 0 é apenas para iniciar o useState na posição 0
  const [pageNumber, setPageNumber] = useState(0);

  //construimos um objeto/estado padrão para iniciar o page inicial
  const [page, setPage] = useState<MoviePage>({
    content: [],
    last: true,
    totalPages: 0,
    totalElements: 0,
    size: 12,
    number: 0,
    first: true,
    numberOfElements: 0,
    empty: true,
  });

  //garante que somente será executado quando o pagenumber mudar
  useEffect(() => {
    axios
      .get(`${BASE_URL}/movies?size=12&page=${pageNumber}`)
      .then((response) => {
        const data = response.data as MoviePage;
        setPage(data);
      });
  }, [pageNumber]);

  return (
    <>
      <Pagination />

      <div className="container">
        <div className="row">
          {page.content.map((movie) => (
            <div key={movie.id} className="col-sm-6 col-lg-4 col-xl-3">
              <MovieCard movie={movie} />
            </div>
          ))}
        </div>
      </div>
    </>
  );
}

export default Listing;
