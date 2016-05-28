import React, {Component} from 'react';
import {connect} from 'react-redux';
import {Link} from 'react-router';

class Header extends Component {
  constructor(props){
    super(props);
  }

  renderLinks() {
    if(this.props.authenticated){
      return (
        <li className="nav-item">
          <Link className="nav-link" to="/signout">Sign out</Link>
        </li>
      );
    } else {
      return ([
        <li className="nav-item" key={1}>
          <Link className="nav-link" to="/signin">Sign in</Link>
        </li>,
        <li className="nav-item" key={2}>
          <Link className="nav-link" to="/signout">Sign out</Link>
        </li>
      ]);
    }
  }

  render(){
    return (
      <nav className="navbar navbar-light">
        <ul className="nav navbar-nav">
          {this.renderLinks()}
        </ul>
      </nav>
    );
  }
}

function mapStateToProps(state){
  return {authenticated: state.authReducer.authenticated};
}

export default connect(mapStateToProps)(Header);
