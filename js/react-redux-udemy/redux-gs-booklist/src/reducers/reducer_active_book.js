// State argument is anot application state, only the state this reducer is responsible for.
// Reducers are not allowed to return an 'undefined' state
export default function(state=null, action) {
  switch(action.type){
    case 'BOOK_SELECTED':
      return action.payload
  }
  return state
}
