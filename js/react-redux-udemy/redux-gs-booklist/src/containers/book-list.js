import React, { Component } from 'react';

// forge the connection to redux
// pull off a single property, connect function
import { connect } from 'react-redux';

class BookList extends Component {

  renderList() {
    return this.props.books.map((book) => {
      return (
        <li key={book.title} className="list-group-item">{book.title}</li>
      )
    });
  }

  render() {
    return (
      <ul className="list-group col-sm-4">
        {this.renderList()}
      </ul>
    );
  }

}

function mapStateToProps(state) {
  // Whatever is returned will show up as props inside of BookList
  return {
    books: state.books
  };
}

console.log('Hello world');
// Takes a function and a component and returns a container
export default connect(mapStateToProps)(BookList)
