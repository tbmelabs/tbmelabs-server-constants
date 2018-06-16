const webpack = require('webpack');
const path = require('path');

const HtmlWebpackPlugin = require('html-webpack-plugin');
const UglifyJSPlugin = require('uglifyjs-webpack-plugin');

const BUILD_DIR = path.resolve(__dirname, 'public');
const NODE_DIR = path.resolve(__dirname, 'node_modules');
const TEST_DIR = path.resolve(__dirname, '__tests__');

const APP = path.resolve(__dirname, 'app');
const COMMON_UTILS = path.resolve(__dirname, 'common');
const AUTHORIZE_APP = path.resolve(__dirname, 'authorize');
const SIGNIN_APP = path.resolve(__dirname, 'signin');
const SIGNUP_APP = path.resolve(__dirname, 'signup');

const ENV = 'production';

module.exports = {
  entry: {
    app: ['babel-polyfill', APP],
    authorize: AUTHORIZE_APP,
    signin: ['babel-polyfill', SIGNIN_APP],
    signup: ['babel-polyfill', SIGNUP_APP]
  },
  output: {
    chunkFilename: '[chunkhash].js',
    filename: '[name].bundle.js',
    path: BUILD_DIR,
    publicPath: 'public/'
  },
  module: {
    rules: [
      {
        test: /\.js$/,
        exclude: [
          NODE_DIR,
          TEST_DIR
        ],
        include: [
          APP,
          COMMON_UTILS,
          AUTHORIZE_APP,
          SIGNIN_APP,
          SIGNUP_APP
        ],
        loader: 'babel-loader',
        options: {
          plugins: [
            'babel-plugin-syntax-dynamic-import',
            'transform-flow-strip-types',
            'transform-object-rest-spread'
          ],
          presets: [
            'env',
            'react',
            'flow'
          ]
        }
      }, {
        test: /\.css$/,
        loader: 'style-loader!css-loader'
      }, {
        test: /\.(jpe?g|png|gif|svg)$/i,
        loader: 'file-loader?publicPath=public/'
      }, {
        test: /\.(woff|woff2|eot|ttf)$/,
        loader: 'url-loader?limit=100000'
      }
    ]
  },
  mode: ENV,
  optimization: {
    splitChunks: {
      cacheGroups: {
        commons: {
          chunks: 'initial',
          minChunks: 2,
        }
      }
    }
  },
  plugins: [
    new UglifyJSPlugin(),
    new HtmlWebpackPlugin({
      chunks: ['app'],
      filename: '../index.html',
      template: 'templates/app.template.ejs'
    }),
    new HtmlWebpackPlugin({
      chunks: ['authorize'],
      filename: '../authorize.html',
      template: 'templates/authorize.template.ejs'
    }),
    new HtmlWebpackPlugin({
      chunks: ['signin'],
      filename: '../signin.html',
      template: 'templates/signin.template.ejs'
    }),
    new HtmlWebpackPlugin({
      chunks: ['signup'],
      filename: '../signup.html',
      template: 'templates/signup.template.ejs'
    })
  ]
};
