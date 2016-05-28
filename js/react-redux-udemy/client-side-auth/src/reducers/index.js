import { combineReducers } from 'redux';
import {reducer as form} from 'redux-form';
import authReducer from './auth_reducer';

// ES6 magic reducer as form!
const rootReducer = combineReducers({
  form,
  authReducer
});

export default rootReducer;
