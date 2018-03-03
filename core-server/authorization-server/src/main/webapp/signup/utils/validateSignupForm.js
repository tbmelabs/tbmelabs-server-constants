// @flow
'use strict';

import validateUsername from './validators/validateUsername';
import validateEmail from './validators/validateEmail';
import validatePassword from './validators/validatePassword';
import validatePasswordConfirmation from './validators/validatePasswordConfirmation';

export default function validateSignupForm(control: string, data: { username: string, email: string, password: string, confirmation: string, errors: any }, callback: function) {
  const {username, email, password, confirmation, errors} = data;

  delete errors.form;

  switch (control) {
    case 'username':
      validateUsername(username, errors, callback);
      break
    case 'email':
      validateEmail(email, errors, callback);
      break
    case 'password':
      validatePassword(password, errors, callback);
      validatePasswordConfirmation(password, confirmation, errors, callback);
      break
    case 'confirmation':
      validatePasswordConfirmation(password, confirmation, errors, callback);
      break
    default:
      validateUsername(username, errors, errors => {
        validateEmail(email, errors, errors => {
          validatePassword(password, errors, errors => {
            validatePasswordConfirmation(password, confirmation, errors, callback);
          });
        });
      });
  }
}

