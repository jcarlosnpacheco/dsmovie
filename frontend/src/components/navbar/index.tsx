import './style.css';

import { ReactComponent as GithubIcon } from '../../assets/img/githubicon.svg';

function Navbar() {
  return (
    <header>
      <nav className="container">
        <div className="dsmovie-nav-content">
          <h1>DSMovie</h1>
          <a
            href="https://github.com/jcarlosnpacheco/dsmovie"
            target="_blank"
            rel="noreferrer"
          >
            <div className="dsmovie-contact-container">
              <GithubIcon />
              <p className="dsmovie-contact-link">/jcarlosnpacheco</p>
            </div>
          </a>
        </div>
      </nav>
    </header>
  );
}

export default Navbar;
