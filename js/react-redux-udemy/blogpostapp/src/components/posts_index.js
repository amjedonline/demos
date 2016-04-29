import React, {Component} from 'react';
import {connect} from 'react-redux';
import {fetchPosts} from '../actions/index';
import {Link} from 'react-router';

class PostsIndex extends Component {

  componentWillMount(){
    console.log('This will be a good time to call action creator.');
    this.props.fetchPosts();
  }

  render(){
    return (
        <div>
          <div className="text-xs-right">
            <Link to="/posts/new" className="btn btn-primary">
              Add a Post
            </Link>
          </div>
          List of Blog posts
        </div>
    );
  }
}

// no need of mapActionCreatorsToProps/bindActionCreators method
export default connect(null, {fetchPosts})(PostsIndex);
