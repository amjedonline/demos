import React, {Component, PropTypes} from 'react';
import {reduxForm} from 'redux-form';
import { createPost } from '../actions/index';
import {Link} from 'react-router';

class PostsNew extends Component {

  static contextTypes = {
    router: PropTypes.object
  }

  onSubmit(props){
    this.props.createPost(props)
      .then(() => {
        // blog post has been created, navigate the user to the index
        // We navigate by calling this.context.router.push with
        // the new path to navigate to.
        this.context.router.push('/');
      });
  }

  render() {
    // this is like handleSubmit = this.props.handleSubmit;
    // and title = this.props.fields.title
    const {fields:{title, categories, content}, handleSubmit} = this.props;
    console.log(title);
    // {...title} -> destructures and passes the values as key value pair for instance.

    // passing in to handleSubmit is optional, if nothing is passed the method from this.props.onSubmit is called/bound.
    return (
      <form onSubmit={handleSubmit(this.onSubmit.bind(this))}>
        <h3>Create a new form</h3>

        <div className={`form-group ${title.touched && title.invalid? 'has-danger' : ''}`}>
          <label>Title</label>
          <input type="text" className="form-control" {...title}/>
          <div className="text-help">
            {title.touched ? title.error : ""}
          </div>
        </div>

        <div className={`form-group ${categories.touched && categories.invalid? 'has-danger' : ''}`}>
          <label>Categories</label>
          <input type="text" className="form-control" {...categories}/>
          <div className="text-help">
            {categories.touched ? categories.error : ""}
          </div>
        </div>

        <div className={`form-group ${content.touched && content.invalid? 'has-danger' : ''}`}>
          <label>Content</label>
          <textarea className="form-control"  {...content}/>
          <div className="text-help">
            {content.touched ? content.error : ""}
          </div>
        </div>

        <button type="submit" className="btn btn-pimary">Submit</button>
        <Link to="/" className="btn btn-danger">Cancel</Link>
      </form>
    );
  }
}

//validation
// add validation function in redux-form configObject
function validate(values) {
  const errors = {};
  if(!values.title){
    errors.title='Enter a title';
  }

  if(!values.categories){
    errors.categories='Enter atleast 1 category';
  }

  if(!values.content){
    errors.content='Blog post content cannot be empty';
  }

  return errors;
}

// Integrate the redux-form by calling in the funcitn, and passing in the Component name.

// connect: first argument is mapStateToProps
//2nd is mapDispatchtoProps
// reduxForm: 1st is form config, 2nd is mapStateToProps, 3rd is mapDispatchToProps

const configObject = {
  form: 'PostsNewForm',
  fields: ['title', 'categories', 'content'],
  validate
};

const mapStateToProps = (state) => {
  return {
      onSubmit: () =>{console.log('Hello I was called.');}
  };
};

// mapStateToProps, we will rather let pass in other ways

export default reduxForm(configObject, null , { createPost })(PostsNew);
