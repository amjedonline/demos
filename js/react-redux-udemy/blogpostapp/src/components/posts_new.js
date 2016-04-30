import React, {Component} from 'react';
import {reduxForm} from 'redux-form';
import { createPost } from '../actions/index';

class PostsNew extends Component {
  render() {
    // this is like handleSubmit = this.props.handleSubmit;
    // and title = this.props.fields.title
    const {fields:{title, categories, content}, handleSubmit} = this.props;
    console.log(title);
    // {...title} -> destructures and passes the values as key value pair for instance.

    // passing in to handleSubmit is optional, if nothing is passed the method from this.props.onSubmit is called/bound.
    return (
      <form onSubmit={handleSubmit(this.props.createPost)}>
        <h3>Create a new form</h3>

        <div className="form-group">
          <label>Title</label>

          <input type="text" className="form-control" {...title}/>
        </div>

        <div className="form-group">
          <label>Categories</label>
          <input type="text" className="form-control" {...categories}/>
        </div>

        <div className="form-group">
          <label>Content</label>
          <textarea className="form-control"  {...content}/>
        </div>

        <button type="submit" className="btn btn-pimary">Submit</button>
      </form>
    );
  }
}

// Integrate the redux-form by calling in the funcitn, and passing in the Component name.

// connect: first argument is mapStateToProps
//2nd is mapDispatchtoProps
// reduxForm: 1st is form config, 2nd is mapStateToProps, 3rd is mapDispatchToProps

const configObject = {
  form: 'PostsNewForm',
  fields: ['title', 'categories', 'content']
};

const mapStateToProps = (state) => {
  return {
      onSubmit: () =>{console.log('Hello I was called.');}
  };
};

// mapStateToProps, we will rather let pass in other ways

export default reduxForm(configObject, null , { createPost })(PostsNew);
