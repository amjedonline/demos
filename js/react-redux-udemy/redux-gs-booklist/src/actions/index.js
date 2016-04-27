export function selectBook(book) {
  // SelectBook is an ActionCreator it needs to return an Action.
  // An object ith a type property
  return {
    type: 'BOOK_SELECTED',
    payload: book
  };
}
