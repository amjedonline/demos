import React, {Component} from 'react';
import {connect} from 'react-redux';
import {fetchPosts} from '../actions/index';
import {Link} from 'react-router';

class PostsIndex extends Component {

  componentWillMount(){
    console.log('This will be a good time to call action creator.');
    this.props.fetchPosts();
  }

  renderPosts(){
    console.log(this.props.posts);
    return this.props.posts.map((post) => {
      return (
        <li className="list-group-item" key={post.id}>
          <Link to={"posts/"+post.id}>
            <span className="pull-xs-right">{post.categories}</span>
            <strong>{post.title}</strong>
          </Link>
        </li>
      );
    });
  }

  render(){
    return (
        <div>
          <div className="text-xs-right">
            <Link to="/posts/new" className="btn btn-primary">
              Add a Post
            </Link>
          </div>
          <h3>Posts</h3>
          <ul className="list-group">
            {this.renderPosts()}
          </ul>
        </div>
    );
  }
}

function mapStateToProps(state){
  console.log('Mapping');
  console.log(state);
  return {posts: state.posts.all};
}

// no need of mapActionCreatorsToProps/bindActionCreators method
export default connect(mapStateToProps, {fetchPosts})(PostsIndex);
