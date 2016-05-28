import React, {Component} from 'react';
import {reduxForm} from 'redux-form';
import * as actions from '../../actions';

class Signin extends Component {

  handleFormSubmit({email, password}) {
    // login the user here
    this.props.signinUser({email, password});
  }

  renderAlert() {
    if(this.props.errorMessage){
      return (
        <div className="alert alert-danger">
          <strong>Ooop! </strong>{this.props.errorMessage}
        </div>
      );
    }
  }

  render() {
    const {handleSubmit, fields: {email, password }} = this.props;
    return (
      <form onSubmit={handleSubmit(this.handleFormSubmit.bind(this))}>
        <fieldset className="form-group">
          <label>Email:</label>
          <input {...email} className="form-control"></input>
        </fieldset>
        <fieldset className="form-group">
          <label>Password:</label>
          <input {...password} className="form-control"></input>
        </fieldset>
        {this.renderAlert()}
        <button action="submit" className="btn btn-primary">Sign in</button>
      </form>
    );
  }
}

function mapStateToProps(state){
  console.log('Mapping ', state);
  return { errorMessage: state.authReducer.error };
}

// this injects all actions into the props.
export default reduxForm({
  form: 'signin',
  fields: ['email', 'password']
}, mapStateToProps, actions)(Signin);
