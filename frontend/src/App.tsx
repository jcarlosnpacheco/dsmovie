import { BrowserRouter, Route, Routes } from 'react-router-dom';

import Navbar from './components/navbar';
import Form from './pages/Form/Index';
import Listing from './pages/Listing/Index';

function App() {
  return (
    <BrowserRouter>
      <Navbar />
      <Routes>
        <Route path="/" element={<Listing />} />
        <Route path="/form">
          <Route path=":movieId" element={<Form />} />
        </Route>
      </Routes>
    </BrowserRouter>
  );
}

export default App;
