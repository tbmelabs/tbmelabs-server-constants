// @flow

import {put, takeLatest} from 'redux-saga/effects';

import axios from 'axios';

import {REQUEST_AUTHENTICATION, setAuthenticationAction} from '../../actions/authentication/index';

export function* requestAuthenticationSaga(): Generator<any, void, any> {
  yield takeLatest(REQUEST_AUTHENTICATION, () => {
    axios.get('authenticated').then(
      function* (response) {
        yield put(setAuthenticationAction(response.data));
      }
      // TODO: new BackendNotReachableAction(error.response.data.message)
    );
  });
}
