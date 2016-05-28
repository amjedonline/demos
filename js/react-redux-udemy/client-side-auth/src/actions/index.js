import axios from 'axios';
import {browserHistory} from 'react-router';

import {
  AUTH_USER,
  AUTH_ERROR,
  UNAUTH_USER
} from './types';

const ROOT_URL='http://54.235.165.54:3000/api/authentication/jwt_token';
export function signinUser({email, password}) {
  // this is how we get direct access to the Dispatch

  return function(dispatch){
    // Submit email password to server
    // this forms an object like
    // {email:email, password:password}
    axios.post(`${ROOT_URL}`,
      { email, password, registration_id: 'dummy-1234', scope: 'driver' })
      .then(response=> {
      // if request is good...
        console.log('Logged in successfully.', response);

        // - update state to indicate user is authenticated
        dispatch({type: AUTH_USER});

        // - save the JWT token
        console.log(response.data.token);
        localStorage.setItem('token', response.data.token);

        // - redirect to the route /feature
        console.log(browserHistory);
        browserHistory.push('/feature');
      })
      .catch(function (response) {
        console.log('Bad email/password.', response);
        // If request is bad...
        dispatch(authError('Bad Login Info'));
        // - Show an error to the user
      });
    }
}

export function authError(error) {
  console.log('Called with ', error);
  return {
    type: AUTH_ERROR,
    payload: error
  }
}

export function signoutUser(){
  localStorage.removeItem('token');
  return {type: UNAUTH_USER};
}
