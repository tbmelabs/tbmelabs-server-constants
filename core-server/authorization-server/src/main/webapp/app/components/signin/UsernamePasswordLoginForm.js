'use strict';

import React, {Component} from 'react';
import PropTypes from 'prop-types';

import {Link} from 'react-router-dom';

import Form from 'react-bootstrap/lib/Form';
import FormGroup from 'react-bootstrap/lib/FormGroup'
import Col from 'react-bootstrap/lib/Col';
import ControlLabel from 'react-bootstrap/lib/ControlLabel';
import FormControl from 'react-bootstrap/lib/FormControl';
import Button from 'react-bootstrap/lib/Button';

import CollapsableAlert from '../common/CollapsableAlert';

require('bootstrap/dist/css/bootstrap.css');

class UsernamePasswordLoginForm extends Component {
  constructor(props) {
    super(props);

    this.state = {
      username: '',
      password: '',
      errors: {},
      isLoading: false
    };

    this.onChange = this.onChange.bind(this);
    this.onSubmit = this.onSubmit.bind(this);
  }

  onChange(event) {
    this.setState({[event.target.name]: event.target.value});
  }

  onSubmit(event) {
    event.preventDefault();

    this.setState({errors: {}, isLoading: true});

    this.props.authenticateUser(this.state).then(
      response => {
      },
      error => this.setState({password: '', errors: {form: error.response.data.message}, isLoading: false})
    );
  }

  render() {
    const {isLoading} = this.state;
    const {texts} = this.props;

    return (
      <Form onSubmit={this.onSubmit} horizontal>
        <CollapsableAlert style='danger' title={texts.signin_failed_error_title} message={this.state.errors.form}
                          collapse={!!this.state.errors.form}/>

        <FormGroup controlId='username'>
          <Col componentClass={ControlLabel}>
            {texts.username_form_control}
          </Col>
          <Col>
            <FormControl name='username' type='text' value={this.state.username}
                         onChange={this.onChange} required/>
            <FormControl.Feedback/>
          </Col>
        </FormGroup>

        <FormGroup controlId='password'>
          <Col componentClass={ControlLabel}>
            {texts.password_form_control}
          </Col>
          <Col>
            <FormControl name='password' type='password' value={this.state.password}
                         onChange={this.onChange} required/>
            <FormControl.Feedback/>
          </Col>
        </FormGroup>

        <FormGroup className='link-group'>
          <Col sm={8}>
            {require('../../config/config.json').isRegistrationEnabled ?
              <Link to='/signup'>{texts.signup_link_text}</Link>
              : null}
          </Col>
          <Col sm={4}>
            <Button className='pull-right' type='submit' disabled={isLoading}
                    onClick={!isLoading ? this.handleClick : null}>
              {isLoading ? texts.signin_button_loading_text : texts.signin_button_text}
            </Button>
          </Col>
        </FormGroup>
      </Form>
    );
  }
}

UsernamePasswordLoginForm.propTypes = {
  authenticateUser: PropTypes.func.isRequired,
  texts: PropTypes.object.isRequired
}

UsernamePasswordLoginForm.contextTypes = {
  router: PropTypes.object.isRequired
}

export default UsernamePasswordLoginForm;