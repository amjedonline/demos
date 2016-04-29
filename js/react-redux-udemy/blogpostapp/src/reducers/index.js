import { combineReducers } from 'redux';
import { PostsReducer } from './reducer_posts';

const rootReducer = combineReducers({
  all: PostsReducer
});

export default rootReducer;
